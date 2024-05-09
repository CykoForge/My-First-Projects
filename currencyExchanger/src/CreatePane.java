import java.awt.Color;
import java.awt.Dimension;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.jshell.spi.ExecutionControl;

public class CreatePane {
    private static final String API_KEY = "f260e59da9881e0b8703acd8";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    public static void main(final String[] args) {
        setupGUI();
    }

    public static void setupGUI(){
        JFrame home = new JFrame();
        home.setPreferredSize(new Dimension(800,800));
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLayout(null);
        home.setBackground(Color.WHITE);

        JButton button = new JButton("Welcome to the Curreny Exchanger Calculator!");
        button.setBounds(250, 250, 300, 50);
        home.add(button);
        home.pack();
        home.setVisible(true);

        button.addActionListener(evt -> {
            handleButtonClick(home);
        });
    }

    private static void handleButtonClick(JFrame home){
        String fromCountry = JOptionPane.showInputDialog(home,
                    "What is the country you want your conversion calculated to?", null);
            if(fromCountry != null){
                String toCountry = JOptionPane.showInputDialog(home,
                "What is the current country's money you have?", null);
                if(toCountry != null){
                    executeCurrencyExchange(home, fromCountry, toCountry);
            }
        }
    }

    private static void executeCurrencyExchange(JFrame home, String fromCountry, String toCountry) {
        try {
            String amountStr = JOptionPane.showInputDialog(home, "Enter amount in " + toCountry + " currency:");
            double amount = Double.parseDouble(amountStr);
            double rate = getExchangeRate(fromCountry, toCountry);
            double exchanged = amount * rate;
            JOptionPane.showMessageDialog(home, String.format("%.2f %s is approximately %.2f %s", amount, fromCountry, exchanged, toCountry));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(home, "Please enter a valid number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(home, "Error during currency conversion: " + e.getMessage());
        }
    }

    private static double getExchangeRate(String fromCountry, String toCountry) throws Exception {
        URL url = new URL(API_URL + API_KEY + "/pair/" + fromCountry + "/" + toCountry);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
    
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("HTTP Response Code: " + responseCode);
        }
        
        StringBuilder response = new StringBuilder();
        try (Scanner scanner = new Scanner(url.openStream())) {
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
        }
        
        String responseStr = response.toString();
        int startIndex = responseStr.indexOf("\"conversion_rate\":") + 18;
        int endIndex = responseStr.indexOf(",", startIndex);
        endIndex = (endIndex == -1) ? responseStr.indexOf("}", startIndex) : endIndex;
        String rateStr = responseStr.substring(startIndex, endIndex).trim();
    
        try {
            return Double.parseDouble(rateStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Failed to parse the conversion rate from the response", e);
        }
    }
}
    

