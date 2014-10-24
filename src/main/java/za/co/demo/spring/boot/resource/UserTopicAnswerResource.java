package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.UserTopicAnswer;

public interface UserTopicAnswerResource extends
        CrudRepository<UserTopicAnswer, Long> {

}
