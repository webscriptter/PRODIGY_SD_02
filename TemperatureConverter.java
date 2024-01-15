import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {

    private JTextField inputField;
    private JButton convertButton;
    private JTextArea resultTextArea;
    private JPanel inputPanel;
    private JPanel resultPanel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(450, 300); // Increased size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panels for input and result sections
        inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setBackground(new Color(210, 210, 210));

        resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBackground(new Color(210, 210, 210));

        JLabel inputLabel = new JLabel("Enter Temperature (Celsius):");
        inputField = new JTextField(10);
        convertButton = new JButton("Convert");
        resultTextArea = new JTextArea(8, 30); // Increased size
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setBorder(new EmptyBorder(10, 10, 10, 10)); // Increased border size

        // Add components to input panel
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(convertButton);

        // Add result text area to result panel
        resultPanel.add(resultTextArea, BorderLayout.CENTER);

        // Add panels to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

private void convertTemperature() {
    try {
        double temperatureCelsius = Double.parseDouble(inputField.getText());

        double temperatureFahrenheit = (temperatureCelsius * 9/5) + 32;
        double temperatureKelvin = temperatureCelsius + 273.15;

        String resultText = String.format("%.2fFahrenheit\n%.2fK", temperatureFahrenheit, temperatureKelvin);
        resultTextArea.setText(resultText);
    } catch (NumberFormatException e) {
        resultTextArea.setText("Invalid input. Please enter a valid temperature.");
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }
}
