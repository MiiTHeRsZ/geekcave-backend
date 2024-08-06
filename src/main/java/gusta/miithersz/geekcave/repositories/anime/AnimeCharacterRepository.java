package gusta.miithersz.geekcave.repositories.anime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeCharacterModel;

@Repository
public interface AnimeCharacterRepository extends JpaRepository<AnimeCharacterModel, Long> {

    List<AnimeCharacterModel> findAllByAnime_AnimeId(Long id);

    AnimeCharacterModel findByAnimeCharacterId(Long id);

}