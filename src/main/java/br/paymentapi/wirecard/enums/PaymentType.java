package br.paymentapi.wirecard.enums;

public enum PaymentType {

    CARTAO("cartao"),
    BOLETO("boleto");

    private String type;

    PaymentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
