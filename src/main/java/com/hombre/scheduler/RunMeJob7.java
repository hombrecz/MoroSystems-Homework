package com.hombre.scheduler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;
import com.hombre.mailservice.ApplicationMailer;

import freemarker.template.TemplateException;

@Component
public class RunMeJob7 extends QuartzJobBean {

    @Autowired
    private UserBo userBo;

    @Autowired
    private ServletContext servletContext;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Job7");
        List<User> users = userBo.getUserByMailFreq("7");

        for (User user : users) {
            System.out.println("Sending mail to " + user.getUsername());
            try {
                ApplicationMailer.sendMail(user, servletContext);
            } catch (TemplateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}