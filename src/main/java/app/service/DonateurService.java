package app.service;
import app.model.Donateur;
import app.repository.DonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonateurService {
    @Autowired
    private DonateurRepository donateurRepository;

    public List<Donateur> getAllDonateurs() {
        return donateurRepository.findAll();
    }

    public Donateur getDonateurById(Long id) {
        return donateurRepository.findById(id).orElse(null);
    }

    public Donateur createDonateur(Donateur Donateur) {

        return donateurRepository.save(Donateur);
    }

    public Donateur updateDonateur(Long id, Donateur Donateur) {
        Donateur existingDonateur = donateurRepository.findById(id).orElse(null);
        if (existingDonateur != null) {
            existingDonateur.setPassword(Donateur.getPassword());
            existingDonateur.setEmail(Donateur.getEmail());
            existingDonateur.setNom(Donateur.getNom());
            existingDonateur.setDesription(Donateur.getDesription());
            existingDonateur.setLocalisation(Donateur.getLocalisation());
            existingDonateur.setType(Donateur.getType());
            return donateurRepository.save(existingDonateur);
        }
        return null;
    }

    public void deleteDonateur(Long id) {
        donateurRepository.deleteById(id);
    }
}
