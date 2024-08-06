package gusta.miithersz.geekcave.repositories.manga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.manga.MangaCharacterModel;

@Repository
public interface MangaCharacterRepository extends JpaRepository<MangaCharacterModel, Long> {

    MangaCharacterModel findByMangaCharacterId(Long id);
    
}
