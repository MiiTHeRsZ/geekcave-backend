/* ----------------Mangas---------------- */

/* DROP TABLE IF EXISTS MANGA_TITLE;
CREATE TABLE MANGA_TITLE (
	manga_title_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    manga_title_default VARCHAR(100) NOT NULL,
    manga_title_english VARCHAR(100),
    manga_title_japanese VARCHAR(100),
    manga_title_synonyms VARCHAR(100)
);

DROP TABLE IF EXISTS MANGA;
CREATE TABLE MANGA (
	manga_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    manga_pin BOOLEAN NOT NULL,
    fk_manga_title_id BIGINT NOT NULL,
    manga_tier CHAR(5),
    manga_type VARCHAR(25) NOT NULL,
    manga_chapters INT NOT NULL,
    manga_status VARCHAR(25) NOT NULL,
    manga_author VARCHAR(100) NOT NULL,
    manga_artist VARCHAR(100) NOT NULL,
    manga_synopsis VARCHAR(500) NOT NULL,

    FOREIGN KEY (fk_manga_title_id) REFERENCES MANGA_TITLE(manga_title_id)
);

DROP TABLE IF EXISTS MANGA_CHARACTER;
CREATE TABLE MANGA_CHARACTER (
	manga_character_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_manga_id BIGINT NOT NULL,
    manga_character_name VARCHAR(50) NOT NULL,
    manga_character_img VARCHAR(100) NOT NULL,

    FOREIGN KEY (fk_manga_id) REFERENCES MANGA(manga_id)
);

DROP TABLE IF EXISTS MANGA_COVER;
CREATE TABLE MANGA_COVER (
    manga_cover_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_manga_id BIGINT NOT NULL,
    manga_cover_vol TINYINT NOT NULL,
    manga_cover_img VARCHAR(100) NOT NULL,

    FOREIGN KEY (fk_manga_id) REFERENCES MANGA(manga_id)
);

DROP TABLE IF EXISTS MANGA_GENRE;
CREATE TABLE MANGA_GENRE (
	manga_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    manga_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS MANGA_X_MANGA_GENRE;
CREATE TABLE MANGA_X_MANGA_GENRE (
    fk_manga_id BIGINT NOT NULL,
    fk_manga_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_manga_id) REFERENCES MANGA(manga_id),
    FOREIGN KEY (fk_manga_genre_id) REFERENCES MANGA_GENRE(manga_genre_id)
); */

/* ----------------Games---------------- */

/* DROP TABLE IF EXISTS GAME_DEVELOPER;
CREATE TABLE GAME_DEVELOPER (
    game_developer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_developer_name VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS GAME;
CREATE TABLE GAME (
	game_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_pin BOOLEAN NOT NULL,
    game_title VARCHAR(100) NOT NULL,
    game_tier CHAR(5),
    game_img VARCHAR(100) NOT NULL,
    fk_game_developer_id BIGINT NOT NULL,
    game_released DATE,

    FOREIGN KEY (fk_game_developer_id) REFERENCES GAME_DEVELOPER(game_developer_id)
);

DROP TABLE IF EXISTS GAME_CHARACTER;
CREATE TABLE GAME_CHARACTER (
	game_character_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_game_id BIGINT NOT NULL,
    game_character_name VARCHAR(50) NOT NULL,
    game_character_img VARCHAR(100) NOT NULL,

    FOREIGN KEY (fk_game_id) REFERENCES GAME(game_id)
);

DROP TABLE IF EXISTS GAME_TAG;
CREATE TABLE GAME_TAG (
	game_tag_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_tag_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS GAME_GENRE;
CREATE TABLE GAME_GENRE (
	game_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS GAME_X_GAME_TAG;
CREATE TABLE GAME_X_GAME_TAG (
    fk_game_id BIGINT NOT NULL,
    fk_game_tag_id BIGINT NOT NULL,

    FOREIGN KEY (fk_game_id) REFERENCES GAME(game_id),
    FOREIGN KEY (fk_game_tag_id) REFERENCES GAME_TAG(game_tag_id)
);

DROP TABLE IF EXISTS GAME_X_GAME_GENRE;
CREATE TABLE GAME_X_GAME_GENRE (
    fk_game_id BIGINT NOT NULL,
    fk_game_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_game_id) REFERENCES GAME(game_id),
    FOREIGN KEY (fk_game_genre_id) REFERENCES GAME_GENRE(game_genre_id)
); */

