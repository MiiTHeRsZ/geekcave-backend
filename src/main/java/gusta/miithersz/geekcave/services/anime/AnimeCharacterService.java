package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeCharacterModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeCharacterRepository;

@Service
public class AnimeCharacterService {

    @Autowired
    private AnimeCharacterRepository animeCharacterRepository;

    public AnimeCharacterModel postAnimeCharacter(AnimeCharacterModel animeCharacter) {
        return animeCharacterRepository.save(animeCharacter);
    }

    public Page<AnimeCharacterModel> getAnimeCharacterList(Pageable pageable) {
        return animeCharacterRepository.findAll(pageable);
    }

    public AnimeCharacterModel getAnimeCharacterById(Long id) {
        return animeCharacterRepository.findByAnimeCharacterId(id);
    }

    public AnimeCharacterModel putAnimeCharacterById(Long id, AnimeCharacterModel animeCharacter) {
        animeCharacter.setAnimeCharacterId(id);

        return animeCharacterRepository.save(animeCharacter);
    }

    public void deleteAnimeCharacterById(Long id) {
        animeCharacterRepository.deleteById(id);
    }

}
