package br.com.sergiowink.scale_generator.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sergiowink.scale_generator.models.ScaleNames;


public interface ScaleNamesRepository  extends JpaRepository<ScaleNames, UUID>{
    
}
