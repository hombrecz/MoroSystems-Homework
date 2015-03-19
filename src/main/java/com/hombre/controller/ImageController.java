package com.hombre.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes
public class ImageController {

    @Value("#{generalConfiguration['PATH_IMAGES']}")
    private String pathToImgFolder;
    
    @RequestMapping(value="/image", method=RequestMethod.POST)
    public void getImage(HttpServletResponse response,String imagename) throws IOException {
        response.setContentType("image/png");
        File defaultFile = new File(pathToImgFolder+imagename);
        byte[] imageBytes = FileUtils.readFileToByteArray(defaultFile);
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
    }

}