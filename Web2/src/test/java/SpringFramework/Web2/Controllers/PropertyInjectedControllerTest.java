package SpringFramework.Web2.Controllers;

import SpringFramework.Web2.Services.GreetingServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;
    // Configure the controller (Setting up conditions) by setup method
    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceImp();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}
