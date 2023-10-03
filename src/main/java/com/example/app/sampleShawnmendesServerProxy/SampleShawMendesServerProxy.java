package com.example.app.sampleShawnmendesServerProxy;

import com.example.app.itunes.ItunesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "sample-server-shawn-mendes-client" )
public interface SampleShawMendesServerProxy {

    // GET http://localhost:8080/shawn/songs
    @GetMapping("/shawn/songs")
    public SampleServerShawnMendesResponse fetchAllSongs(@RequestHeader String requestId);

    @PostMapping("/shawn/songs")
    public SampleServerShawnMendesResponse addSongs(@RequestBody SampleShawnMendesRequest request);
}
