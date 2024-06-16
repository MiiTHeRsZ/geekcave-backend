package gusta.miithersz.geekcave.repositories.anime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeCharacterModel;

@Repository
public interface AnimeCharacterRepository extends JpaRepository<AnimeCharacterModel, Integer> {
    
}