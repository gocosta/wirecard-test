package br.paymentapi.wirecard.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;

}
