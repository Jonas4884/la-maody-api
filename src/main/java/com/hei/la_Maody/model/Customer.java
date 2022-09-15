package com.hei.la_Maody.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(name = "have",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id")}
    )
    List<Article> bags_item;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "customer_paying",
            joinColumns = @JoinColumn(name = "customer_null"),
            inverseJoinColumns = @JoinColumn(name = "paying_id"))
    private Paying paying;

    public Paying getPaying() {
        return paying;
    }

    public void setPaying(Paying paying) {
        this.paying = paying;
    }
}
