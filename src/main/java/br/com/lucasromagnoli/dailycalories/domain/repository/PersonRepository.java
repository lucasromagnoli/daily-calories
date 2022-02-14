package br.com.lucasromagnoli.dailycalories.domain.repository;

import br.com.lucasromagnoli.dailycalories.domain.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
