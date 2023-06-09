package uz.najottalim.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.najottalim.bankingapp.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
