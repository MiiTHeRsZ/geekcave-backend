package gusta.miithersz.geekcave.utils.enumerated.anime;

public enum AnimeGenre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    CGI("CGI"),
    COMEDY("Comedy"),
    DETECTIVE("Detective"),
    DRAMA("Drama"),
    ECCHI("Ecchi"),
    EROTICA("Erotica"),
    FANTASY("Fantasy"),
    GORE("Gore"),
    HAREM("Harem"),
    HENTAI("Hentai"),
    HISTORICAL("Historical"),
    HORROR("Horror"),
    IDOLS("Idols"),
    ISEKAI("Isekai"),
    MARTIAL_ARTS("Martial Arts"),
    MECH("Mech"),
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
    SEINEN("Seinen"),
    SHOUJO("Shoujo"),
    SHOUNEN("Shounen"),
    SLICE_OF_LIFE("Slice of Life"),
    SPACE("Space"),
    SPORTS("Sports"),
    SUPERNATURAL("Supernatural"),
    SUPER_POWER("Super Power"),
    SUSPENSE("Suspense"),
    SURVIVAL("Survival"),
    TENSEI("Tensei"),
    TIME_TRAVEL("Time Travel"),
    VAMPIRE("Vampire");

    private final String genre;

    AnimeGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
