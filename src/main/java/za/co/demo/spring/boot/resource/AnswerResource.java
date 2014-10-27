package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.Answer;
import za.co.demo.spring.boot.domain.Question;

public interface AnswerResource extends CrudRepository<Answer, Long> {

    Answer findByQuestionAndAnswer(Question question, String selected);

}
