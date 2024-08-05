package gusta.miithersz.geekcave.services.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.manga.MangaModel;
import gusta.miithersz.geekcave.repositories.manga.MangaRepository;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public MangaModel postAnime(MangaModel manga) {
        return mangaRepository.save(manga);
    }

    public Page<MangaModel> getMangaList(Pageable pageable) {
        return mangaRepository.findAll(pageable);
    }

    public MangaModel getMangaById(Long id) {
        return mangaRepository.findMangaByMangaId(id);
    }

    public MangaModel putMangaById(Long id, MangaModel manga) {
        manga.setMangaId(id);
        
        return mangaRepository.save(manga);
    }

    public void deleteMangaById(Long id) {
        deleteMangaById(id);
    }
    
}
