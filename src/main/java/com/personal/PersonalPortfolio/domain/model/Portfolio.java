package com.personal.PersonalPortfolio.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Portfolio extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<PortfolioCard> portfolioCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PortfolioCard> getPortfolioCards() {
        return portfolioCards;
    }

    public void setPortfolioCards(List<PortfolioCard> portfolioCards) {
        this.portfolioCards = portfolioCards;
    }
}
