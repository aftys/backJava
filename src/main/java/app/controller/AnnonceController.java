package app.controller;

import app.model.Annonce;
import app.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")

public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

    @GetMapping("")
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable Long id) {
        return annonceService.getAnnonceById(id);
    }

    @GetMapping("/association/{annonceId}")
    public List<Annonce> getAnnonceByAssociationId(@PathVariable Long annonceId) {
        return annonceService.getAnnonceByAnnonceId(annonceId);
    }

    @PostMapping("")
    public Annonce createAnnonce(@RequestBody Annonce annonce) {
        return annonceService.createAnnonce(annonce);
    }

    @PutMapping("/{id}")
    public Annonce updateAnnonce(@PathVariable Long id, @RequestBody Annonce annonce) {
        return annonceService.updateAnnonce(id, annonce);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
    }
}
