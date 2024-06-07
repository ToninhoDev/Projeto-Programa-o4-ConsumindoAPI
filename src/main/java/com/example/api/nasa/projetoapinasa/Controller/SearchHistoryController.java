package com.example.api.nasa.projetoapinasa.Controller;

import com.example.api.nasa.projetoapinasa.Entity.SearchHistory;
import com.example.api.nasa.projetoapinasa.Service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @PostMapping("/search-history")
    public ResponseEntity<String> saveSearchHistory(@RequestBody String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            throw new IllegalArgumentException("Search term must not be empty");
        }
        SearchHistory savedSearchHistory = searchHistoryService.saveSearchHistory(searchTerm);
        return new ResponseEntity<>(savedSearchHistory.getTermo(), HttpStatus.CREATED);
    }
}