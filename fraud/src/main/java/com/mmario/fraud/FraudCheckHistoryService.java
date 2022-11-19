package com.mmario.fraud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckHistoryService {


    @Autowired
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;



    public boolean isFraudlentCustomer(Integer customerId ){

        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createAt(LocalDateTime.now())
                        .build()
        );
         return false;
    }
}
