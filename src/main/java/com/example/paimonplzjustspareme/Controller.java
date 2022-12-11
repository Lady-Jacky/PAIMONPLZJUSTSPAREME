package com.example.paimonplzjustspareme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label MYLABEL;
    private int paiFist = 0;
    private int slimeLick = 0;
    private int defense = 0;
    private int dragonAtk = 0;


    public void Fight(ActionEvent e) {
        Dragon Dvalin = new Dragon();
        Slime slimey = new Slime();
        Paimon Paimon = new Paimon();

        if (Dvalin.isDead() == true) {
            MYLABEL.setText("Yo");
        } else {
            MYLABEL.setText("Oi");
        }
    }
    public void Defend(ActionEvent e) {
        System.out.println("Defend!");
    }

    public void CheckPaimon(ActionEvent e) {
        MYLABEL.setText(Paimon.state3());
    }

}