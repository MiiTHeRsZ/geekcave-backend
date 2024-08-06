package gusta.miithersz.geekcave.repositories.manga;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import gusta.miithersz.geekcave.models.manga.MangaCoverModel;

public interface MangaCoverRepository extends JpaRepository<MangaCoverModel, Long> {

    Page<MangaCoverModel> findAllByManga_MangaId(Long id);
    
}
