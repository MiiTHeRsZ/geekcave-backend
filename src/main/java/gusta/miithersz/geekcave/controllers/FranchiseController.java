package gusta.miithersz.geekcave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.dto.requests.DTOFranchiseModel;
import gusta.miithersz.geekcave.models.FranchiseModel;
import gusta.miithersz.geekcave.services.FranchiseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/franchise")
@SecurityRequirement(name = "bearer-key")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postFranchise(@RequestBody @Valid DTOFranchiseModel franchise) {
        try {
            return new ResponseEntity<FranchiseModel>(franchiseService.postFranchise(new FranchiseModel(franchise)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
