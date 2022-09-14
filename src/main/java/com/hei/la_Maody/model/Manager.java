package com.hei.la_Maody.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120)
    private String firstName;
    @Column(length = 120)
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;
}
