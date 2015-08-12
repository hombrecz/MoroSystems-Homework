package com.hombre.mailservice;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.hombre.db.model.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ApplicationMailer {

    public static void sendMail(User user, ServletContext servletContext) throws TemplateException, IOException {
        Configuration configurer = new Configuration();
        configurer.setServletContextForTemplateLoading(servletContext, "WEB-INF/templates"); 
        
        Template template = configurer.getTemplate("mail.ftl");
        
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("username", user.getUsername());
        context.put("books", user.getBooks());
        
        StringWriter output = new StringWriter();
        template.process(context, output);
        
        MailSender mailSender = new JavaMailSenderImpl();
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom("Example Server" + " <" + "example@test.cz" + ">");
        message.setTo(user.getUsername().toLowerCase()+"@test.cz");
        message.setSubject("Your booklist");
        message.setText(output.toString());

        mailSender.send(message);
        
    }

}
