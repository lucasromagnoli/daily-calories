package br.com.lucasromagnoli.dailycalories.domain.repository;

import br.com.lucasromagnoli.dailycalories.domain.entities.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
