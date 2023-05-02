import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGUI extends JFrame implements ActionListener, KeyListener {
    private JPanel mainPanel;
    private JTextField billField;
    private JTextField tipField;
    private JTextField pplField;
    private JButton billDecButton;
    private JButton tipDecButton;
    private JButton pplDecButton;
    private JButton billIncButton;
    private JButton tipIncButton;
    private JButton pplIncButton;
    private JLabel billLabel;
    private JLabel tipLabel;
    private JLabel pplLabel;
    private JLabel resTipLabel;
    private JLabel resTotalLabel;

    private TipCalculator calculator;

    public MainGUI() {
        this.calculator = new TipCalculator(0, 0, 0);
        createUIComponents();
        createActionListeners();
    }

    public void createUIComponents() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tip Calculator GUI");
        setSize(800, 300);
        setVisible(true);

        billField.setText("0");
        tipField.setText("0");
        pplField.setText("0");
    }

    public void createActionListeners() {
        tipIncButton.addActionListener(this);
        tipDecButton.addActionListener(this);
        pplIncButton.addActionListener(this);
        pplDecButton.addActionListener(this);

        billField.addKeyListener(this);
        tipField.addKeyListener(this);
        pplField.addKeyListener(this);
    }

    public void calculateResults() {
        calculator.setBill(Double.parseDouble(billField.getText()));
        calculator.setTipPercentage(Integer.parseInt(tipField.getText()));
        calculator.setNumberOfPeople(Integer.parseInt(pplField.getText()));
        resTipLabel.setText(String.format("Tip: %.2f (%.2f each)", calculator.calculateTip(), calculator.tipPerPerson()));
        resTotalLabel.setText(String.format("Total: %.2f (%.2f each)", calculator.totalBill(), calculator.totalPerPerson()));
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if (button.equals(tipIncButton)) {
            int currTip = Integer.parseInt(tipField.getText());
            int newTip = currTip + 5;
            tipField.setText("" + newTip);
        } else if (button.equals(tipDecButton)) {
            int currTip = Integer.parseInt(tipField.getText());
            int newTip = currTip - 5;
            tipField.setText("" + newTip);
        } else if (button.equals(pplIncButton)) {
            int currPpl = Integer.parseInt(pplField.getText());
            int newPpl = currPpl + 1;
            pplField.setText("" + newPpl);
        } else if (button.equals(pplDecButton)) {
            int currPpl = Integer.parseInt(pplField.getText());
            int newPpl = currPpl - 1;
            pplField.setText("" + newPpl);
        }

        calculateResults();
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {
        calculateResults();
    }
}