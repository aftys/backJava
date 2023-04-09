package app.service;
import app.model.Admin;
import app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin Admin) {

        return adminRepository.save(Admin);
    }

    public Admin updateAdmin(Long id, Admin Admin) {
        Admin existingAdmin = adminRepository.findById(id).orElse(null);
        if (existingAdmin != null) {
            existingAdmin.setPassword(Admin.getPassword());
            existingAdmin.setEmail(Admin.getEmail());
            existingAdmin.setNom(Admin.getNom());
            existingAdmin.setPrenom(Admin.getPrenom());
            return adminRepository.save(existingAdmin);
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
