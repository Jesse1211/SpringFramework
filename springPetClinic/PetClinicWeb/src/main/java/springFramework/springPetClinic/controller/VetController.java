package springFramework.springPetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springFramework.springPetClinic.services.IVet;

@Controller
public class VetController {
    private final IVet vetService;
    public VetController(IVet vetService) {
        this.vetService = vetService;
    }
    @RequestMapping({"/vets", "/vets/index", "/vets.html", "/vets/index.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
