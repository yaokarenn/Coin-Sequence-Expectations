import javax.swing.*;
import java.util.Random;

public class CoinSequenceExpectations {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coin Sequence Expectations");

            JButton button = new JButton("Flip Coin");
            JLabel resultLabel = new JLabel("Click to flip a coin");
            JLabel statusLabel = new JLabel("Target: HH");
           
            Random random = new Random();
            button.addActionListener(e -> {
                String previous = resultLabel.getText();
                // changes result label to current flip
                if (random.nextBoolean()) {
                    resultLabel.setText("Heads");
                } else {
                    resultLabel.setText("Tails");
                }    

                if (previous.equals("Heads") && resultLabel.getText().equals("Heads")) {
                    System.out.println("got HH");
                    button.setEnabled(false);
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
            
            JPanel panel = new JPanel();
            panel.add(button);
            panel.add(resultLabel);
            panel.add(statusLabel);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);

        });
    }
}