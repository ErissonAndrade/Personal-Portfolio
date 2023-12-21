package com.personal.PersonalPortfolio.controller;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import com.personal.PersonalPortfolio.service.interfaces.AboutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/about")
public class AboutController {
    private final AboutService aboutService;
    AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public String about() {
        return "Hello There";
    }

    /**
     * Retrieves the About object with the specified ID.
     *
     * @param id the ID of the About object to retrieve
     * @return the About object with the specified ID
     */
    @GetMapping("/{id}")
    public About about(@PathVariable Long id) {
        return this.aboutService.findById(id);
    }

    @PostMapping
    public About createAbout(About about){
        return this.aboutService.create(about);
    }

    @PutMapping("/{id}")
    public About updateAbout(Long id, About about){
        return this.aboutService.update(id, about);
    }
}
