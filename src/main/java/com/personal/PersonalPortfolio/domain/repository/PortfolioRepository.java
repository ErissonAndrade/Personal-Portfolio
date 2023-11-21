package com.personal.PersonalPortfolio.domain.repository;

import com.personal.PersonalPortfolio.domain.model.pages.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
