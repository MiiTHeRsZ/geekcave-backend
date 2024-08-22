package gusta.miithersz.geekcave.utils.enumerated.manga;

public enum MangaGenre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    DRAMA("Dram"),
    ECCHI("Ecchi"),
    EROTIC("Erotic"),
    FANTASY("Fantasy"),
    GORE("Gore"),
    HAREM("Harem"),
    HENTAI("Hentai"),
    HORROR("Horror"),
    IDOLS("Idols"),
    ISEKAI("Isekai"),
    MARTIAL_ARTS("Martial Arts"),
    MECHA("Mecha"),
    MEDICAL("Medical"),
    MILITARY("Military"),
    MUSIC("Music"),
    MYSTERY("Mystery"),
    MYTHOLOGY("Mythology"),
    PSYCHOLOGICAL("Psychological"),
    RACING("Racing"),
    ROMANCE("Romance"),
    SAMURAI("Samurai"),
    SCHOOL("School"),
    SCI_FI("Sci-Fi"),
    SPACE("Space"),
    SPORTS("Sports"),
    SUPERNATURAL("Supernatural"),
    SUPER_POWER("Super Power"),
    SURVIVAL("Survival"),
    TENSE("Tense"),
    TIME_TRAVEL("Time Travel"),
    VAMPIRE("Vampire"),
    VIDEO_GAME("Video Game");

    private final String genre;

    MangaGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
    
}
