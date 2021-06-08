package com.avaliacaobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableConfigurationProperties({
//        FileStorageConfig.class
//})
@SpringBootApplication
public class WsAvaliacaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsAvaliacaoApplication.class, args);
    }

}
