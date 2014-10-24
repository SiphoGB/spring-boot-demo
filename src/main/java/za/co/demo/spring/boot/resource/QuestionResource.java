package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.Question;

public interface QuestionResource extends CrudRepository<Question, Long> {

}
