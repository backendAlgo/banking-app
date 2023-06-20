package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.bankingapp.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice,Long> {

}
