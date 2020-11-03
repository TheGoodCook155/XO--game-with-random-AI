package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;


public class Controller {
    @FXML
    private Pane pane;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Text text5;
    @FXML
    private Text text6;
    @FXML
    private Text text7;
    @FXML
    private Text text8;
    @FXML
    private Text text9;

    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Rectangle rect5;
    @FXML
    private Rectangle rect6;
    @FXML
    private Rectangle rect7;
    @FXML
    private Rectangle rect8;
    @FXML
    private Rectangle rect9;

    Button button;

    private boolean xTurn = true;
    private  List<Integer> notAvailableMoves = new ArrayList<>();





//
//        /*
//        1t 2t 3t
//        5t 4t 6t
//        7t 9t 8t
//         */
//
    private void makeNotAvailable(Text text){

            if(text.equals(text1)){
                notAvailableMoves.add(1);
            }
            if(text.equals(text2)){
                notAvailableMoves.add(2);
            }
            if(text.equals(text3)){
                notAvailableMoves.add(3);
            }
            if(text.equals(text4)){
                notAvailableMoves.add(4);
            }
            if(text.equals(text5)){
                notAvailableMoves.add(5);
            }
            if(text.equals(text6)){
                notAvailableMoves.add(6);
            }
            if(text.equals(text7)){
                notAvailableMoves.add(7);
            }
            if(text.equals(text8)){
                notAvailableMoves.add(8);
            }
            if(text.equals(text9)){
                notAvailableMoves.add(9);
            }
    }

