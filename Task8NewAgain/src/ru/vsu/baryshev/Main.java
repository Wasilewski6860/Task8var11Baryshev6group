package ru.vsu.baryshev;

import ru.vsu.baryshev.util.ArrayUtils;
import ru.vsu.baryshev.util.JTableUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Locale;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.ENGLISH);       //testOfReading1.txt  testOfWriting1.txt

    if(args.length==1){

        InputArgs p = InputArgs.parseCmdArgs(args);
        double[][] array = InputArgs.strToArr(p.strArr);
        if(array==null){
            System.out.println("Wrong input format, do in like 1,2,3-4,5,7");
            return;
        }
        array = logic.solution(array);
        InputArgs.printOfArray(array);

    }else if(args.length==2){
        double [][]array = ArrayUtils.readDoubleArray2FromFile(args[0]);
        array = logic.solution(array);
        PrintStream ps = new PrintStream(args[1]);
        InputArgs.saving(ps,array);


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