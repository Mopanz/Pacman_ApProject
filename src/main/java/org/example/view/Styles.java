package org.example.view;

public final class Styles {
    public static final String BtnNormalStyle = """
            -fx-background-color: #FFD700;
            -fx-text-fill: #1A1A1A;
            -fx-font-size: 12px;
            -fx-font-weight: bold;
            -fx-font-family: "Arial Black", "Impact", sans-serif;
            -fx-background-radius: 7px;
            -fx-border-radius: 9px;
            -fx-border-width: 3px;
            -fx-border-color: #CD312C;
            -fx-background-insets: 3px;
            -fx-cursor: hand;
            -fx-padding: 12 40 12 40;
            -fx-focus-color: transparent;
            -fx-faint-focus-color: transparent;
            -fx-focus-traversable: false;
            """;
    public static final String BtnActiveStyle = """
            -fx-background-color: #FFD700;
            -fx-text-fill: #1A1A1A;
            -fx-font-size: 12px;
            -fx-font-weight: bold;
            -fx-font-family: "Arial Black", "Impact", sans-serif;
            -fx-background-radius: 7px;
            -fx-border-radius: 9px;
            -fx-border-width: 3px;
            -fx-border-color: #93C8D8;
            -fx-background-insets: 3px;
            -fx-cursor: hand;
            -fx-padding: 12 40 12 40;
            -fx-focus-color: transparent;
            -fx-faint-focus-color: transparent;
            -fx-focus-traversable: false;
            -fx-scale-x: 1.05;
            -fx-scale-y: 1.05;
            """;
    public static final String ScoreStyle = """
            -fx-font-family: "Arial Black", "Impact", sans-serif;
            -fx-font-size: 20px;
            -fx-text-fill: #FFD700;
            -fx-font-weight: bold;
            -fx-padding: 10 0 10 0;
            """;
    public static final String CloseNormalStyle = """
            -fx-background-color: transparent;
            -fx-text-fill: #FFD700;
            -fx-font-weight: bold;
            -fx-font-size: 20px;
            -fx-cursor: hand;
            """;
    public static final String CloseActiveStyle = """
            -fx-background-color: transparent;
            -fx-text-fill: #FF4500;
            -fx-font-weight: bold;
            -fx-font-size: 20px;
            -fx-cursor: hand;
            """;
    public static final String SmallWindowStyle = """
            -fx-background-color: #1d5397;
            -fx-border-color: #FFD700;
            -fx-border-width: 4;
            -fx-background-radius: 15;
            -fx-border-radius: 15;
            -fx-focus-color: transparent;
            -fx-faint-focus-color: transparent;
            -fx-focus-traversable: false;
            """;
    public static  final String SoundOnImg = """
            -fx-background-image: url("/Images/SoundOn.png");
            -fx-background-repeat: no-repeat;
            -fx-background-position: center;
            """;
    public static  final String SoundOffImg = """
            -fx-background-image: url("/Images/SoundOff.png");
            -fx-background-repeat: no-repeat;
            -fx-background-position: center;
            """;
    public static  final String MusicOnImg = """
            -fx-background-image: url("/Images/MusicOn.png");
            -fx-background-repeat: no-repeat;
            -fx-background-position: center;
            """;
    public static  final String MusicOffImg = """
            -fx-background-image: url("/Images/MusicOff.png");
            -fx-background-repeat: no-repeat;
            -fx-background-position: center;
            """;
}
