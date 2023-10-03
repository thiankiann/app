package com.example.app;

import com.example.app.itunes.ItunesProxy;
import com.example.app.itunes.ItunesResponse;
import com.example.app.itunes.ItunesResult;
import com.example.app.sampleShawnmendesServerProxy.SampleServerShawnMendesResponse;
import com.example.app.sampleShawnmendesServerProxy.SampleShawMendesServerProxy;
import com.example.app.sampleShawnmendesServerProxy.SampleShawnMendesRequest;
import feign.FeignException;


import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class AppApplication {


    @Autowired
    ItunesProxy itunesClient;

    @Autowired
    SampleShawMendesServerProxy sampleShawMendesServerClient;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
    // ItunesResponse response = itunesClient.makeSearchRequest("shawnmendes", 5);
    // SampleServerShawnMendesResponse response = sampleShawMendesServerClient.fetchAllSongs("id1");
    // log.info(response);
    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {
            log.info(sampleShawMendesServerClient.fetchAllSongs("id1"));
            log.info(sampleShawMendesServerClient.addSongs(new SampleShawnMendesRequest("In My Blood")));
            log.info(sampleShawMendesServerClient.addSongs(new SampleShawnMendesRequest("Stitches")));
            log.info(sampleShawMendesServerClient.fetchAllSongs("id2"));
        } catch (FeignException.FeignClientException feignClientException) {
            System.out.println("client exception: " + feignClientException.status());
            log.error("client exception: " + feignClientException.status());
        } catch (FeignException.FeignServerException feignServerException) {
            System.out.println("server exception: " + feignServerException.status());
        } catch (FeignException feignException) {
            System.out.println(feignException.getMessage());
            System.out.println(feignException.status());
        }
    }
}
