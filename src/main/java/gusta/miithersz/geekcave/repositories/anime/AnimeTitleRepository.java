package gusta.miithersz.geekcave.repositories.anime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;

@Repository
public interface AnimeTitleRepository extends JpaRepository<AnimeTitleModel, Integer> {

}
