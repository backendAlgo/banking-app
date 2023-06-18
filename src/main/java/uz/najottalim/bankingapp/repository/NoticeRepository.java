package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
