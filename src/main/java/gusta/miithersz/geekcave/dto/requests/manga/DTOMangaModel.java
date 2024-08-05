package gusta.miithersz.geekcave.dto.requests.manga;

public record DTOMangaModel(
        Long mangaId,
        Boolean mangaPin,
        DTOMangaTitleModel mangaTitle,
        String mangaType,
        Integer mangaChapters,
        String mangaStatus,
        String mangaAuthor,
        String mangaArtist,
        String mangaSynopsis) {

}
