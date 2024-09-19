package gusta.miithersz.geekcave.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.FranchiseModel;
import gusta.miithersz.geekcave.repositories.FranchiseRepository;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    public FranchiseModel postFranchise(FranchiseModel franchise) {
        return franchiseRepository.save(franchise);
    }

}
