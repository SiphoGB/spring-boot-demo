package za.co.demo.spring.boot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserTopicAnswer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6552369646514124275L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserTopic userTopic;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    public UserTopic getUserTopic() {
        return userTopic;
    }

    public void setUserTopic(UserTopic userTopic) {
        this.userTopic = userTopic;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
