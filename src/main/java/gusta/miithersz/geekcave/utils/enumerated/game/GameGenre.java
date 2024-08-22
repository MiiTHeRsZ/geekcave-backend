package gusta.miithersz.geekcave.utils.enumerated.game;

public enum GameGenre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    ADULT_CONTENT("Adult Content"),
    ARCADE("Arcade"),
    BATTLE_ROYALE("Battle Royale"),
    BOARD_GAME("Board Game"),
    BOSS_RUSH("Boss Rush"),
    BUILDING("Building"),
    CARD_GAME("Card Game"),
    CASUAL("Casual"),
    CRAFTING("Crafting"),
    COOKING("Cooking"),
    DUNGEON_CRAWLER("Dungeon Crawler"),
    EXPLORATION("Exploration"),
    FARMING("Farming"),
    FANTASY("Fantasy"),
    FICTION("Fiction"),
    GORE("Gore"),
    HACK_AND_SLASH("Hack & Slash"),
    HORROR("Horror"),
    HUNTING("Hunting"),
    INDIE("Indie"),
    INVESTIGATION("Investigation"),
    MMO("MMO"),
    MMORPG("MMORPG"),
    MINING("Mining"),
    MOBA("MOBA"),
    MATURE("Mature"),
    METROIDVANIA("Metroidvania"),
    NSFW("NSFW"),
    OPEN_WORLD("Open World"),
    PLATFORM("Platform"),
    POINT_AND_CLICK("Point & Click"),
    POST_APOCALYPTIC("Post-Apocalyptic"),
    PUZZLE("Puzzle"),
    RACING("Racing"),
    RETRO("Retro"),
    ROGUE_LIKE("Rogue-Like"),
    ROGUE_LITE("Rogue-Lite"),
    RPG("RPG"),
    SANDBOX("Sandbox"),
    SCI_FI("Sci-Fi"),
    SEXUAL_CONTENT("Sexual Content"),
    SHOOTER("Shooter"),
    SIMULATION("Simulation"),
    SOULS_LIKE("Souls-Like"),
    SOULS_LITE("Souls-Lite"),
    SPORTS("Sports"),
    STEALTH("Stealth"),
    STRATEGY("Strategy"),
    SUPERHERO("Superhero"),
    SURVIVAL("Survival"),
    TACTICS("Tactics"),
    TOWER_DEFENSE("Tower Defense"),
    TRADING_CARD_GAME("Trading Card Game"),
    TURN_BASED("Turn-Based"),
    VISUAL_NOVEL("Visual Novel"),
    VIOLENT("Violent");

    private final String genre;

    GameGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

}
