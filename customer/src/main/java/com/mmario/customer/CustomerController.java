package com.mmario.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerService) {




    @PostMapping
    public void  registerCustomer(@RequestBody  CustomerRegistrationRequest customerRegistrationRequest){
        log.info("nerw customer registration{}", customerRegistrationRequest);
    customerService.registerCustomer(customerRegistrationRequest);

    }


    @GetMapping
    public String getSomeRepsonse(){
        return "someRepsonse";
    }
}
