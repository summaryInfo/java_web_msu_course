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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean getOversized() {
        return oversized;
    }

    public void setOversized(boolean oversized) {
        this.oversized = oversized;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != Product.class)
            return false;
        Product other = (Product) obj;
        if (((productId == null) != (other.productId == null))
                || (productId != null && !productId.equals(other.productId)))
            return false;
        if (((name == null) != (other.name == null)) || (name != null && !name.equals(other.name)))
            return false;
        if (((description == null) != (other.description == null))
                || (description != null && !description.equals(other.description)))
            return false;
        if (((category == null) != (other.category == null)) || (category != null && !category.equals(other.category)))
            return false;
        if (((unit == null) != (other.unit == null)) || (unit != null && !unit.equals(other.unit)))
            return false;
        if (oversized != other.oversized)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product(productId=" + productId.toString() + ", name=" + (name != null ? name.toString() : "<NULL>")
                + ", description=" + (description != null ? description.toString() : "<NULL>") + ", category="
                + (category != null ? category.toString() : "<NULL>") + ", unit="
                + (unit != null ? unit.toString() : "<NULL>") + ", oversized=" + Boolean.toString(oversized) + ")";
    }
}
