package br.paymentapi.wirecard;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WirecardApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WirecardApplicationTests {


    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Ignore
    void contextLoads() {
    }

    @Test
    void showRequest(){
        String teste = getRootUrl();

        Assert.assertNotNull(teste);
    }


}
