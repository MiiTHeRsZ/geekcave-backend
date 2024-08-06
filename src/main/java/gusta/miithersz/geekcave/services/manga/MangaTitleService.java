package gusta.miithersz.geekcave.services.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.manga.MangaTitleModel;
import gusta.miithersz.geekcave.repositories.manga.MangaTitleRepository;

@Service
public class MangaTitleService {

    @Autowired
    private MangaTitleRepository mangaTitleRepository;

    public MangaTitleModel postMangaTitle(MangaTitleModel title) {
        return mangaTitleRepository.save(title);
    }

    public Page<MangaTitleModel> getMangaTitleByName(String name, @PageableDefault(size = 10) Pageable pageable) {
        return mangaTitleRepository.findAllByMangaTitleName(name, pageable);
    }

    public MangaTitleModel putMangaTitleById(Long id, MangaTitleModel title) {
        title.setMangaTitleId(id);

        return mangaTitleRepository.save(title);
    }

}
