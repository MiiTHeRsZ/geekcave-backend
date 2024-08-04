DROP TABLE IF EXISTS ANIME_TITLE;
CREATE TABLE ANIME_TITLE (
	anime_title_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anime_title_default VARCHAR(100) NOT NULL,
    anime_title_english VARCHAR(100),
    anime_title_japanese VARCHAR(100),
    anime_title_synonyms VARCHAR(100)
);

DROP TABLE IF EXISTS ANIME_STUDIO;
CREATE TABLE ANIME_STUDIO (
	anime_studio_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anime_studio_name VARCHAR(50) NOT NULL,
    anime_studio_img VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS ANIME;
CREATE TABLE ANIME (
    anime_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anime_pin BOOLEAN NOT NULL,
    fk_anime_title_id BIGINT NOT NULL,
    anime_tier CHAR(5),
    anime_img VARCHAR(100) NOT NULL,
	fk_anime_studio_id BIGINT NOT NULL,
    anime_sessions INT NOT NULL,
    anime_status VARCHAR(25),
	anime_synopsis VARCHAR(500) NOT NULL,

    FOREIGN KEY (fk_anime_title_id) REFERENCES ANIME_TITLE(anime_title_id),
    FOREIGN KEY (fk_anime_studio_id) REFERENCES ANIME_STUDIO(anime_studio_id)
);

DROP TABLE IF EXISTS ANIME_GENRE;
CREATE TABLE ANIME_GENRE (
	anime_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anime_genre_name VARCHAR(25) NOT NULL
);

DROP TABLE IF EXISTS ANIME_THEME;
CREATE TABLE ANIME_THEME (
	anime_theme_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_anime_id BIGINT NOT NULL,
    anime_theme_name VARCHAR(100) NOT NULL,
    anime_theme_song VARCHAR(100),
    anime_theme_song_full VARCHAR(100),
    anime_theme_type CHAR(2) NOT NULL,
    
    FOREIGN KEY (fk_anime_id) REFERENCES ANIME(anime_id)
);

DROP TABLE IF EXISTS ANIME_CHARACTER;
CREATE TABLE ANIME_CHARACTER (
	anime_character_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_anime_id BIGINT NOT NULL,
    anime_character_name VARCHAR(50) NOT NULL,
    anime_character_img VARCHAR(100) NOT NULL,

    FOREIGN KEY (fk_anime_id) REFERENCES ANIME(anime_id)
);

DROP TABLE IF EXISTS ANIME_X_ANIME_GENRE;
CREATE TABLE ANIME_X_ANIME_GENRE (
    anime_x_anime_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_anime_id BIGINT NOT NULL,
    fk_anime_genre_id BIGINT NOT NULL,

    FOREIGN KEY (fk_anime_id) REFERENCES ANIME(anime_id),
    FOREIGN KEY (fk_anime_genre_id) REFERENCES ANIME_GENRE(anime_genre_id)
);
