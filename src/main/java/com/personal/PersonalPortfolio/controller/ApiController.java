package com.personal.PersonalPortfolio.controller;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import com.personal.PersonalPortfolio.domain.model.pages.AvailableServices;
import com.personal.PersonalPortfolio.domain.model.pages.Contact;
import com.personal.PersonalPortfolio.domain.model.pages.Portfolio;
import com.personal.PersonalPortfolio.service.interfaces.ApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/home")
    public About home(Long id) {
        return apiService.getAbout(id);
    }
    @RequestMapping("/about")
    public About about(Long id) {
        return apiService.getAbout(id);
    }

    @RequestMapping("/services")
    public AvailableServices services(Long id) {
        return apiService.getAvailableServices(id);
    }

    @RequestMapping("/portfolio")
    public Portfolio portfolio(Long id) {
        return apiService.getPortfolio(id);
    }

    @RequestMapping("/contact")
    public Contact contact(Long id) {
        return apiService.getContact(id);
    }
}
