import javax.swing.*;
import java.util.Random;

public class CoinSequenceExpectations {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coin Sequence Expectations");

            JButton button = new JButton("Flip Coin");
            JLabel resultLabel = new JLabel("Click to flip a coin");
           
            Random random = new Random();
            button.addActionListener(e -> {
                // Changes resultLabel text to show heads or tails based on a random flip    
                if (random.nextBoolean()) {
                    resultLabel.setText("Heads");
                } else {
                    resultLabel.setText("Tails");
                }        
            });
            
            JPanel panel = new JPanel();
            panel.add(button);
            panel.add(resultLabel);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);

        });
    }
}