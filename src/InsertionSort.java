import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Source:   https://mathbits.com/MathBits/Java/arrays/InsertionSort.htm

/**
 * Created by Evert Poort (331484) on 21-3-2017.
 */

public class InsertionSort {

    private static int[] intArray = new int[10];
    private static int[] startArray = new int[10];

    private static int a = 1;
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
            startArray[i] = intArray[i];
        }

        //Create Graphical User Interface
        createGUI();
        createButtons();
        updateTextFields(Color.ORANGE, Color.BLACK);

        while (true){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            checkStatus();
        }
    }

    private static void createGUI(){
        frame1 = new JFrame("Insertion Sort");
        frame1.setSize(450, 230);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        pane = frame1.getContentPane();
        pane.setLayout(null);
    }

    private static void createButtons(){
        btnStart = new JButton("Start");
        pane.add(btnStart);
        btnStart.setBounds(10, 10, 80, 30);
        btnStart.addActionListener(new InsertionSort.btnStartAction());    //Register action

        btnStep = new JButton("Step");
        pane.add(btnStep);
        btnStep.setBounds(10, 50, 80, 30);
        btnStep.addActionListener(new InsertionSort.btnStepAction());      //Register action

        btnQuit = new JButton("Quit");
        pane.add(btnQuit);
        btnQuit.setBounds(10, 130, 80, 30);
        btnQuit.addActionListener(new InsertionSort.btnQuitAction());      //Register action

        btnPause = new JButton("Pause");
        pane.add(btnPause);
        btnPause.setBounds(10, 90, 80, 30);
        btnPause.addActionListener(new InsertionSort.btnPauseAction());    //Register action
    }

    private static void updateTextFields(Color c1, Color c2){
        String swapamount = Integer.toString(a-1);
        JTextField swapamountTextField = new JTextField("Swaps: " + swapamount, 1);
        pane.add(swapamountTextField);
        swapamountTextField.setEditable(false);
        swapamountTextField.setBounds(100, 90, 80, 20);

        String stepamount = Integer.toString(a-1);
        JTextField stepamountTextField = new JTextField("Steps: " + stepamount, 1);
        pane.add(stepamountTextField);
        stepamountTextField.setEditable(false);
        stepamountTextField.setBounds(100, 130, 80, 20);

        JTextField unsortedTextField = new JTextField("Unsorted:", 1);
        pane.add(unsortedTextField);
        unsortedTextField.setEditable(false);
        unsortedTextField.setBounds(100, 10, 80, 20);

        JTextField sortedTextField = new JTextField("Sorted:", 1);
        pane.add(sortedTextField);
        sortedTextField.setEditable(false);
        sortedTextField.setBounds(100, 50, 80, 20);

        String u0 = Integer.toString(startArray[0]);
        JTextField textField0 = new JTextField(u0, 1);
        pane.add(textField0);
        textField0.setForeground(Color.RED);
        textField0.setBackground(c2);
        textField0.setEditable(false);
        textField0.setBounds(185, 10, 20, 20);
        textField0.setHorizontalAlignment(JTextField.CENTER);

        String u1 = Integer.toString(startArray[0]);
        JTextField textField1 = new JTextField(u1, 1);
        pane.add(textField1);
        textField1.setForeground(Color.RED);
        textField1.setBackground(c2);
        textField1.setEditable(false);
        textField1.setBounds(210, 10, 20, 20);
        textField1.setHorizontalAlignment(JTextField.CENTER);

        String u2 = Integer.toString(startArray[0]);
        JTextField textField2 = new JTextField(u2, 1);
        pane.add(textField2);
        textField2.setForeground(Color.RED);
        textField2.setBackground(c2);
        textField2.setEditable(false);
        textField2.setBounds(235, 10, 20, 20);
        textField2.setHorizontalAlignment(JTextField.CENTER);

        String u3 = Integer.toString(startArray[0]);
        JTextField textField3 = new JTextField(u3, 1);
        pane.add(textField3);
        textField3.setForeground(Color.RED);
        textField3.setBackground(c2);
        textField3.setEditable(false);
        textField3.setBounds(260, 10, 20, 20);
        textField3.setHorizontalAlignment(JTextField.CENTER);

        String u4 = Integer.toString(startArray[0]);
        JTextField textField4 = new JTextField(u4, 1);
        pane.add(textField4);
        textField4.setForeground(Color.RED);
        textField4.setBackground(c2);
        textField4.setEditable(false);
        textField4.setBounds(285, 10, 20, 20);
        textField4.setHorizontalAlignment(JTextField.CENTER);

        String u5 = Integer.toString(startArray[0]);
        JTextField textField5 = new JTextField(u5, 1);
        pane.add(textField5);
        textField5.setForeground(Color.RED);
        textField5.setBackground(c2);
        textField5.setEditable(false);
        textField5.setBounds(310, 10, 20, 20);
        textField5.setHorizontalAlignment(JTextField.CENTER);

        String u6 = Integer.toString(startArray[0]);
        JTextField textField6 = new JTextField(u6, 1);
        pane.add(textField6);
        textField6.setForeground(Color.RED);
        textField6.setBackground(c2);
        textField6.setEditable(false);
        textField6.setBounds(335, 10, 20, 20);
        textField6.setHorizontalAlignment(JTextField.CENTER);

        String u7 = Integer.toString(startArray[0]);
        JTextField textField7 = new JTextField(u7, 1);
        pane.add(textField7);
        textField7.setForeground(Color.RED);
        textField7.setBackground(c2);
        textField7.setEditable(false);
        textField7.setBounds(360, 10, 20, 20);
        textField7.setHorizontalAlignment(JTextField.CENTER);

        String u8 = Integer.toString(startArray[0]);
        JTextField textField8 = new JTextField(u8, 1);
        pane.add(textField8);
        textField8.setForeground(Color.RED);
        textField8.setBackground(c2);
        textField8.setEditable(false);
        textField8.setBounds(385, 10, 20, 20);
        textField8.setHorizontalAlignment(JTextField.CENTER);

        String u9 = Integer.toString(startArray[0]);
        JTextField textField9 = new JTextField(u9, 1);
        pane.add(textField9);
        textField9.setForeground(Color.RED);
        textField9.setBackground(c2);
        textField9.setEditable(false);
        textField9.setBounds(410, 10, 20, 20);
        textField9.setHorizontalAlignment(JTextField.CENTER);

        String s0 = Integer.toString(intArray[0]);
        JTextField textFields0 = new JTextField(s0, 1);
        pane.add(textFields0);
        textFields0.setForeground(c1);
        textFields0.setBackground(c2);
        textFields0.setEditable(false);
        textFields0.setBounds(185, 50, 20, 20);
        textFields0.setHorizontalAlignment(JTextField.CENTER);

        String s1 = Integer.toString(intArray[1]);
        JTextField textFields1 = new JTextField(s1, 1);
        pane.add(textFields1);
        textFields1.setForeground(c1);
        textFields1.setBackground(c2);
        textFields1.setEditable(false);
        textFields1.setBounds(210, 50, 20, 20);
        textFields1.setHorizontalAlignment(JTextField.CENTER);

        String s2 = Integer.toString(intArray[2]);
        JTextField textFields2 = new JTextField(s2, 1);
        pane.add(textFields2);
        textFields2.setForeground(c1);
        textFields2.setBackground(c2);
        textFields2.setEditable(false);
        textFields2.setBounds(235, 50, 20, 20);
        textFields2.setHorizontalAlignment(JTextField.CENTER);

        String s3 = Integer.toString(intArray[3]);
        JTextField textFields3 = new JTextField(s3, 1);
        pane.add(textFields3);
        textFields3.setForeground(c1);
        textFields3.setBackground(c2);
        textFields3.setEditable(false);
        textFields3.setBounds(260, 50, 20, 20);
        textFields3.setHorizontalAlignment(JTextField.CENTER);

        String s4 = Integer.toString(intArray[4]);
        JTextField textFields4 = new JTextField(s4, 1);
        pane.add(textFields4);
        textFields4.setForeground(c1);
        textFields4.setBackground(c2);
        textFields4.setEditable(false);
        textFields4.setBounds(285, 50, 20, 20);
        textFields4.setHorizontalAlignment(JTextField.CENTER);

        String s5 = Integer.toString(intArray[5]);
        JTextField textFields5 = new JTextField(s5, 1);
        pane.add(textFields5);
        textFields5.setForeground(c1);
        textFields5.setBackground(c2);
        textFields5.setEditable(false);
        textFields5.setBounds(310, 50, 20, 20);
        textFields5.setHorizontalAlignment(JTextField.CENTER);

        String s6 = Integer.toString(intArray[6]);
        JTextField textFields6 = new JTextField(s6, 1);
        pane.add(textFields6);
        textFields6.setForeground(c1);
        textFields6.setBackground(c2);
        textFields6.setEditable(false);
        textFields6.setBounds(335, 50, 20, 20);
        textFields6.setHorizontalAlignment(JTextField.CENTER);

        String s7 = Integer.toString(intArray[7]);
        JTextField textFields7 = new JTextField(s7, 1);
        pane.add(textFields7);
        textFields7.setForeground(c1);
        textFields7.setBackground(c2);
        textFields7.setEditable(false);
        textFields7.setBounds(360, 50, 20, 20);
        textFields7.setHorizontalAlignment(JTextField.CENTER);

        String s8 = Integer.toString(intArray[8]);
        JTextField textFields8 = new JTextField(s8, 1);
        pane.add(textFields8);
        textFields8.setForeground(c1);
        textFields8.setBackground(c2);
        textFields8.setEditable(false);
        textFields8.setBounds(385, 50, 20, 20);
        textFields8.setHorizontalAlignment(JTextField.CENTER);

        String s9 = Integer.toString(intArray[9]);
        JTextField textFields9 = new JTextField(s9, 1);
        pane.add(textFields9);
        textFields9.setForeground(c1);
        textFields9.setBackground(c2);
        textFields9.setEditable(false);
        textFields9.setBounds(410, 50, 20, 20);
        textFields9.setHorizontalAlignment(JTextField.CENTER);
    }

    private static void checkStatus(){
        //This function checks whether the program should be running or paused
        if(isRunning){
            insertionSort(intArray);
        }
    }

    private static void insertionSort(int[] intArray) {
        //The function that actually sorts the values of the array (one iteration)
        int j = a;              // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        if(j < intArray.length){

            key = intArray[j];

            for(i = j - 1; (i >= 0) && (intArray[i] > key); i--)   // Smaller values are moving up
            {
                intArray[ i+1 ] = intArray[ i ];
            }
            intArray[ i+1 ] = key;    // Put the key in its proper location
        }

        if(a <= 9){
            a++;
            updateTextFields(Color.ORANGE, Color.black);
        }

        if(a > 9){
            updateTextFields(Color.GREEN, Color.black);
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
            insertionSort(intArray);
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
            System.out.println("Quitting");
            System.exit(0);
        }
    }
}

