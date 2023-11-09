package com.personal.PersonalPortfolio.domain.model.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServiceCard extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String icon;

    private PopupWindow popupWindow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public void setPopupWindow(PopupWindow popupWindow) {
        this.popupWindow = popupWindow;
    }
}
