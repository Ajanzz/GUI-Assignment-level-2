import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp extends JFrame {

    private JTextField kelvinTextField;
    private JLabel resultLabel;

    public TemperatureConverterApp() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel kelvinLabel = new JLabel("Kelvin:");
        kelvinTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("");

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double kelvin = Double.parseDouble(kelvinTextField.getText());
                    double celsius = kelvin - 273.15;
                    resultLabel.setText("Celsius: " + celsius);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });

        add(kelvinLabel);
        add(kelvinTextField);
        add(convertButton);
        add(resultLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterApp();
            }
        });
    }
}

