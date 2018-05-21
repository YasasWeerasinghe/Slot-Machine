import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    // int variable initialize and declaration
    static int addCoin = 10;
    static int bet=0;
    static int noOfWins;
    static int noOfLoss;
    static int totalBet;
    static int avg;
    static int noOFPlay;
    static int creditAVG;
    static int buttonCount=0;

    // new symbol objects
    Symbol symbol1 = new Symbol();
    Symbol symbol2 = new Symbol();
    Symbol symbol3 = new Symbol();
    // reel label
    Label reel1 =new Label();
    Label reel2 = new Label();
    Label reel3 = new Label();

    //button declaration
    Button bAddCoin ;
    Button bBetOne;
    Button bBetMax;
    Button bReset;
    Button bStatistics;
    Button bSpin;

    // new reel objects
    Reel reelobj1 = new Reel();
    Reel reelobj2 = new Reel();
    Reel reelobj3 = new Reel();

    // label declaration
    Label lBetArea;
    Label lAddCoin;
    Label lCreditArea;
    Label lBetAreaText;
    static Label status;

    //reel images
    ImageView view1;
    ImageView view2;
    ImageView view3;

    ArrayList<Double> payOutList = new ArrayList<>();  // payOut arrayList


        @Override
        public void start(Stage primaryStage) throws Exception{

        // reel1 mouse click event handlers
        reel1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spin = false; // spin will stop
                calc(); // after spin stop calc method will call
                creditAVG(); //after spin stop creditAVG method will call
                avg();  //after spin stop avd method will call
                enable();   //after spin stop enable method will call and all button will activate
            }

        });
            // reel2 mouse click event handlers
        reel2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spin2 = false;
                calc();
                creditAVG();
                avg();
            }
        });
            // reel3 mouse click event handlers
        reel3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spin3 = false;
                calc();
                creditAVG();
                avg();
            }
        });

        //border pane
        //to align components to the window
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: black");

        // left grid pane initialising, padding
        GridPane gLeft = new GridPane();
        gLeft.setPadding(new Insets(0,10,30,20));
        gLeft.setVgap(10); // vertical gap
        gLeft.setHgap(10); // horizontal gap
        gLeft.setAlignment(Pos.BOTTOM_LEFT);

        // right grid pane initialising, padding
        GridPane gRight = new GridPane();
        gRight.setPadding(new Insets(150,20,20,20));
        gRight.setVgap(15); // vertical gap
        gRight.setAlignment(Pos.CENTER_RIGHT);

        // title grip pane initialising, padding
        GridPane gTitle = new GridPane();
        gTitle.setPadding(new Insets(30,10,10,10));
        gTitle.setAlignment(Pos.TOP_CENTER);

        // image grip pane initialising, padding
        GridPane images = new GridPane();
        images.setPadding(new Insets(10,10,10,120));
        images.setHgap(7);

        // all button naming and initialising
        bAddCoin = new Button("Add Coin");
        bAddCoin.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold;-fx-background-color: gold");
        bBetOne = new Button("Bet One");
        bBetOne.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold;-fx-background-color: gold");
        bBetMax = new Button("Bet Max");
        bBetMax.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold;-fx-background-color: gold");
        bReset = new Button("Reset");
        bReset.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold;-fx-background-color: lime");
        bStatistics = new Button("Statistics");
        bStatistics.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold;-fx-background-color: orange");
        bSpin = new Button("Spin");
        bSpin.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold;-fx-background-color: red");

        // labels and the text area initialising
        Text title = new Text("Slot Machine");
        title.setStyle("-fx-font: bold  26 Arial;");
        title.setFill(Color.GOLD);
        lCreditArea = new Label("Credit Area");
        lCreditArea.setStyle("-fx-font-size: 14;-fx-text-fill: white; -fx-font-weight: bold");
        lAddCoin = new Label(""+ addCoin);
        lAddCoin.setStyle("-fx-font-size: 14;-fx-text-fill: white;-fx-font-weight: bold");
        lBetAreaText = new Label("Bet Area");
        lBetAreaText.setStyle("-fx-font-size: 14;-fx-text-fill: white;-fx-font-weight: bold");
        lBetArea = new Label();
        lBetArea.setStyle("-fx-font-size: 14;-fx-text-fill: white;-fx-font-weight: bold");
        status = new Label("");

        //default images
        ImageView iV1 = new ImageView(new Image("redseven.png"));
        ImageView iV2 = new ImageView(new Image("redseven.png"));
        ImageView iV3 = new ImageView(new Image("redseven.png"));

        //background image
        ImageView b1 = new ImageView(new Image("b1.png"));
        ImageView b2 = new ImageView(new Image("b2.png"));
        ImageView b3 = new ImageView(new Image("b3.png"));

        // image width and height
         iV1.setFitWidth(120);
         iV1.setFitHeight(120);
         iV2.setFitWidth(120);
         iV2.setFitHeight(120);
         iV3.setFitWidth(120);
         iV3.setFitHeight(120);

         // reel background image width and height
         b1.setFitWidth(150);
         b1.setFitHeight(170);
         b2.setFitWidth(150);
         b2.setFitHeight(170);
         b3.setFitWidth(150);
         b3.setFitHeight(170);

         //set images to the reel label
         reel1.setGraphic(iV1);
         reel1.setDisable(true);
         reel2.setGraphic(iV2);
         reel2.setDisable(true);
         reel3.setGraphic(iV3);
         reel3.setDisable(true);

        // all button size
        bAddCoin.setMaxSize(100,30);
        bBetOne.setMaxSize(100,30);
        bBetMax.setMaxSize(100,30);
        bReset.setMaxSize(100,30);
        bStatistics.setMaxSize(100,30);
        bSpin.setMaxSize(100,30);

        // left side button grid pane alignments
        GridPane.setHalignment(bAddCoin, HPos.LEFT);
        gLeft.add(bAddCoin,0,0);
        GridPane.setHalignment(bBetOne, HPos.LEFT);
        gLeft.add(bBetOne,0,1);
        GridPane.setHalignment(bBetMax, HPos.LEFT);
        gLeft.add(bBetMax,1,1);
        GridPane.setHalignment(bReset, HPos.LEFT);
        gLeft.add(bReset,0,2);

        // labels and the text area grid pane alignments
        GridPane.setHalignment(lCreditArea, HPos.LEFT);
        gLeft.add(lCreditArea,8,0);
        GridPane.setHalignment(lAddCoin, HPos.LEFT);
        gLeft.add(lAddCoin,10,0);
        GridPane.setHalignment(lBetAreaText, HPos.LEFT);
        gLeft.add(lBetAreaText,8,1);
        GridPane.setHalignment(lBetArea, HPos.LEFT);
        gLeft.add(lBetArea,10,1);
        GridPane.setHalignment(lBetArea, HPos.LEFT);
        gTitle.add(status,0,1);
        GridPane.setHalignment(status, HPos.CENTER);

        // right side button grid pane alignments
        GridPane.setHalignment(bStatistics, HPos.RIGHT);
        gRight.add(bStatistics,1,0);
        GridPane.setHalignment(bSpin, HPos.RIGHT);
        gRight.add(bSpin,1,1);

        // center title grid pane alignments
        GridPane.setHalignment(title, HPos.CENTER);
        gTitle.add(title,0,0);

        // image alignments
        images.setAlignment(Pos.CENTER);
        //image grid pane alignments
        images.add(iV1,0,0);
        images.add(iV2,1,0);
        images.add(iV3,2,0);
        images.add(b1,0,0);
        images.add(b2,1,0);
        images.add(b3,2,0);
        //reel label grid pane alignments
        images.add(reel1,0,0);
        images.add(reel2,1,0);
        images.add(reel3,2,0);

        // add all components to the border pane
        root.setBottom(gLeft); // left side grid add to the border pane
        root.setRight(gRight); // right side grid add to the border pane
        root.setTop(gTitle); // title add to the top of the border pane
        root.setCenter(images); // set reel images to center

        // window setup
        primaryStage.setTitle("Slot Machine application CW"); // window title
        Scene scene = new Scene(root,750,500); // window size and add all components to the window
        primaryStage.setScene(scene);
        primaryStage.show();

        //addCoin button Action Event
        bAddCoin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addCoin++; // when click button add one
                status.setText(addCoin+ " coin added");
                status.setStyle("-fx-font-size: 20;-fx-text-fill: deeppink;-fx-font-weight: bold;");
                lAddCoin.setText(""+addCoin); // set the values to the label
                if (addCoin>=3){    // when addCoin value less than or equal to 3 betMax button will disable
                    bBetMax.setDisable(false);
                }
                if (addCoin>=1){    // when addCoin value less than or equal to 1 betOne button will disable
                    bBetOne.setDisable(false);
                }
            }
        });

        //betOne button Action Event
        bBetOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addCoin--; // when betOne button click addCoin reduce from 1
                if(addCoin>=0){
                    bet++;  // until addCoin 0 bet area'll increase  by 1
                    System.out.print(bet);
                    status.setText(1+" bet is added and current bet value is " + bet);
                    status.setStyle("-fx-font-size: 20;-fx-text-fill: deeppink;-fx-font-weight: bold;");
                    lAddCoin.setText(""+ addCoin); // display values in the label
                    lBetArea.setText(""+bet); // display values in the label
                    bSpin.setDisable(false);
                } else{
                    bet++; // this used to show correct addCoin value when click the reset button
                    bBetOne.setDisable(true); // addCoin less than or equal to 0 betOne'll disable
                    bBetMax.setDisable(true); // addCoin less than or equal to 0 betMax'll disable
                    // alert msg when credit les than 1
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("There's no enough  credit to bet ");
                    alert.setTitle("Out of credit");
                    alert.show();
                }
            }
        });

        //betMax button Action Event
            bBetMax.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(buttonCount==0){
                            if (addCoin > 2) {
                                addCoin = addCoin - 3;  // when click betMax addCoin'll reduce by 3
                                bet = bet + 3; // when click betMax betArea'll increase by 3
                                buttonCount++; // button count
                                status.setText(" Max bet 3 is added and current bet value is " + bet);
                                status.setStyle("-fx-font-size: 20;-fx-text-fill: deeppink;-fx-font-weight: bold;");
                                lAddCoin.setText("" + addCoin); // display the values in the label
                                lBetArea.setText("" + bet); // display the values in the label
                                // bBetMax.setDisable(true); // when click ones the button'll disable
                                bSpin.setDisable(false);

                            } else {

                                bBetMax.setDisable(true); // addCoin less than or equal to 0 betMax'll disable
                                // alert msg when credit les than 3
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setHeaderText(null);
                                alert.setContentText("There's no enough  credit to bet ");

                                alert.setTitle("Out of credit");
                                alert.show();
                            }
                        }else{

                            Alert alertMax = new Alert(Alert.AlertType.WARNING);
                            alertMax.setTitle("Warning");
                            alertMax.setHeaderText(null);
                            alertMax.setContentText("You can not BetMax twice");
                            alertMax.showAndWait();
                        }
                    }
                });


        //reset button Action Event
        bReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                status.setText("Reset the bet area and add all bet value's to the credit");
                status.setStyle("-fx-font-size: 20;-fx-text-fill: deepskyblue;-fx-font-weight: bold;");
                addCoin= addCoin + bet;
                bet = bet - bet;
                buttonCount=0;
                lBetArea.setText("" + bet);
                lAddCoin.setText("" + addCoin);
                bBetOne.setDisable(false); // use to enable the disable button
                bBetMax.setDisable(false); // use to enable the disable button
                bSpin.setDisable(false);
            }
        });
        // statistics button Action Event
        bStatistics.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                status.setText("Statistics");
                status.setStyle("-fx-font-size: 20;-fx-text-fill: deepskyblue;-fx-font-weight: bold;");
                Statistics statistics =new Statistics(noOfWins,noOfLoss);
                statistics.displayStatistics(creditAVG,avg); // call the displayStatistics method
                lBetArea.setText("" + bet);
            }
        });

        //spin button Action Event
        bSpin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                status.setText("Spinning");
                status.setStyle("-fx-font-size: 20;-fx-text-fill: deepskyblue;-fx-font-weight: bold;");
                spin=true; // when spin true it'll spin
                spin2=true; // when spin true it'll spin
                spin3=true; // when spin true it'll spin
                if(bet==0) { // if bet 0 show an alert message
                    status.setText("Error! Please bet a coin");
                    status.setStyle("-fx-font-size: 20;-fx-text-fill: orangered;-fx-font-weight: bold;");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("You can not spin without bet a coin");
            alert.showAndWait();
        }else{
             spinReels(); // when spin true spinReel method'll call
                    bSpin.setDisable(true);
                    reel1.setDisable(false);
                    reel2.setDisable(false);
                    reel3.setDisable(false);

                    bBetMax.setDisable(true);
                    bBetOne.setDisable(true);
                    bStatistics.setDisable(true);
                    bSpin.setDisable(true);
                    bAddCoin.setDisable(true);
                    bReset.setDisable(true);

                    totalBet+=bet; // total bet
                    noOFPlay++; // no of play
                    buttonCount=0;
                }
            }
        });
    }

    // Score calculation method
        public void calc(){
           if(spin ==false && spin2==false && spin3==false ) {


               if (Symbol.compareImages(symbol1, symbol2) == 0 || Symbol.compareImages(symbol1, symbol3) == 0) {
                   addCoin += symbol1.getValue() * bet; // calculation                   // status
                   System.out.println(addCoin + " " + symbol1.getValue() + " " + bet);
                   status.setText("Reel value: " + symbol1.getValue() + "  Bet value:  " + bet + "  Value * Bet: " + symbol1.getValue() * bet +  "  Total value(reel * bet + coin): " + addCoin);
                   status.setStyle("-fx-font-size: 20;-fx-text-fill: lime;-fx-font-weight: bold;");
                   lAddCoin.setText("" + addCoin);
                   noOfWins++;
                   bet = 0;
                   lBetArea.setText("" + bet); // bet area reset to 0
                    // win alert box
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("You Win " + addCoin + " credits!");
                   alert.setTitle("You won");
                   alert.show();


               } else if (Symbol.compareImages(symbol2, symbol3) == 0) {
                   addCoin += symbol2.getValue() * bet; // calculation                   // status
                   System.out.println(addCoin + " " + symbol2.getValue() + " " + bet);
                   status.setText("Reel value: " + symbol2.getValue() + "  Bet value: " + bet +  "  Value * Bet: " + symbol1.getValue() * bet +  "  Total value(reel * bet + coin): " + addCoin);
                   status.setStyle("-fx-font-size: 20;-fx-text-fill: lime;-fx-font-weight: bold;");
                   lAddCoin.setText("" + addCoin);
                   noOfWins++;
                    // win alert box
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("You Win " + addCoin + " credits!");
                   alert.setTitle("You won");
                   alert.show();

               } else { // alert message when lose
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("You Lose");
                   alert.setTitle("Game the lose");
                   alert.show();
                   noOfLoss++; // count no of lose
                   status.setText("You lose");
                   status.setStyle("-fx-font-size: 20;-fx-text-fill: red;-fx-font-weight: bold;");
               }

               noOFPlay++; // count no of plays
               bet = 0; // set bet to 0
               lBetArea.setText("" + bet);
           }
        }


    // payOut Calculation
    public void payOutCalc(){

        double payout = 0.0;
        int numberOfSymbols = 6;
        double threeMachedProbability = (1.0/(numberOfSymbols*numberOfSymbols*numberOfSymbols));    //three reel probability calculation
        double twoMachedProbability = (1.0/(numberOfSymbols*numberOfSymbols));  //two reel probability calculation
        Symbol s = new Symbol();//Symbol class object is created

        //compares symbols reel 1
        if(s.compareImages(symbol1, symbol2)==0 && s.compareImages(symbol1, symbol3) == 0){
            payout = symbol1.getValue()*threeMachedProbability; //payout Calculated
            payOutList.add(payout);//add the values to the array

            //compares symbols reel 2
        }else if(s.compareImages(symbol1,symbol2) == 0 || s.compareImages(symbol1, symbol3) == 0){
            payout = symbol1.getValue()*twoMachedProbability;
            payOutList.add(payout); // value add to the arrayList

            //compares symbols reel 3
        }else if(s.compareImages(symbol2, symbol3)== 0 ){
            payout = symbol1.getValue()*twoMachedProbability;
            payOutList.add(payout);

        }else{
            //if symbols are not equal
            payout = 0.0;//payOut initialize to 0;
            payOutList.add(payout);
        }

    }



        // calculate the credit AVG
    public static void creditAVG(){ // calculate Credit average
       creditAVG= addCoin/noOFPlay;
    }

        // calculate the AVG
    public static void avg (){ // calculate average
        avg=noOfWins-noOfLoss;
    }

    public void enable(){ // method used to enable buttons
        bAddCoin.setDisable(false);
        bBetOne.setDisable(false);
        bBetMax.setDisable(false);
        bReset.setDisable(false);
        bStatistics.setDisable(false);
    }

    private boolean spin = false;
    private boolean spin2 = false;
    private boolean spin3 = false;

    public void spinReels(){

        //reel image size
        view1 = new ImageView();
        view1.setFitHeight(100);
        view1.setFitWidth(100);

        view2 = new ImageView();
        view2.setFitHeight(100);
        view2.setFitWidth(100);

        view3 = new ImageView();
        view3.setFitHeight(100);
        view3.setFitWidth(100);

        //reel one thread
        new Thread(new Runnable(){
            @Override
            public void run(){

                while(spin){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {

                            reelobj1.Spin();
                            int x=(int)(Math.random()*6);
                            view1.setImage(reelobj1.sList.get(x).getImage());
                            symbol1.setValue(reelobj1.sList.get(x).getValue());
                            reel1.setGraphic(view1);

                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        //reel two thread
        new Thread(new Runnable(){
            @Override
            public void run(){

                while(spin2){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {

                            reelobj2.Spin();
                            int random1=(int)(Math.random()*6);
                            view2.setImage(reelobj2.sList.get(random1).getImage());
                            symbol2.setValue(reelobj2.sList.get(random1).getValue());
                            reel2.setGraphic(view2);

                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        //reel three thread
        new Thread(new Runnable(){
            @Override
            public void run(){

                while(spin3){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {

                            reelobj3.Spin();
                            int random2=(int)(Math.random()*6);
                            view3.setImage(reelobj3.sList.get(random2).getImage());
                            symbol3.setValue(reelobj3.sList.get(random2).getValue());
                            reel3.setGraphic(view3);

                        }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}