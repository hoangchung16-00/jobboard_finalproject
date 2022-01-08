package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Company;
import com.example.jobboard_final.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService {
    @Autowired
    private Environment env;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendUserVerificationEmail(Users user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = env.getProperty("spring.mail.username");
        String senderName = "Job Board System";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Job Board System.";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", user.getName());
        String verifyURL = siteURL + "/verify?code=" + user.getAccount().getVerificationcode();
        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        javaMailSender.send(message);
    }

    public void sendCompanyVerificationEmail(Company company, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = company.getEmail();
        String fromAddress = env.getProperty("spring.mail.username");
        String senderName = "Job Board System";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Job Board System.";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", company.getName());
        String verifyURL = siteURL + "/verify?code=" + company.getAccount().getVerificationcode();
        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        javaMailSender.send(message);
    }
}
