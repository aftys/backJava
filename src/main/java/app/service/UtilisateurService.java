package app.service;
import app.model.Utilisateur;
import app.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur createUtilisateur(Utilisateur Utilisateur) {
        return utilisateurRepository.save(Utilisateur);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur Utilisateur) {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id).orElse(null);
        if (existingUtilisateur != null) {
            existingUtilisateur.setPassword(Utilisateur.getPassword());
            existingUtilisateur.setEmail(Utilisateur.getEmail());
            return utilisateurRepository.save(existingUtilisateur);
        }
        return null;
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
