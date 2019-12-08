package com.dfbz.xbhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class XbhyApplication {

    public static void main(String[] args) {
        SpringApplication.run(XbhyApplication.class, args);
    }

}
