package gusta.miithersz.geekcave.utils.enumerated.game;

public enum GameFeature {
    TWO_D("2D"),
    TWO_POINT_FIVE_D("2.5D"),
    THREE_D("3D"),
    CHOICES_MATTER("Choices Matter"),
    CHOOSE_YOUR_OWN_ADVENTURE("Choose Your Own Adventure"),
    COMPETITIVE("Competitive"),
    CO_OP("Co-Op"),
    CO_OP_CAMPAIGN("Co-Op Campaign"),
    DYNAMIC_NARRATION("Dynamic Narration"),
    FIRST_PERSON("First Person"),
    FREE_TO_PLAY("Free to Play"),
    ISOMETRIC("Isometric"),
    LEGO("LEGO"),
    LOCAL_CO_OP("Local Co-Op"),
    LOCAL_MULTIPLAYER("Local Multiplayer"),
    MOUSE_ONLY("Mouse Only"),
    MULTIPLE_ENDINGS("Multiple Endings"),
    MUSIC_BASED_PROCEDURAL_GENERATION("Music-Based Procedural Generation"),
    PIXEL("Pixel"),
    PVE("PvE"),
    PVP("PvP"),
    REMAKE("Remake"),
    SEQUEL("Sequel"),
    SIDE_SCROLLER("Side Scroller"),
    SINGLEPLAYER("Singleplayer"),
    STORY_RICH("Story Rich"),
    THIRD_PERSON("Third Person"),
    TOP_DOWN("Top-Down");

    private final String feature;

    GameFeature(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }

}
