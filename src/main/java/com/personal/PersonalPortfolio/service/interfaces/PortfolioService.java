package com.personal.PersonalPortfolio.service.interfaces;

import com.personal.PersonalPortfolio.domain.model.pages.Portfolio;
import com.personal.PersonalPortfolio.domain.model.utils.PortfolioCard;

import java.util.List;

public interface PortfolioService {
    Portfolio findById(Long id);

    Portfolio createPortfolio(Portfolio newPortfolio);

    Portfolio deletePortfolio(Long id);

    Portfolio updatePortfolio(Long id, Portfolio newPortfolio );

    List<PortfolioCard> getPortfolioCards(Long portfolioId);
    
    PortfolioCard getPortfolioCard(Long portfolioId, Long PortfolioCardId);
    PortfolioCard createPortfolioCard(Long portfolioId, PortfolioCard newPortfolioCard);
    
    PortfolioCard updatePortfolioCard(Long portfolioId, Long portfolioCardId, PortfolioCard newPortfolioCard);
    
    PortfolioCard deletePortfolioCard(Long portfolioId, Long portfolioCardId);
}
