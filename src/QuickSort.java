import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by Evert Poort (331484) on 21-3-2017.
 *
 */

public class QuickSort {

    private static int[] intArray = new int[10];
    private static int a = 1;

    private static JFrame frame1;
    private static Container pane;
    private static JButton btnSort, btnQuit;

    public static void main(String[] args) {
        //Fill our array with random values between 1 and 50
        Random rand = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(50) + 1;
        }

        //Create Graphical User Interface
        createGUI();
        updateGUI();
    }

    private static void createGUI(){

        //Create the frame
        frame1 = new JFrame("Insertion Sort");
        frame1.setSize(460, 130);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pane = frame1.getContentPane();
        pane.setLayout(null);

        //Create controls
        btnSort = new JButton("Sort");
        btnQuit = new JButton("Quit");

        createTextFields();

        //Add all components to panel
        pane.add(btnSort);
        pane.add(btnQuit);

        //Place and resize all components
        btnSort.setBounds(10, 10, 80, 30);

        btnQuit.setBounds(10, 50, 80, 30);

        //Make frame visible
        frame1.setVisible(true);

        //Add functionality to the buttons
        btnSort.addActionListener(new btnSortAction());    //Register action

        btnQuit.addActionListener(new QuickSort.btnQuitAction());      //Register action
    }

    private static void createTextFields(){
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
    }

    private static void updateGUI(){

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

    public static void quickSort(int array[], int start, int end)
    {
        int i = start;                          // index of left-to-right scan
        int k = end;                            // index of right-to-left scan

        if (end - start >= 1)                   // check that there are at least two elements to sort
        {
            int pivot = array[start];       // set the pivot as the first element in the partition

            while (k > i)                   // while the scan indices from left and right have not met,
            {
                while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
                    i++;                                    // element greater than the pivot
                while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
                    k--;                                        // element not greater than the pivot
                if (k > i)                                       // if the left seekindex is still smaller than
                    swap(array, i, k);                      // the right index, swap the corresponding elements
            }

            swap(array, start, k);          // after the indices have crossed, swap the last element in
            // the left partition with the pivot
            quickSort(array, start, k - 1); // quicksort the left partition
            quickSort(array, k + 1, end);   // quicksort the right partition
        }
        else    // if there is only one element in the partition, do not do any sorting
        {
            return;                  // the array is sorted, so exit
        }

    }

    private static void swap(int array[], int index1, int index2){
    // pre: array is full and index1, index2 < array.length
    // post: the values at indices 1 and 2 have been swapped

        int temp = array[index1];           // store the first value in a temp
        array[index1] = array[index2];      // copy the value of the second into the first
        array[index2] = temp;               // copy the value of the temp into the second
    }

    public static class btnSortAction implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            quickSort(intArray, 0, intArray.length-1);
            updateGUI();

            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            finalGUI();

        }
    }



    public static class btnQuitAction implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.out.println("Quitting");
            System.exit(0);
        }
    }
}

