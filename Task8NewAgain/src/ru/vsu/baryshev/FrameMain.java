package ru.vsu.baryshev;

import javax.swing.*;
import ru.vsu.baryshev.util.JTableUtils;
import ru.vsu.baryshev.util.ArrayUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FrameMain extends JFrame {
    private JTextField pathOfReading;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panelMain;
    private JTable table1;
    private JButton ManualReadingFromFileButton;
    private JButton ManualWritingToFileButton;
    private JTextField pathOfWriting;
    private JButton FileProcessingButton;
    private JTextField Errors;
    private JButton ReadFromDirectory;
    private JButton WriteToFoleDirectory;
    private JButton plusRow;
    private JButton minRow;
    private JButton minColumn;
    private JButton plusColmn;
    private double[][] startArr = new double[1][1];

    public FrameMain(){

        this.setTitle("ТАбличка");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        ManualReadingFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String path = pathOfReading.getText();


               try {
                   double [][]array = ArrayUtils.readDoubleArray2FromFile(path);
                   JTableUtils.writeArrayToJTable(table1,array);

               }catch (FileNotFoundException ex){
                   Errors.setText("Wrong path of reading ");
                   return;
               }


            }
        });
        ReadFromDirectory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    String path = file.toString();
                    try {
                        double [][]array = ArrayUtils.readDoubleArray2FromFile(path);
                        JTableUtils.writeArrayToJTable(table1,array);

                    }catch (FileNotFoundException ex){
                        Errors.setText("Wrong path of reading ");
                        return;
                    }
                }

            }
        });
        WriteToFoleDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    String path = file.toString();
                    double[][] arr = WorkWithJT.writeJTtoArray(table1);

                    try {
                        PrintStream ps = new PrintStream(path);
                        InputArgs.saving(ps,arr);
                    } catch (FileNotFoundException ex) {
                        Errors.setText("Wrong path of writing ");
                        return;
                    }
                }
            }
        });

        ManualWritingToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String path = pathOfWriting.getText();
                double[][] arr = WorkWithJT.writeJTtoArray(table1);

                try {
                    PrintStream ps = new PrintStream(path);
                    InputArgs.saving(ps,arr);
                } catch (FileNotFoundException ex) {
                    Errors.setText("Wrong path of writing ");
                    return;
                }

            }
        });
        plusRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTableUtils.writeArrayToJTable(table1,startArr);
                double[][] arr = new double[startArr.length+1][ startArr[0].length];
                startArr = arr;

            }
        });
        minRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTableUtils.writeArrayToJTable(table1,startArr);
                double[][] arr = new double[startArr.length-1][ startArr[0].length];
                startArr = arr;

            }
        });
        plusColmn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTableUtils.writeArrayToJTable(table1,startArr);
                double[][] arr = new double[startArr.length+1][ startArr[0].length+1];
                startArr = arr;

            }
        });
        minColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTableUtils.writeArrayToJTable(table1,startArr);
                double[][] arr = new double[startArr.length+1][ startArr[0].length-1];
                startArr = arr;

            }
        });

        FileProcessingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double [][]array = WorkWithJT.writeJTtoArray(table1);
                 array = logic.solution(array);
                JTableUtils.writeArrayToJTable(table1,array);

            }
        });

    }

    }

