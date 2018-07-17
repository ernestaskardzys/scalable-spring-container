package info.ernestas.scalablespringcontainer.gateway;

import info.ernestas.scalablespringcontainer.gateway.model.request.DataRequest;
import info.ernestas.scalablespringcontainer.gateway.model.response.DataResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    private static final String MICROSERVICE_URL = "http://localhost:";
    private static final String OK = "OK";

    @LocalServerPort
    private int servicePort;

    @Value("${local.management.port}")
    private int managementPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private JmsTemplate jmsTemplate;

    @Test
    public void shouldProcessMessage() {
        DataRequest dataRequest = new DataRequest("John Doe");

        ResponseEntity<DataResponse> entity = restTemplate.postForEntity(MICROSERVICE_URL + servicePort + "/data", dataRequest, DataResponse.class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody().getStatus(), is(OK));
    }

    @Test
    public void serviceShouldWork() {
        ResponseEntity<Map> entity = restTemplate.getForEntity(MICROSERVICE_URL + managementPort + "/actuator/info", Map.class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
    }

}
