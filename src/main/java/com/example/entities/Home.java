package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "home")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 @Column(name = "price")
 private BigDecimal price;


 @OneToMany(mappedBy = "home")
 private List<Room> rooms;
}
