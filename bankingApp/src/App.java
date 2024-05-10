import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


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
    menu.setSize(650,650);
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

    JButton guestButton = new JButton("Guest");
    guestButton.setFont(new Font("Courier", Font.PLAIN, 20));
    guestButton.setForeground(Color.WHITE);
    guestButton.setBounds(50, 490, 200, 50);
    guestButton.setBackground(Color.DARK_GRAY);
    welcomePanel.add(guestButton);


//Registration Panel 
    JPanel regPanel = new JPanel();
    regPanel.setLayout(null);

    JLabel regTitle = new JLabel("Enter credentials to register below");
    regTitle.setFont(new Font("Courier", Font.BOLD, 16));
    regTitle.setBounds(50,100, 400, 50);
    regPanel.add(regTitle);

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
        String username = userTextField.getText().trim();
        String password = new String(passTextField.getPassword()).trim();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(menu, "Username and password cannot be empty.");
            return;
        }
        if (username.length() < 7 || !password.matches(".*[^a-zA-Z0-9].*") || password.length() < 7) {
            JOptionPane.showMessageDialog(menu, "Username or password does not meet the criteria.");
            return;
        }
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, password);
            JOptionPane.showMessageDialog(menu, "Registration successful. You can now login.");
            cardLayout.show(cardPanel, "Login");
        } else {
            JOptionPane.showMessageDialog(menu, "Username already exists. Please choose another username.");
        }
    }
});
//Login Panel 
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

//Forgot Password Panel
    JPanel fPPanel = new JPanel();
    fPPanel.setLayout(null);

    JLabel fPHeader = new JLabel("Enter your username below");
    fPHeader.setFont(new Font("Courier", Font.BOLD, 23));
    fPHeader.setBounds(50,100,500,50);
    fPPanel.add(fPHeader);

    JButton backTo2 = new JButton("Back to Menu");
    backTo2.setBounds(400 ,300,150,30);
    fPPanel.add(backTo2);

    JLabel fPUsername = new JLabel("Username: ");
    fPUsername.setBounds(50,200,150,30);
    fPPanel.add(fPUsername);

    JTextField fPUserTextField = new JTextField();
    fPUserTextField.setBounds(220,200,150,30);
    fPPanel.add(fPUserTextField);

    JLabel fPnewPass = new JLabel("New Password :");
    fPnewPass.setBounds(50, 250, 150, 30);
    fPPanel.add(fPnewPass);

    JPasswordField fPnewPassText = new JPasswordField();
    fPnewPassText.setBounds(220, 250, 150,30);
    fPPanel.add(fPnewPassText);

    JLabel fPnewPass1 = new JLabel("Confirm Password :");
    fPnewPass1.setBounds(50, 300, 150, 30);
    fPPanel.add(fPnewPass1);

    JPasswordField fPnewPassText1 = new JPasswordField();
    fPnewPassText1.setBounds(220, 300, 150,30);
    fPPanel.add(fPnewPassText1);

    JButton submiFPButton = new JButton("Submit");
    submiFPButton.setBounds(150,350,100,30);
    fPPanel.add(submiFPButton);

    submiFPButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = fPUserTextField.getText().trim();
            String password1 = new String(fPnewPassText.getPassword()).trim();
            String password2 = new String(fPnewPassText1.getPassword()).trim();
            if (!password1.equals(password2)) {
                JOptionPane.showMessageDialog(menu, "Passwords do not match.");
                return;
            }
            if (password1.length() < 7 || !password1.matches(".*[^a-zA-Z0-9].*")) {
                JOptionPane.showMessageDialog(menu, "Password must be at least 7 characters long and contain at least one special character.");
                return;
            }
            if (userCredentials.containsKey(username)) {
                userCredentials.put(username, password1);
                JOptionPane.showMessageDialog(menu, "Password reset successful.");
                cardLayout.show(cardPanel, "Login");
            } else {
                JOptionPane.showMessageDialog(menu, "Username does not exist.");
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
//Settings Page
    JLabel settingsHeader = new JLabel("Settings: ");
    settingsHeader.setFont(new Font("Courier", Font.BOLD, 23));
    settingsHeader.setBounds(50,100, 500, 50);
    settingPanel.add(settingsHeader);

    JCheckBox goPaperLess = new JCheckBox("Go Paperless ");
    goPaperLess.setFont(new Font("Courier", Font.PLAIN, 12 ));
    goPaperLess.setBounds(50,275,150,12);
    settingPanel.add(goPaperLess);
 
    JToggleButton darkTheme = new JToggleButton("Dark Theme ");
    darkTheme.setFont(new Font("Courier", Font.PLAIN, 12));
    darkTheme.setBounds(50,225, 200, 30);
    settingPanel.add(darkTheme);

    JButton backTo4 = new JButton("Back ");
    backTo4.setFont(new Font("Courier", Font.PLAIN, 12));
    backTo4.setForeground(Color.WHITE);
    backTo4.setBackground(Color.DARK_GRAY);
    backTo4.setBounds(220,425,125,30);
    settingPanel.add(backTo4);

    backTo4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Bank");
        }
    });

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

    JButton backTo3 = new JButton("Back ");
    backTo3.setFont(new Font("Courier", Font.PLAIN, 12));
    backTo3.setForeground(Color.WHITE);
    backTo3.setBackground(Color.DARK_GRAY);
    backTo3.setBounds(220,425,125,30);
    statementPanel.add(backTo3);

    backTo3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Bank");
        }
    });

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
    cardPanel.add(fPPanel, "ForgotPassword");
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

    forgotPassword.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "ForgotPassword");
        }
    });

    guestButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Bank");
        }
    });
