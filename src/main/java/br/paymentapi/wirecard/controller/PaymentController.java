package br.paymentapi.wirecard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping(value = "/pay")
    public String pay(){
        System.out.println("doneee!!!!");
        return "done";
    }
}
