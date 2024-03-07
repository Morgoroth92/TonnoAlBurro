package Cavallo.TonnoAlBurro.repository;

import Cavallo.TonnoAlBurro.entities.Pesce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesceRepository extends JpaRepository<Pesce, Long> {
    // stiamo facendo un repository per i pesci
    // qui inseriremo le nostre query
}
