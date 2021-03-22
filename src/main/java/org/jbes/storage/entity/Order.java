package org.jbes.storage.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @JoinColumn(name = "order_id", nullable = false)
    private Long orderId;

    @JoinColumn(name = "consumer_id", nullable = false)
    @ManyToOne
    private Consumer consumer;

    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private boolean completed;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Consumer getConsumerId() {
        return consumer;
    }

    public void setConsumerId(Consumer consumer) {
        this.consumer = consumer;
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

    public boolean equals(Order other) {
        if (other == null)
            return false;
        if (other.getClass() != Order.class)
            return false;
        if (((orderId == null) != (other.orderId == null)) || (orderId != null && !orderId.equals(other.orderId)))
            return false;
        if (((consumer == null) != (other.consumer == null)) || (consumer != null && !consumer.equals(other.consumer)))
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
