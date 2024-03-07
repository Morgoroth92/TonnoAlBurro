package Cavallo.TonnoAlBurro.controllers;

import Cavallo.TonnoAlBurro.entities.Pesce;
import Cavallo.TonnoAlBurro.service.PesceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pesci")
public class PesceController {
    // stiamo facendo un controller per i pesci
    // qui inseriremo i metodi per gestire i pesci
    @Autowired
    PesceService pesceService;

    @GetMapping("/getAll")
    public List<Pesce> getAll() {
        return pesceService.getAllPesci();
    }

    @GetMapping("/getSingle/{id}")
    public Pesce getSinglePesce(@RequestParam long id) {
        return pesceService.getPesceById(id);
    }

    @PutMapping("/{id}/update")
    public Pesce updatePesce(@PathVariable long id, @RequestBody Pesce pesce) {
        return pesceService.updatePesceById(id, pesce );
    }

    @DeleteMapping("/deleteAll")
    public Boolean deleteAllPesci() {
        return pesceService.deleteAllPesci();
    }

    @DeleteMapping("/{id}/deletePesce")
    public Boolean deletePesceById(@PathVariable long id){
        return pesceService.deletePesceById(id);
    }

}