/* ----------------Animations---------------- */

/* DROP TABLE IF EXISTS ANIMATION;
CREATE TABLE ANIMATION (
	animation_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    animation_pin BOOLEAN NOT NULL,
    animation_title VARCHAR(100) NOT NULL,
    animation_img VARCHAR(100) NOT NULL,
    animation_status VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIMATION_GENRE;
CREATE TABLE ANIMATION_GENRE (
	animation_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    animation_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIMATION_X_ANIMATION_GENRE;
CREATE TABLE ANIMATION_X_ANIMATION_GENRE (
    fk_animation_id BIGINT NOT NULL,
    fk_animation_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_animation_id) REFERENCES ANIMATION(animation_id),
    FOREIGN KEY (fk_animation_genre_id) REFERENCES ANIMATION_GENRE(animation_genre_id)
);
 */
/* ----------------Animation-Series---------------- */

/* DROP TABLE IF EXISTS ANIMATION_SERIE;
CREATE TABLE ANIMATION_SERIE (
	animation_serie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    animation_pin BOOLEAN NOT NULL,
    animation_serie_title VARCHAR(100) NOT NULL,
    animation_serie_img VARCHAR(100) NOT NULL,
    animation_serie_sessions INT NOT NULL,
    animation_serie_status VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIMATION_SERIE_GENRE;
CREATE TABLE ANIMATION_SERIE_GENRE (
	animation_serie_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    animation_serie_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIMATION_SERIE_X_ANIMATION_SERIE_GENRE;
CREATE TABLE ANIMATION_SERIE_X_ANIMATION_SERIE_GENRE (
    fk_animation_serie_id BIGINT NOT NULL,
    fk_animation_serie_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_animation_serie_id) REFERENCES ANIMATION_SERIE(animation_serie_id),
    FOREIGN KEY (fk_animation_serie_genre_id) REFERENCES ANIMATION_SERIE_GENRE(animation_serie_genre_id)
); */

/* ----------------Anime-Films---------------- */

/* DROP TABLE IF EXISTS ANIME_FILM;
CREATE TABLE ANIME_FILM (
	anime_film_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anime_film_pin BOOLEAN NOT NULL,
    anime_film_title VARCHAR(100) NOT NULL,
    anime_film_img VARCHAR(100) NOT NULL,
    anime_film_status VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIME_FILM_GENRE;
CREATE TABLE ANIME_FILM_GENRE (
	anime_film_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anime_film_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIME_FILM_X_ANIME_FILM_GENRE;
CREATE TABLE ANIME_FILM_X_ANIME_FILM_GENRE (
    fk_anime_film_id BIGINT NOT NULL,
    fk_anime_film_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_anime_film_id) REFERENCES ANIME_FILM(anime_film_id),
    FOREIGN KEY (fk_anime_film_genre_id) REFERENCES ANIME_FILM_GENRE(anime_film_genre_id)
); */

/* ----------------Films---------------- */

/* DROP TABLE IF EXISTS FILM;
CREATE TABLE FILM (
	film_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    film_pin BOOLEAN NOT NULL,
    film_title VARCHAR(100) NOT NULL,
    film_img VARCHAR(100) NOT NULL,
    film_status VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS FILM_GENRE;
CREATE TABLE FILM_GENRE (
	film_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    film_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS FILM_X_FILM_GENRE;
CREATE TABLE FILM_X_FILM_GENRE (
    fk_film_id BIGINT NOT NULL,
    fk_film_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_film_id) REFERENCES FILM(film_id),
    FOREIGN KEY (fk_film_genre_id) REFERENCES FILM_GENRE(film_genre_id)
); */

/* ----------------Series---------------- */

/* DROP TABLE IF EXISTS SERIE;
CREATE TABLE SERIE (
	serie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serie_pin BOOLEAN NOT NULL,
    serie_title VARCHAR(100) NOT NULL,
    serie_img VARCHAR(100) NOT NULL,
    serie_sessions INT NOT NULL,
    serie_status VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS SERIE_GENRE;
CREATE TABLE SERIE_GENRE (
	serie_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serie_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS SERIE_X_SERIE_GENRE;
CREATE TABLE SERIE_X_SERIE_GENRE (
    fk_serie_id BIGINT NOT NULL,
    fk_serie_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_serie_id) REFERENCES SERIE(serie_id),
    FOREIGN KEY (fk_serie_genre_id) REFERENCES SERIE_GENRE(serie_genre_id)
); */