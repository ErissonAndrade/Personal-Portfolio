package com.personal.PersonalPortfolio.service.interfaces;

import com.personal.PersonalPortfolio.domain.model.pages.*;

public interface ApiService {
    Home getHome(Long id);

    About getAbout(Long id);

    AvailableServices getAvailableServices(Long id);

    Portfolio getPortfolio(Long id);

    Contact getContact(Long id);
}
