import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Evert Poort (331484) on 20-3-2017.
 *
 */

public class BubbleSort {

    private static int[] intArray = new int[10];
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;

    private static boolean isRunning = true;

    private static JFrame frame1;
    private static Container pane;
    private static JButton btnStart, btnStep, btnQuit, btnPause;

    public static void main(String[] args) {

        isRunning = false;

        //Fill our array with random values between 1 and 50
        Random rand = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(50) + 1;
        }


        //Create Graphical User Interface
        createGUI();
        updateGUI();

        while (true){
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                System.out.println("Exc");
                Thread.currentThread().interrupt();
            }
            checkStatus();
        }
    }

    private static void createGUI(){

        //Create the frame
        frame1 = new JFrame("Bubble Sort");
        frame1.setSize(450, 230);
        pane = frame1.getContentPane();
        pane.setLayout(null);

        //Create controls
        btnStart = new JButton("Start");
        btnStep = new JButton("Step");
        btnQuit = new JButton("Quit");
        btnPause = new JButton("Pause");

        //Assign unsorted array values to new text fields
        String u0 = Integer.toString(intArray[0]);
        String u1 = Integer.toString(intArray[1]);
        String u2 = Integer.toString(intArray[2]);
        String u3 = Integer.toString(intArray[3]);
        String u4 = Integer.toString(intArray[4]);
        String u5 = Integer.toString(intArray[5]);
        String u6 = Integer.toString(intArray[6]);
        String u7 = Integer.toString(intArray[7]);
        String u8 = Integer.toString(intArray[8]);
        String u9 = Integer.toString(intArray[9]);

        JTextField unsortedTextField = new JTextField("Unsorted:", 1);
        JTextField sortedTextField = new JTextField("Sorted:", 1);

        JTextField textField0 = new JTextField(u0, 1);
        JTextField textField1 = new JTextField(u1, 1);
        JTextField textField2 = new JTextField(u2, 1);
        JTextField textField3 = new JTextField(u3, 1);
        JTextField textField4 = new JTextField(u4, 1);
        JTextField textField5 = new JTextField(u5, 1);
        JTextField textField6 = new JTextField(u6, 1);
        JTextField textField7 = new JTextField(u7, 1);
        JTextField textField8 = new JTextField(u8, 1);
        JTextField textField9 = new JTextField(u9, 1);


        //Add all components to panel
        pane.add(btnStart);
        pane.add(btnStep);
        pane.add(btnQuit);
        pane.add(btnPause);
        pane.add(unsortedTextField);
        pane.add(sortedTextField);
        pane.add(textField0);
        pane.add(textField1);
        pane.add(textField2);
        pane.add(textField3);
        pane.add(textField4);
        pane.add(textField5);
        pane.add(textField6);
        pane.add(textField7);
        pane.add(textField8);
        pane.add(textField9);

        textField0.setForeground(Color.RED);
        textField1.setForeground(Color.RED);
        textField2.setForeground(Color.RED);
        textField3.setForeground(Color.RED);
        textField4.setForeground(Color.RED);
        textField5.setForeground(Color.RED);
        textField6.setForeground(Color.RED);
        textField7.setForeground(Color.RED);
        textField8.setForeground(Color.RED);
        textField9.setForeground(Color.RED);

        textField0.setBackground(Color.BLACK);
        textField1.setBackground(Color.BLACK);
        textField2.setBackground(Color.BLACK);
        textField3.setBackground(Color.BLACK);
        textField4.setBackground(Color.BLACK);
        textField5.setBackground(Color.BLACK);
        textField6.setBackground(Color.BLACK);
        textField7.setBackground(Color.BLACK);
        textField8.setBackground(Color.BLACK);
        textField9.setBackground(Color.BLACK);

        //Place and resize all components
        btnStart.setBounds(10, 10, 80, 30);
        btnStep.setBounds(10, 50, 80, 30);
        btnPause.setBounds(10, 90, 80, 30);
        btnQuit.setBounds(10, 130, 80, 30);

        unsortedTextField.setBounds(100, 10, 80, 20);
        unsortedTextField.setEditable(false);

        sortedTextField.setBounds(100, 50, 80, 20);
        sortedTextField.setEditable(false);

        textField0.setBounds(185, 10, 20, 20);
        textField0.setHorizontalAlignment(JTextField.CENTER);
        textField0.setEditable(false);

        textField1.setBounds(210, 10, 20, 20);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setEditable(false);

        textField2.setBounds(235, 10, 20, 20);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setEditable(false);

        textField3.setBounds(260, 10, 20, 20);
        textField3.setHorizontalAlignment(JTextField.CENTER);
        textField3.setEditable(false);

        textField4.setBounds(285, 10, 20, 20);
        textField4.setHorizontalAlignment(JTextField.CENTER);
        textField4.setEditable(false);

        textField5.setBounds(310, 10, 20, 20);
        textField5.setHorizontalAlignment(JTextField.CENTER);
        textField5.setEditable(false);

        textField6.setBounds(335, 10, 20, 20);
        textField6.setHorizontalAlignment(JTextField.CENTER);
        textField6.setEditable(false);

        textField7.setBounds(360, 10, 20, 20);
        textField7.setHorizontalAlignment(JTextField.CENTER);
        textField7.setEditable(false);

        textField8.setBounds(385, 10, 20, 20);
        textField8.setHorizontalAlignment(JTextField.CENTER);
        textField8.setEditable(false);

        textField9.setBounds(410, 10, 20, 20);
        textField9.setHorizontalAlignment(JTextField.CENTER);
        textField9.setEditable(false);

        //Make frame visible
        frame1.setVisible(true);

        //Add functionality to the buttons
        btnStart.addActionListener(new BubbleSort.btnStartAction());    //Register action
        btnStep.addActionListener(new BubbleSort.btnStepAction());      //Register action
        btnPause.addActionListener(new BubbleSort.btnPauseAction());    //Register action
        btnQuit.addActionListener(new BubbleSort.btnQuitAction());      //Register action
    }

    private static void updateGUI(){

        String swapamount = Integer.toString(BubbleSort.c);
        String stepamount = Integer.toString(BubbleSort.d);

        String s0 = Integer.toString(intArray[0]);
        String s1 = Integer.toString(intArray[1]);
        String s2 = Integer.toString(intArray[2]);
        String s3 = Integer.toString(intArray[3]);
        String s4 = Integer.toString(intArray[4]);
        String s5 = Integer.toString(intArray[5]);
        String s6 = Integer.toString(intArray[6]);
        String s7 = Integer.toString(intArray[7]);
        String s8 = Integer.toString(intArray[8]);
        String s9 = Integer.toString(intArray[9]);

        JTextField swapamountTextField = new JTextField("Swaps: " + swapamount, 1);
        JTextField stepamountTextField = new JTextField("Steps: " + stepamount, 1);
        JTextField textFields0 = new JTextField(s0, 1);
        JTextField textFields1 = new JTextField(s1, 1);
        JTextField textFields2 = new JTextField(s2, 1);
        JTextField textFields3 = new JTextField(s3, 1);
        JTextField textFields4 = new JTextField(s4, 1);
        JTextField textFields5 = new JTextField(s5, 1);
        JTextField textFields6 = new JTextField(s6, 1);
        JTextField textFields7 = new JTextField(s7, 1);
        JTextField textFields8 = new JTextField(s8, 1);
        JTextField textFields9 = new JTextField(s9, 1);

        pane.add(swapamountTextField);
        pane.add(stepamountTextField);
        pane.add(textFields0);
        pane.add(textFields1);
        pane.add(textFields2);
        pane.add(textFields3);
        pane.add(textFields4);
        pane.add(textFields5);
        pane.add(textFields6);
        pane.add(textFields7);
        pane.add(textFields8);
        pane.add(textFields9);

        textFields0.setForeground(Color.ORANGE);
        textFields1.setForeground(Color.ORANGE);
        textFields2.setForeground(Color.ORANGE);
        textFields3.setForeground(Color.ORANGE);
        textFields4.setForeground(Color.ORANGE);
        textFields5.setForeground(Color.ORANGE);
        textFields6.setForeground(Color.ORANGE);
        textFields7.setForeground(Color.ORANGE);
        textFields8.setForeground(Color.ORANGE);
        textFields9.setForeground(Color.ORANGE);

        textFields0.setBackground(Color.BLACK);
        textFields1.setBackground(Color.BLACK);
        textFields2.setBackground(Color.BLACK);
        textFields3.setBackground(Color.BLACK);
        textFields4.setBackground(Color.BLACK);
        textFields5.setBackground(Color.BLACK);
        textFields6.setBackground(Color.BLACK);
        textFields7.setBackground(Color.BLACK);
        textFields8.setBackground(Color.BLACK);
        textFields9.setBackground(Color.BLACK);

        swapamountTextField.setEditable(false);
        swapamountTextField.setBounds(100, 90, 80, 20);

        stepamountTextField.setEditable(false);
        stepamountTextField.setBounds(100, 130, 80, 20);

        textFields0.setEditable(false);
        textFields0.setBounds(185, 50, 20, 20);
        textFields0.setHorizontalAlignment(JTextField.CENTER);

        textFields1.setEditable(false);
        textFields1.setBounds(210, 50, 20, 20);
        textFields1.setHorizontalAlignment(JTextField.CENTER);

        textFields2.setEditable(false);
        textFields2.setBounds(235, 50, 20, 20);
        textFields2.setHorizontalAlignment(JTextField.CENTER);

        textFields3.setEditable(false);
        textFields3.setBounds(260, 50, 20, 20);
        textFields3.setHorizontalAlignment(JTextField.CENTER);

        textFields4.setEditable(false);
        textFields4.setBounds(285, 50, 20, 20);
        textFields4.setHorizontalAlignment(JTextField.CENTER);

        textFields5.setEditable(false);
        textFields5.setBounds(310, 50, 20, 20);
        textFields5.setHorizontalAlignment(JTextField.CENTER);

        textFields6.setEditable(false);
        textFields6.setBounds(335, 50, 20, 20);
        textFields6.setHorizontalAlignment(JTextField.CENTER);

        textFields7.setEditable(false);
        textFields7.setBounds(360, 50, 20, 20);
        textFields7.setHorizontalAlignment(JTextField.CENTER);

        textFields8.setEditable(false);
        textFields8.setBounds(385, 50, 20, 20);
        textFields8.setHorizontalAlignment(JTextField.CENTER);

        textFields9.setEditable(false);
        textFields9.setBounds(410, 50, 20, 20);
        textFields9.setHorizontalAlignment(JTextField.CENTER);
    }

    private static void finalGUI(){

        String swapamount = Integer.toString(BubbleSort.c);
        String stepamount = Integer.toString(BubbleSort.d);
        String s0 = Integer.toString(intArray[0]);
        String s1 = Integer.toString(intArray[1]);
        String s2 = Integer.toString(intArray[2]);
        String s3 = Integer.toString(intArray[3]);
        String s4 = Integer.toString(intArray[4]);
        String s5 = Integer.toString(intArray[5]);
        String s6 = Integer.toString(intArray[6]);
        String s7 = Integer.toString(intArray[7]);
        String s8 = Integer.toString(intArray[8]);
        String s9 = Integer.toString(intArray[9]);

        JTextField swapamountTextField = new JTextField("Swaps: " + swapamount, 1);
        JTextField stepamountTextField = new JTextField("Steps: " + stepamount, 1);
        JTextField textFields0 = new JTextField(s0, 1);
        JTextField textFields1 = new JTextField(s1, 1);
        JTextField textFields2 = new JTextField(s2, 1);
        JTextField textFields3 = new JTextField(s3, 1);
        JTextField textFields4 = new JTextField(s4, 1);
        JTextField textFields5 = new JTextField(s5, 1);
        JTextField textFields6 = new JTextField(s6, 1);
        JTextField textFields7 = new JTextField(s7, 1);
        JTextField textFields8 = new JTextField(s8, 1);
        JTextField textFields9 = new JTextField(s9, 1);

        pane.add(swapamountTextField);
        pane.add(stepamountTextField);
        pane.add(textFields0);
        pane.add(textFields1);
        pane.add(textFields2);
        pane.add(textFields3);
        pane.add(textFields4);
        pane.add(textFields5);
        pane.add(textFields6);
        pane.add(textFields7);
        pane.add(textFields8);
        pane.add(textFields9);

        textFields0.setForeground(Color.GREEN);
        textFields1.setForeground(Color.GREEN);
        textFields2.setForeground(Color.GREEN);
        textFields3.setForeground(Color.GREEN);
        textFields4.setForeground(Color.GREEN);
        textFields5.setForeground(Color.GREEN);
        textFields6.setForeground(Color.GREEN);
        textFields7.setForeground(Color.GREEN);
        textFields8.setForeground(Color.GREEN);
        textFields9.setForeground(Color.GREEN);

        textFields0.setBackground(Color.BLACK);
        textFields1.setBackground(Color.BLACK);
        textFields2.setBackground(Color.BLACK);
        textFields3.setBackground(Color.BLACK);
        textFields4.setBackground(Color.BLACK);
        textFields5.setBackground(Color.BLACK);
        textFields6.setBackground(Color.BLACK);
        textFields7.setBackground(Color.BLACK);
        textFields8.setBackground(Color.BLACK);
        textFields9.setBackground(Color.BLACK);

        swapamountTextField.setEditable(false);
        swapamountTextField.setBounds(100, 90, 80, 20);

        stepamountTextField.setEditable(false);
        stepamountTextField.setBounds(100, 130, 80, 20);

        textFields0.setEditable(false);
        textFields0.setBounds(185, 50, 20, 20);
        textFields0.setHorizontalAlignment(JTextField.CENTER);

        textFields1.setEditable(false);
        textFields1.setBounds(210, 50, 20, 20);
        textFields1.setHorizontalAlignment(JTextField.CENTER);

        textFields2.setEditable(false);
        textFields2.setBounds(235, 50, 20, 20);
        textFields2.setHorizontalAlignment(JTextField.CENTER);

        textFields3.setEditable(false);
        textFields3.setBounds(260, 50, 20, 20);
        textFields3.setHorizontalAlignment(JTextField.CENTER);

        textFields4.setEditable(false);
        textFields4.setBounds(285, 50, 20, 20);
        textFields4.setHorizontalAlignment(JTextField.CENTER);

        textFields5.setEditable(false);
        textFields5.setBounds(310, 50, 20, 20);
        textFields5.setHorizontalAlignment(JTextField.CENTER);

        textFields6.setEditable(false);
        textFields6.setBounds(335, 50, 20, 20);
        textFields6.setHorizontalAlignment(JTextField.CENTER);

        textFields7.setEditable(false);
        textFields7.setBounds(360, 50, 20, 20);
        textFields7.setHorizontalAlignment(JTextField.CENTER);

        textFields8.setEditable(false);
        textFields8.setBounds(385, 50, 20, 20);
        textFields8.setHorizontalAlignment(JTextField.CENTER);

        textFields9.setEditable(false);
        textFields9.setBounds(410, 50, 20, 20);
        textFields9.setHorizontalAlignment(JTextField.CENTER);
    }

    private static void checkStatus(){
        //This function checks whether the program should be running or paused
        if(isRunning){
            bubbleSort(intArray);
        }
    }

    static void bubbleSort(int[] intArray) {
        //The function that actually sorts the values of the array (one iteration)
        int l = intArray.length;
        int j = BubbleSort.a;
        int temp;

        if (b < l) { //Checks if there have been swaps in the last n iterations, if not: exit

            BubbleSort.d++;


            if (j < l - 1) {
                if (intArray[j] > intArray[j + 1]) {
                    temp = intArray[j + 1];
                    intArray[j + 1] = intArray[j];
                    intArray[j] = temp;
                    c++;
                    b = 0;
                }

                else {
                    b++;
                }
                a++;
            }

            else {
                a = 0;
            }
        }

        updateGUI();


        if (b >= l){
            //Done sorting

            finalGUI();
            //System.exit(0);
        }

    }

    public static class btnStartAction implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            isRunning = true;
            checkStatus();
        }
    }

    public static class btnStepAction implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            bubbleSort(intArray);
            isRunning = false;
            checkStatus();
        }
    }

    public static class btnPauseAction implements ActionListener{
        public void actionPerformed (ActionEvent e){
            isRunning = false;
            checkStatus();
        }
    }

    public static class btnQuitAction implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }

}

