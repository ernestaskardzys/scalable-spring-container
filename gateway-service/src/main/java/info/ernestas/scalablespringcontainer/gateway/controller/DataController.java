package info.ernestas.scalablespringcontainer.gateway.controller;

import info.ernestas.scalablespringcontainer.gateway.model.request.DataRequest;
import info.ernestas.scalablespringcontainer.gateway.model.response.DataResponse;
import info.ernestas.scalablespringcontainer.gateway.service.ProcessingService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final ProcessingService processingService;

    public DataController(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public DataResponse saveData(@RequestBody DataRequest request) {
        String result = processingService.process(request);

        return new DataResponse(result);
    }

}
