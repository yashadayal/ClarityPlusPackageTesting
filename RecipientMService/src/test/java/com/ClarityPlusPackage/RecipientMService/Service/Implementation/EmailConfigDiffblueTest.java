package com.ClarityPlusPackage.RecipientMService.Service.Implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {EmailConfig.class})
@ExtendWith(SpringExtension.class)
class EmailConfigDiffblueTest {

    @Autowired
    private EmailConfig emailConfig;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test: {@link EmailConfig#sendOTPMail(String, String, String)}
     */
    @Test
    void testSendOTPMail() throws MailException {
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());
        emailConfig.sendOTPMail("alice.liddell@example.org", "Hello from the Dreaming Spires",
                "Not all who wander are lost");
        verify(javaMailSender).send(Mockito.<SimpleMailMessage>any());
    }

}
