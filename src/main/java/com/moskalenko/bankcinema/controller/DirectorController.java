package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.client.DirectorClient;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.service.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/directors")
public class DirectorController implements DirectorClient {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    @PostMapping
    public Director addDirector(@RequestBody DirectorDTO directorData) {
        return directorService.addDirector(directorData);
    }

    @Override
    @GetMapping("/{directorId}")
    public Director getDirectorById(@PathVariable Long directorId) {
        return directorService.getDirectorById(directorId);
    }

    @Override
    @GetMapping
    public Collection<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }
}
