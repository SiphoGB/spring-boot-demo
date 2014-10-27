package za.co.demo.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.demo.spring.boot.domain.Topic;
import za.co.demo.spring.boot.resource.TopicResource;
import za.co.demo.spring.boot.resource.UserTopicResource;

@RestController
@RequestMapping("/rest/topics")
@Transactional
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
    
    @RequestMapping("/active")
    public Iterable<Topic> getActiveTopics() {
        Iterable<Topic> topics = topicResource.findAll();
        List<Topic> activeTopics = new ArrayList<Topic>();
        for (Topic topic : topics) {
            if (topic.isActive()) {
                activeTopics.add(topic);
            }
        }
        
        return activeTopics;
    }

	@RequestMapping("/{id}")
	public Topic getTopic(@PathVariable("id") long id) {
		Topic topic = topicResource.findOne(id);
		return topic;
	}

    @RequestMapping("/active/{id}")
    public Topic setTopicActive(@PathVariable("id") long id) {
        Topic topic = topicResource.findOne(id);
        topic.setActive(true);
        return topic;
    }

    @RequestMapping("/inactive/{id}")
    public Topic setTopicInActive(@PathVariable("id") long id) {
        Topic topic = topicResource.findOne(id);
        topic.setActive(false);
        return topic;
    }

}
