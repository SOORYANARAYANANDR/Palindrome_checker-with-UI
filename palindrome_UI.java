import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class palindrome_UI extends JFrame implements ActionListener {
    private JTextField numberField;
    private JLabel resultLabel;
    
    public palindrome_UI() {
        // create the main window
        setTitle("Binary Palindrome Checker");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create the input field for the number
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        
        JLabel numberLabel = new JLabel("Enter a number:");
        inputPanel.add(numberLabel);
        
        numberField = new JTextField(10);
        inputPanel.add(numberField);
        
        // create the button to check the palindrome
        JButton checkButton = new JButton("Check Palindrome");
        checkButton.addActionListener(this);
        
        // create the label to display the result
        resultLabel = new JLabel("");
        
        // add the components to the main window
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainPanel.add(inputPanel);
        mainPanel.add(checkButton);
        mainPanel.add(resultLabel);
        
        setContentPane(mainPanel);
    }
    
    public void actionPerformed(ActionEvent e) {
        String input = numberField.getText();
        
        // convert the input to a binary string
        String binary = Integer.toBinaryString(Integer.parseInt(input));
        
        // check if the binary string is a palindrome
        boolean isPalindrome = true;
        for (int i = 0; i < binary.length() / 2; i++) {
            if (binary.charAt(i) != binary.charAt(binary.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        
        // display the result
        if (isPalindrome) {
            resultLabel.setText("The binary representation of " + input + " is a palindrome!");
        } else {
            resultLabel.setText("The binary representation of " + input + " is not a palindrome.");
        }
    }
    
    public static void main(String[] args) {
        palindrome_UI app = new palindrome_UI();
        app.setVisible(true);
    }
}
