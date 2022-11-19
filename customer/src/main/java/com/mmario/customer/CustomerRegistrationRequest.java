package com.mmario.customer;


import org.springframework.stereotype.Repository;

public record CustomerRegistrationRequest (

        String firstName,
        String lastName,
        String email
){
}
