import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class App {
    private static JFrame menu = new JFrame("Bank Application");
    private static JPanel cardPanel = new JPanel();
    private static CardLayout cardLayout = new CardLayout();
    private static JLabel checkingAmountLabel, savingsAmountLabel;
    private static double checkingAmount = 1000.00; 
    private static double savingsAmount = 5000.00;
    private static Map<String, String> userCredentials = new HashMap<>();
    public static void main(String[] args) {
       setupGUI();
         }
public static void setupGUI(){
    menu.setSize(650,550);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setLayout(new BorderLayout());

    cardPanel.setLayout(cardLayout);
//Main Menu Layout
    JPanel welcomePanel = new JPanel();
    welcomePanel.setLayout(null);
    welcomePanel.setBackground(Color.LIGHT_GRAY);
    JLabel title = new JLabel("Welcome to your Bank!");
    title.setFont(new Font("Courier", Font.BOLD, 30));
    title.setBounds(50,100, 400, 50);
    welcomePanel.add(title);

    JLabel creator = new JLabel("Created by Ali Haider");
    creator.setFont(new Font("Courier", Font.ITALIC, 12));
    creator.setSize(creator.getPreferredSize());
    int labelWidth = creator.getWidth();
    int labelHeight = creator.getHeight();
    creator.setBounds(50, 150, labelWidth, labelHeight);
    welcomePanel.add(creator);

    JButton login = new JButton("Login");
    login.setFont(new Font("Courier", Font.PLAIN, 20));
    login.setForeground(Color.WHITE);
    login.setBounds(50, 250, 200, 50);
    login.setBackground(Color.DARK_GRAY);
    welcomePanel.add(login);

    JButton register = new JButton("Register");
    register.setFont(new Font("Courier", Font.PLAIN, 20));
    register.setForeground(Color.WHITE);
    register.setBounds(50, 310, 200, 50);
    register.setBackground(Color.DARK_GRAY);
    welcomePanel.add(register);

    JButton forgotPassword = new JButton("Forgot Password");
    forgotPassword.setFont(new Font("Courier", Font.PLAIN, 15));
    forgotPassword.setForeground(Color.WHITE);
    forgotPassword.setBounds(50, 370, 200, 50);
    forgotPassword.setBackground(Color.DARK_GRAY);
    welcomePanel.add(forgotPassword);

    JButton quit = new JButton("Quit");
    quit.setFont(new Font("Courier", Font.PLAIN, 20));
    quit.setForeground(Color.WHITE);
    quit.setBounds(50, 430, 200, 50);
    quit.setBackground(Color.DARK_GRAY);
    welcomePanel.add(quit);

//Registration Panel 
    JPanel regPanel = new JPanel();
    regPanel.setLayout(null);

    JLabel fullName = new JLabel("Full Name: ");
    fullName.setBounds(50,150, 150, 30);
    regPanel.add(fullName);

    JTextField fullNamed = new JTextField();
    fullNamed.setBounds(220, 150,150,30);
    regPanel.add(fullNamed);

    JLabel userLabel = new JLabel("Username: ");
    userLabel.setBounds(50,200,150,30);
    regPanel.add(userLabel);

    JTextField userTextField = new JTextField();
    userTextField.setBounds(220,200,150,30);
    regPanel.add(userTextField);

    JButton userNameInfo = new JButton("Info");
    userNameInfo.setFont(new Font(null, Font.PLAIN, 8));
    userNameInfo.setBounds(120, 200, 50, 30);
// Register Username Components
    userNameInfo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = userTextField.getText();
            if (username.length() >= 7) {
                JOptionPane.showMessageDialog(menu, "Username is valid: " + username);
            } else {
                JOptionPane.showMessageDialog(menu, "Username must be at least 7 characters long.");
            }
        }
    });
    regPanel.add(userNameInfo);

    JLabel passLabel = new JLabel("Password :");
    passLabel.setBounds(50, 250, 150, 30);
    regPanel.add(passLabel);

    JPasswordField passTextField = new JPasswordField();
    passTextField.setBounds(220, 250, 150,30);
    regPanel.add(passTextField);

    JButton passwordInfo = new JButton("Info");
    passwordInfo.setFont(new Font(null, Font.PLAIN, 8));
    passwordInfo.setBounds(120, 250, 50, 30);
// Register Password Components
    passwordInfo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String password = new String(passTextField.getPassword());
        StringBuilder message = new StringBuilder();
        boolean isValid = true;
        if (password.length() < 7) {
            message.append("Password must be at least 7 characters long.\n");
            isValid = false;
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            message.append("Password must contain at least one special character.\n");
            isValid = false;
        }
        if (isValid) {
            message.append("Password is valid.");
        }
        JOptionPane.showMessageDialog(menu, message.toString());
    }
    });
    regPanel.add(passwordInfo);

    JButton submiButton = new JButton("Submit");
    submiButton.setBounds(150,300,100,30);
    regPanel.add(submiButton);

