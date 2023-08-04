package org.mrsf.repository;

import org.mrsf.repository.entity.Skor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISkorRepository extends JpaRepository<Skor, Long> {
    Optional<Skor> findByUserId(Long userId);
    List<Skor> findAllByOrderBySkorDesc();
}
