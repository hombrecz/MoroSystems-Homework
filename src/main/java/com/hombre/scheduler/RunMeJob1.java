package com.hombre.scheduler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.hombre.db.bo.UserBo;
import com.hombre.db.model.User;
import com.hombre.mailservice.ApplicationMailer;

import freemarker.template.TemplateException;

@Component
public class RunMeJob1 extends QuartzJobBean {

    @Autowired
    private UserBo userBo;
    
    @Autowired
    private ServletContext servletContext;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("Job1");
        List<User> users = userBo.getUserByMailFreq("1");//TODO - tady se je userBo vždy null :-/ - podobně u ostatních
        
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