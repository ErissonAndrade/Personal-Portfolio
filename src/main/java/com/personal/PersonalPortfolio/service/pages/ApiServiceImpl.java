package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.Api;
import com.personal.PersonalPortfolio.domain.model.pages.*;
import com.personal.PersonalPortfolio.domain.repository.ApiRepository;
import com.personal.PersonalPortfolio.service.interfaces.ApiService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ApiServiceImpl implements ApiService {

    private final ApiRepository apiRepository;
    ApiServiceImpl(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }
    @Override
    public Home getHome(Long id) {
        Api findApi = apiRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Api not found with the id" + id));
        return findApi.getHome();
    }

    @Override
    public About getAbout(Long id) {
        Api findApi = apiRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Api not found with the id" + id));
        return findApi.getAbout();
    }

    @Override
    public AvailableServices getAvailableServices(Long id) {
        Api findApi = apiRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Api not found with the id" + id));
        return findApi.getAvailableServices();
    }

    @Override
    public Portfolio getPortfolio(Long id) {
        Api findApi = apiRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Api not found with the id" + id));
        return findApi.getPortfolio();
    }

    @Override
    public Contact getContact(Long id) {
        Api findApi = apiRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Api not found with the id" + id));
        return findApi.getContact();
    }
}
