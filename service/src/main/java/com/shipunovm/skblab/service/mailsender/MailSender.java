package com.shipunovm.skblab.service.mailsender;

import com.shipunovm.skblab.service.exception.TimeoutException;
import com.shipunovm.skblab.service.mailsender.email.EmailAddress;
import com.shipunovm.skblab.service.mailsender.email.EmailContent;

/**
 * Ориентировочный интерфейс мейлера.
 */
public interface MailSender {

    void sendMail(EmailAddress toAddress, EmailContent messageBody) throws TimeoutException;

}
