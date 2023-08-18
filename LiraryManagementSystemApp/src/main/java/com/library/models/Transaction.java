package com.library.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Book book;
    
    private LocalDate checkoutDate;
    
    private LocalDate dueDate;
    
    private LocalDate returnDate;
    
    private Double fineAmount;
  
}