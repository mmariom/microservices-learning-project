package com.mmario.fraud;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class FraudCheckHistory {


    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"

    )
    @GeneratedValue(
            generator = "fraud_id_sequence",
            strategy = GenerationType.SEQUENCE
    )

    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createAt;

}
