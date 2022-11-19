package com.mmario.fraud;


import com.mmario.client.fraud.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudCheckHistoryController {

    @Autowired
    private FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{id}")
    public FraudCheckResponse isFraudster(@PathVariable("id") Integer id) {
        boolean isfraudlentCustomer = fraudCheckHistoryService.isFraudlentCustomer(id);
        log.info("fraudCheck request for customer id {}", id);
        return new FraudCheckResponse(isfraudlentCustomer);

    }
}
