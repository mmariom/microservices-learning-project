package com.mmario.client.fraud.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {



    @GetMapping(path = "api/v1/fraud-check/{id}")
    FraudCheckResponse isFraudster(@PathVariable("id") Integer id);
}
