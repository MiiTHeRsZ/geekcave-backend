/* ----------------Mangas---------------- */

DROP TABLE IF EXISTS MANGA_TITLE;
CREATE TABLE MANGA_TITLE (
	manga_title_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    manga_title_default VARCHAR(100) NOT NULL,
    manga_title_english VARCHAR(100),
    manga_title_japanese VARCHAR(100),
    manga_title_korean VARCHAR(100),
    manga_title_synonyms VARCHAR(100)
);

DROP TABLE IF EXISTS MANGA;
CREATE TABLE MANGA (
	manga_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    manga_pin BOOLEAN NOT NULL,
    fk_manga_title_id BIGINT NOT NULL,
    manga_tier VARCHAR(5),
    manga_type VARCHAR(25) NOT NULL,
    manga_chapters TINYINT,
    manga_status VARCHAR(25),
    manga_author VARCHAR(100),
    manga_artist VARCHAR(100),
    manga_synopsis VARCHAR(500),

    FOREIGN KEY (fk_manga_title_id) REFERENCES MANGA_TITLE(manga_title_id)
);

DROP TABLE IF EXISTS MANGA_CHARACTER;
CREATE TABLE MANGA_CHARACTER (
	manga_character_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_manga_id BIGINT NOT NULL,
    manga_character_name VARCHAR(50) NOT NULL,
    manga_character_img VARCHAR(100),

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
    fk_manga_id BIGINT NOT NULL,
    manga_genre_name VARCHAR(50) NOT NULL,

    FOREIGN KEY (fk_manga_id) REFERENCES MANGA(manga_id)
);