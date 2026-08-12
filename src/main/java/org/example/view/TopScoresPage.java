package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TopScoresPage extends VBox {

    private Button closeBtn;
    private VBox vBoxTwoGhostClassicMap;
    private VBox vBoxTwoGhostHardMap;
    private VBox vBoxThreeGhostClassicMap;
    private VBox vBoxThreeGhostHardMap;

    public TopScoresPage(){

        closeBtn = new Button("X");
        closeBtn.setStyle(Styles.CloseNormalStyle);
        HBox top = new HBox(closeBtn);
        top.setAlignment(Pos.CENTER_RIGHT);

        Label titleTwoGhostClassicMap = new Label("Two Ghost Classic Map");
        titleTwoGhostClassicMap.setStyle(Styles.BtnNormalStyle + "-fx-cursor: default;");
        Label titleTwoGhostHardMap = new Label("Two Ghost Hard Map");
        titleTwoGhostHardMap.setStyle(Styles.BtnNormalStyle + "-fx-cursor: default;");

        HBox hBoxTitleTwoGhostRow = new HBox();
        hBoxTitleTwoGhostRow.setAlignment(Pos.CENTER);
        hBoxTitleTwoGhostRow.setSpacing(10);
        hBoxTitleTwoGhostRow.getChildren().addAll(titleTwoGhostClassicMap, titleTwoGhostHardMap);

        vBoxTwoGhostClassicMap = new VBox();
        vBoxTwoGhostClassicMap.setAlignment(Pos.CENTER);
        vBoxTwoGhostHardMap = new VBox();
        vBoxTwoGhostHardMap.setAlignment(Pos.CENTER);

        HBox hBoxTwoGhostRow = new HBox();
        hBoxTwoGhostRow.setAlignment(Pos.CENTER);
        hBoxTwoGhostRow.setSpacing(175);
        hBoxTwoGhostRow.getChildren().addAll(vBoxTwoGhostClassicMap, vBoxTwoGhostHardMap);

        Label titleThreeGhostClassicMap = new Label("Three Ghost Classic Map");
        titleThreeGhostClassicMap.setStyle(Styles.BtnNormalStyle + "-fx-cursor: default;");
        Label titleThreeGhostHardMap = new Label("Three Ghost Hard Map");
        titleThreeGhostHardMap.setStyle(Styles.BtnNormalStyle + "-fx-cursor: default;");

        HBox hBoxTitleThreeGhostRow = new HBox();
        hBoxTitleThreeGhostRow.setAlignment(Pos.CENTER);
        hBoxTitleThreeGhostRow.setSpacing(10);
        hBoxTitleThreeGhostRow.getChildren().addAll(titleThreeGhostClassicMap, titleThreeGhostHardMap);

        vBoxThreeGhostClassicMap = new VBox();
        vBoxThreeGhostClassicMap.setAlignment(Pos.CENTER);
        vBoxThreeGhostHardMap = new VBox();
        vBoxThreeGhostHardMap.setAlignment(Pos.CENTER);

        HBox hBoxThreeGhostRow = new HBox();
        hBoxThreeGhostRow.setAlignment(Pos.CENTER);
        hBoxThreeGhostRow.setSpacing(175);
        hBoxThreeGhostRow.getChildren().addAll(vBoxThreeGhostClassicMap, vBoxThreeGhostHardMap);

        VBox bottom = new VBox();
        bottom.setSpacing(5);
        bottom.getChildren().addAll(hBoxTitleTwoGhostRow, hBoxTwoGhostRow, hBoxTitleThreeGhostRow, hBoxThreeGhostRow);

        this.setStyle(Styles.SmallWindowStyle);
        this.getChildren().addAll(top, bottom);
        this.setAlignment(Pos.CENTER);

    }

    public Button getCloseBtn() {
        return closeBtn;
    }

    public void setCloseBtn(Button closeBtn) {
        this.closeBtn = closeBtn;
    }

    public VBox getvBoxTwoGhostClassicMap() {
        return vBoxTwoGhostClassicMap;
    }

    public void setvBoxTwoGhostClassicMap(VBox vBoxTwoGhostClassicMap) {
        this.vBoxTwoGhostClassicMap = vBoxTwoGhostClassicMap;
    }

    public VBox getvBoxTwoGhostHardMap() {
        return vBoxTwoGhostHardMap;
    }

    public void setvBoxTwoGhostHardMap(VBox vBoxTwoGhostHardMap) {
        this.vBoxTwoGhostHardMap = vBoxTwoGhostHardMap;
    }

    public VBox getvBoxThreeGhostClassicMap() {
        return vBoxThreeGhostClassicMap;
    }

    public void setvBoxThreeGhostClassicMap(VBox vBoxThreeGhostClassicMap) {
        this.vBoxThreeGhostClassicMap = vBoxThreeGhostClassicMap;
    }

    public VBox getvBoxThreeGhostHardMap() {
        return vBoxThreeGhostHardMap;
    }

    public void setvBoxThreeGhostHardMap(VBox vBoxThreeGhostHardMap) {
        this.vBoxThreeGhostHardMap = vBoxThreeGhostHardMap;
    }
}
