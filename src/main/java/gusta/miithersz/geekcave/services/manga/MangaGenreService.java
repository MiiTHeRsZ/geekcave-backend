package gusta.miithersz.geekcave.services.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.manga.MangaGenreModel;
import gusta.miithersz.geekcave.repositories.manga.MangaGenreRepository;

@Service
public class MangaGenreService {

    @Autowired
    private MangaGenreRepository mangaGenreRepository;

    public MangaGenreModel postMangaGenre(MangaGenreModel genre) {
        return mangaGenreRepository.save(genre);
    }

    public Page<MangaGenreModel> getMangaGenreList(Pageable pageable) {
        try {
            return mangaGenreRepository.findAll(pageable);
        } catch (Exception e) {
            throw e;
        }
    }

    public MangaGenreModel getMangaGenreById(Long id) {
        return mangaGenreRepository.findByMangaGenreId(id);
    }

    public MangaGenreModel putMangaGenreById(Long id, MangaGenreModel genre) {
        genre.setMangaGenreId(id);

        return mangaGenreRepository.save(genre);
    }

    public void deleteMangaGenreById(Long id) {
        mangaGenreRepository.deleteById(id);
    }

}