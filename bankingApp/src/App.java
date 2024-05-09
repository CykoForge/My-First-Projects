import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App {
    private static JFrame menu = new JFrame("Bank Application");
    private static JPanel cardPanel = new JPanel();
    private static CardLayout cardLayout = new CardLayout();
    public static void main(String[] args) {
       setupGUI();
         }
public static void setupGUI(){
    menu.setSize(800,800);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setLayout(new BorderLayout());

    cardPanel.setLayout(cardLayout);
//Main Menu Layout
    JPanel welcomePanel = new JPanel();
    welcomePanel.setLayout(null);
    JLabel title = new JLabel("Welcome to your Bank!");
    title.setFont(new Font("Courier", Font.BOLD, 25));
    title.setBounds(50,50, 400, 50);
    welcomePanel.add(title);

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

    JLabel firstName = new JLabel("Full Name: ");
    firstName.setBounds(50,150, 150, 30);
    regPanel.add(firstName);

    JTextField firstNamed = new JTextField();
    firstNamed.setBounds(220, 150,150,30);
    regPanel.add(firstNamed);

    JLabel userLabel = new JLabel("Username: ");
    userLabel.setBounds(50,200,150,30);
    regPanel.add(userLabel);

    JTextField userTextField = new JTextField();
    userTextField.setBounds(220,200,150,30);
    regPanel.add(userTextField);

    JLabel passLabel = new JLabel("Password :");
    passLabel.setBounds(50, 250, 150, 30);
    regPanel.add(passLabel);

    JPasswordField passTextField = new JPasswordField();
    passTextField.setBounds(220, 250, 150,30);
    regPanel.add(passTextField);

    JButton submiButton = new JButton("Submit");
    submiButton.setBounds(150,300,100,30);
    regPanel.add(submiButton);

    submiButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            String username = userTextField.getText();
            String first = firstNamed.getText();
        }
    });

    cardPanel.add(welcomePanel, "Welcome");
    cardPanel.add(regPanel, "Register");

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
}