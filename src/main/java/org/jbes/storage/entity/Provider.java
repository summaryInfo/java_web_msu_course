package org.jbes.storage.entity;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import java.util.Arrays;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String address;

    private String phone;

    private String email;

    public Provider() {
    }

    public Provider(Long providerId, String name, String description, String address, String phone, String email) {
        this.providerId = providerId;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (obj.getClass() != Provider.class)
            return false;
        Provider other = (Provider) obj;
        if ((providerId == null) != (other.providerId == null)
                || (providerId != null && !providerId.equals(other.providerId)))
            return false;
        if ((name == null) != (other.name == null) || (name != null && !name.equals(other.name)))
            return false;
        if ((description == null) != (other.description == null)
                || (description != null && !description.equals(other.description)))
            return false;
        if ((address == null) != (other.address == null) || (address != null && !other.address.equals(address)))
            return false;
        if ((phone == null) != (other.phone == null) || (phone != null && !other.phone.equals(phone)))
            return false;
        if ((email == null) != (other.email == null) || (email != null && !other.email.equals(email)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Provider(providerId=" + (providerId != null ? providerId.toString() : "<NULL>") + ", name="
                + (name != null ? name.toString() : "<NULL>") + ", description="
                + (description != null ? description.toString() : "<NULL>") + ", address="
                + (address != null ? address : "<NULL>") + ", phone=" + (phone != null ? phone : "<NULL>") + ", email="
                + (email != null ? email : "<NULL>") + ")";
    }
}