// Register Sumbit Button
submiButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = new String(passTextField.getPassword());
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, password);
            JOptionPane.showMessageDialog(menu, "Registration successful. You can now login.");
            cardLayout.show(cardPanel, "Login");
        } else {
            JOptionPane.showMessageDialog(menu, "Username already exists. Please choose another username.");
        }
    }
});

    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(null);

    JLabel loginTitle = new JLabel("Enter credentials to log in below");
    loginTitle.setFont(new Font("Courier", Font.BOLD, 16));
    loginTitle.setBounds(50,100, 400, 50);
    loginPanel.add(loginTitle);

    JButton backTo = new JButton("Back to Menu");
    backTo.setBounds(400 ,300,150,30);
    loginPanel.add(backTo);

    JButton backTo1 = new JButton("Back to Menu");
    backTo1.setBounds(400 ,300,150,30);
    regPanel.add(backTo1);

    JLabel userLogLabel = new JLabel("Username: ");
    userLogLabel.setBounds(50,200,150,30);
    loginPanel.add(userLogLabel);

    JTextField userLogTextField = new JTextField();
    userLogTextField.setBounds(220,200,150,30);
    loginPanel.add(userLogTextField);

    JLabel loginPass = new JLabel("Password :");
    loginPass.setBounds(50, 250, 150, 30);
    loginPanel.add(loginPass);

    JPasswordField loginPassed = new JPasswordField();
    loginPassed.setBounds(220, 250, 150,30);
    loginPanel.add(loginPassed);

    JButton submiLogButton = new JButton("Submit");
    submiLogButton.setBounds(150,300,100,30);
    loginPanel.add(submiLogButton);

    backTo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Welcome");
        }
    });

    backTo1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Welcome");
        }
    });

    submiLogButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = userLogTextField.getText();
            String password = new String(loginPassed.getPassword());
            if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                JOptionPane.showMessageDialog(menu, "Login successful.");
                cardLayout.show(cardPanel, "Bank");
            } else {
                JOptionPane.showMessageDialog(menu, "Invalid username or password.");
            }
        }
    });

//Logged in successful 
    JPanel bankPanel = new JPanel();
    bankPanel.setLayout(null);

    JLabel bankHeader = new JLabel("Your are listed accounts below");
    bankHeader.setFont(new Font("Courier", Font.BOLD, 23));
    bankHeader.setBounds(50,100, 500, 50);
    bankPanel.add(bankHeader);

    checkingAmountLabel = new JLabel("Checking Account: $" + checkingAmount);
    checkingAmountLabel.setFont(new Font("Courier", Font.BOLD, 16));
    checkingAmountLabel.setBounds(50,200,500,30);
    bankPanel.add(checkingAmountLabel);

    savingsAmountLabel = new JLabel("Savings Account: $" + savingsAmount);
    savingsAmountLabel.setFont(new Font("Courier", Font.BOLD, 16));
    savingsAmountLabel.setBounds(50,275,500,30);
    bankPanel.add(savingsAmountLabel);

    JButton updateButton = new JButton("Update Balances");
    updateButton.setFont(new Font("Courier", Font.PLAIN, 12));
    updateButton.setBounds(50, 300, 200, 30);
    updateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            checkingAmount += 100; 
            savingsAmount -= 50; 
            updateBalances();
        }
    });
    bankPanel.add(updateButton);

    JButton logoutButton = new JButton("Log Out");
    logoutButton.setFont(new Font("Courier", Font.PLAIN, 12));
    logoutButton.setForeground(Color.WHITE);
    logoutButton.setBackground(Color.DARK_GRAY);
    logoutButton.setBounds(500, 425, 100, 30);
    bankPanel.add(logoutButton);

    JPanel transferPanel = new JPanel();
    transferPanel.setLayout(null);

    JPanel settingPanel = new JPanel();
    settingPanel.setLayout(null);

    JButton settings = new JButton("Settings");
    settings.setFont(new Font("Courier", Font.PLAIN, 12));
    settings.setForeground(Color.WHITE);
    settings.setBackground(Color.DARK_GRAY);
    settings.setBounds(360, 425, 125, 30);
    bankPanel.add(settings);

//Statement Page
    JPanel statementPanel = new JPanel();
    statementPanel.setLayout(null);

    JLabel wordStatement = new JLabel("Statements are below: ");
    wordStatement.setFont(new Font("Courier", Font.BOLD, 23));
    wordStatement.setBounds(50,100, 500, 50);
    statementPanel.add(wordStatement);

    JButton statements = new JButton("Statement");
    statements.setFont(new Font("Courier", Font.PLAIN, 12));
    statements.setForeground(Color.WHITE);
    statements.setBackground(Color.DARK_GRAY);
    statements.setBounds(220, 425, 125, 30);
    bankPanel.add(statements);

    statements.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Statements");
        }
    });

    settings.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Setting");
        }
    });

    logoutButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        cardLayout.show(cardPanel, "Welcome");
    }
});

    cardPanel.add(welcomePanel, "Welcome");
    cardPanel.add(regPanel, "Register");
    cardPanel.add(loginPanel, "Login");
    cardPanel.add(bankPanel, "Bank");
    cardPanel.add(settingPanel, "Setting");
    cardPanel.add(statementPanel, "Statements");

//The Main Menu Button Links
    login.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Login");
        }
    });
    register.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Register");
        }
    });

    quit.addActionListener(e -> System.exit(0));

    

    menu.add(cardPanel, BorderLayout.CENTER);
    cardLayout.show(cardPanel, "Welcome");
    menu.setVisible(true);

    }

    private static void updateBalances() {
        checkingAmountLabel.setText("Checking Account: $" + checkingAmount);
        savingsAmountLabel.setText("Savings Account: $" + savingsAmount);
    }
}