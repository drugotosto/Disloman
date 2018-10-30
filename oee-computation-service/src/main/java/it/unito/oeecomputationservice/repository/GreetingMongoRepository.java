package it.unito.oeecomputationservice.repository;

import it.unito.oeecomputationservice.events.model.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
//@RepositoryRestResource(collectionResourceRel = "greetings", path = "ssb/greetings")
@RepositoryRestResource(collectionResourceRel = "greetings", path = "greetings")
public interface GreetingMongoRepository extends MongoRepository<Greeting, String> {
}
