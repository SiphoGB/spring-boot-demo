package za.co.demo.spring.boot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.demo.spring.boot.domain.Answer;
import za.co.demo.spring.boot.domain.Question;
import za.co.demo.spring.boot.domain.Topic;
import za.co.demo.spring.boot.resource.TopicResource;

@Service
public class LoadData {

    @Autowired
    private TopicResource topicResource;

    public Topic insertTopic() {
        Topic topic = new Topic();
        topic.setName("Sample Questions " + getName());
        Set<Question> questions = new HashSet<Question>();
        topic.setQuestions(questions);
        
        Set<Answer> answers = new HashSet<Answer>();
        Question question1 = createQuestion(topic, "First Question");
        questions.add(question1);
        answers.add(createAnswer(question1, "a", "First Answer", true));
        answers.add(createAnswer(question1, "b", "Second Answer", false));        
        //This should be done in the domain objects
        question1.setAnswers(answers);

        Question question2 = createQuestion(topic, "Second Question");
        questions.add(question2);
        answers.add(createAnswer(question2, "a", "First Answer...", false));
        answers.add(createAnswer(question2, "b", "Second Answer..", true));        
        //This should be done in the domain objects
        question1.setAnswers(answers);

        topic = topicResource.save(topic);
        
        return topic;
    }
    
    private String getName() {
        return System.currentTimeMillis()+"";
    }

    private Question createQuestion(Topic topic, String question) {
        Question question1 = new Question();
        question1.setQuestion(question);
        question1.setTopic(topic);
        return question1;
    }

    private Answer createAnswer(Question question1, String answer,
            String display, boolean correct) {
        Answer answer1 = new Answer();
        answer1.setAnswer(answer);
        answer1.setDisplay(display);
        answer1.setCorrect(correct);
        answer1.setQuestion(question1);

        return answer1;
    }
}
