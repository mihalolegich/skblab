package com.shipunovm.skblab;

import com.shipunovm.skblab.dao.AccountDao;
import com.shipunovm.skblab.service.mailsender.MailSender;
import com.shipunovm.skblab.service.messaging.MessagingService;
import com.shipunovm.skblab.service.messaging.message.ReceivedMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private MessagingService messagingService;
    @Autowired
    private MailSender mailSender;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testNewAccount() throws Exception {
        assertEquals(0, accountDao.getAll().size());
        final String email = "test@gmail.com";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/account/register")
                        .param("email", email)
                        .param("login", "login")
                        .param("pass", "1")
                        .param("name", "Test")
                        .param("lastName", "TestLastName"))
                .andExpectAll(status().is(200), forwardedUrl("/jsp/registration.jsp"));
        assertEquals(1, accountDao.getAll().size());
        assertNotNull(messagingService.getLastSentMessageCorrelationId().getUuid());
        assertEquals(new ReceivedMessage("message from external system"), messagingService.getLastReceivedMessage());
        assertEquals(email, mailSender.getLastSentEmailAddress());
    }

}

