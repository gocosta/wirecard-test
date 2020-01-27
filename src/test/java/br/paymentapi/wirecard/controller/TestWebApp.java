package br.paymentapi.wirecard.controller;

import br.paymentapi.wirecard.enums.PaymentType;
import br.paymentapi.wirecard.models.Buyer;
import br.paymentapi.wirecard.models.Card;
import br.paymentapi.wirecard.models.Payment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebApp extends PaymentControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Payment payment;

    private Card card;

    private Buyer buyer;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        card = new Card.CardBuilder()
                .withHolder("Guilherme O Costa")
                .withNumber("4123456378964569")
                .withExpiration("20/2023")
                .withCvv("123")
                .build();

        buyer = new Buyer.BuyerBuilder()
                .withName("Guilherme")
                .withEmail("guilherme@gmail.com")
                .withCPF("41551086845")
                .build();

        payment = new Payment.PaymentBuilder()
                .withAmount(Double.valueOf(1200))
                .withPaymentType(PaymentType.CARTAO)
                .withCard(card)
                .withBuyer(buyer)
                .build();

    }

    @Test
    public void getAllPayments() throws Exception {

        String uri = "/payments";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.ALL)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void getPayment() throws Exception {

        String uri = "/payment/1";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.ALL)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void doPayment() throws Exception {
        String uri = "/pay";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .param("amount", "1200")
                .param("paymentType", "CARTAO")
                .param("card.holder", "Guilherme")
                .param("card.number", "4563412367896852")
                .param("card.expiration", "10/2022")
                .param("card.cvv", "123")
                .param("buyer.name", "Guilherme+Oliveira")
                .param("buyer.email", "guilherme@gmail.com")
                .param("buyer.CPF", "41551086824")
                .accept(MediaType.ALL)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(201, status);
        Assert.assertTrue(mvcResult.getResponse().getContentAsString().matches("Pagamento bem sucedido(.*)"));

    }

    @Test
    public void doPaymentwithBoleto() throws Exception {
        String uri = "/pay";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .param("amount", "1200")
                .param("paymentType", "BOLETO")
                .param("buyer.name", "Guilherme+Oliveira")
                .param("buyer.email", "guilherme@gmail.com")
                .param("buyer.CPF", "41551086824")
                .accept(MediaType.ALL)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(201, status);
        Assert.assertTrue(mvcResult.getResponse().getContentAsString().matches("Segue numero de boleto(.*)"));
    }

}
