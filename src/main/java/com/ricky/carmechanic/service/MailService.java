package com.ricky.carmechanic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    JavaMailSenderImpl mailSender;

    // @Scheduled(initialDelay = 1000)
    public void sendMailRegister(String address, String name, String book, String date) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper help = new MimeMessageHelper(mimeMessage,true);
        help.setSubject("您好！您的修理业务已经开始");
        help.setText(name+"您好，您的汽车，牌号"+book+"在"+date+"已经开始维修");
        help.setTo(address);
        help.setFrom("1553680641@qq.com");
        mailSender.send(mimeMessage);
    }

    public void sendMailBill(String address, String name, String book) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper help = new MimeMessageHelper(mimeMessage,true);
        help.setSubject("您好！您的修理业务以及完成");
        help.setText(name+"您好，您的汽车，牌号"+book+"已经维修完成");
        help.setTo(address);
        help.setFrom("1553680641@qq.com");
        mailSender.send(mimeMessage);
    }
}
