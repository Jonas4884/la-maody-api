package com.hei.la_Maody.model;

import com.hei.la_Maody.model.Utils.paymentENum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;


@Builder
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Paying implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String payment_type;
    @OneToOne
    private Customer allCustomerDetails;


    private Date payment_date;

    @Enumerated(EnumType.STRING)
    private paymentENum paymentENum;

    @Column(columnDefinition = "boolean default false")
    private boolean payed;

}
