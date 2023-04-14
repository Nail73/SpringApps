package org.example.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private int amount;
    private double weight;
    private boolean freshness;
    private Long categoryId;
}
