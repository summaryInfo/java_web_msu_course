package org.jbes.storage.entity;

import javax.persistence.*;
import org.hibernate.annotations.Type;

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

    @Type(type = "string-array")
    @Column(nullable = false, name = "address", columnDefinition = "text[]")
    private String[] address;

    @Type(type = "string-array")
    @Column(nullable = false, name = "tel", columnDefinition = "text[]")
    private String[] tel;

    @Type(type = "string-array")
    @Column(nullable = false, name = "email", columnDefinition = "text[]")
    private String[] email;

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
}
