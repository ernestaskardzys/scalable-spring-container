package info.ernestas.scalablespringcontainer.backend.service;

import info.ernestas.scalablespringcontainer.backend.model.entity.Person;
import info.ernestas.scalablespringcontainer.backend.model.request.DataRequest;
import info.ernestas.scalablespringcontainer.backend.service.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    private final PersonRepository personRepository;

    public MessageService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @JmsListener(destination = "messages", containerFactory = "myFactory")
    public void receiveMessage(DataRequest dataRequest) {
        LOGGER.info("Received message: {}", dataRequest.getName());

        Person person = new Person(UUID.randomUUID().toString(), dataRequest.getName());

        personRepository.save(person);
    }

}
