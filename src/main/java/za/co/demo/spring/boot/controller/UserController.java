package za.co.demo.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.demo.spring.boot.domain.Question;
import za.co.demo.spring.boot.domain.Topic;
import za.co.demo.spring.boot.domain.User;
import za.co.demo.spring.boot.domain.UserTopic;
import za.co.demo.spring.boot.domain.UserTopicAnswer;
import za.co.demo.spring.boot.resource.AnswerResource;
import za.co.demo.spring.boot.resource.TopicResource;
import za.co.demo.spring.boot.resource.UserTopicAnswerResource;
import za.co.demo.spring.boot.resource.UserTopicResource;

@RestController
@RequestMapping("/rest/user")
@Transactional
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private TopicResource topicResource;

    @Autowired
    private AnswerResource answerResource;

    @Autowired
    private UserTopicResource userTopicResource;

    @Autowired
    private UserTopicAnswerResource userTopicAnswerResource;

    @RequestMapping(value = "/start/{topicId}", method = RequestMethod.POST)
    public String startUserTopic(@PathVariable("topicId") long topicId,
            @RequestBody User user) {
        UserTopic userTopic = new UserTopic();
        userTopic.setUser(user);
        userTopic.setStart(System.currentTimeMillis());
        userTopic.setTopic(topicResource.findOne(topicId));
        userTopic.setUuid(UUID.randomUUID().toString());

        userTopicResource.save(userTopic);

        return userTopic.getUuid();
    }

    @RequestMapping(value = "/end/{uuid}", method = RequestMethod.POST)
    public double endUserTopic(@PathVariable("uuid") String uuid,
            @RequestBody Topic topic) {
        LOG.debug(topic.toString());
        UserTopic userTopic = userTopicResource.findByUuid(uuid);
        userTopic.setEnd(System.currentTimeMillis());
        int totalQuestions = 0;
        int totalCorrectQuestions = 0;
        
        for (Question question : topic.getQuestions()) {
            totalQuestions++;
            
            saveUserTopicAnswer(userTopic, question);

            LOG.debug("correct = {}, selected = {}", new Object[]{question.getCorrectAnswer(), question.getSelected()});
            
            if (question.getCorrectAnswer().equals(question.getSelected())) {
                totalCorrectQuestions++;
            }
        }

        // calculate result
        double result = ((double) totalCorrectQuestions / totalQuestions) * 100d;
        LOG.debug("result = " + result);
        
        userTopic.setResult(result);

        return userTopic.getResult();
    }

    private void saveUserTopicAnswer(UserTopic userTopic, Question question) {
        UserTopicAnswer userTopicAnswer = new UserTopicAnswer();
        userTopicAnswer.setQuestion(question);
        userTopicAnswer.setUserTopic(userTopic);
        userTopicAnswer.setAnswer(answerResource.findByQuestionAndAnswer(
                question, question.getSelected()));
        
        userTopicAnswerResource.save(userTopicAnswer);
    }

    @RequestMapping(value = "/usertopic")
    public Iterable<UserTopic> findAllUserTopics() {
        return userTopicResource.findAll();
    }

    @RequestMapping(value = "/usertopicanswer/{topicId}")
    public Iterable<UserTopicAnswer> findAllUserTopicAnswers(@PathVariable("topicId") long topicId) {
        return userTopicAnswerResource.findByUserTopicTopicId(topicId);
    }

    @RequestMapping(value = "/usertopic/{topicId}")
    public Iterable<UserTopic> findUserTopicsForTopic(
            @PathVariable("topicId") long topicId) {
        return userTopicResource.findByTopicId(topicId);
    }

}
