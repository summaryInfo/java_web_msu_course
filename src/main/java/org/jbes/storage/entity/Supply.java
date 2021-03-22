package org.jbes.storage.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "supplies")
public class Supply {
    @Id
    @GeneratedValue
    @Column(name = "supply_id")
    private Long supplyId;

    @JoinColumn(nullable = false, name = "provider_id")
    @ManyToOne
    private Provider provider;

    @JoinColumn(nullable = false, name = "product_id")
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private boolean completed;

    public Supply() {
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean equals(Supply other) {
        if (other == null)
            return false;
        if (other.getClass() != Supply.class)
            return false;
        if (((supplyId == null) != (other.supplyId == null)) || (supplyId != null && !supplyId.equals(other.supplyId)))
            return false;
        if (((provider == null) != (other.provider == null)) || (provider != null && !provider.equals(other.provider)))
            return false;
        if (((product == null) != (other.product == null)) || (product != null && !product.equals(other.product)))
            return false;
        if (amount != amount)
            return false;
        if (((time == null) != (other.time == null)) || (time != null && !time.equals(other.time)))
            return false;
        if (completed != other.completed)
            return false;
        return true;
    }
}
