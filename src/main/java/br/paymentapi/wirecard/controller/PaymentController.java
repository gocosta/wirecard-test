package br.paymentapi.wirecard.controller;

import br.paymentapi.wirecard.enums.PaymentType;
import br.paymentapi.wirecard.models.Payment;
import br.paymentapi.wirecard.validators.CreditCardValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;
import java.util.Random;

@Controller
public class PaymentController {

    @GetMapping("/pay")
    public String doPayment(Payment payment) {
        return "pay";
    }

    @PostMapping(value = "/pay")
    @ResponseStatus(HttpStatus.OK)
    public String pay(Payment payment) {

        if (Objects.nonNull(payment)) {
            if (payment.getPaymentType().equals(PaymentType.CARTAO)) {
                if (Objects.nonNull(payment.getCard())) {
                    CreditCardValidator credCard = new CreditCardValidator(payment.getCard());
                    if (credCard.validateCreditCard()) {

                    }

                } else {

                }
            } else {
                //gerar boleto
                String boleto = generateBoletoNumber();

                return boleto;
            }
        }
        System.out.println("doneee!!!!");
        return "done";
    }

    private String generateBoletoNumber() {

        Long rangeMin = 1L;
        Long rangeMax = 100000000000L;
        Random rnd = new Random();

        StringBuilder boleto = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            Long randomValue = rangeMin + (rangeMax - rangeMin) * rnd.nextLong();
            boleto.append(randomValue);
        }
        return boleto.toString();
    }


}
