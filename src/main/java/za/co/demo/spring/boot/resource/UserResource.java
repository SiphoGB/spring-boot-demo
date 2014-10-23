package za.co.demo.spring.boot.resource;

import org.springframework.data.repository.CrudRepository;

import za.co.demo.spring.boot.domain.User;

public interface UserResource extends CrudRepository<User, Long> {

}
