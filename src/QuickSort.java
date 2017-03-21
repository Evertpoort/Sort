import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

/**
 * Created by Evert Poort (331484) on 21-3-2017.
 */

public class QuickSort {

    private static int[] intArray = new int[10];
    private static int[] startArray = new int[10];
    private static JFrame frame1;
    private static Container pane;
    private static JButton btnSort, btnQuit;

    public static void main(String[] args) {
        //Fill our array with random values between 1 and 50
        Random rand = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(50) + 1;
            startArray[i] = intArray[i];
        }

        createGUI();
        createButtons();
        updateTextFields(Color.ORANGE, Color.BLACK);
    }

    private static void createGUI(){
        frame1 = new JFrame("Insertion Sort");
        frame1.setSize(460, 130);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        pane = frame1.getContentPane();
        pane.setLayout(null);
    }

    private static void createButtons(){
        btnSort = new JButton("Sort");
        pane.add(btnSort);
        btnSort.setBounds(10, 10, 80, 30);
        btnSort.addActionListener(new btnSortAction());    //Register action

        btnQuit = new JButton("Quit");
        pane.add(btnQuit);
        btnQuit.setBounds(10, 50, 80, 30);
        btnQuit.addActionListener(new QuickSort.btnQuitAction());      //Register action
    }

    private static void updateTextFields(Color c1, Color c2){

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

    private static void quickSort(int array[], int start, int end) {
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
        int temp = array[index1];           // store the first value in a temp
        array[index1] = array[index2];      // copy the value of the second into the first
        array[index2] = temp;               // copy the value of the temp into the second
    }

    public static class btnSortAction implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            quickSort(intArray, 0, intArray.length-1);

            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            updateTextFields(Color.green, Color.black);
        }
    }

    public static class btnQuitAction implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
}
