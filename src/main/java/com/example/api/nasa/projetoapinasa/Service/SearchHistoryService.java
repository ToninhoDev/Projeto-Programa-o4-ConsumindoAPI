package com.example.api.nasa.projetoapinasa.Service;

import com.example.api.nasa.projetoapinasa.Entity.SearchHistory;
import com.example.api.nasa.projetoapinasa.Repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchHistoryService {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    public SearchHistory saveSearchHistory(String searchTerm) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setTermo(searchTerm);
        return searchHistoryRepository.save(searchHistory);

    }
}