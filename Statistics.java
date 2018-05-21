import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Statistics  {

    //save button
    Button save;
    Button bPayOut;


    //declaring int variable
    private int noOfWins;
    private int noOfLoses;

    double probability;
    double finalPayOut;
    ArrayList<Double> probList = new ArrayList<>(); // probability arrayList
  

    // constructor
    public Statistics (int noOfWins,int noOfLoses){
        super();
        this.noOfLoses=noOfLoses;
        this.noOfWins=noOfWins;
    }

    // pie chart display method
    public  void displayStatistics(int creditAVG,int avg) {

        // pie chart value showing label
        Label lPieValue;
        save=new Button("Save");
        bPayOut= new Button("Pay Out");

            // save button Action Event
            save.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    saveFile( noOfWins, noOfLoses, creditAVG, avg);

                }
            });

        bPayOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                payOutCalc();
                writeToFile();

            }
        });



        // creating new date object
        Date dt = new Date();

        System.out.print(dt.toString());
        Stage window = new Stage();
        window.setTitle("Statistics"); // window name

        // border pane
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: azure");

        // gid pane
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10,10,10,10));
        gp.setAlignment(Pos.CENTER);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Total wins", Main.noOfWins), // add values tot the pie chart
                        new PieChart.Data("Total loses", Main.noOfLoss));

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Statistics"); // window title

        // adding values to the labels
        lPieValue = new Label("");
        lPieValue.setStyle("-fx-font-size: 15;-fx-text-fill: red;-fx-font-weight: bold");

        Label lCreditAvg = new Label("Total credit avg: " + creditAVG);
        lCreditAvg.setStyle("fx-font-size: 15;-fx-text-fill: green;-fx-font-weight: bold");
        lCreditAvg.setAlignment(Pos.BOTTOM_LEFT);

        Label lAvg = new Label("Avarage of win and lose: "+ avg);
        lAvg.setStyle("fx-font-size: 15;-fx-text-fill: green;-fx-font-weight: bold");
          lAvg.setAlignment(Pos.BOTTOM_LEFT);

        //add event handler
        for (PieChart.Data data : pieChart.getData()) {

            data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED,
                    new EventHandler<javafx.scene.input.MouseEvent>() {

                        @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {

                            String name = data.getName();
                            int value = (int) data.getPieValue();
                            lPieValue.setText(name + " : " + String.valueOf(value));
                        }
                    });

            data.getNode().addEventHandler(
                    javafx.scene.input.MouseEvent.MOUSE_RELEASED,
                    new EventHandler<javafx.scene.input.MouseEvent>() {

                        @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                            lPieValue.setText("");
                        }
                    });
        }

        // components align grid pane
        GridPane.setHalignment(pieChart, HPos.CENTER);
        gp.add(pieChart,0,5);
        GridPane.setHalignment(lPieValue, HPos.CENTER);
        gp.add(lPieValue,0,0);
        GridPane.setHalignment(lCreditAvg, HPos.LEFT);
        gp.add(lCreditAvg,0,10);
        GridPane.setHalignment(lAvg, HPos.LEFT);
        gp.add(lAvg,0,11);
        GridPane.setHalignment(save, HPos.CENTER);
        gp.add(save,0,10);
        GridPane.setHalignment(bPayOut, HPos.CENTER);
        gp.add(bPayOut,0,11);

        // add all components to the border pane
        root.setCenter(gp);

        // window format
        window.setScene(new Scene(root, 500, 400));
        window.setResizable(false);
        window.show();
    }

    // file save method
    public void saveFile(int noOfWins,int noOfLoss,int creditAVG,int avg){

        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss"); // date format
            LocalDateTime now = LocalDateTime.now();
            PrintWriter saveFile = new PrintWriter("cw"+dtf.format(now)+".txt");// fill name and the file format
            saveFile.print("No of wins: "+noOfWins+"\n"+" No of lose: "+noOfLoss+"\n"+ // file printing format
                    " Credit avg: "+creditAVG+"\n"+" Average: "+avg);
            saveFile.close();
            Alert alertSave = new Alert(Alert.AlertType.INFORMATION); // alert msg show when the file saved
            alertSave.setHeaderText(null);
            alertSave.setContentText("File successfully saved");
            alertSave.show();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public void setList(ArrayList<Double> payoutList){
        for(int i = 0;i<payoutList.size();i++){// every element add to the arrayList
            probList.add(payoutList.get(i));
        }
    }

    //calculates the Payout
    public void payOutCalc(){

        for(int i=0;i<probList.size();i++){
            finalPayOut = finalPayOut+probList.get(i);   //total payout is calculated
        }
    }

    // store the data on the text file
    public void writeToFile() {
               PrintWriter writer = null;
        try {
            writer = new PrintWriter("PayOutCalc.txt");
            writer.println("              PayOut Calculation Details");
            writer.println("----------------------------------------------------------------\n");
            for(int i=0;i<probList.size();i++){
                writer.println("Spin Count "+(i+1)+" : "+"PayOut = "+probability+probList.get(i));
            }

            writer.println("Payout(s) = "+probability+finalPayOut);
            writer.println(" Percentage ("+finalPayOut+"*"+"100%"+") = "+(finalPayOut*100)+" %");

            writer.println("    **  **   -- -- Description -- --   **   **  ");
            writer.println("Total Symbols = 6 ");
            writer.println("\nReel count is 3");
            writer.println("1.RedSeven");
            writer.println("2.Cherry");
            writer.println("3.Lemon");
            writer.println("4.Bell");
            writer.println("5.Plum");
            writer.println("6.Watermelon");
            writer.println("Getting a specific symbol in a reel is = 1/6\n as same as the other Symbols");

            Alert alertSave = new Alert(Alert.AlertType.INFORMATION); // alert msg show when the file saved
            alertSave.setHeaderText(null);
            alertSave.setContentText("PayOut successfully saved");
            alertSave.show();

            } catch (FileNotFoundException ex) {
            System.err.println("File failed print");
        } finally {
            writer.close();
        }
    }




}



