package com.shipunovm.skblab.controllers;

import com.shipunovm.skblab.domain.account.Account;
import com.shipunovm.skblab.formbeans.AccountFormBean;
import com.shipunovm.skblab.service.account.AccountService;
import com.shipunovm.skblab.service.exception.TimeoutException;
import com.shipunovm.skblab.service.mailsender.MailSender;
import com.shipunovm.skblab.service.mailsender.email.EmailAddress;
import com.shipunovm.skblab.service.mailsender.email.EmailContent;
import com.shipunovm.skblab.service.messaging.MessagingService;
import com.shipunovm.skblab.service.messaging.message.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {

    private AccountService accountService;
    private MessagingService messagingService;
    private MailSender mailSender;

    @Autowired
    public RegistrationController(AccountService accountService, MessagingService messagingService, MailSender mailSender) {
        this.accountService = accountService;
        this.messagingService = messagingService;
        this.mailSender = mailSender;
    }

    @PostMapping("/account/register")
    public String registerAccount(AccountFormBean accFromForm) throws TimeoutException {
        Account account = createAccountFromFormBean(accFromForm);
        accountService.save(account);
        Message<String> message = messagingService.doRequest(new Message<>(account));
        mailSender.sendMail(new EmailAddress(accFromForm.getEmail()), new EmailContent(message.getBody()));
        return "registration";
    }

    private Account createAccountFromFormBean(AccountFormBean a) {
        return new Account(a.getLogin(),
                a.getPass(),
                a.getEmail(),
                a.getName(),
                a.getLastName(),
                a.getPatronymic());
    }

    @ExceptionHandler({TimeoutException.class, DataAccessException.class})
    public String error(Model model, Exception ex) {
        log.error("exception!!!", ex);
        model.addAttribute("exception", true);
        return "registration";
    }

}
