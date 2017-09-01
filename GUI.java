/**
* @author Victor Bieniek
* CSC 201
* Professor Tanes Kanchanawanchai
* Assignment 1 Programming Problem 5 – Complex Numbers
* This class takes two complex numbers and adds, subtracts, multipiles and dives them
*/

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.HPos;

public class GUI extends Application{
	
	Button enter;
	TextField complexReal1;
	TextField complexImag1;
	TextField complexReal2;
	TextField complexImag2;
	TextField complexSum;
	TextField complexDif;
	TextField complexProd;
	TextField complexQuot;
	Label titleLabel;
	Label complexLabel1;
	Label complexLabel2;
	Label sumLabel;
	Label difLabel;
	Label prodLabel;
	Label quotLabel;
	private double real1;
	private double imag1;
	private double real2;
	private double imag2;
	private Complex com1;
	private Complex com2;
	private Complex comResult;

	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Complex Numbers");
		primaryStage.setResizable(false);
		
		//initialize all nodes
		titleLabel = new Label("Complex Number Calculator");
		complexReal1 = new TextField("Real");
		complexImag1 = new TextField("Imaginary");
		complexReal2 = new TextField("Real");
		complexImag2 = new TextField("Imaginary");
		complexLabel1 = new Label(" Complex #1: ");
		complexLabel2 = new Label(" Complex #2: ");
		enter = new Button("Calculate");
		sumLabel = new Label("Sum: ");
		complexSum = new TextField();
		difLabel = new Label("Difference: ");
		complexDif = new TextField();
		prodLabel = new Label("Product: ");
		complexProd = new TextField();
		quotLabel = new Label("Quotient: ");
		complexQuot = new TextField();
		
		
		titleLabel.setFont(new Font(15));
		
		
		//This is what happens when the button is pressed
		//it should check if all input values are valid before importing them into
		//Complex Objects and adding them
		enter.setOnAction(e -> {
			if(isDouble(complexReal1.getText()) && isDouble(complexImag1.getText())
					&& isDouble(complexReal2.getText()) && isDouble(complexImag2.getText()))
			{
				real1 = Double.parseDouble(complexReal1.getText());
				imag1 = Double.parseDouble(complexImag1.getText());
				real2 = Double.parseDouble(complexReal2.getText());
				imag2 = Double.parseDouble(complexImag2.getText());
				
				com1 = new Complex(real1, imag1);
				com2 = new Complex(real2, imag2);
				comResult = com1.add(com2);
				complexSum.setText(comResult.toString());
				comResult = com1.sub(com2);
				complexDif.setText(comResult.toString());
				comResult = com1.mult(com2);
				complexProd.setText(comResult.toString());
				comResult = com1.div(com2);
				complexQuot.setText(comResult.toString());
			}
			else
			{
				if(!isDouble(complexReal1.getText()))
				{
					errorColor(complexReal1);
				}
				if(!isDouble(complexImag1.getText()))
				{
					errorColor(complexImag1);
				}
				if(!isDouble(complexReal2.getText()))
				{
					errorColor(complexReal2);
				}
				if(!isDouble(complexImag2.getText()))
				{
					errorColor(complexImag2);
				}
				
				complexSum.setText("Invalid Input");
				complexDif.setText("Invalid Input");
				complexProd.setText("Invalid Input");
				complexQuot.setText("Invalid Input");
			}
			
		});
		
		//remove the red error color when input is changed
		complexReal1.setOnKeyTyped(e -> {
			resetColor(complexReal1);
		});
		complexImag1.setOnKeyTyped(e -> {
			resetColor(complexImag1);
		});
		complexReal2.setOnKeyTyped(e -> {
			resetColor(complexReal2);
		});
		complexImag2.setOnKeyTyped(e -> {
			resetColor(complexImag2);
		});
		
		
		GridPane layout = new GridPane();
		
		int colPercent = 22;
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(colPercent);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(colPercent);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(colPercent - 8);
		ColumnConstraints column4 = new ColumnConstraints();
		column4.setPercentWidth(colPercent);
		ColumnConstraints column5 = new ColumnConstraints();
		column5.setPercentWidth(colPercent);
		layout.getColumnConstraints().addAll(column1, column2, column3, column4, column5);
		
		for (int i = 0; i <= 15; i++) {
			RowConstraints con = new RowConstraints();
			// Here we set the pref height of the row, but you could also use .setPercentHeight(double) if you don't know much space you will need for each label.
			con.setPrefHeight(20);
			layout.getRowConstraints().add(con);
        }
		
		layout.getChildren().add(titleLabel);
		layout.getChildren().add(complexReal1);
		layout.getChildren().add(complexImag1);
		layout.getChildren().add(complexReal2);
		layout.getChildren().add(complexImag2);
		layout.getChildren().add(enter);
		layout.getChildren().add(complexSum);
		layout.getChildren().add(complexLabel1);
		layout.getChildren().add(complexLabel2);
		layout.getChildren().add(sumLabel);
		layout.getChildren().add(difLabel);
		layout.getChildren().add(complexDif);
		layout.getChildren().add(prodLabel);
		layout.getChildren().add(complexProd);
		layout.getChildren().add(quotLabel);
		layout.getChildren().add(complexQuot);
		
		GridPane.setConstraints(titleLabel, 1, 0, 3, 1);
		GridPane.setConstraints(complexLabel1, 0, 2);
		GridPane.setConstraints(complexReal1, 1, 2);
		GridPane.setConstraints(complexImag1, 3, 2);
		GridPane.setConstraints(complexLabel2, 0, 4);
		GridPane.setConstraints(complexReal2, 1, 4);
		GridPane.setConstraints(complexImag2, 3, 4);
		GridPane.setConstraints(enter, 1, 6, 3, 1);
		GridPane.setConstraints(sumLabel, 0, 8);
		GridPane.setConstraints(complexSum, 1, 8, 3, 1);
		GridPane.setConstraints(difLabel, 0, 10);
		GridPane.setConstraints(complexDif, 1, 10, 3, 1);
		GridPane.setConstraints(prodLabel, 0, 12);
		GridPane.setConstraints(complexProd, 1, 12, 3, 1);
		GridPane.setConstraints(quotLabel, 0, 14);
		GridPane.setConstraints(complexQuot, 1, 14, 3, 1);
		
		GridPane.setHalignment(enter, HPos.CENTER);
		GridPane.setHalignment(titleLabel, HPos.CENTER);
		GridPane.setHalignment(sumLabel, HPos.RIGHT);
		GridPane.setHalignment(difLabel, HPos.RIGHT);
		GridPane.setHalignment(prodLabel, HPos.RIGHT);
		GridPane.setHalignment(quotLabel, HPos.RIGHT);
		
		complexSum.setEditable(false);
		complexDif.setEditable(false);
		complexProd.setEditable(false);
		complexQuot.setEditable(false);
		
		Scene scene = new Scene(layout, 450, 350); //size is set
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private boolean isDouble(String toCheck)
	{
		try {
			Double.parseDouble(toCheck);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	private void errorColor(TextField f)
	{
		f.setStyle("-fx-text-box-border: red;");
	}
	
	private void resetColor(TextField f)
	{
		f.setStyle("-fx-text-box-border: lightgrey;");
	}


}//end class
