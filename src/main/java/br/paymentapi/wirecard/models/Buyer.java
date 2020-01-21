package br.paymentapi.wirecard.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
@EntityListeners(AuditingEntityListener.class)
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "buyer_name", nullable = false)
    private String name;

    @Column(name = "buyer_email", nullable = false)
    private String email;

    @Column(name = "buyer_cpf", nullable = false)
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
}
