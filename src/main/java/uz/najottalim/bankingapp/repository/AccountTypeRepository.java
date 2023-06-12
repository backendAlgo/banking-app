package uz.najottalim.bankingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.bankingapp.model.AccountType;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType,Integer> {
}
