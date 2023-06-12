package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.najottalim.bankingapp.model.New;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {
}
