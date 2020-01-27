package br.paymentapi.wirecard.controller;

import br.paymentapi.wirecard.enums.PaymentType;
import br.paymentapi.wirecard.models.Payment;
import br.paymentapi.wirecard.repository.PaymentRepository;
import br.paymentapi.wirecard.validators.CreditCardValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Api(value = "Wirecard Payment Test", description = "Payment test")
@RestController
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;

    private Random rand = SecureRandom.getInstanceStrong();

    public PaymentController() throws NoSuchAlgorithmException {
    }

    @ApiOperation(value = "Get all the payments")
    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "", dataType = "java.lang.Long")})
    @ApiOperation(value = "Get the payment by payment ID")
    @GetMapping("/payment/{id}")
    public ResponseEntity<?> getPayment(@PathVariable("id") Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @ApiImplicitParams(value = {@ApiImplicitParam(name = "payment", value = "", dataType = "br.paymentapi.wirecard.models.Payment")})
    @ApiOperation(value = "Do the payment, with card or boleto and return the information")
    @PostMapping(value = "/pay")
    @ResponseStatus(HttpStatus.CREATED)
    public String pay(Payment payment) throws Exception {

        if (Objects.nonNull(payment)) {
            if (payment.getPaymentType().equals(PaymentType.CARTAO)) {
                if (Objects.nonNull(payment.getCard())) {
                    CreditCardValidator credCard = new CreditCardValidator(payment.getCard());
                    if (credCard.validateCreditCard()) {
                        payment = paymentRepository.save(payment);
                        ObjectMapper obj = new ObjectMapper();

                        return "Pagamento bem sucedido <br> Dados: <br> " + obj.writeValueAsString(payment);
                    } else {
                        throw new Exception("There's a error in your payment");
                    }
                } else {
                    throw new Exception("You need to fill the credit card information");
                }
            } else {
                //gera numero do boleto
                paymentRepository.save(payment);

                return "Segue numero de boleto para o pagamento: " + generateBoletoNumber();
            }
        } else {
            throw new Exception("You need to fill the payment informations");
        }
    }

    private String generateBoletoNumber() {

        Long rangeMin = 0L;
        Long rangeMax = 100000000000L;

        StringBuilder boleto = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            Long randomValue = rangeMin + (rangeMax - rangeMin) * rand.nextLong();
            boleto.append(randomValue);
        }
        return boleto.toString();
    }


}
