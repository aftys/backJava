package app.service;
import app.model.Annonce;
import app.model.Annonce;
import app.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;

    public List<Annonce> getAllAnnonces(){
        return annonceRepository.findAll();
    }
    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id).orElse(null);
    }



    public List<Annonce> getAnnonceByAnnonceId(Long idAnnonce) {
        return annonceRepository.findByAssociationId(idAnnonce);
    }

    public Annonce createAnnonce(Annonce Annonce) {

        return annonceRepository.save(Annonce);
    }

    public Annonce updateAnnonce(Long id, Annonce Annonce) {
        Annonce existingAnnonce = annonceRepository.findById(id).orElse(null);
        if (existingAnnonce != null) {
            existingAnnonce.setAssociation(Annonce.getAssociation());
            existingAnnonce.setStatus(Annonce.getStatus());
            existingAnnonce.setId(Annonce.getId());
            existingAnnonce.setDateDebut(Annonce.getDateDebut());
            existingAnnonce.setDateFin(Annonce.getDateFin());
            return annonceRepository.save(existingAnnonce);
        }
        return null;
    }

    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}
