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
import javafx.scene.shape.Rectangle;
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
    private ImageView Paimoned;
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
        scene = new Scene(mainMenu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        continua.setPrefSize(350, 150);
        continua.setLayoutX(350);
        continua.setLayoutY(340);
        continua.setVisible(false);
        continua.setDisable(true);
        Button slimecont = new Button();
        slimecont.setFont(Font.font("Chiller", 20));
        slimecont.setPrefSize(350, 150);
        slimecont.setLayoutX(350);
        slimecont.setLayoutY(340);
        slimecont.setVisible(false);
        slimecont.setDisable(true);
        if(Paimon.getLevel3() > 0 && Paimon.getLevel3() <= 4)  {
            Paimoned = new ImageView("Paimonangry.png");
            Paimoned.setFitWidth(500);
            Paimoned.setFitHeight(300);
            Paimoned.setX(-100);
            Paimoned.setY(200);
        }
        if(Paimon.getLevel3() > 4 && Paimon.getLevel3() <= 7 )  {
            Paimoned = new ImageView("Paimonangry.png");
        }
        if(Paimon.getLevel3() > 7 && Paimon.getLevel3()  <= 10)  {
            Paimoned = new ImageView("PaimonLVL3.png");
            Paimoned.setFitWidth(500);
            Paimoned.setFitHeight(300);
            Paimoned.setX(-100);
            Paimoned.setY(200);
        }
        ImageView slime = new ImageView("Slimes-removebg-preview.png");
        slime.setX(425);
        slime.setY(0);
        slime.setFitHeight(300);
        slime.setFitWidth(300);
        Rectangle SlimeHPrec = new Rectangle(300, 35);
        SlimeHPrec.setX(100);
        SlimeHPrec.setY(50);
        SlimeHPrec.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1.5;");
        Text SlimeHP = new Text("Slime          HP: " + slimey.getHealth2() + "/" + slimey.getHealthCap2());
        SlimeHP.setX(120);
        SlimeHP.setY(75);
        SlimeHP.setFont(Font.font("Bell MT", 25));
        Rectangle HPrec = new Rectangle(300, 35);
        HPrec.setX(350);
        HPrec.setY(300);
        HPrec.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1.5;");
        Text PaiHP = new Text("Paimon         HP: " + Paimon.getHealth3() + "/" + Paimon.getHealthCap());
        PaiHP.setX(365);
        PaiHP.setY(325);
        PaiHP.setFont(Font.font("Bell MT", 25));
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

        SlimeStats.setLayoutX(475);
        SlimeStats.setLayoutY(415);
        SlimeStats.setPrefHeight(50);
        SlimeStats.setPrefWidth(100);
        root.getChildren().addAll(background, Paimoned , slime, Fight, paiStats, SlimeStats, HPrec, SlimeHPrec, SlimeHP, PaiHP, continua, slimecont);
        stage.show();


        Fight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = "";
                String text2 = "";
                paiFist = Paimon.attack3();
                slimeLick = slimey.attack2();
                continua.setVisible(true);
                continua.setDisable(false);
                    text = "Paimon attacks for " + paiFist + " damage!\n" + slimey.getSlap(paiFist) + "\n(Click to proceed)";
                    continua.setText(text);
                    text2 = "The slime attacks for " + slimeLick + " damage!\n" + Paimon.slapped(slimeLick) + "\n(Click to proceed)";
                    slimecont.setText(text2);
                continua.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        SlimeHP.setText("Slime          HP: " + slimey.getHealth2() + "/" + slimey.getHealthCap2());
                        continua.setVisible(false);
                        continua.setDisable(true);
                        slimecont.setVisible(true);
                        slimecont.setDisable(false);

                        slimecont.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {
                                PaiHP.setText("Paimon         HP: " + Paimon.getHealth3() + "/" + Paimon.getHealthCap());
                                slimecont.setVisible(false);
                                slimecont.setDisable(true);
                                if (slimey.isDead2() == true) {

                                    scene = new Scene(mainMenu);
                                    stage.setScene(scene);

                                    Group xpGet = new Group();
                                    Scene levels = new Scene(xpGet, 650, 450);
                                    Stage lvlup = new Stage();
                                    ImageView win = new ImageView("paimonwins.jpg");
                                    win.setFitHeight(450);
                                    win.setFitWidth(650);
                                    Text lvlXp = new Text("You've successfully beaten the enemy!\n\n" + Paimon.LevelUp3(slimey.xpGive()));
                                    lvlXp.setX(175);
                                    lvlXp.setY(100);
                                    lvlXp.setFont(Font.font("Forte", 20));
                                    Rectangle rect = new Rectangle();
                                    rect.setWidth(380);
                                    if (Paimon.nextLvl() == true) {
                                        rect.setHeight(210);
                                        Paimon.setLevelFalse();
                                    } else {
                                        rect.setHeight(125);
                                    }
                                    rect.setX(160);
                                    rect.setY(70);
                                    rect.setOpacity(.8);
                                    rect.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 3;");
                                    xpGet.getChildren().addAll(win, rect, lvlXp);
                                    lvlup.setScene(levels);
                                    lvlup.show();
                                }
                                if (Paimon.isDead3() == true) {
                                    Group foodmon = new Group();
                                    Scene cooked = new Scene(foodmon, 650, 450);
                                    ImageView lose = new ImageView("Paimoneaten.jpg");
                                    lose.setFitHeight(450);
                                    lose.setFitWidth(650);
                                    Rectangle rect = new Rectangle();
                                    rect.setWidth(475);
                                    rect.setHeight(50);
                                    rect.setX(115);
                                    rect.setY(290);
                                    rect.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 3;");
                                    rect.setOpacity(.8);
                                    Text eaten = new Text("GAME OVER! Paimon dead and shall be cooked! :D");
                                    eaten.setX(125);
                                    eaten.setY(320);
                                    eaten.setFont(Font.font("Forte", 20));
                                    foodmon.getChildren().addAll(lose, rect, eaten);
                                    stage.setScene(cooked);
                                    stage.show();
                                }

                            }
                        });
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
                stats.setX(780);
                stats.setY(200);
                ImageView PaimonHi = new ImageView("paimonhand.png");
                PaimonHi.setY(0);
                PaimonHi.setX(-75);

                Text paimonstat = new Text(Paimon.state3());
                paimonstat.setX(350);
                paimonstat.setY(150);

                paimonstat.setFont(Font.font("Chiller", 45));
                root.getChildren().addAll(paimonstat, PaimonHi);
                stats.setScene(paimonstatus);
                stats.show();
            }

        });

        SlimeStats.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Group root = new Group();
                Scene slimestatus = new Scene(root, 600, 500, Color.WHITESMOKE);
                Stage stats = new Stage();

                Image icon = new Image("Slime icon.png");
                stats.getIcons().add(icon);
                stats.setTitle("Slime Stats");
                stats.setX(780);
                stats.setY(200);
                ImageView slimed = new ImageView("Slime icon.png");
                slimed.setFitHeight(325);
                slimed.setFitWidth(450);
                slimed.setY(70);
                slimed.setX(-75);

                Text slimestat = new Text(slimey.state2());
                slimestat.setX(350);
                slimestat.setY(175);

                slimestat.setFont(Font.font("Chiller", 45));
                root.getChildren().addAll(slimestat, slimed);
                stats.setScene(slimestatus);
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
        paimonstat.setX(340);
        paimonstat.setY(150);

        paimonstat.setFont(Font.font("Chiller", 40));
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
