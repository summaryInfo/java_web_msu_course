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

    public ProductInstance(Long instanceId, Product product, double amount, Date arrival, Date expires, int roomNo,
            int shelfNo, Supply source, Order destination) {
        this.instanceId = instanceId;
        this.product = product;
        this.amount = amount;
        this.arrival = arrival;
        this.expires = expires;
        this.roomNo = roomNo;
        this.shelfNo = shelfNo;
        this.source = source;
        this.destination = destination;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != ProductInstance.class)
            return false;
        ProductInstance other = (ProductInstance) obj;
        if (((instanceId == null) != (other.instanceId == null))
                || (instanceId != null && !instanceId.equals(other.instanceId)))
            return false;
        if (((product == null) != (other.product == null)) || (product != null && !product.equals(other.product)))
            return false;
        if (amount != other.amount)
            return false;
        if (((arrival == null) != (other.arrival == null)) || (arrival != null && !arrival.equals(other.arrival)))
            return false;
        if (((expires == null) != (other.expires == null)) || (expires != null && !expires.equals(other.expires)))
            return false;
        if (roomNo != other.roomNo)
            return false;
        if (shelfNo != other.shelfNo)
            return false;
        if (((source == null) != (other.source == null)) || (source != null && !source.equals(other.source)))
            return false;
        if (((destination == null) != (other.destination == null))
                || (destination != null && !destination.equals(other.destination)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductInstance(instanceId=" + (instanceId != null ? instanceId.toString() : "<NULL>") + ", product="
                + (product != null ? product.toString() : "<NULL>") + ", amount=" + Double.toString(amount)
                + ", arrival=" + (arrival != null ? arrival.toString() : "<NULL>") + ", expires="
                + (expires != null ? expires.toString() : "<NULL>") + ", roomNo=" + Integer.toString(roomNo)
                + ", shelfNo=" + Integer.toString(shelfNo) + ", source="
                + (source != null ? source.toString() : "<NULL>") + ", destination="
                + (destination != null ? destination.toString() : "<NULL>") + ")";
    }
}
