package za.co.demo.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.demo.spring.boot.resource.UserResource;

@RestController
public class Example {
	
    @Autowired
    private UserResource userResource;
    
	@RequestMapping("/")
	public String hello() {
		return "Hello " + userResource.findOne(1L).getName();
	}
	
	@RequestMapping("/args/{val}")
	public String helloWithArgs(@PathVariable("val") String val) {
		return "Hello " + val;
	}

}
