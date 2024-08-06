package gusta.miithersz.geekcave.dto.requests.manga;

public record DTOMangaCoverModel(
        Long mangaCoverId,
        DTOMangaModel manga,
        Integer mangaCoverVol,
        String mangaCoverImg) {

}
