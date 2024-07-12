package gusta.miithersz.geekcave.repositories.anime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeXAnimeGenreModel;

@Repository
public interface AnimeXAnimeGenreRepository extends JpaRepository<AnimeXAnimeGenreModel, Long> {

    List<AnimeXAnimeGenreModel> findAllByAnime_AnimeId(Long id);

}
