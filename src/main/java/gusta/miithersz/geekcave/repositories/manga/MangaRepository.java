package gusta.miithersz.geekcave.repositories.manga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.manga.MangaModel;

@Repository
public interface MangaRepository extends JpaRepository<MangaModel, Long> {

    MangaModel findMangaByMangaId(Long id);
    
}
