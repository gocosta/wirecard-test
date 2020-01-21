package br.paymentapi.wirecard.controller;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PaymentControllerTest {

    @Test
    public void doPayment() {
    }

    @Test
    public void pay() {

        String uriBase = "http://localhost:8080/pay";

        given()
                .param("buyer.name", "Guilherme+Costa")
                .param("buyer.email", "guilherme@gmail.com")
                .param("buyer.CPF", "41551086832")
                .param("amount", "1300")
                .param("paymentType", "cartao")
                .param("card.holder", "Guilherme")
                .param("card.number", "4478963285217456")
                .param("card.expiration", "10/2021")
                .param("card.cvv", "123")
                .post(uriBase)
                .then()
                .statusCode(200);
    }
}