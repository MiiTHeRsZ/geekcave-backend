package gusta.miithersz.geekcave.repositories.manga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.manga.MangaGenreModel;

@Repository
public interface MangaGenreRepository extends JpaRepository<MangaGenreModel, Long> {

    MangaGenreModel findByMangaGenreId(Long id);

}
