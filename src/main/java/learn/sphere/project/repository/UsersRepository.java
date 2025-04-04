package learn.sphere.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sphere.project.model.Account;

@Repository
public interface UsersRepository extends JpaRepository<Account, Long>{

    public Optional<Account> findOneByEmailIgnoreCase(String email);

    public Optional<Account> findByEmail(String email);

    public Account findByName(String username);
}
