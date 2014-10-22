package za.co.demo.spring.boot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	
	@RequestMapping("/")
	public String hello() {
		return "java controller";
	}
	
	@RequestMapping("/args/{val}")
	public String helloWithArgs(@PathVariable("val") String val) {
		return "Hello " + val;
	}

}
