package gusta.miithersz.geekcave.services.anime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeGenreModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeGenreRepository;

@Service
public class AnimeGenreService {

    @Autowired
    private AnimeGenreRepository animeGenreRepository;

    public List<AnimeGenreModel> getAnimeGenreList() {
        try {
            return animeGenreRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public AnimeGenreModel getAnimeGenreById(Long id) {
        return animeGenreRepository.findAnimeGenreByAnimeGenreId(id);
    }

    public AnimeGenreModel postAnimeGenre(AnimeGenreModel animeGenre) {
        return animeGenreRepository.save(animeGenre);
    }

    public AnimeGenreModel putAnimeGenre(Long id, AnimeGenreModel animeGenre) {
        animeGenre.setAnimeGenreId(id);

        return animeGenreRepository.save(animeGenre);
    }

    public void deleteAnimeGenre(Long id) {
        animeGenreRepository.deleteById(id);
    }

}