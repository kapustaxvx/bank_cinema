package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.DirectorDTO;
import com.moskalenko.bankcinema.api.client.DirectorClient;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.service.DirectorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/directors")
public class DirectorController implements DirectorClient {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    @PostMapping
    @ApiOperation(value = "Add new director")
    public Director addDirector(@RequestBody DirectorDTO directorData) {
        return directorService.addDirector(directorData);
    }

    @Override
    @GetMapping("/{directorId}")
    @ApiOperation(value = "Get director by id")
    public Director getDirectorById(@PathVariable Long directorId) {
        return directorService.getDirectorById(directorId);
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Get list of all directors")
    public Collection<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }
}
