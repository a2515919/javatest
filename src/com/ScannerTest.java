package com;

import org.junit.Test;

import java.util.Scanner;

public class ScannerTest {

    @Test
    public void ScanTest(){
        Scanner scan = new Scanner(System.in);
        int i=0;
        float f=0.0f;
        System.out.println("input int number:");
        if(scan.hasNextInt()){
            i=scan.nextInt();
            System.out.println("int number :"+ i);
        }else{
            System.out.println("input error!");
        }
        System.out.println("input double number :");
        if(scan.hasNextFloat()){
            f= scan.nextFloat();
            System.out.println("float number :"+f);

        }else {
            System.out.println("input float number error!");
        }
        scan.close();

    }
}
