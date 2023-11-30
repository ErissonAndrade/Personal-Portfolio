package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.pages.Home;
import com.personal.PersonalPortfolio.domain.repository.HomeRepository;
import com.personal.PersonalPortfolio.service.interfaces.HomeService;

import java.util.NoSuchElementException;

public class HomeServiceImpl implements HomeService {
    private final HomeRepository homeRepository;
    HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public Home createHome(Home home) {
        homeRepository.save(home);
        return home;
    }

    @Override
    public Home getHomeById(Long id) {
        return homeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No home found with id" + id));
    }

    @Override
    public Home updateHome(Long id, Home newHome) {
        Home getHome = this.getHomeById(id);

        getHome.setGreetings(newHome.getGreetings());
        getHome.setName(newHome.getName());
        getHome.setRole(newHome.getRole());
        getHome.setIntro(newHome.getIntro());
        getHome.setIntro(newHome.getIntro());

        homeRepository.save(getHome);

        return newHome;
    }

    @Override
    public Home deleteHome(Long id) {
        Home getHome = this.getHomeById(id);
        homeRepository.deleteById(id);
        return getHome;
    }

    @Override
    public String createGreetings(Long homeId, String newGreetings) {
        Home getHome = this.getHomeById(homeId);

        getHome.setGreetings(newGreetings);

        homeRepository.save(getHome);

        return newGreetings;
    }

    @Override
    public String getGreetings(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        return getHome.getGreetings();
    }

    @Override
    public String updateGreetings(Long homeId, String newGreetings) {
        Home getHome = this.getHomeById(homeId);

        getHome.setGreetings(newGreetings);

        homeRepository.save(getHome);

        return getHome.getGreetings();
    }

    @Override
    public String deleteGreetings(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        getHome.setGreetings(null);

        return getHome.getGreetings();
    }

    @Override
    public String createName(Long homeId, String name) {
        Home getHome = this.getHomeById(homeId);

        getHome.setName(name);

        homeRepository.save(getHome);

        return getHome.getName();
    }

    @Override
    public String getName(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        return getHome.getName();
    }

    @Override
    public String updateName(Long homeId, String newName) {
        Home getHome = this.getHomeById(homeId);

        getHome.setName(newName);

        homeRepository.save(getHome);

        return getHome.getName();
    }

    @Override
    public String deleteName(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        getHome.setName(null);

        homeRepository.save(getHome);

        return getHome.getName();
    }

    @Override
    public String createRole(Long homeId, String newRole) {
        Home getHome = this.getHomeById(homeId);

        getHome.setRole(newRole);

        homeRepository.save(getHome);

        return getHome.getRole();
    }

    @Override
    public String getRole(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        return getHome.getRole();
    }

    @Override
    public String updateRole(Long homeId, String newRole) {
        Home getHome = this.getHomeById(homeId);

        getHome.setRole(newRole);

        homeRepository.save(getHome);

        return getHome.getRole();
    }

    @Override
    public String deleteRole(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        getHome.setRole(null);

        homeRepository.save(getHome);

        return getHome.getRole();
    }

    @Override
    public String createIntro(Long homeId, String intro) {
        Home getHome = this.getHomeById(homeId);

        getHome.setIntro(intro);

        homeRepository.save(getHome);

        return getHome.getIntro();
    }

    @Override
    public String getIntro(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        return getHome.getIntro();
    }

    @Override
    public String updateIntro(Long homeId, String newIntro) {
        Home getHome = this.getHomeById(homeId);

        getHome.setIntro(newIntro);

        homeRepository.save(getHome);

        return getHome.getIntro();
    }

    @Override
    public String deleteIntro(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        getHome.setIntro(null);

        homeRepository.save(getHome);

        return getHome.getIntro();
    }

    @Override
    public String createPictureURL(Long homeId, String newUrl) {
        Home getHome = this.getHomeById(homeId);

        getHome.setPictureURL(newUrl);

        homeRepository.save(getHome);

        return getHome.getPictureURL();
    }

    @Override
    public String getPictureURL(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        return getHome.getPictureURL();
    }

    @Override
    public String updatePictureUrl(Long homeId, String newUrl) {
        Home getHome = this.getHomeById(homeId);

        getHome.setPictureURL(newUrl);

        homeRepository.save(getHome);

        return getHome.getPictureURL();
    }

    @Override
    public String deletePictureUrl(Long homeId) {
        Home getHome = this.getHomeById(homeId);

        getHome.setPictureURL(null);

        homeRepository.save(getHome);

        return getHome.getPictureURL();
    }
}
