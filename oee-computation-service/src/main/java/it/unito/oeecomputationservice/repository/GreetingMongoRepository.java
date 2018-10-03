package it.unito.oeecomputationservice.repository;

import it.unito.oeecomputationservice.events.model.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingMongoRepository extends MongoRepository<Greeting, Integer> {
}
