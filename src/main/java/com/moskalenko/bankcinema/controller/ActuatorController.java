package com.moskalenko.bankcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ActuatorController {

    @ResponseBody
    @RequestMapping("/actuator")
    public String home(HttpServletRequest request) {

        String contextPath = request.getContextPath();
        String host = request.getServerName();

        // Spring Boot >= 2.0.0.M7
        String endpointBasePath = "/actuator";

        StringBuilder sb = new StringBuilder();

        sb.append("<h2>Sprig Boot Actuator</h2>");
        sb.append("<ul>");

        // http://localhost:8090/actuator
        String url = "http://" + host + ":8090" + contextPath + endpointBasePath;

        sb.append("<li><a href='").append(url).append("'>").append(url).append("</a></li>");

        sb.append("</ul>");

        return sb.toString();
    }
}