    public void mousePress(MouseEvent mouseEvent) {

        Text text = (Text) mouseEvent.getSource();

            text.setOnMouseClicked(event -> {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    text.setText("X");
                    text.setDisable(true);
                    text.setTextAlignment(TextAlignment.CENTER);
                    makeNotAvailable(text);
                    text.setDisable(true);
                    xTurn = false;
                    checkState();
                    if (checkState() == true) {
                        try {
                            endGame();
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                    aiPlay();
                    checkState();
                    if(checkState() == true){
                        try {
                            endGame();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                }
            });


    }

    private void aiPlay() {
        if (!xTurn) {
            int move = 0;
            if (notAvailableMoves.size() < 9) {
                do {
                    move = generateMove();
                    isAvailable(move);
                } while (isAvailable(move) == -1);

            }

            //
//        /*
//        1t 2t 3t
//        5t 4t 6t
//        7t 9t 8t
//         */
            if(text1.getText().isEmpty()){
            if (move == 1) {
                text1.setText("O");
                text1.setDisable(true);
                text1.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text1);
                text1.setDisable(true);
              }
            }
            if(text2.getText().isEmpty()){
            if (move == 2) {

                text2.setText("O");
                text2.setDisable(true);
                text2.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text2);
                text2.setDisable(true);

               }
            }
            if(text3.getText().isEmpty()){
            if (move == 3) {

                text3.setText("O");
                text3.setDisable(true);
                text3.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text3);
                text3.setDisable(true);
                }
            }
            if(text4.getText().isEmpty()){
            if (move == 4) {

                text4.setText("O");
                text4.setDisable(true);
                text4.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text4);
                text4.setDisable(true);
               }
            }
            if(text5.getText().isEmpty()){
            if (move == 5) {

                text5.setText("O");
                text5.setDisable(true);
                text5.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text5);
                text5.setDisable(true);
              }
            }
            if(text6.getText().isEmpty()){
            if (move == 6) {

                text6.setText("O");
                text6.setDisable(true);
                text6.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text6);
                text6.setDisable(true);
              }
            }
            if(text7.getText().isEmpty()){
            if (move == 7) {

                text7.setText("O");
                text7.setDisable(true);
                text7.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text7);
                text7.setDisable(true);
              }
            }
            if(text8.getText().isEmpty()){
            if (move == 8) {

                text8.setText("O");
                text8.setDisable(true);
                text8.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text8);
                text8.setDisable(true);
              }
            }
            if(text9.getText().isEmpty()){
            if (move == 9) {

                text9.setText("O");
                text9.setDisable(true);
                text9.setTextAlignment(TextAlignment.CENTER);
                makeNotAvailable(text9);
                text9.setDisable(true);
               }
            }
        }
    }

    private int isAvailable(int move) {

        for (int i = 0; i < notAvailableMoves.size(); i++){
            if(move == notAvailableMoves.get(i) || move == 0){
                return -1;
            }
        }
        return move;
    }

    private int generateMove() {
        Random random = new Random();
        int upperBound = 9;
        int lowerBound = 1;
        int test = random.nextInt(upperBound-lowerBound) + lowerBound;

        return test;
    }



    public void endGame() throws InterruptedException, IOException {
        button = new Button("Restart Game?");
        button.setFont(Font.font(30));
        button.setLayoutX(185);
        button.setLayoutY(250);
        pane.getChildren().add(button);

        button.setOnMouseClicked(event -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            //get the stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        });

        text1.setDisable(true);
        text2.setDisable(true);
        text3.setDisable(true);
        text4.setDisable(true);
        text5.setDisable(true);
        text6.setDisable(true);
        text7.setDisable(true);
        text8.setDisable(true);
        text9.setDisable(true);


    }




    public  boolean checkState() {

        /*
        1R 2R 3R
        4R 5R 6R
        7R 8R 9R
         */

                /*
        1t 2t 3t 0,1,2
        5t 4t 6t 3,4,5
        7t 9t 8t 6,7,8
         */


        boolean gameOver = false;

        if(notAvailableMoves.size() < 9) {
            if (text1.getText().isEmpty() == false && text2.getText().isEmpty() == false && text3.getText().isEmpty() == false) {
                if (text1.getText().equals(text2.getText()) && text1.getText().equals(text3.getText())) {
                    rect1.setFill(Color.RED);
                    rect2.setFill(Color.RED);
                    rect3.setFill(Color.RED);
                    gameOver = true;
                }
            }

            if (text1.getText().isEmpty() == false && text5.getText().isEmpty() == false && text7.getText().isEmpty() == false) {
                if (text1.getText().equals(text5.getText()) && text1.getText().equals(text7.getText())) {
                    rect1.setFill(Color.RED);
                    rect4.setFill(Color.RED);
                    rect7.setFill(Color.RED);
                    gameOver = true;
                }
            }

            if (text1.getText().isEmpty() == false && text4.getText().isEmpty() == false && text8.getText().isEmpty() == false) {
                if (text1.getText().equals(text4.getText()) && text1.getText().equals(text8.getText())) {
                    rect1.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect9.setFill(Color.RED);
                    gameOver = true;
                }
            }

            if (text2.getText().isEmpty() == false && text4.getText().isEmpty() == false && text9.getText().isEmpty() == false) {
                if (text2.getText().equals(text4.getText()) && text2.getText().equals(text9.getText())) {
                    rect2.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect8.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text3.getText().isEmpty() == false && text6.getText().isEmpty() == false && text8.getText().isEmpty() == false) {
                if (text3.getText().equals(text6.getText()) && text3.getText().equals(text8.getText())) {
                    rect3.setFill(Color.RED);
                    rect6.setFill(Color.RED);
                    rect9.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text3.getText().isEmpty() == false && text4.getText().isEmpty() == false && text7.getText().isEmpty() == false) {
                if (text3.getText().equals(text4.getText()) && text3.getText().equals(text7.getText())) {
                    rect3.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect7.setFill(Color.RED);
                    gameOver = true;
                }
            }

            if (text5.getText().isEmpty() == false && text4.getText().isEmpty() == false && text6.getText().isEmpty() == false) {
                if (text5.getText().equals(text4.getText()) && text5.getText().equals(text6.getText())) {
                    rect4.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect6.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text4.getText().isEmpty() == false && text5.getText().isEmpty() == false && text6.getText().isEmpty() == false) {
                if (text4.getText().equals(text5.getText()) && text4.getText().equals(text6.getText())) {
                    rect4.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect6.setFill(Color.RED);
                    gameOver = true;
                }
            }



            if (text4.getText().isEmpty() == false && text2.getText().isEmpty() == false && text9.getText().isEmpty() == false) {
                if (text4.getText().equals(text2.getText()) && text4.getText().equals(text9.getText())) {
                    rect2.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect8.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text7.getText().isEmpty() == false && text9.getText().isEmpty() == false && text8.getText().isEmpty() == false) {
                if (text7.getText().equals(text9.getText()) && text7.getText().equals(text8.getText())) {
                    rect7.setFill(Color.RED);
                    rect8.setFill(Color.RED);
                    rect9.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text9.getText().isEmpty() == false && text4.getText().isEmpty() == false && text2.getText().isEmpty() == false) {
                if (text9.getText().equals(text2.getText()) && text9.getText().equals(text4.getText())) {
                    rect2.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect8.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text8.getText().isEmpty() == false && text9.getText().isEmpty() == false && text7.getText().isEmpty() == false) {
                if (text8.getText().equals(text7.getText()) && text8.getText().equals(text9.getText())) {
                    rect7.setFill(Color.RED);
                    rect8.setFill(Color.RED);
                    rect9.setFill(Color.RED);
                    gameOver = true;
                }
            }

            if (text8.getText().isEmpty() == false && text6.getText().isEmpty() == false && text3.getText().isEmpty() == false) {
                if (text8.getText().equals(text6.getText()) && text8.getText().equals(text3.getText())) {
                    rect3.setFill(Color.RED);
                    rect6.setFill(Color.RED);
                    rect9.setFill(Color.RED);
                    gameOver = true;
                }
            }


            if (text8.getText().isEmpty() == false && text4.getText().isEmpty() == false && text1.getText().isEmpty() == false) {
                if (text8.getText().equals(text4.getText()) && text8.getText().equals(text1.getText())) {
                    rect1.setFill(Color.RED);
                    rect5.setFill(Color.RED);
                    rect9.setFill(Color.RED);
                    gameOver = true;
                }
            }
            return gameOver;
        }else{
            //if last x move wins, won't color boxes
            gameOver = true;
        }

        return gameOver;
        }



}


