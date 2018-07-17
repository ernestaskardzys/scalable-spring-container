package info.ernestas.scalablespringcontainer.gateway.service;

import info.ernestas.scalablespringcontainer.gateway.model.request.DataRequest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessingService {

    private final JmsTemplate jmsTemplate;

    public ProcessingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String process(DataRequest dataRequest) {
        jmsTemplate.convertAndSend("messages", dataRequest);

        return "OK";
    }

}
