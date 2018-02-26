import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    public CalculatorGUI() {

        cButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int tal1 = Integer.parseInt(input1.getText());
                int tal2 = Integer.parseInt(input2.getText());
                answer.setText(""+(tal1 + tal2));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CalculatorGUI");
        frame.setContentPane(new CalculatorGUI().calc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }

    public JPanel calc;
    private JTextField input2;
    private JTextField input1;
    private JButton cButton;
    private JLabel answer;
}
