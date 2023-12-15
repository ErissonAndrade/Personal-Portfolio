package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.pages.Portfolio;
import com.personal.PersonalPortfolio.domain.model.utils.PortfolioCard;
import com.personal.PersonalPortfolio.domain.repository.PortfolioRepository;
import com.personal.PersonalPortfolio.service.interfaces.PortfolioService;

import java.util.List;
import java.util.NoSuchElementException;

public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;

    PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
    @Override
    public Portfolio findById(Long id) {
        Portfolio getPortfolio = this.portfolioRepository.findById(id)
                .orElseThrow(() ->  new NoSuchElementException("No portfolio found with id" + id));
        return getPortfolio;
    }

    @Override
    public Portfolio createPortfolio(Portfolio newPortfolio) {
        this.portfolioRepository.save(newPortfolio);
        Portfolio savedPortfolio = this.findById(newPortfolio.getId());
        return savedPortfolio;
    }

    @Override
    public Portfolio deletePortfolio(Long id) {
        this.portfolioRepository.deleteById(id);
        return null;
    }

    @Override
    public Portfolio updatePortfolio(Long id, Portfolio newPortfolio) {
        Portfolio getPortfolio = this.findById(id);
        getPortfolio.setPortfolioCards(newPortfolio.getPortfolioCards());
        getPortfolio.setText(newPortfolio.getText());
        getPortfolio.setTitle(newPortfolio.getTitle());
        return getPortfolio;
    }

    @Override
    public List<PortfolioCard> getPortfolioCards(Long portfolioId) {
        Portfolio getPortfolio = this.findById(portfolioId);
        return getPortfolio.getPortfolioCards();
    }

    @Override
    public PortfolioCard getPortfolioCard(Long portfolioId, Long portfolioCardId) {
        Portfolio getPortfolio = this.findById(portfolioId);
        PortfolioCard findPortfolioCard = getPortfolio.getPortfolioCards().stream()
                .filter(portfolioCard -> portfolioCard.getId().equals(portfolioCardId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No portfolio card found with id" + portfolioCardId));
        return findPortfolioCard;
    }

    @Override
    public PortfolioCard createPortfolioCard(Long portfolioId, PortfolioCard newPortfolioCard) {
        Portfolio getPortfolio = this.findById(portfolioId);
        List<PortfolioCard> getPortfolioCards = getPortfolio.getPortfolioCards();
        getPortfolioCards.add(newPortfolioCard);

        this.portfolioRepository.save(getPortfolio);

        return newPortfolioCard;
    }

    @Override
    public PortfolioCard updatePortfolioCard(Long portfolioId, Long portfolioCardId, PortfolioCard newPortfolioCard) {
        Portfolio getPortfolio = this.findById(portfolioId);
        PortfolioCard getPortfolioCard = this.getPortfolioCard(portfolioId, portfolioCardId);

        getPortfolioCard.setPortfolioURL(newPortfolioCard.getPortfolioURL());
        getPortfolioCard.setPreviewURL(newPortfolioCard.getPreviewURL());
        getPortfolioCard.setText(newPortfolioCard.getText());
        getPortfolioCard.setTitle(newPortfolioCard.getTitle());

        this.portfolioRepository.save(getPortfolio);

        return newPortfolioCard;
    }

    @Override
    public PortfolioCard deletePortfolioCard(Long portfolioId, Long portfolioCardId) {
        List<PortfolioCard> getPortfolioCards = this.getPortfolioCards(portfolioId);
        PortfolioCard getPortfolioCard = this.getPortfolioCard(portfolioId, portfolioCardId);
        getPortfolioCards.remove(getPortfolioCard);
        return getPortfolioCard;
    }
}
