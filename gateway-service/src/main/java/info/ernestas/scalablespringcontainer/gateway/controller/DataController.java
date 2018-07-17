package info.ernestas.scalablespringcontainer.gateway.controller;

import info.ernestas.scalablespringcontainer.gateway.model.request.DataRequest;
import info.ernestas.scalablespringcontainer.gateway.model.response.DataResponse;
import info.ernestas.scalablespringcontainer.gateway.service.ProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    private final ProcessingService processingService;

    public DataController(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public DataResponse saveData(@RequestBody DataRequest request) {
        LOGGER.info("Received request: {}", request);

        String result = processingService.process(request);

        return new DataResponse(result);
    }

}
