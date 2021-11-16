package ru.vsu.baryshev;

import java.util.Locale;


public class Main {

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