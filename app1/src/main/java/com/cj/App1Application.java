package com.cj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wb-cj189958
 * @date 2018/6/12 19:26
 */
@SpringBootApplication
@RestController
public class App1Application{

    private static final Log log = LogFactory.getLog(App1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(App1Application.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        log.info("request start");
        String s = restTemplate.getForObject("http://localhost:8901/redirect", String.class);
        return s;
    }

    @RequestMapping("/redirect")
    public String redirect() throws InterruptedException {
        log.info("redirect");
        return restTemplate.getForObject("http://localhost:8902/getMessage", String.class);
    }
}
