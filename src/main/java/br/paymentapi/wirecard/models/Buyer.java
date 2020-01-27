package br.paymentapi.wirecard.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String CPF;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public static final class BuyerBuilder {
        private long id;
        private String name;
        private String email;
        private String CPF;

        public BuyerBuilder() {
        }

        public static BuyerBuilder aBuyer() {
            return new BuyerBuilder();
        }

        public BuyerBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public BuyerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public BuyerBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public BuyerBuilder withCPF(String CPF) {
            this.CPF = CPF;
            return this;
        }

        public Buyer build() {
            Buyer buyer = new Buyer();
            buyer.setId(id);
            buyer.setName(name);
            buyer.setEmail(email);
            buyer.setCPF(CPF);
            return buyer;
        }
    }
}
