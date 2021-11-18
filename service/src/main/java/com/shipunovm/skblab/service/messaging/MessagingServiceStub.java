package com.shipunovm.skblab.service.messaging;

import com.shipunovm.skblab.service.exception.TimeoutException;
import com.shipunovm.skblab.service.messaging.message.Message;
import com.shipunovm.skblab.service.messaging.message.MessageId;
import com.shipunovm.skblab.service.messaging.message.ReceivedMessage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MessagingServiceStub implements MessagingService {

    //these fields must be used with sync if we want to avoid data races, but for performance kept them volatile only
    private volatile MessageId lastSentMessageCorrelationId;
    private volatile Message<?> lastReceivedMessage;

    @SneakyThrows
    private static void sleep() {
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
    }

    private static boolean shouldSleep() {
        return new Random().nextInt(10) == 1;
    }

    private static boolean shouldThrowTimeout() {
        return new Random().nextInt(10) == 1;
    }

    @Override
    public <T> MessageId send(Message<T> msg) {
        log.info("message is sent to external system");
        final MessageId messageId = new MessageId(UUID.randomUUID());
        lastSentMessageCorrelationId = messageId;
        return messageId;
    }

    @Override
    public <T> Message<T> receive(MessageId messageId) throws TimeoutException {
        if (shouldThrowTimeout()) {
            sleep();
            throw new TimeoutException("Timeout!");
        }
        if (shouldSleep()) {
            sleep();
        }
        log.info("message received from external system");
        final Message<T> externalMsg = (Message<T>) new ReceivedMessage("message from external system");
        lastReceivedMessage = externalMsg;
        return externalMsg;
    }

    @Override
    public <R, A> Message<A> doRequest(Message<R> request) throws TimeoutException {
        return receive(send(request));
    }

    @Override
    public Message<?> getLastReceivedMessage() {
        return lastReceivedMessage;
    }

    @Override
    public MessageId getLastSentMessageCorrelationId() {
        return lastSentMessageCorrelationId;
    }

}