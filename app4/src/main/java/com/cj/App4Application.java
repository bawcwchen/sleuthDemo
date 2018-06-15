package com.cj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-cj189958
 * @date 2018/6/12 19:31
 */
@SpringBootApplication
@RestController
public class App4Application {

    private static final Log log = LogFactory.getLog(App4Application.class);

    public static void main(String[] args) {
        SpringApplication.run(App4Application.class, args);
    }

    @RequestMapping("/getMessage")
    public String getMessage() {
        log.info("app4 start");
        return ",app4 response";
    }
}
