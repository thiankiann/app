package com.example.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("shawnmendes-client")
public interface ShawnMendesProxy {

    //GET http://itunes...   <-- we want to send get on this address
    @RequestMapping("/search")
    public String search();


}
