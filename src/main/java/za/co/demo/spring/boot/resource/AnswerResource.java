package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.Answer;

public interface AnswerResource extends CrudRepository<Answer, Long> {

}
