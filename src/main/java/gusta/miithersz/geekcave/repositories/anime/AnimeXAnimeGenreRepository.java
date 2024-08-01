package gusta.miithersz.geekcave.repositories.anime;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeXAnimeGenreModel;

@Repository
public interface AnimeXAnimeGenreRepository extends JpaRepository<AnimeXAnimeGenreModel, Long> {

    List<AnimeXAnimeGenreModel> findAllByAnime_AnimeId(Long id);

    // * To do
    @Query(value = "SELECT * FROM anime_x_anime_genre AS axag WHERE axag??", nativeQuery = true)
    Page<AnimeXAnimeGenreModel> findAllByAnime(String anime, Pageable pageable);

    // * To do
    @Query(value = "SELECT * FROM anime_x_anime_genre AS axag WHERE axag??", nativeQuery = true)
	Page<AnimeXAnimeGenreModel> findAllByGenre(String genre, Pageable pageable);

}
