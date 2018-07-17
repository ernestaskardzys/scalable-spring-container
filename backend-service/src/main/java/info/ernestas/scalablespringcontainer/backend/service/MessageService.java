package info.ernestas.scalablespringcontainer.backend.service;

import info.ernestas.scalablespringcontainer.backend.request.DataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    @JmsListener(destination = "messages", containerFactory = "myFactory")
    public void receiveMessage(DataRequest dataRequest) {
        LOGGER.info("Received message: {} : {}", dataRequest.getId(), dataRequest.getName());
    }

}
