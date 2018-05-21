//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Date;
//
//public class bb  {
//
//    Button save;
//
//        public  void displayStatistics(int creditAVG,int avg) {
//            Label label;
//
//
//             save=new Button("Save");
//
////
////            save.setOnAction((ActionEvent event) -> {
////
////                saveFile();
////            });
//
////            save.setOnAction(new EventHandler<ActionEvent>() {
////                @Override
////                public void handle(ActionEvent event) {
////                    bb c = new bb();
////                    c.saveFile();
////                    //saveFile(int noOfWins,int noOfLoss,int creditAvg,int avg);
////
////                }
////            });
//
//                    Date dt = new Date();
//            //SimpleDateFormat dds= new SimpleDateFormat("D. MM.YY")
//
//            System.out.print(dt.toString());
//            Stage window = new Stage();
//            window.setTitle("Statistics");
//
//            BorderPane root = new BorderPane();
//             // Group cc = new Group();
//
//            GridPane gg = new GridPane();
//            gg.setPadding(new Insets(10,10,10,10));
//            gg.setAlignment(Pos.CENTER);
//
//            ObservableList<PieChart.Data> pieChartData =
//                    FXCollections.observableArrayList(
//                     new PieChart.Data("Total wins", Main.noOfWins),
//                     new PieChart.Data("Total loses", Main.noOfLoss));
//
//            PieChart pieChart = new PieChart(pieChartData);
//            pieChart.setTitle("Statistics");
//
//
//
//            label = new Label("");
//            label.setStyle("-fx-font-size: 15;-fx-text-fill: red;-fx-font-weight: bold");
//
//            Label lCreditAvg = new Label("Total credit avg " + creditAVG);
//           // lCreditAvg.setAlignment(Pos.BOTTOM_LEFT);
//
//            Label lAvg = new Label("Avarage of win and lose "+ avg);
//          //  lAvg.setAlignment(Pos.BOTTOM_RIGHT);
//            //add event handler
//            for (PieChart.Data data : pieChart.getData()) {
//
//                data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED,
//                        new EventHandler<javafx.scene.input.MouseEvent>() {
//
//                            @Override
//                            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
//
//                                String name = data.getName();
//                                double value = data.getPieValue();
//                                label.setText(name + " : " + String.valueOf(value));
//                            }
//                        });
//
//                data.getNode().addEventHandler(
//                        javafx.scene.input.MouseEvent.MOUSE_RELEASED,
//                        new EventHandler<javafx.scene.input.MouseEvent>() {
//
//                            @Override
//                            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
//                                label.setText("");
//                            }
//                        });
//            }
//
////            save.setOnAction(new EventHandler<ActionEvent>() {
////                @Override
////                public void handle(ActionEvent event) {
////                    saveFile();
////                }
////            });
//
//
//            GridPane.setHalignment(pieChart, HPos.CENTER);
//            gg.add(pieChart,0,5);
//            GridPane.setHalignment(label, HPos.CENTER);
//            gg.add(label,0,0);
//            GridPane.setHalignment(lCreditAvg, HPos.CENTER);
//            gg.add(lCreditAvg,0,10);
//            GridPane.setHalignment(lAvg, HPos.CENTER);
//            gg.add(lAvg,0,11);
//            GridPane.setHalignment(save, HPos.CENTER);
//            gg.add(save,0,12);
//
//            root.setCenter(gg);
//
//            window.setScene(new Scene(root, 500, 400));
//            window.setResizable(false);
//            window.show();
//        }
//
//
//
//
//        public void saveFile(int noOfWins,int noOfLoss,int creditAVG,int avg){
//
//                    Date date = new Date();
//            try{
//                PrintWriter saveFile = new PrintWriter(date.toString()+".txt");
//                saveFile.write("No of wins: "+noOfWins+"\n"+"No of lose: "+noOfLoss+"\n"+
//                        "Credit avg: "+creditAVG+"\n"+"Average: "+avg);
//                saveFile.flush();
//                saveFile.close();
//                Alert alertSave = new Alert(Alert.AlertType.INFORMATION);
//                alertSave.setHeaderText(null);
//                alertSave.setContentText("File successfully saved");
//                alertSave.show();
//
//            }catch (FileNotFoundException e){
//                e.printStackTrace();
//            }
//        }
//
//
////         save.setOnAction(new EventHandler<ActionEvent>() {
////                @Override
////                public void handle(ActionEvent event) {
////                    saveFile();
////                }
////            });
//
//
//}
//
