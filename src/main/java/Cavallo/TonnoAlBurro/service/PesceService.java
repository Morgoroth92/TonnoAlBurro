package Cavallo.TonnoAlBurro.service;

import Cavallo.TonnoAlBurro.entities.Pesce;
import Cavallo.TonnoAlBurro.repository.PesceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesceService {

    // stiamo facendo un service per i pesci
    // qui inseriremo i metodi per gestire i pesci
    @Autowired
    PesceRepository pesceRepository;


    public Pesce createPesce(Pesce pesce) {
        return pesceRepository.save(pesce);
    }
    public List<Pesce> getAllPesci() {
        return pesceRepository.findAll();
    }

    public Pesce getPesceById(long id) {
        return pesceRepository.findById(id).orElseThrow(() -> new RuntimeException("Pesce non trovato"));
        // ritorna un pesce con un certo id, altrimenti lancia un'eccezione
    }

    public Pesce updatePesceById(long id, Pesce pesce) {
    Optional<Pesce> pesceDaAggiornare = pesceRepository.findById(id);
    if (pesceDaAggiornare.isPresent()) {
        Pesce pesceAggiornato = pesceDaAggiornare.get();
        pesceAggiornato.setDisponibile(pesce.isDisponibile());
        pesceAggiornato.setPrezzoPerKg(pesce.getPrezzoPerKg());
        pesceAggiornato.setDimensione(pesce.getDimensione());
        pesceAggiornato.setSpecie(pesce.getSpecie());
        pesceRepository.save(pesceAggiornato);
        return pesceAggiornato;
    } else {
        return null;
    }
}

    public Boolean deletePesceById(long id) {
        // qui cancelliamo un pesce con un certo id
        try {
            pesceRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    public Boolean deleteAllPesci() {
        try {
            pesceRepository.deleteAll();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
