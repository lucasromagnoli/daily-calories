package br.com.lucasromagnoli.dailycalories.domain.repository;

import br.com.lucasromagnoli.dailycalories.domain.entities.DailyRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyRegisterRepository extends JpaRepository<DailyRegisterEntity, Long> {
}
