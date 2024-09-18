package gusta.miithersz.geekcave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.FranchiseModel;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseModel, Long> {

}