//Back to Menu Links
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

    backTo2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardPanel, "Welcome");
        }
    });

    quit.addActionListener(e -> System.exit(0));

    darkTheme.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (darkTheme.isSelected()) {
                darkTheme.setText("Light Theme");
                setColorTheme(Color.DARK_GRAY);
                wordStatement.setForeground(Color.WHITE);
                settingsHeader.setForeground(Color.WHITE);
                savingsAmountLabel.setForeground(Color.WHITE);
                checkingAmountLabel.setForeground(Color.WHITE);
                bankHeader.setForeground(Color.WHITE);
                fPnewPass1.setForeground(Color.WHITE);
                fPnewPass.setForeground(Color.WHITE);
                fPUsername.setForeground(Color.WHITE);
                fPHeader.setForeground(Color.WHITE);
                loginPass.setForeground(Color.WHITE);
                userLogLabel.setForeground(Color.WHITE);
                loginTitle.setForeground(Color.WHITE);
                loginTitle.setForeground(Color.WHITE);
                userLabel.setForeground(Color.WHITE);
                fullName.setForeground(Color.WHITE);
                regTitle.setForeground(Color.WHITE);
                creator.setForeground(Color.WHITE);
                title.setForeground(Color.WHITE);
            } else {
                darkTheme.setText("Dark Theme"); 
                setColorTheme(Color.LIGHT_GRAY);
                wordStatement.setForeground(Color.BLACK);
                settingsHeader.setForeground(Color.BLACK);
                savingsAmountLabel.setForeground(Color.BLACK);
                checkingAmountLabel.setForeground(Color.BLACK);
                bankHeader.setForeground(Color.BLACK);
                fPnewPass1.setForeground(Color.BLACK);
                fPnewPass.setForeground(Color.BLACK);
                fPUsername.setForeground(Color.BLACK);
                fPHeader.setForeground(Color.BLACK);
                loginPass.setForeground(Color.BLACK);
                userLogLabel.setForeground(Color.BLACK);
                loginTitle.setForeground(Color.BLACK);
                loginTitle.setForeground(Color.BLACK);
                userLabel.setForeground(Color.BLACK);
                fullName.setForeground(Color.BLACK);
                regTitle.setForeground(Color.BLACK);
                creator.setForeground(Color.BLACK);
                title.setForeground(Color.BLACK);
            }
        }
    
    private void setColorTheme(Color color) {
        welcomePanel.setBackground(color);
        bankPanel.setBackground(color);
        settingPanel.setBackground(color);
        transferPanel.setBackground(color);
        regPanel.setBackground(color);
        loginPanel.setBackground(color);
        fPPanel.setBackground(color);
        statementPanel.setBackground(color); 
        }
    });

    menu.add(cardPanel, BorderLayout.CENTER);
    cardLayout.show(cardPanel, "Welcome");
    menu.setVisible(true);

    }

    private static void updateBalances() {
        checkingAmountLabel.setText("Checking Account: $" + checkingAmount);
        savingsAmountLabel.setText("Savings Account: $" + savingsAmount);
    }
}