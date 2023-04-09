package app.controller;

import app.model.Donateur;
import app.service.DonateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donateur")

public class DonateurController {
    @Autowired
    private DonateurService donateurService;

    @GetMapping("")
    public List<Donateur> getAllDonateurs() {
        return donateurService.getAllDonateurs();
    }

    @GetMapping("/{id}")
    public Donateur getDonateurById(@PathVariable Long id) {
        return donateurService.getDonateurById(id);
    }

    @PostMapping("")
    public Donateur createDonateur(@RequestBody Donateur donateur) {
        return donateurService.createDonateur(donateur);
    }

    @PutMapping("/{id}")
    public Donateur updateDonateur(@PathVariable Long id, @RequestBody Donateur donateur) {
        return donateurService.updateDonateur(id, donateur);
    }

    @DeleteMapping("/{id}")
    public void deleteDonateur(@PathVariable Long id) {
        donateurService.deleteDonateur(id);
    }
}
