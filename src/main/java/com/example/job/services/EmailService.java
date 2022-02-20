package com.example.job.services;

import com.example.job.entities.Company;
import com.example.job.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService {
    @Autowired
    private Environment env;

    @Autowired
    private JavaMailSender javaMailSender;

    private static String SENDERNAME = "Job Board System";
    @Transactional
    public void sendUserVerificationEmail(Users user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = env.getProperty("spring.mail.username");
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Job Board System.";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, SENDERNAME);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", user.getName());
        String verifyURL = siteURL + "/verify?code=" + user.getAccount().getVerificationcode();
        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        javaMailSender.send(message);
    }
    @Transactional
    public void sendCompanyVerificationEmail(Company company, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = company.getEmail();
        String fromAddress = env.getProperty("spring.mail.username");
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Job Board System.";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, SENDERNAME);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", company.getName());
        String verifyURL = siteURL + "/verify?code=" + company.getAccount().getVerificationcode();
        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        javaMailSender.send(message);
    }
    @Transactional
    public void sendAcceptEmail(Company company,Users users) throws UnsupportedEncodingException, MessagingException {
        String toAddress = users.getEmail();
        String fromAddress = env.getProperty("spring.mail.username");
        String subject = "Response job apply";
        String content = "Dear [[user]],<br>"
                + "Congratulation, your apply to [[company]] has been accepted<br>"
                + "The recruiter will contact you soon, please keep in touch<br>"
                + "Thank you,<br>"
                + "Job Board System.";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, SENDERNAME);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[user]]",users.getName());
        content = content.replace("[[company]]",company.getName());
        helper.setText(content,true);
        javaMailSender.send(message);
    }
    @Transactional
    public void sendDenyEmail(Company company,Users users) throws UnsupportedEncodingException, MessagingException {
        String toAddress = users.getEmail();
        String fromAddress = env.getProperty("spring.mail.username");
        String subject = "Response job apply";
        String content = "Dear [[user]],<br>"
                + "We sorry that your apply to [[company]] has been denied<br>"
                + "You still can find more job chance suitable for you in the job board system<br>"
                + "Thank you,<br>"
                + "Job Board System.";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, SENDERNAME);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[user]]",users.getName());
        content = content.replace("[[company]]",company.getName());
        helper.setText(content,true);
        javaMailSender.send(message);
    }
}
