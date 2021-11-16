package com.shipunovm.skblab.service.config;

import com.shipunovm.skblab.dao.config.DaoConfig;
import com.shipunovm.skblab.service.mailsender.MailSender;
import com.shipunovm.skblab.service.mailsender.MailSenderStub;
import com.shipunovm.skblab.service.messaging.MessagingService;
import com.shipunovm.skblab.service.messaging.MessagingServiceStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(value = DaoConfig.class)
@EnableTransactionManagement
public class ServiceConfig {

    @Bean
    public MailSender mailSender() {
        return new MailSenderStub();
    }

    @Bean
    public MessagingService messagingService() {
        return new MessagingServiceStub();
    }

}
