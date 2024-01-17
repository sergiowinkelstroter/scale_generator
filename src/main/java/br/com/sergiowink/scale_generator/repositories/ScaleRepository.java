package br.com.sergiowink.scale_generator.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.sergiowink.scale_generator.models.Scale;


public interface ScaleRepository extends JpaRepository<Scale, UUID> {
    Optional<Scale> findById(@Param("id") UUID id);
}
