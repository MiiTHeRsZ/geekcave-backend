package gusta.miithersz.geekcave.services.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.manga.MangaCoverModel;
import gusta.miithersz.geekcave.repositories.manga.MangaCoverRepository;

@Service
public class MangaCoverService {
    
    @Autowired
    private MangaCoverRepository mangaCoverRepository;

    public MangaCoverModel postMangaCover(MangaCoverModel cover) {
        return mangaCoverRepository.save(cover);
    }

    public Page<MangaCoverModel> getMangaCoverListByMangaId(Long id) {
        return mangaCoverRepository.findAllByManga_MangaId(id);
    }

    public MangaCoverModel putMangaCoverById(Long id, MangaCoverModel cover) {
        cover.setMangaCoverId(id);

        return mangaCoverRepository.save(cover);
    }

    public void deleteMangaCoverById(Long id) {
        mangaCoverRepository.deleteById(id);
    }

}
