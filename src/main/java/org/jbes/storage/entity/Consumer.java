package org.jbes.storage.entity;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import java.util.Arrays;

@Entity
@Table(name = "consumers")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumerId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String address;

    private String tel;

    private String email;

    public Consumer() {
    }

    public Consumer(Long id, String name, String description, String address, String tel, String email) {
        this.consumerId = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.tel = tel;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != Consumer.class)
            return false;
        Consumer other = (Consumer) obj;
        if ((consumerId == null) != (other.consumerId == null)
                || (consumerId != null && !consumerId.equals(other.consumerId)))
            return false;
        if ((name == null) != (other.name == null) || (name != null && !name.equals(other.name)))
            return false;
        if ((description == null) != (other.description == null)
                || (description != null && !description.equals(other.description)))
            return false;
        if ((address == null) != (other.address == null) || (address != null && !other.address.equals(address)))
            return false;
        if ((tel == null) != (other.tel == null) || (tel != null && !other.tel.equals(tel)))
            return false;
        if ((email == null) != (other.email == null) || (email != null && !other.email.equals(email)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Consumer(consumerId=" + (consumerId != null ? consumerId.toString() : "<NULL>") + ", name="
                + (name != null ? name.toString() : "<NULL>") + ", description="
                + (description != null ? description.toString() : "<NULL>") + ", address="
                + (address != null ? address : "<NULL>") + ", tel=" + (tel != null ? tel : "<NULL>") + ", email="
                + (email != null ? email : "<NULL>") + ")";
    }
}
