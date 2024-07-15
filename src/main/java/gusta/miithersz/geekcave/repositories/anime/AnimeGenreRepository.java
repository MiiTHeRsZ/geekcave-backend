package gusta.miithersz.geekcave.repositories.anime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeGenreModel;

@Repository
public interface AnimeGenreRepository extends JpaRepository<AnimeGenreModel, Long> {

    AnimeGenreModel findAnimeGenreByAnimeGenreId(Long id);

}
