package gusta.miithersz.geekcave.repositories.anime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;

@Repository
public interface AnimeTitleRepository extends JpaRepository<AnimeTitleModel, Long> {

    @Query(value = "SELECT * FROM anime_title AS at WHERE at.anime_title_default LIKE %?1% OR at.anime_title_english LIKE %?1% OR at.anime_title_japanese LIKE %?1% OR at.anime_title_synonyms LIKE %?1%", nativeQuery = true)
    Page<AnimeTitleModel> findAllByAnimeTitleName(String name, Pageable pageable);

}
