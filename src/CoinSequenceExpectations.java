import javax.swing.*;
import java.util.Random;

public class CoinSequenceExpectations {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coin Sequence Expectations");

            JButton flipButton = new JButton("Flip Coin");
            JButton resetButton = new JButton("Reset");
            JLabel resultLabel = new JLabel("Click to flip a coin");
            JLabel statusLabel = new JLabel("Target: HH");
           
            Random random = new Random();
            flipButton.addActionListener(e -> {
                String previous = resultLabel.getText();
                // changes result label to current flip
                if (random.nextBoolean()) {
                    resultLabel.setText("Heads");
                } else {
                    resultLabel.setText("Tails");
                }    

                if (previous.equals("Heads") && resultLabel.getText().equals("Heads")) {
                    System.out.println("got HH");
                    flipButton.setEnabled(false);
                    statusLabel.setText("got HH");
                } else if (previous.equals("Tails") && resultLabel.getText().equals("Tails")) {
                    System.out.println("got TT");
                } else if (previous.equals("Heads") && resultLabel.getText().equals("Tails")) {
                    System.out.println("got HT");
                } else if (previous.equals("Tails") && resultLabel.getText().equals("Heads")) {
                    System.out.println("got TH");
                } else {
                    System.out.println("nothing");
                }
                      
            });

            resetButton.addActionListener(e -> {
                resultLabel.setText("Click to flip a coin");
                statusLabel.setText("Target: HH");
                flipButton.setEnabled(true);
            });
            
            JPanel panel = new JPanel();
            panel.add(flipButton);
            panel.add(resetButton);
            panel.add(resultLabel);
            panel.add(statusLabel);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);

        });
    }
}