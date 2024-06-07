package com.example.api.nasa.projetoapinasa.Controller;

import com.example.api.nasa.projetoapinasa.Entity.Apod;
import com.example.api.nasa.projetoapinasa.Repository.ApodRepository;
import com.example.api.nasa.projetoapinasa.Service.NasaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/nasa")
public class NasaApiController {

    @Autowired
    private NasaApiService  nasaService;

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchNasaData() {
        nasaService.fetchAndSaveNasaData();
        return ResponseEntity.ok("Dados da NASA salvos com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Apod>> getAll(){
        return ResponseEntity.ok(nasaService.findAll());

    }


}
