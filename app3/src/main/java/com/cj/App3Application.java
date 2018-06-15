package com.cj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-cj189958
 * @date 2018/6/12 19:30
 */
@SpringBootApplication
@RestController
public class App3Application {

    private static final Log log = LogFactory.getLog(App3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(App3Application.class, args);
    }

    @RequestMapping("/getMessage")
    public String getMessage() throws InterruptedException {
        log.info("app3 start");
        return "app3 response";
    }

}
