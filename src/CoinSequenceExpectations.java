import javax.swing.*;
import java.util.*;

public class CoinSequenceExpectations {
    private static int flipCount = 0;
    private static ArrayList<Integer> hhResults = new ArrayList<>();
    private static ArrayList<Integer> ttResults = new ArrayList<>();
    private static ArrayList<Integer> htResults = new ArrayList<>();
    private static ArrayList<Integer> thResults = new ArrayList<>();

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coin Sequence Expectations");
            JButton flipButton = new JButton("Flip Coin");
            JButton resetButton = new JButton("Reset");
            JLabel resultLabel = new JLabel("Click to flip a coin");
            JLabel statusLabel = new JLabel("Target: HH");
            JLabel countLabel = new JLabel("Flips: " + flipCount);
            String[] patterns = {"HH", "TT", "HT", "TH"};
            JComboBox<String> patternComboBox = new JComboBox<>(patterns);
            JButton results = new JButton("Show Results");
            JLabel resultsLabel = new JLabel("No results yet");

           
            Random random = new Random();
            flipButton.addActionListener(e -> {
                String targetPattern = (String) patternComboBox.getSelectedItem();
                patternComboBox.setEnabled(false);
                flipCount++;
                countLabel.setText("Flips: " + flipCount);
                String previous = resultLabel.getText();
                // changes result label to current flip
                if (random.nextBoolean()) {
                    resultLabel.setText("Heads");
                } else {
                    resultLabel.setText("Tails");
                }    

                if (previous.equals("Heads") && resultLabel.getText().equals("Heads") && targetPattern.equals("HH")) {
                    System.out.println("got HH");
                    flipButton.setEnabled(false);
                    statusLabel.setText("got HH");
                    hhResults.add(flipCount);
                    System.out.println(hhResults);
                } else if (previous.equals("Tails") && resultLabel.getText().equals("Tails") && targetPattern.equals("TT")) {
                    System.out.println("got TT");
                    flipButton.setEnabled(false);
                    statusLabel.setText("got TT");
                    ttResults.add(flipCount);
                    System.out.println(ttResults);
                } else if (previous.equals("Heads") && resultLabel.getText().equals("Tails") && targetPattern.equals("HT")) {
                    System.out.println("got HT");
                    flipButton.setEnabled(false);
                    statusLabel.setText("got HT");
                    htResults.add(flipCount);
                    System.out.println(htResults);
                } else if (previous.equals("Tails") && resultLabel.getText().equals("Heads") && targetPattern.equals("TH")) {
                    System.out.println("got TH");
                    flipButton.setEnabled(false);
                    statusLabel.setText("got TH");
                    thResults.add(flipCount);
                    System.out.println(thResults);
                } else {
                    System.out.println("nothing");
                }
                      
            });

            resetButton.addActionListener(e -> {
                resultLabel.setText("Click to flip a coin");
                statusLabel.setText("Target: " + patternComboBox.getSelectedItem());
                patternComboBox.setEnabled(true);
                flipButton.setEnabled(true);
                flipCount = 0;
                countLabel.setText("Flips: " + flipCount);
            });

            patternComboBox.addActionListener(e -> {
                statusLabel.setText("Target: " + patternComboBox.getSelectedItem());
            });

            results.addActionListener(e -> {
                String pattern = "" + patternComboBox.getSelectedItem();
                if (pattern.equals("HH")) {
                    resultsLabel.setText("HH results: " + hhResults);
                } else if (pattern.equals("TT")) {
                    resultsLabel.setText("TT results: " + ttResults);
                } else if (pattern.equals("HT")) {
                    resultsLabel.setText("HT results: " + htResults);
                } else if (pattern.equals("TH")) {
                    resultsLabel.setText("TH results: " + thResults);
                }
            });
            
            JPanel panel = new JPanel();
            panel.add(flipButton);
            panel.add(resetButton);
            panel.add(resultLabel);
            panel.add(statusLabel);
            panel.add(countLabel);
            panel.add(patternComboBox);
            panel.add(results);
            panel.add(resultsLabel);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);

        });
    }
}