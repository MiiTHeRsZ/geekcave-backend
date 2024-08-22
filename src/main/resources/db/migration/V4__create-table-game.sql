/* ----------------Games---------------- */

DROP TABLE IF EXISTS GAME_DEVELOPER;
CREATE TABLE GAME_DEVELOPER (
    game_developer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_developer_name VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS GAME;
CREATE TABLE GAME (
	game_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_pin BOOLEAN NOT NULL,
    game_title VARCHAR(100) NOT NULL,
    game_tier VARCHAR(5),
    game_img VARCHAR(100),
    fk_game_developer_id BIGINT NOT NULL,
    game_released DATE,

    FOREIGN KEY (fk_game_developer_id) REFERENCES GAME_DEVELOPER(game_developer_id)
);

DROP TABLE IF EXISTS GAME_CHARACTER;
CREATE TABLE GAME_CHARACTER (
	game_character_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_game_id BIGINT NOT NULL,
    game_character_name VARCHAR(50) NOT NULL,
    game_character_img VARCHAR(100),

    FOREIGN KEY (fk_game_id) REFERENCES GAME(game_id)
);

DROP TABLE IF EXISTS GAME_FEATURE;
CREATE TABLE GAME_FEATURE (
    game_feature_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_game_id BIGINT NOT NULL,
    game_feature_name VARCHAR(50) NOT NULL,

    FOREIGN KEY (fk_game_id) REFERENCES GAME(game_id)
);

DROP TABLE IF EXISTS GAME_GENRE;
CREATE TABLE GAME_GENRE (
    game_genre_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_game_id BIGINT NOT NULL,
    game_genre_name VARCHAR(50) NOT NULL,

    FOREIGN KEY (fk_game_id) REFERENCES GAME(game_id)
);