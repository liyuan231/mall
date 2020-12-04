package com.liyuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmailServiceImpl {
    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    private static ConcurrentHashMap<String, String> codeMap = new ConcurrentHashMap<>();

    public String get(String key) {
        String s = codeMap.get(key);
//        codeMap.remove(key);
        return s;
    }

    public void remove(String key) {
        codeMap.remove(key);
    }


    public void sendCode(String username) {
        String s = String.valueOf(System.currentTimeMillis());
        String message = "邮箱验证码是 %s (三分之内有效)";
        String code = s.substring(s.length() - 6);
        this.send(username, "MALL-邮箱验证码", String.format(message, code));
        codeMap.put(username, code);
    }

    public void send(String to, String subject, String context) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.mailProperties.getUsername());
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(context);
        simpleMailMessage.setTo(to);
        this.javaMailSender.send(simpleMailMessage);
    }


}
