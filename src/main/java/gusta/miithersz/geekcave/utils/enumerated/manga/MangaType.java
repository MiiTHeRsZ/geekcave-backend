package gusta.miithersz.geekcave.utils.enumerated.manga;

public enum MangaType {
    COMIC("Comic"),
    MANGA("Manga"),
    MANHWA("Manhwa"),
    MANHUA("Manhua");

    private final String type;

    private MangaType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
