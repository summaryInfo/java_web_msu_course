package org.jbes.storage.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @JoinColumn(nullable = false, name = "consumerId")
    @ManyToOne
    private Consumer consumer;

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

    public Order() {
    }

    public Order(Long orderId, Consumer consumer, Product product, double amount, Date time, boolean completed) {
        this.orderId = orderId;
        this.consumer = consumer;
        this.product = product;
        this.amount = amount;
        this.time = time;
        this.completed = completed;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != Order.class)
            return false;
        Order other = (Order) obj;
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

    @Override
    public String toString() {
        return "Order(orderId=" + (orderId != null ? orderId.toString() : "<NULL>") + ", consumer="
                + (consumer != null ? consumer.toString() : "<NULL>") + ", product="
                + (product != null ? product.toString() : "<NULL>") + ", amount=" + Double.toString(amount) + ", time="
                + (time != null ? time.toString() : "<NULL>") + ", completed=" + Boolean.toString(completed) + ")";
    }
}
