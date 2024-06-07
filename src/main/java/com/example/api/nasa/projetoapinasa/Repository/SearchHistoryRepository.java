package com.example.api.nasa.projetoapinasa.Repository;

import com.example.api.nasa.projetoapinasa.Entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
}
