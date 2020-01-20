package br.paymentapi.wirecard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @RequestMapping(value = "/pay" , method = RequestMethod.POST)
    public String pay(){
        return "done";
    }
}
