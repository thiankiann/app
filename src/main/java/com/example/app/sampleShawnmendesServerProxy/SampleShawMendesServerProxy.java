package com.example.app.sampleShawnmendesServerProxy;

import com.example.app.itunes.ItunesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "sample-server-shawn-mendes-client" )
public interface SampleShawMendesServerProxy {

    // GET http://localhost:8080/shawn/songs
    @GetMapping("/shawn/songs")
    public SampleServerShawnMendesResponse fetchAllSongs(@RequestHeader String requestId);
}
