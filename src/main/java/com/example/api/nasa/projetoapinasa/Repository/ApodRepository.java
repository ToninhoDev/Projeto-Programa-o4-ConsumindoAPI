package com.example.api.nasa.projetoapinasa.Repository;

import com.example.api.nasa.projetoapinasa.Entity.Apod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApodRepository extends JpaRepository<Apod, Long> {
}
