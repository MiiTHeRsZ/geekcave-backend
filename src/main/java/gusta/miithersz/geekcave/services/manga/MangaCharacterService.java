package gusta.miithersz.geekcave.services.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.manga.MangaCharacterModel;
import gusta.miithersz.geekcave.repositories.manga.MangaCharacterRepository;

@Service
public class MangaCharacterService {

    @Autowired
    private MangaCharacterRepository mangaCharacterRepository;

    public MangaCharacterModel postMangaCharacter(MangaCharacterModel character) {
        return mangaCharacterRepository.save(character);
    }

    public Page<MangaCharacterModel> getMangaCharacterList(Pageable pageable) {
        return mangaCharacterRepository.findAll(pageable);
    }

    public MangaCharacterModel getMangaCharacterById(Long id) {
        return mangaCharacterRepository.findByMangaCharacterId(id);
    }

    public MangaCharacterModel putMangaCharacterById(Long id, MangaCharacterModel character) {
        character.setMangaCharacterId(id);

        return mangaCharacterRepository.save(character);
    }

    public void deleteMangaCharacterById(Long id) {
        mangaCharacterRepository.deleteById(id);
    }

}
