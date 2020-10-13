import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFrame mainFrame;
    public Calculator() {
        mainFrame = new JFrame();

        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(100, 100, 300, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));

        mainFrame.add(top, BorderLayout.NORTH);
        mainFrame.add(bottom, BorderLayout.CENTER);

        JTextField outField = new JTextField();
        outField.setEditable(false);
        top.add(outField, BorderLayout.CENTER);

        ActionButtonListener abListener = new ActionButtonListener(outField);
        for (int i = 0; i <= 9; i++) {
            JButton digitBtn = new JButton(String.valueOf(i));
            bottom.add(digitBtn);
            digitBtn.addActionListener(abListener);
        }

        JButton plusBtn = new JButton("+");
        plusBtn.addActionListener(abListener);
        bottom.add(plusBtn);
        JButton minusBtn = new JButton("-");
        minusBtn.addActionListener(abListener);
        bottom.add(minusBtn);
        JButton multiplicationBtn = new JButton("*");
        multiplicationBtn.addActionListener(abListener);
        bottom.add(multiplicationBtn);
        JButton divisionBtn = new JButton("/");
        divisionBtn.addActionListener(abListener);
        bottom.add(divisionBtn);
        JButton cancelBtn = new JButton("C");
        cancelBtn.addActionListener(abListener);
        bottom.add(cancelBtn);
        ActionSubmitHandleListener ashListener = new ActionSubmitHandleListener(outField);
        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(ashListener);
        bottom.add(submitBtn);


        mainFrame.setVisible(true);
    }
}
