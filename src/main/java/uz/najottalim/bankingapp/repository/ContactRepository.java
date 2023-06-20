package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
