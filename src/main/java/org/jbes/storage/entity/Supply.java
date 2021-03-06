package org.jbes.storage.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;

    @JoinColumn(nullable = false, name = "providerId")
    @ManyToOne
    private Provider provider;

    @JoinColumn(nullable = false, name = "productId")
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

    public Supply(Long supplyId, Provider provider, Product product, double amount, Date time, boolean completed) {
        this.supplyId = supplyId;
        this.provider = provider;
        this.product = product;
        this.amount = amount;
        this.time = time;
        this.completed = completed;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != Supply.class)
            return false;
        Supply other = (Supply) obj;
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

    @Override
    public String toString() {
        return "Supply(supplyId=" + (supplyId != null ? supplyId.toString() : "<NULL>") + ", provider="
                + (provider != null ? provider.toString() : "<NULL>") + ", product="
                + (product != null ? product.toString() : "<NULL>") + ", amount=" + Double.toString(amount) + ", time="
                + (time != null ? time.toString() : "<NULL>") + ", completed=" + Boolean.toString(completed) + ")";
    }
}
