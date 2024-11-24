package learn.sphere.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sphere.project.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    public Optional<Users> findOneByEmailIgnoreCase(String email);

    public Optional<Users> findByEmail(String email);

    public Users findByName(String username);
}
