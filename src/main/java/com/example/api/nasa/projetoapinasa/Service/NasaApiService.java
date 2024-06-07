package com.example.api.nasa.projetoapinasa.Service;

import com.example.api.nasa.projetoapinasa.Entity.Apod;
import com.example.api.nasa.projetoapinasa.ProjetoapinasaApplication;
import com.example.api.nasa.projetoapinasa.Repository.ApodRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NasaApiService {

    @Autowired
    private ApodRepository nasaDataRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void fetchAndSaveNasaData() {
        String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=aheSDgodxdkxj9llSPCwbpVfaG68V8f3fraGeMoq&count=5";
        ResponseEntity<Apod[]> response = restTemplate.getForEntity(apiUrl, Apod[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Apod[] nasaData = response.getBody();
            if (nasaData != null) {
                for (Apod apod : nasaData) {
                    nasaDataRepository.save(apod);
                }
            }
        }
    }

    public List<Apod> findAll(){

        return nasaDataRepository.findAll();
    }
}