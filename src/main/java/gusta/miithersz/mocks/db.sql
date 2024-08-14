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