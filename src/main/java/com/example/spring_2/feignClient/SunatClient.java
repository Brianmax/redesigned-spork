package com.example.spring_2.feignClient;

import com.example.spring_2.dto.response.SunatResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sunat-client", url = "https://api.decolecta.com/v1/sunat/ruc/full")
public interface SunatClient {
    @GetMapping()
    SunatResponse getInfoEmpresa(@RequestParam String numero, @RequestHeader("Authorization") String token);
}
