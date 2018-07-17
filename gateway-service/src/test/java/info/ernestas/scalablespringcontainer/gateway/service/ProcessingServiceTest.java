package info.ernestas.scalablespringcontainer.gateway.service;

import info.ernestas.scalablespringcontainer.gateway.model.request.DataRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProcessingServiceTest {

    private JmsTemplate jmsTemplate;
    private ProcessingService processingService;

    @Before
    public void setUp() {
        jmsTemplate = mock(JmsTemplate.class);
        processingService = new ProcessingService(jmsTemplate);
    }

    @Test
    public void testProcess() {
        DataRequest dataRequest = new DataRequest("1", "John Doe");

        String result = processingService.process(dataRequest);

        assertThat(result, is("OK"));
        verify(jmsTemplate).convertAndSend("messages", dataRequest);
    }
}
