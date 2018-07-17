package info.ernestas.scalablespringcontainer.backend.service.repository;

import info.ernestas.scalablespringcontainer.backend.model.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

}
