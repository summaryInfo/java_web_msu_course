package org.jbes.storage.entity;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue
    @Column(name = "provider_id")
    private Long providerId;

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

    public Provider() {
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
        if ((address == null) != (other.address == null) || (address != null && !address.equals(other.address)))
            return false;
        if ((tel == null) != (other.tel == null) || (tel != null && !tel.equals(other.tel)))
            return false;
        if ((email == null) != (other.email == null) || (email != null && !email.equals(other.email)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Provider(providerId=" + (providerId != null ? providerId.toString() : "<NULL>") + ", name="
                + (name != null ? name.toString() : "<NULL>") + ", description="
                + (description != null ? description.toString() : "<NULL>") + ", address="
                + (address != null ? address.toString() : "<NULL>") + ", tel="
                + (tel != null ? tel.toString() : "<NULL>") + ", email=" + (email != null ? email.toString() : "<NULL>")
                + ")";
    }
}
