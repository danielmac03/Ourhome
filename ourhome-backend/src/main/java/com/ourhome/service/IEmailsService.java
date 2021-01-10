package com.ourhome.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IEmailsService {

    public void sendEmail(String to, String subject, String text) throws MessagingException, UnsupportedEncodingException;

}