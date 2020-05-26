package com.croclub.club.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import com.croclub.club.model.Event;

@Entity
@Table(name = "Tickets", schema = "PUBLIC")
public class Ticket {
    @Id
    private Long id;
    private BigDecimal price;




}
