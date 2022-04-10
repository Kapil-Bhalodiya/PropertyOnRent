package com.example.credential.Services;

import com.example.credential.Repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class GenerateOTP {
    @Autowired
    private RegistrationRepo repo;

    @Autowired
    private JavaMailSender mailSender;

    int randomCode;

    public int sendVerificationEmail(String reg)  throws MessagingException, UnsupportedEncodingException {
        Random rnd = new Random();
        randomCode = rnd.nextInt(999999);
        String content = "<div style='align:center'>Dear Sweta,<br>"
                + "Please Enter below number to verify your registration:<br><br><br><br>"
                + "<b>"+randomCode+"</b><br><br><br>"
                + "</div>"
                + "Thank you,<br>"
                + "OxOnRealEstate";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("kapilbhalodiya.dcs22@vnsgu.ac.in", "OxOnRealEstate");
        helper.setTo(reg);
        helper.setSubject("OxOnRealEstate");
        helper.setText(content, true);

        mailSender.send(message);
        return randomCode;
    }
}