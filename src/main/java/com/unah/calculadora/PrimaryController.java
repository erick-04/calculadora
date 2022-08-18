package com.unah.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML private Label lblresult;
    @FXML private Label operations;
    
    private double num1=0;
    private String operator = "+";
    
    @FXML void numberclicked(MouseEvent event){
        int value = Integer.parseInt(((Button)event.getSource()).getId().replace("btn",""));
        lblresult.setText(Double.parseDouble(lblresult.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(lblresult.getText())*10+value));
    }
    
    @FXML void symbolclicked(MouseEvent event){
        String symbol = ((Button)event.getSource()).getId().replace("btn","");
        if(symbol.equals("Equals")) {
            double num2 = Double.parseDouble(lblresult.getText());
            operations.setText((num1 + operator + num2));
            switch (operator) {
                case "+": 
                    lblresult.setText((num1+num2) + "");
                    break;
                case "-":
                    lblresult.setText((num1-num2) + "");
                    break;
                case "*": 
                    lblresult.setText((num1*num2) + "");
                    break;
                case "/":
                    lblresult.setText((num1/num2) + "");
                    break;
            }
            operator = ".";
        }
        else if(symbol.equals("clear")) {
            lblresult.setText(String.valueOf(0.0));
            operations.setText(String.valueOf(0.0));
            operator = ".";
        }
        else {
            switch (symbol) {
                case "sum":
                    operator="+";
                    break;
                case "rest": 
                    operator="-";
                    break;
                case "mul":
                    operator="*";
                    break;
                case "div":
                    operator="/";
                    break;
            }
            num1 = Double.parseDouble(lblresult.getText());
            lblresult.setText(String.valueOf(0.0));
        }
    } 
}
