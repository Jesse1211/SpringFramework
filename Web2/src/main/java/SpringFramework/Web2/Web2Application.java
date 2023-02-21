package SpringFramework.Web2;

import SpringFramework.Web2.Controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Web2Application {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Web2Application.class, args);

		// Add controller to the spring context
		MyController myController = (MyController) ctx.getBean("myController");

		// The controller is ready to invoke
		String greeting = myController.sayHello();

		System.out.println(greeting);
	}
}
