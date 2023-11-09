package com.personal.PersonalPortfolio.domain.model;

import com.personal.PersonalPortfolio.domain.model.pages.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class API {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Home home;
    private About about;

    private Service service;

    private Portfolio portfolio;

    private Contact contact;
}
