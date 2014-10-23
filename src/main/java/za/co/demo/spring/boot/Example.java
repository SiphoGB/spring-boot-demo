package za.co.demo.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	
    @Autowired
	private Config config;

    @RequestMapping("/")
	public String hello() {
		return "java controller";
	}
	   
    @RequestMapping("/version")
    public String version() {
        return config.getVersion();
    }
    
	@RequestMapping("/args/{val}")
	public String helloWithArgs(@PathVariable("val") String val) {
		return "Hello " + val;
	}

}
