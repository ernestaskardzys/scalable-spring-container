package info.ernestas.scalablespringcontainer.backend.service;

import info.ernestas.scalablespringcontainer.backend.model.entity.Person;
import info.ernestas.scalablespringcontainer.backend.model.request.DataRequest;
import info.ernestas.scalablespringcontainer.backend.service.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessageServiceTest {

    private PersonRepository personRepository;
    private MessageService messageService;

    @Before
    public void setUp() {
        personRepository = mock(PersonRepository.class);
        messageService = new MessageService(personRepository);
    }

    @Test
    public void testReceiveMessage() {
        DataRequest dataRequest = new DataRequest("John Doe");

        messageService.receiveMessage(dataRequest);

        verify(personRepository).save(any(Person.class));
    }
}
