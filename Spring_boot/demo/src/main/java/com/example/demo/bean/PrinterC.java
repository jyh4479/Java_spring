package com.example.demo.bean;

public class PrinterC implements Printer{

    @Override
    public void print(String message){
        System.out.println("Printer C : "+message);
    }
}
