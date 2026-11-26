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
                    if (hhResults.isEmpty()) {
                        resultsLabel.setText("No results for HH yet");
                    } else {
                        double average = getAverage(hhResults);
                        resultsLabel.setText("HH results: " + hhResults + ", Average: " + String.format("%.2f", average));
                    }
                } else if (pattern.equals("TT")) {
                    if (ttResults.isEmpty()) {
                        resultsLabel.setText("No results for TT yet");
                    } else {
                        double average = getAverage(ttResults);
                        resultsLabel.setText("TT results: " + ttResults + ", Average: " + String.format("%.2f", average));
                    }
                } else if (pattern.equals("HT")) {
                    if (htResults.isEmpty()) {
                        resultsLabel.setText("No results for HT yet");
                    } else {
                        double average = getAverage(htResults);
                        resultsLabel.setText("HT results: " + htResults + ", Average: " + String.format("%.2f", average));
                    }
                } else if (pattern.equals("TH")) {
                    if (thResults.isEmpty()) {
                        resultsLabel.setText("No results for TH yet");
                    } else {
                        double average = getAverage(thResults);
                        resultsLabel.setText("TH results: " + thResults + ", Average: " + String.format("%.2f", average));
                    }
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

    public static double getAverage(ArrayList<Integer> results) {
        int sum = 0;
        for (int i : results) {
            sum += i;
        }
        double average = 0;
        if (!results.isEmpty()) {
            average = (double) sum / results.size();
        }
        return average;
    }
}