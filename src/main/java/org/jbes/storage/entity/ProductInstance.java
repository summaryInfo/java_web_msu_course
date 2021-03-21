package org.jbes.storage.entity;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "product_instances")
public class ProductInstance {
    @Id
    @GeneratedValue
    @Column(name = "instance_id")
    private Long instanceId;

    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private double amount;

    @CreationTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrival;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    @Column(name = "room_no", nullable = false)
    private int roomNo;

    @Column(name = "shelf_no", nullable = false)
    private int shelfNo;

    @JoinColumn(nullable = false, name = "supply_id")
    @ManyToOne
    private Supply source;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order destination;

    public ProductInstance() {
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
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

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(int shelfNo) {
        this.shelfNo = shelfNo;
    }

    public Supply getSource() {
        return source;
    }

    public void setSource(Supply source) {
        this.source = source;
    }

    public Order getDestination() {
        return destination;
    }

    public void setDestination(Order destination) {
        this.destination = destination;
    }
}
