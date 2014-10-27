package za.co.demo.spring.boot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import za.co.demo.spring.boot.TestApplication;
import za.co.demo.spring.boot.resource.AnswerResource;
import za.co.demo.spring.boot.resource.TopicResource;
import za.co.demo.spring.boot.resource.UserResource;
import za.co.demo.spring.boot.resource.UserTopicAnswerResource;
import za.co.demo.spring.boot.resource.UserTopicResource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@Transactional
public class UserTests {

    @Autowired
    private UserResource userResource;

    @Autowired
    private UserTopicResource userTopicResource;

    @Autowired
    private TopicResource topicResource;

    @Autowired
    private AnswerResource answerResource;

    @Autowired
    private UserTopicAnswerResource userTopicAnswerResource;

    @Test
    public void testGetUser() {
        Long userId = 1L;
        User user = userResource.findOne(userId);
        assertNotNull(user);
        assertEquals("Naeem", user.getName());
    }

    @Test
    public void testInsertUserTopic() {
        UserTopic userTopic = new UserTopic();
        userTopic.setStart(System.currentTimeMillis() - 1000);
        userTopic.setResult(75d);
        userTopic.setTopic(topicResource.findOne(1L));
        userTopic.setUser(userResource.findOne(1L));
        userTopic.setUuid(UUID.randomUUID().toString());
        userTopic.setEnd(System.currentTimeMillis());
        userTopicResource.save(userTopic);
    }

    @Test
    public void testInsertUserTopicAnswer() {
        UserTopic userTopic = new UserTopic();
        userTopic.setStart(System.currentTimeMillis() - 1000);
        userTopic.setResult(75d);
        userTopic.setTopic(topicResource.findOne(1L));
        userTopic.setUser(userResource.findOne(1L));
        userTopic.setUuid(UUID.randomUUID().toString());
        System.out.println("uuid = " + userTopic.getUuid());
        userTopic.setEnd(System.currentTimeMillis());
        userTopic = userTopicResource.save(userTopic);
        System.out.println("userTopic.id = " + userTopic.getId());

        UserTopicAnswer userTopicAnswer = new UserTopicAnswer();
        Answer answer = answerResource.findOne(2L);
        userTopicAnswer.setAnswer(answer);
        userTopicAnswer.setQuestion(answer.getQuestion());
        userTopicAnswer.setUserTopic(userTopic);
        userTopicAnswerResource.save(userTopicAnswer);
    }

}
