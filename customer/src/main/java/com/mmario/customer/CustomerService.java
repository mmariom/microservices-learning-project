package com.mmario.customer;


import com.mmario.client.fraud.fraud.FraudCheckResponse;
import com.mmario.client.fraud.fraud.FraudClient;
import com.mmario.client.fraud.notification.NotificationClient;
import com.mmario.client.fraud.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService{
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FraudClient fraudClient;


    @Autowired
    private NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();


        customerRepository.saveAndFlush(customer);


        //todo: check if fraudster
        //todo: send notififcation request
        //todo: check if email is valid and if is not taken
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());


        if (fraudCheckResponse.isFraudster()){
            throw  new IllegalStateException("fraudster");

        }

        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to Mmario code...",
                                customer.getFirstName())
                )
        );


//        customerRepository.save(customer);
    }
}
