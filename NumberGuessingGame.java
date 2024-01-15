import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame extends JFrame {
    private int randomNumber;
    private int attempts;

    private JLabel instructionLabel;
    private JTextField guessTextField;
    private JButton submitButton;
    private JLabel resultLabel;

    public NumberGuessingGame() {
        randomNumber = new Random().nextInt(100) + 1; // Generates a random number between 1 and 100
        attempts = 0;

        setTitle("Number Guessing Game");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        instructionLabel = new JLabel("Guess the number (1-100):");
        guessTextField = new JTextField(10);
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("");

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        topPanel.add(instructionLabel);
        topPanel.add(guessTextField);
        topPanel.add(submitButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(resultLabel);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        guessTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        resultLabel.setForeground(Color.BLUE);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessTextField.getText());
            attempts++;

            if (guess < randomNumber) {
                resultLabel.setText("Too low. Try again.");
            } else if (guess > randomNumber) {
                resultLabel.setText("Too high. Try again.");
            } else {
                resultLabel.setText("Congratulations! You guessed it in " + attempts + " attempts.");
                guessTextField.setEditable(false);
                submitButton.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
        guessTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NumberGuessingGame game = new NumberGuessingGame();
                game.setVisible(true);
            }
        });
    }
}
