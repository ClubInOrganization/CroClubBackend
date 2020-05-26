package com.croclub.club.model;

import javax.persistence.*;

@Entity
@Table(name="DRINKS", schema = "PUBLIC")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;

}
