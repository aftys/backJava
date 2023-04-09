package app.service;
import app.model.Association;
import app.repository.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssociationService {
    @Autowired
    private AssociationRepository associationRepository;

    public List<Association> getAllAssociations() {
        return associationRepository.findAll();
    }

    public Association getAssociationById(Long id) {
        return associationRepository.findById(id).orElse(null);
    }

    public Association createAssociation(Association Association) {

        return associationRepository.save(Association);
    }

    public Association updateAssociation(Long id, Association Association) {
        Association existingAssociation = associationRepository.findById(id).orElse(null);
        if (existingAssociation != null) {
            existingAssociation.setPassword(Association.getPassword());
            existingAssociation.setEmail(Association.getEmail());
            existingAssociation.setNom(Association.getNom());
            existingAssociation.setDesription(Association.getDesription());
            existingAssociation.setLocalisation(Association.getLocalisation());
            return associationRepository.save(existingAssociation);
        }
        return null;
    }

    public void deleteAssociation(Long id) {
        associationRepository.deleteById(id);
    }
}
