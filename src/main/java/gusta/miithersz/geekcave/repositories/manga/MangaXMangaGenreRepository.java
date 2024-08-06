package gusta.miithersz.geekcave.repositories.manga;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.manga.MangaXMangaGenreModel;

@Repository
public interface MangaXMangaGenreRepository extends JpaRepository<MangaXMangaGenreModel, Long> {

    List<MangaXMangaGenreModel> findAllByManga_MangaId(Long id);

    // * To do
    @Query(value = "SELECT * FROM manga_x_manga_genre AS axag WHERE axag??", nativeQuery = true)
    Page<MangaXMangaGenreModel> findAllByManga(String manga, Pageable pageable);

    // * To do
    @Query(value = "SELECT * FROM manga_x_manga_genre AS axag WHERE axag??", nativeQuery = true)
    Page<MangaXMangaGenreModel> findAllByGenre(String genre, Pageable pageable);

    void deleteAllByManga_MangaId(Long id);

}
