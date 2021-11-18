package com.shipunovm.skblab.service.messaging;

import com.shipunovm.skblab.service.exception.TimeoutException;
import com.shipunovm.skblab.service.messaging.message.Message;
import com.shipunovm.skblab.service.messaging.message.MessageId;

/**
 * Ориентировочный интерфейс нашего messaging решения.
 */
public interface MessagingService {

    /**
     * Отправка сообщения в шину.
     *
     * @param msg сообщение для отправки.
     * @return идентификатор отправленного сообщения (correlationId)
     */
    <T> MessageId send(Message<T> msg);

    /**
     * Встает на ожидание ответа по сообщению с messageId.
     * <p>
     * Редко, но может кинуть исключение по таймауту.
     *
     * @param messageId идентификатор сообщения, на которое ждем ответ.
     * @return Тело ответа.
     */
    <T> Message<T> receive(MessageId messageId) throws TimeoutException;

    /**
     * Отправляем сообщение и ждем на него ответ.
     *
     * @param request тело запроса.
     * @return тело ответа.
     */
    <R, A> Message<A> doRequest(Message<R> request) throws TimeoutException;

    <T> Message<T> getLastReceivedMessage();

    MessageId getLastSentMessageCorrelationId();

}
