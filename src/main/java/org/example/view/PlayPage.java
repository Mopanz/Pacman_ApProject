package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayPage extends VBox {

    private Button closeBtn;

    private RadioButton twoGhost;
    private RadioButton threeGhost;

    private RadioButton classicMap;
    private RadioButton hardMap;

    private Button startBtn;

    public PlayPage(){
        this.getStylesheets().add(getClass().getResource("/CssStyles/CustomRadioButton.css").toExternalForm());

        closeBtn = new Button("X");
        closeBtn.setStyle(Styles.CloseNormalStyle);
        HBox top = new HBox(closeBtn);
        top.setAlignment(Pos.CENTER_RIGHT);


        twoGhost = new RadioButton();
        twoGhost.setStyle(Styles.BtnActiveStyle + Styles.TwoGhostsImg);
        threeGhost = new RadioButton();
        threeGhost.setStyle(Styles.BtnNormalStyle + Styles.ThreeGhostsImg);

        ToggleGroup ghostGroup = new ToggleGroup();
        twoGhost.setToggleGroup(ghostGroup);
        threeGhost.setToggleGroup(ghostGroup);
        twoGhost.setSelected(true);

        HBox ghostHbox = new HBox(twoGhost, threeGhost);
        ghostHbox.setAlignment(Pos.CENTER);
        ghostHbox.setSpacing(10);


        classicMap = new RadioButton();
        classicMap.setStyle(Styles.BtnActiveStyle + Styles.ClassicMapImg);
        hardMap = new RadioButton();
        hardMap.setStyle(Styles.BtnNormalStyle + Styles.HardMapImg);

        ToggleGroup mapGroup = new ToggleGroup();
        classicMap.setToggleGroup(mapGroup);
        hardMap.setToggleGroup(mapGroup);
        classicMap.setSelected(true);

        HBox mapHbox = new HBox(classicMap, hardMap);
        mapHbox.setAlignment(Pos.CENTER);
        mapHbox.setSpacing(10);


        startBtn = new Button("Start");
        startBtn.setStyle(Styles.BtnNormalStyle);

        VBox bottom = new VBox(ghostHbox, mapHbox, startBtn);
        bottom.setSpacing(20);
        bottom.setAlignment(Pos.CENTER);

        this.setStyle(Styles.SmallWindowStyle);
        this.getChildren().addAll(top, bottom);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(250, 250);

    }

    public Button getCloseBtn() {
        return closeBtn;
    }

    public void setCloseBtn(Button closeBtn) {
        this.closeBtn = closeBtn;
    }

    public RadioButton getTwoGhost() {
        return twoGhost;
    }

    public void setTwoGhost(RadioButton twoGhost) {
        this.twoGhost = twoGhost;
    }

    public RadioButton getThreeGhost() {
        return threeGhost;
    }

    public void setThreeGhost(RadioButton threeGhost) {
        this.threeGhost = threeGhost;
    }

    public RadioButton getClassicMap() {
        return classicMap;
    }

    public void setClassicMap(RadioButton classicMap) {
        this.classicMap = classicMap;
    }

    public RadioButton getHardMap() {
        return hardMap;
    }

    public void setHardMap(RadioButton hardMap) {
        this.hardMap = hardMap;
    }

    public Button getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(Button startBtn) {
        this.startBtn = startBtn;
    }
}
