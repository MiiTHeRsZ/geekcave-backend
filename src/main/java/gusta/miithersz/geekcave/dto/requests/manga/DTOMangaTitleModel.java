package gusta.miithersz.geekcave.dto.requests.manga;

public record DTOMangaTitleModel(
        Long mangaTitleId,
        String mangaTitleDefault,
        String mangaTitleEnglish,
        String mangaTitleJapanese,
        String mangaTitleKorean,
        String mangaTitleSynonyms) {

}
