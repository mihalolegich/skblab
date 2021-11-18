package com.shipunovm.skblab.service.mailsender;

import com.shipunovm.skblab.service.exception.TimeoutException;
import com.shipunovm.skblab.service.mailsender.email.EmailAddress;
import com.shipunovm.skblab.service.mailsender.email.EmailContent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSenderStub implements MailSender {

    //not thread safe reference
    private String lastSentEmailAddress;

    @SneakyThrows
    private static void sleep() {
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
    }

    private static boolean shouldSleep() {
        return new Random().nextInt(10) == 1;
    }

    private static boolean shouldThrowTimeout() {
        return new Random().nextInt(10) == 1;
    }

    @Override
    public void sendMail(EmailAddress toAddress, EmailContent messageBody) throws TimeoutException {
        if (shouldThrowTimeout()) {
            sleep();
            throw new TimeoutException("Timeout!");
        }
        if (shouldSleep()) {
            sleep();
        }
        lastSentEmailAddress = toAddress.getEmail();
        log.info("Email sent to {}, body {}.", toAddress, messageBody);
    }

    public String getLastSentEmailAddress() {
        return lastSentEmailAddress;
    }

}
