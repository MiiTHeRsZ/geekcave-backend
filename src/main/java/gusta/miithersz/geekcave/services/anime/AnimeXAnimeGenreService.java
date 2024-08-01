package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeXAnimeGenreModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeXAnimeGenreRepository;

@Service
public class AnimeXAnimeGenreService {

    @Autowired
    private AnimeXAnimeGenreRepository animeXAnimeGenreRepository;

    public AnimeXAnimeGenreModel postAnimeXAnimeGenre(AnimeXAnimeGenreModel animeXAnimeGenre) {
        return animeXAnimeGenreRepository.save(animeXAnimeGenre);
    }

    public Page<AnimeXAnimeGenreModel> getAnimeXAnimeGenreSearchByAnime(String anime, Pageable pageable) {
        return animeXAnimeGenreRepository.findAllByAnime(anime, pageable);
    }

    public Page<AnimeXAnimeGenreModel> getAnimeXAnimeGenreSearchByGenre(String genre, Pageable pageable) {
        return animeXAnimeGenreRepository.findAllByGenre(genre, pageable);
    }

    public void deleteAnimeXAnimeGenre(Long id) {
        animeXAnimeGenreRepository.deleteById(id);
    }
    
}
