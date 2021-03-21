package org.jbes.storage.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long productId;

    @Column(nullable = false)
    private String name;

    private String description;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private ProductCategory category;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private boolean oversized;

    public Product() {
    }

    Long getProductId() {
        return productId;
    }

    void setProductId(Long productId) {
        this.productId = productId;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    ProductCategory getCategory() {
        return category;
    }

    void setCategory(ProductCategory category) {
        this.category = category;
    }

    String getUnit() {
        return unit;
    }

    void setUnit(String unit) {
        this.unit = unit;
    }

    boolean getOversized() {
        return oversized;
    }

    void setOversized(boolean oversized) {
        this.oversized = oversized;
    }
}
