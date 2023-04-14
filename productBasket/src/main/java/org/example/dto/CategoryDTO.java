package org.example.dto;

import lombok.Data;
import org.example.entity.Category;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private String type;
    private String shopName;
    private String description;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.type = category.getType();
        this.shopName = category.getShopName();
        this.description = category.getDescription();
    }

}