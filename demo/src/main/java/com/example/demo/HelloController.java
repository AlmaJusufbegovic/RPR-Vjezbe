package com.example.demo;
//U NJEMU SE NALAZE SVE AKCIJE
//DEFINISEMO STA SE DESAVA KADA DEFINISEMO HELLO BUTTON
//NE PRAVITI PRAZNU LABELU_SAVJET
//KADA DEFINISEMO STVARI UVIJEK KORISTITI KONTEJNERE - DA MOZEMO LAKSE DEFINISATI ZBOG LOKACIJE

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController extends HelloApplication implements Initializable{

    @FXML
    private TextField txt_rez;
    double num1=0, num2=0, result=0;
    String operator="";

    public void Number(ActionEvent a){
        String n = ((Button)a.getSource()).getText();
        txt_rez.setText(txt_rez.getText()+n);
    }


    public void Operation(ActionEvent a) {
        String operation = ((Button) a.getSource()).getText();
        if (!operation.equals("=")) {
            if (!operator.equals("")) return;
            if (operator.equals(".")) {
                txt_rez.setText(txt_rez.getText().concat("."));
            }
            operator = operation;
            num1 = Double.parseDouble(txt_rez.getText());
            txt_rez.setText("");
        } else {
            if (operator.equals("")) return;
            num2 = Double.parseDouble(txt_rez.getText());
            calculate(num1,num2,operator);
            operator="";
        }
    }
    public void calculate(double n1, double n2, String op){
        switch (operator){
            case "C":
                txt_rez.setText("");
                num1=num2=0;
            case "+":
                result=num1+num2;
                txt_rez.setText(String.valueOf(result));
                num1=result;
                break;
            case "-":
                result=num1-num2;
                txt_rez.setText(String.valueOf(result));
                num1=result;
                break;
            case "*":
                result=num1*num2;
                txt_rez.setText(String.valueOf(result));
                num1=result;
                break;
            case "/":
                if(num2==0) { result=-111111;break;}
                result=num1/num2;
                txt_rez.setText(String.valueOf(result));
                num1=result;
                break;
            case "%":
                result=num1%num2;
                txt_rez.setText(String.valueOf(result));
                num1=result;
                break;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}