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
 * @date 2018/6/12 19:30
 */
@SpringBootApplication
@RestController
public class App2Application {

    private static final Log log = LogFactory.getLog(App2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(App2Application.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/getMessage")
    public String getMessage() throws InterruptedException {
        log.info("app2 start");
        String s1 = restTemplate.getForObject("http://localhost:8903/getMessage", String.class);
        String s2 = restTemplate.getForObject("http://localhost:8904/getMessage", String.class);
        return s1 + s2;
    }

}
