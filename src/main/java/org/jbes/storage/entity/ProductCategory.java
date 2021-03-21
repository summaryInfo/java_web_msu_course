package org.jbes.storage.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    private String description;

    public ProductCategory() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
