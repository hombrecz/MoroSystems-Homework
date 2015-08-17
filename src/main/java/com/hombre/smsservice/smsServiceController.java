package com.hombre.smsservice;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.hombre.db.model.ConfirmationMessage;
import com.hombre.db.model.SMS;

@Controller
@RequestMapping("/smsService")
public class smsServiceController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(@ModelAttribute("sms") @Valid SMS sms) {
        return "smsService";
    }

    @RequestMapping(value = "/smsService", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("sms") @Valid SMS sms) {
        System.out.println("Phone Number: " + sms.getPhoneNumber() + ", message: " + sms.getMessage());

        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        try {
            json = mapper.writeValueAsString(sms);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/ServerSMS/sendsms?phoneNumber="+ sms.getPhoneNumber() +"&message=" + sms.getMessage();
//        String url = "http://localhost:8080/ServerSMS/sendsms?sms=" + json;
        ConfirmationMessage confirmMessage = restTemplate.getForObject(url, ConfirmationMessage.class);

        System.out.println(confirmMessage);
        System.out.println("Confirmation message: date=" + confirmMessage.getDate().toString() + ", price= "
              + confirmMessage.getPrice().toString() + ", status= " + confirmMessage.getStatus());
        
        return "smsService";
    }

    @RequestMapping(value = "/recieveConfirmation", method = RequestMethod.GET)
    public String recieveConfirmation(@RequestParam Date date, @RequestParam BigDecimal price,@RequestParam String status) {
        
        System.out.println("Confirmation message: date=" + date + ", price= "
                + price + ", status= " + status);
        return "done";
    }
//    @RequestMapping(value = "/recieveConfirmation", method = RequestMethod.GET)
//    public String recieveConfirmation(@RequestParam ConfirmationMessage confirmationMessage) {
//
//        System.out.println("Confirmation message: date=" + confirmationMessage.getDate().toString() + ", price= "
//                + confirmationMessage.getPrice().toString() + ", status= " + confirmationMessage.getStatus());
//        return "smsService";
//    }
}