package com.personal.PersonalPortfolio.domain.model.pages;

import com.personal.PersonalPortfolio.domain.model.utils.PortfolioCard;
import com.personal.PersonalPortfolio.domain.model.utils.Text;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
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
