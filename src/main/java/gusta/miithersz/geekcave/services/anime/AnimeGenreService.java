package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeGenreModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeGenreRepository;

@Service
public class AnimeGenreService {

    @Autowired
    private AnimeGenreRepository animeGenreRepository;

    public AnimeGenreModel postAnimeGenre(AnimeGenreModel animeGenre) {
        return animeGenreRepository.save(animeGenre);
    }

    public Page<AnimeGenreModel> getAnimeGenreList(Pageable pageable) {
        try {
            return animeGenreRepository.findAll(pageable);
        } catch (Exception e) {
            throw e;
        }
    }

    public AnimeGenreModel getAnimeGenreById(Long id) {
        return animeGenreRepository.findAnimeGenreByAnimeGenreId(id);
    }

    public AnimeGenreModel putAnimeGenreById(Long id, AnimeGenreModel animeGenre) {
        animeGenre.setAnimeGenreId(id);

        return animeGenreRepository.save(animeGenre);
    }

    public void deleteAnimeGenreById(Long id) {
        animeGenreRepository.deleteById(id);
    }

}