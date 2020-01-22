package br.paymentapi.wirecard.controller;

import br.paymentapi.wirecard.enums.PaymentType;
import br.paymentapi.wirecard.models.Payment;
import br.paymentapi.wirecard.repository.PaymentRepository;
import br.paymentapi.wirecard.validators.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@RestController
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;

    private Random rand = SecureRandom.getInstanceStrong();

    public PaymentController() throws NoSuchAlgorithmException {
    }

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping(value = "/pay")
    @ResponseStatus(HttpStatus.OK)
    public String pay(Payment payment) throws Exception {

        if (Objects.nonNull(payment)) {
            if (payment.getPaymentType().equals(PaymentType.CARTAO)) {
                if (Objects.nonNull(payment.getCard())) {
                    CreditCardValidator credCard = new CreditCardValidator(payment.getCard());
                    if (credCard.validateCreditCard()) {
                       payment =  paymentRepository.save(payment);

                        return "success";
                    } else {
                        throw new Exception("There's a error in payment");
                    }
                } else {
                    throw new Exception("You need to fill the credit card information");
                }
            } else {
                //gerar boleto
//                paymentRepository.save(payment);

                return generateBoletoNumber();
            }
        }
        return "done";
    }

    @GetMapping(value = "/success")
    @ResponseStatus(HttpStatus.OK)
    public void successo(Payment payment){
        Optional<Payment> paymentInfo = paymentRepository.findById(payment.getId());

        System.out.println(paymentInfo.toString());
    }

    private String generateBoletoNumber() {

        Long rangeMin = 1L;
        Long rangeMax = 100000000000L;

        StringBuilder boleto = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            Long randomValue = rangeMin + (rangeMax - rangeMin) * rand.nextLong();
            boleto.append(randomValue);
        }
        return boleto.toString();
    }


}
