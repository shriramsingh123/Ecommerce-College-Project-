package com.shriram.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(length = 50,unique = true)
    private String categoryName;

    @Column(length = 500)
    private String categoryDesc;

    @Lob
    private byte[] categoryImg;
}
