package com.hombre.smsservice;

import java.io.IOException;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
//
//    @RequestMapping(value = "/smsService", method = RequestMethod.POST)
//    public String onSubmit(@ModelAttribute("sms") @Valid SMS sms) {
//
//        ObjectMapper mapper = new ObjectMapper();
//        String json = "";
//
//        try {
//            json = mapper.writeValueAsString(sms);
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/ServerSMS/sendsms?phoneNumber=" + sms.getPhoneNumber() + "&message=" + sms.getMessage();
//        ConfirmationMessage confirmMessage = restTemplate.getForObject(url, ConfirmationMessage.class);
//
//        System.out.println("Confirmation message: date=" + confirmMessage.getDate().toString() + ", price= "
//                + confirmMessage.getPrice().toString() + ", status= " + confirmMessage.getStatus());
//
//        return "smsService";
//    }

    // With JSON

    @RequestMapping(value = "/smsService", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("sms") @Valid SMS sms) {

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

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );

        HttpEntity request= new HttpEntity( json, headers );

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/ServerSMS/sendsms";
        ConfirmationMessage confirmMessage = restTemplate.postForObject(url, request, ConfirmationMessage.class);

        System.out.println("Confirmation message: date=" + confirmMessage.getDate().toString() + ", price= "
                + confirmMessage.getPrice().toString() + ", status= " + confirmMessage.getStatus());

        return "smsService";
    }
}