package com.hei.la_Maody.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@EqualsAndHashCode
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name="id_category", nullable=false)
    private Category category;
}
