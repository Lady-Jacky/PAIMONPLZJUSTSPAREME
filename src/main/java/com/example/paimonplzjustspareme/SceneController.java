package com.example.paimonplzjustspareme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Button Fight;
    @FXML
    private Label MYLABEL;
    private int paiFist = 0;
    private int slimeLick = 0;
    private int defense = 0;
    private int dragonAtk = 0;
    private String textslime = ";";

    Dragon Dvalin = new Dragon();
    Slime slimey = new Slime();
    Paimon Paimon = new Paimon();

    public void switchToFightChoice(ActionEvent event) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("Fightwho.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToActionChoice(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaimonVSSlime.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToActionChoice2(ActionEvent event) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("Fightwho.fxml"));
        Group root = new Group();
        Button continua = new Button();
        continua.setFont(Font.font("Chiller", 20));
        continua.setPrefSize(350, 175);
        continua.setLayoutX(350);
        continua.setLayoutY(300);
        continua.setVisible(false);
        continua.setDisable(true);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene PaimonvsSlime = new Scene(root, 750, 500);
        ImageView background = new ImageView("Genshingrass.jpg");
        stage.setScene(PaimonvsSlime);
        Button paiStats = new Button("Paimon's Stats");
        Button SlimeStats = new Button("Slime's Stats");
        Button Fight = new Button("Fight");
        Button block = new Button("Block");
        Fight.setLayoutX(350);
        Fight.setLayoutY(350);
        Fight.setPrefHeight(50);
        Fight.setPrefWidth(100);

        paiStats.setLayoutX(350);
        paiStats.setLayoutY(415);
        paiStats.setPrefHeight(50);
        paiStats.setPrefWidth(100);
        root.getChildren().addAll(background, Fight, paiStats, continua);
        stage.show();


        Fight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = "";
                paiFist = Paimon.attack3();
                slimeLick = slimey.attack2();
                continua.setVisible(true);
                continua.setDisable(false);
                    text += "Paimon attacks for " + paiFist + " damage!\n" + slimey.getSlap(paiFist) + "\n";
                    continua.setText(text);

                    text += "\nThe slime attacks for " + paiFist + " damage!\n" + Paimon.slapped(slimeLick) + "\nClick to proceed";
                    continua.setText(text);
                continua.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        continua.setVisible(false);
                        continua.setDisable(true);
                        if(slimey.isDead2() == true) {

                            scene = new Scene(mainMenu);
                            stage.setScene(scene);

                            Group xpGet = new Group();
                            Scene levels = new Scene(xpGet, 650, 450);
                            Stage lvlup = new Stage();

                            Text lvlXp = new Text("You've successfully beaten the enemy!\n" + Paimon.LevelUp3(slimey.xpGive()));
                            xpGet.getChildren().add(lvlXp);
                            lvlup.setScene(levels);
                            lvlup.show();


                        }

                    }
                });
            }
        });

        paiStats.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Group root = new Group();
                Scene paimonstatus = new Scene(root, 600, 500, Color.WHITESMOKE);
                Stage stats = new Stage();

                Image icon = new Image("paimonhand.png");
                stats.getIcons().add(icon);
                stats.setTitle("Paimon's Stats");
                stats.setX(800);
                stats.setY(200);
                ImageView PaimonHi = new ImageView("paimonhand.png");
                PaimonHi.setY(0);
                PaimonHi.setX(-75);

                Text paimonstat = new Text(Paimon.state3());
                paimonstat.setX(350);
                paimonstat.setY(150);

                paimonstat.setFont(Font.font("Chiller", 50));
                root.getChildren().addAll(paimonstat, PaimonHi);
                stats.setScene(paimonstatus);
                stats.show();
            }

        });
    }


    public void switchToActionChoiceDragon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("killDragon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void PaimonStats(ActionEvent event) throws IOException {
        Group root = new Group();
        Scene paimonstatus = new Scene(root, 600, 500, Color.WHITESMOKE);
        Stage stats = new Stage();

        Image icon = new Image("paimonhand.png");
        stats.getIcons().add(icon);
        stats.setTitle("Paimon's Stats");
        stats.setX(800);
        stats.setY(200);
        ImageView PaimonHi = new ImageView("paimonhand.png");
        PaimonHi.setY(0);
        PaimonHi.setX(-75);

        Text paimonstat = new Text(Paimon.state3());
        paimonstat.setX(350);
        paimonstat.setY(150);

        paimonstat.setFont(Font.font("Chiller", 50));
        root.getChildren().addAll(paimonstat, PaimonHi);
        stats.setScene(paimonstatus);
        stats.show();

    }

    public void SlimeStats(ActionEvent event) throws IOException {
        Group root = new Group();
        Scene slimestatus = new Scene(root, 600, 500, Color.WHITESMOKE);
        Stage stats = new Stage();

        Image icon = new Image("Slimes-removebg-preview.png");
        stats.getIcons().add(icon);
        stats.setTitle("Slime's Stats");
        stats.setX(800);
        stats.setY(200);
        ImageView SlimeHi = new ImageView("Slimes-removebg-preview.png");
        SlimeHi.setY(100);
        SlimeHi.setX(-75);

        Text paimonstat = new Text(slimey.state2());
        paimonstat.setX(350);
        paimonstat.setY(150);

        paimonstat.setFont(Font.font("Chiller", 50));
        root.getChildren().add(paimonstat);
        root.getChildren().add(SlimeHi);


        stats.setScene(slimestatus);
        stats.show();

    }

    public void Fight(ActionEvent e) {
        String text = "";
        slimeLick = Slime.attack2();
        paiFist = Paimon.attack3();
        text = Paimon.slapped(paiFist);
        MYLABEL.setText(text);
        if (slimey.isDead2() == false) {
            text += "\n" + slimey.getSlap(slimeLick);
            MYLABEL.setText(text);
        }

    }
}

//                    Group end = new Group();
//                    Scene endGame = new Scene(end);
//                    endGame.setFill(Color.BLACK);
//                    stage.setScene(endGame);
//                    Text END = new Text("GAME OVER NOOB");
//                    END.setFont(Font.font("Chiller", 50));
//                    END.setFill(Color.WHITE);
//                    end.getChildren().addAll(END);
//                    stage.show();
