package com.example.spring_2.feignClient;

import com.example.spring_2.dto.ReniecResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec-client", url = "https://api.decolecta.com/v1/reniec/dni")
public interface ReniecClient {

    @GetMapping()
    ReniecResponse getPersonaInfo(@RequestParam String numero, @RequestHeader("Authorization") String token);
}
