package it.unito.oeecomputationservice.repository;

import it.unito.oeecomputationservice.events.model.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "greetings", path = "greetings")
public interface GreetingMongoRepository extends MongoRepository<Greeting, String> {
}
