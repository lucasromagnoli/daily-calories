package br.com.lucasromagnoli.dailycalories.domain.repository;

import br.com.lucasromagnoli.dailycalories.domain.entities.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {
}
