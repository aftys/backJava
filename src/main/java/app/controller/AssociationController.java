package app.controller;

import app.model.Association;
import app.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/association")

public class AssociationController {
    @Autowired
    private AssociationService associationService;

    @GetMapping("")
    public List<Association> getAllAssociations() {
        return associationService.getAllAssociations();
    }

    @GetMapping("/{id}")
    public Association getAssociationById(@PathVariable Long id) {
        return associationService.getAssociationById(id);
    }

    @PostMapping("")
    public Association createAssociation(@RequestBody Association association) {
        return associationService.createAssociation(association);
    }

    @PutMapping("/{id}")
    public Association updateAssociation(@PathVariable Long id, @RequestBody Association association) {
        return associationService.updateAssociation(id, association);
    }

    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable Long id) {
        associationService.deleteAssociation(id);
    }
}
