package org.jbes.storage.entity;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import java.util.List;
import java.util.ArrayList;

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

    @Type(type = "com.vladmihalcea.hibernate.type.array.ListArrayType")
    @Column(nullable = false, name = "address", columnDefinition = "text[]")
    private List<String> address = new ArrayList<String>();

    @Type(type = "com.vladmihalcea.hibernate.type.array.ListArrayType")
    @Column(nullable = false, name = "tel", columnDefinition = "text[]")
    private List<String> tel = new ArrayList<String>();

    @Type(type = "com.vladmihalcea.hibernate.type.array.ListArrayType")
    @Column(nullable = false, name = "email", columnDefinition = "text[]")
    private List<String> email = new ArrayList<String>();

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

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<String> getTel() {
        return tel;
    }

    public void setTel(List<String> tel) {
        this.tel = tel;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public boolean equals(Consumer other) {
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
        if ((address == null) != (other.address == null) || (address != null && !address.equals(other.address)))
            return false;
        if ((tel == null) != (other.tel == null) || (tel != null && !tel.equals(other.tel)))
            return false;
        if ((email == null) != (other.email == null) || (email != null && !email.equals(other.email)))
            return false;
        return true;
    }

    public String toString() {
        return "Consumer(consumerId=" + (consumerId != null ? consumerId.toString() : "<NULL>") + ", name="
                + (name != null ? name.toString() : "<NULL>") + ", description="
                + (description != null ? description.toString() : "<NULL>") + ", address="
                + (address != null ? address.toString() : "<NULL>") + ", tel="
                + (tel != null ? tel.toString() : "<NULL>") + ", email="
                + (email != null ? email.toString() : "<NULL>") + ")";
    }
}
