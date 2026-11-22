import javax.swing.*;

public class CoinSequenceExpectations {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coin Sequence Expectations");

            JButton button = new JButton("Flip Coin");

            
            JPanel panel = new JPanel();
            panel.add(button);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);

        });
    }
}