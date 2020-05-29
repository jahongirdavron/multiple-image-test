package uz.apextech.test.multiple.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.apextech.test.multiple.file.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
