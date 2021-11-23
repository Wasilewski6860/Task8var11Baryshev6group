package ru.vsu.baryshev;

import ru.vsu.baryshev.util.ArrayUtils;
import ru.vsu.baryshev.util.JTableUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Locale;


public class Main {
    public static void test(String[] args){
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
            try {

                double[][] array = ArrayUtils.readDoubleArray2FromFile(args[0]);

            } catch (FileNotFoundException exception) {

                System.out.println("Wrong path of reading, do it like .\\\\yourpath.txt ");
                return;

            }
            try {

                double[][] array = ArrayUtils.readDoubleArray2FromFile(args[0]);
                array = logic.solution(array);
                PrintStream ps = new PrintStream(args[1]);
                InputArgs.saving(ps,array);

            }catch (FileNotFoundException exception){

                System.out.println("Wrong path of writing, do it like .\\\\youpath.txt");
                return;
            }


        } else {

            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new FrameMain().setVisible(true);
                }
            });

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] t1Manual = {"1,2,3,4,5,6-7,8,9,10,11,13-14,15,16,17,18,19"};
        String[] t1InputOutput = {".\\\\testOfReading1.txt", ".\\\\testOfWriting1.txt"};
        String[] tJT = {};
        String[] t2Manual = {"0-0"};
        String[] t2InputOutput = {".\\\\testOfReading2.txt", ".\\\\testOfWriting2.txt"};

        String[] t3Manual = {"0,1-1,0"};
        String[] t3InputOutput = {".\\\\testOfReading3.txt", ".\\\\testOfWriting3.txt"};

        String[] t4Manual = {"1,1,1,1-0,0,0,0"};
        String[] t4InputOutput = {".\\\\testOfReading4.txt", ".\\\\testOfWriting4.txt"};

        String[] t5Manual = {"123,124-125,126"};
        String[] t5InputOutput = {".\\\\testOfReading5.txt", ".\\\\testOfWriting5.txt"};

        // Для соответствующего теста передать test соответствующий массив
        test(t1Manual);
        test(t1InputOutput);
        test(tJT);



    }
}