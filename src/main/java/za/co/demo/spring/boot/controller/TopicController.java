package za.co.demo.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.demo.spring.boot.domain.Topic;
import za.co.demo.spring.boot.resource.TopicResource;
import za.co.demo.spring.boot.resource.UserTopicResource;

@RestController
@RequestMapping("/rest/topics")
public class TopicController {

	@Autowired
	private TopicResource topicResource;

	@Autowired
	private UserTopicResource userTopicResource;

	private final Logger LOG = LoggerFactory.getLogger(TopicController.class);

	@RequestMapping("/")
	public Iterable<Topic> getTopics() {
		Iterable<Topic> topics = topicResource.findAll();
		return topics;
	}

	@RequestMapping("/{id}")
	public Topic getTopic(@PathVariable("id") long id) {
		Topic topic = topicResource.findOne(id);
		return topic;
	}

}
