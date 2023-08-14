package com.techdynamics.demo.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class})
@ComponentScan("com.techdynamics.demo.work.controller")
public class TechdynamicsDemoWorkApplication {

    private static Logger log = LoggerFactory.getLogger(TechdynamicsDemoWorkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TechdynamicsDemoWorkApplication.class, args);
    }

    public void run(ApplicationArguments args) throws Exception {

        log.info("Application is Started Successfully...!!");

    }
}
