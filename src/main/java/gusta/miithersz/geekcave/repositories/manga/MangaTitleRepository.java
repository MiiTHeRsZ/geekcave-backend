package gusta.miithersz.geekcave.repositories.manga;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.manga.MangaTitleModel;

@Repository
public interface MangaTitleRepository extends JpaRepository<MangaTitleModel, Long> {

    @Query(value = "SELECT * FROM manga_title AS mt WHERE mt.anime_title_default LIKE %?1% OR mt.anime_title_english LIKE %?1% OR mt.anime_title_japanese LIKE %?1% OR mt.anime_title_synonyms LIKE %?1%", nativeQuery = true)
    Page<MangaTitleModel> findAllByMangaTitleName(String name, Pageable pageable);
    
}
