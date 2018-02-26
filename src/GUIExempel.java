import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Set;

public class GUIExempel {
    private JPanel rotPanel;
    private JTextArea HEJHEJTextArea;
    private JButton saveButton;
    private JButton openButton;
    private JButton newFileButton;
    private JButton calcButton;
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("GUIExempel");
        frame.setContentPane(new GUIExempel().rotPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

    public GUIExempel() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("C:\\Users\\bybe16\\Desktop\\"));
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("HejHej");

                if (fc.showSaveDialog(saveButton) == JFileChooser.APPROVE_OPTION){
                    System.out.println("You chose to open this file: " +
                            fc.getSelectedFile().getName());

                    try (FileWriter out = new FileWriter("C:\\Users\\bybe16\\Desktop\\" + fc.getSelectedFile().getName())){
                        out.write( HEJHEJTextArea.getText().replace("\n", "\r\n"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        } );
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("C:\\Users\\bybe16\\Desktop\\"));
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("HejHej");
                if (fc.showOpenDialog(openButton) == JFileChooser.APPROVE_OPTION){
                    System.out.println("You chose to open this file: " +
                            fc.getSelectedFile().getName());
                    try {
                        BufferedReader br = new BufferedReader( new FileReader("C:\\Users\\bybe16\\Desktop\\" +
                                fc.getSelectedFile().getName()));
                        String line;
                        HEJHEJTextArea.setText("");
                        try {
                            while((line = br.readLine()) != null) {
                                HEJHEJTextArea.append(line + "\n");
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              HEJHEJTextArea.setText("");
            }
        });
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CalculatorGUI().calc);
                //frame.setSize(1920, 1080);
                frame.pack();

            }
        });
    }
}
