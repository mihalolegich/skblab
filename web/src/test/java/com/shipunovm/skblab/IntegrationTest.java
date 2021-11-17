package com.shipunovm.skblab;

import com.shipunovm.skblab.dao.AccountDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
class IntegrationTest {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testNewAccount() throws Exception {
        assertEquals(0, accountDao.getAll().size());
        mockMvc.perform(
                MockMvcRequestBuilders.multipart("/account/register")
                        .param("email", "test@gmail.com")
                        .param("login", "login")
                        .param("pass", "1")
                        .param("name", "Test")
                        .param("lastName", "TestLastName")
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpectAll(status().is(200), forwardedUrl("/jsp/registration.jsp"));
        assertEquals(1, accountDao.getAll().size());

    }

}
