package ru.vsu.baryshev;

import java.util.Locale;
import java.util.Scanner;
import ru.vsu.baryshev.InputArgs;
import ru.vsu.baryshev.util.ArrayUtils;

import javax.swing.*;


public class Main {
    public static boolean check() { //метод для определения, будет ли запускаться консольное приложение или оконное приложение

        Scanner in = new Scanner(System.in);
        int check2 = in.nextInt();
        boolean check;
        if (check2 == 1) {
            check = true;
        } else check = false;

        return check;
    }




    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);       //testOfReading1.txt  testOfWriting1.txt

    if(args.length>0){
        InputArgs p = InputArgs.parseCmdArgs(args);
        double[][] array = InputArgs.strToArr(p.strArr);
        array = logic.solution(array);
        InputArgs.printOfArray(array);
    } else {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        });

    }



    }
}