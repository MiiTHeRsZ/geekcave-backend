package gusta.miithersz.geekcave.dto.requests.manga;

import java.util.Set;

import gusta.miithersz.geekcave.dto.requests.DTOFranchiseModel;
import gusta.miithersz.geekcave.models.manga.MangaCharacterModel;
import gusta.miithersz.geekcave.models.manga.MangaCoverModel;
import gusta.miithersz.geekcave.utils.enumerated.manga.MangaGenre;
import gusta.miithersz.geekcave.utils.enumerated.manga.MangaType;

public record DTOMangaModel(
                Long mangaId,
                Boolean mangaPin,
                DTOFranchiseModel franchise,
                DTOMangaTitleModel mangaTitle,
                MangaType mangaType,
                Integer mangaChapters,
                String mangaStatus,
                String mangaAuthor,
                String mangaArtist,
                String mangaSynopsis,
                Set<MangaGenre> mangaGenres,
                Set<MangaCharacterModel> mangaCharacters,
                Set<MangaCoverModel> mangaCovers) {

}
