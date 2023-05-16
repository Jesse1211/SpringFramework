package springFramework.springPetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springFramework.springPetClinic.services.IOwner;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final IOwner ownerService;

    public OwnerController(IOwner ownerService) {
        this.ownerService = ownerService;
    }

    // Spring MVC calls the function with injecting a model which is returned by Thymeleaf
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){
        // addAttribute(property name inside model, the set to be iterated over)
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }
}