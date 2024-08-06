package gusta.miithersz.geekcave.services.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.manga.MangaXMangaGenreModel;
import gusta.miithersz.geekcave.repositories.manga.MangaXMangaGenreRepository;

@Service
public class MangaXMangaGenreService {

    @Autowired
    private MangaXMangaGenreRepository mangaXMangaGenreRepository;

    public MangaXMangaGenreModel postMangaXMangaGenre(MangaXMangaGenreModel mangaXMangaGenre) {
        return mangaXMangaGenreRepository.save(mangaXMangaGenre);
    }

    public Page<MangaXMangaGenreModel> getMangaXMangaGenreSearchByAnime(String manga, Pageable pageable) {
        return mangaXMangaGenreRepository.findAllByManga(manga, pageable);
    }

    public Page<MangaXMangaGenreModel> getMangaXMangaGenreSearchByGenre(String genre, Pageable pageable) {
        return mangaXMangaGenreRepository.findAllByGenre(genre, pageable);
    }

    public void deleteMangaXMangaGenreById(Long id) {
        mangaXMangaGenreRepository.deleteById(id);
    }

    public void deleteMangaXMangaGenreByAnimeId(Long id) {
        mangaXMangaGenreRepository.deleteAllByManga_MangaId(id);
    }
    
}
