package info.ernestas.scalablespringcontainer.gateway.controller;

import info.ernestas.scalablespringcontainer.gateway.model.request.DataRequest;
import info.ernestas.scalablespringcontainer.gateway.model.response.DataResponse;
import info.ernestas.scalablespringcontainer.gateway.service.ProcessingService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataControllerTest {

    private static final String OK = "OK";
    private DataController dataController;
    private ProcessingService processingService;

    @Before
    public void setUp() {
        processingService = mock(ProcessingService.class);
        dataController = new DataController(processingService);
    }

    @Test
    public void testSaveData() {
        DataRequest dataRequest = new DataRequest("1", "John Doe");
        when(processingService.process(dataRequest)).thenReturn(OK);

        DataResponse response = dataController.saveData(dataRequest);

        assertThat(response.getStatus(), is(OK));
    }
}
