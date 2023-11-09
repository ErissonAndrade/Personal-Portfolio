package com.personal.PersonalPortfolio.domain.model.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactInfoCard extends Text{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String iconURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
