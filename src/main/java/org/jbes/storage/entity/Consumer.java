package org.jbes.storage.entity;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import java.util.Arrays;

@Entity
@Table(name = "consumers")
public class Consumer {
    @Id
    @GeneratedValue
    @Column(name = "consumer_id")
    private Long consumerId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Type(type = "string-array")
    @Column(nullable = false, name = "address", columnDefinition = "text[]")
    private String[] address;

    @Type(type = "string-array")
    @Column(nullable = false, name = "tel", columnDefinition = "text[]")
    private String[] tel;

    @Type(type = "string-array")
    @Column(nullable = false, name = "email", columnDefinition = "text[]")
    private String[] email;

    public Consumer() {
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
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

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String[] getTel() {
        return tel;
    }

    public void setTel(String[] tel) {
        this.tel = tel;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public boolean deep_equal(Consumer other) {
        if (other == null)
            return false;
        if (other.getClass() != Consumer.class)
            return false;
        if ((consumerId == null) != (other.consumerId == null)
                || (consumerId != null && !consumerId.equals(other.consumerId)))
            return false;
        if ((name == null) != (other.name == null) || (name != null && !name.equals(other.name)))
            return false;
        if ((description == null) != (other.description == null)
                || (description != null && !description.equals(other.description)))
            return false;
        if (!Arrays.equals(address, other.address))
            return false;
        if (!Arrays.equals(tel, other.tel))
            return false;
        if (!Arrays.equals(email, other.email))
            return false;
        return true;
    }

    public String toString() {
        return "Consumer(consumerId=" + consumerId.toString() + ", name=" + name.toString() + ", description="
                + description.toString() + ", address={" + Arrays.toString(address) + "}, tel={" + Arrays.toString(tel)
                + "}, email={" + Arrays.toString(email) + "})";
    }
}
