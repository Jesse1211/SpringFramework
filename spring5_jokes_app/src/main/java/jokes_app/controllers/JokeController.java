package jokes_app.controllers;

import jokes_app.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 1/23/21.
 */
@Controller // Spring MVC controller: utilize spring managed component - JokeService
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) { // Service is injected by spring
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})              // set up the mapping (url path)
    public String showJoke(Model model) {   // controller method
        // model is a map implementation, add joke service to model
        model.addAttribute("joke", jokeService.getJoke());
        return "index"; // index view: thymeleaf view layer: ../resources/templates
    }
}
