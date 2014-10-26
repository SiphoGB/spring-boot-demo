package za.co.demo.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.demo.spring.boot.domain.Question;
import za.co.demo.spring.boot.domain.Topic;
import za.co.demo.spring.boot.domain.User;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	private final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/start/{topicId}", method = RequestMethod.POST)
	public String startUserTopic(@PathVariable("topicId") long topicId, @RequestBody User user) {
		return user.getName();
	}

	@RequestMapping(value = "/end/{uuid}", method = RequestMethod.POST)
	public String[] endUserTopic(@PathVariable("uuid") String uuid, @RequestBody Topic topic) {
		LOG.debug(topic.toString());
		List<String> selected = new ArrayList<String>();
		for (Question question : topic.getQuestions()) {
			selected.add(question.getSelected());
		}
		return selected.toArray(new String[selected.size()]);
	}
	
}
