package gusta.miithersz.geekcave.dto.requests.manga;

import gusta.miithersz.geekcave.utils.enumerated.manga.MangaType;

public record DTOMangaModel(
        Long mangaId,
        Boolean mangaPin,
        DTOMangaTitleModel mangaTitle,
        MangaType mangaType,
        Integer mangaChapters,
        String mangaStatus,
        String mangaAuthor,
        String mangaArtist,
        String mangaSynopsis) {

}
