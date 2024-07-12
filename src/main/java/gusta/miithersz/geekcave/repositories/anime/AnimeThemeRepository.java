package gusta.miithersz.geekcave.repositories.anime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeThemeModel;

@Repository
public interface AnimeThemeRepository extends JpaRepository<AnimeThemeModel, Long> {

    List<AnimeThemeModel> findAllByAnime_AnimeId(Long id);

}
