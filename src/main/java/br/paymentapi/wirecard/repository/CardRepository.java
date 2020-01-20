package br.paymentapi.wirecard.repository;

import br.paymentapi.wirecard.models.Card;
import br.paymentapi.wirecard.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
