import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurriculumManager implements ActionListener {
    private static String name;
    JFrame loginFrame = new JFrame();
    JButton enterButton = new JButton("Enter");
    JButton resetButton = new JButton("Reset");
    JTextField userField = new JTextField();
    JLabel userLabel = new JLabel("Name: ");
    JLabel label = new JLabel();
    JLabel messageLabel = new JLabel();
    JPanel login = new JPanel();
    ImageIcon logo = new ImageIcon("CurriculumManager.png");
    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JButton option1 = new JButton("Show Subjects by Term");
    JButton option2 = new JButton("Show Subjects with Grades");
    JButton option3 = new JButton("Enter Grades");
    JButton option4 = new JButton("Edit Courses");
    JButton option5 = new JButton("Quit");

    public static void main(String[] args) {
        CurriculumManager program;
        try {
            program = new CurriculumManager();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        LoginPage();
    }
    
    public void LoginPage() {

        label.setBounds(50, 15, 1000, 80);
        label.setIcon(logo);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userLabel.setBounds(50, 125, 75, 30);
        userLabel.setForeground(Color.WHITE);
        userField.setBounds(125, 125, 200, 30);

        enterButton.setBounds(125, 170, 90, 25);
        enterButton.setFocusable(false);
        enterButton.addActionListener(this);
        enterButton.setBackground(new Color(103,177,215));
        enterButton.setOpaque(true);
        enterButton.setBorder(BorderFactory.createEtchedBorder());
        enterButton.setBorder(new LineBorder(new Color(53,103,128)));

        resetButton.setBounds(235, 170, 90, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(103,177,215));
        resetButton.setOpaque(true);
        resetButton.setBorder(BorderFactory.createEtchedBorder());
        resetButton.setBorder(new LineBorder(new Color(53,103,128)));


        login.setBounds(40,100,330,350);
        login.setBackground(new Color(51,49,49));

        loginFrame.add(label);
        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(enterButton);
        loginFrame.add(resetButton);
        loginFrame.add(login);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(420, 350);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    public void CurriculumManagerUI(){

        mainPanel.setLayout(new GridLayout(6,2));

        JLabel welcomeLabel = new JLabel("Welcome " + name + "!");
        JLabel label1 = new JLabel("What will you be doing today ?");
        JPanel header = new JPanel();
        header.setBounds(0,0,1000,177);
        header.setBackground(new Color(33,92,151));


        welcomeLabel.setBounds(20,25,750,100);
        welcomeLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,65));
        welcomeLabel.setForeground(Color.WHITE);
        label1.setBounds(20,115,500,25);
        label1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        label1.setForeground(Color.WHITE);

        option1.setBounds(0,175,250,95);
        option1.setFocusable(false);

        //TODO: Call subjects service in actionListener
        //
        option1.addActionListener(this);

        option2.setBounds(0,264,250,95);
        option2.setFocusable(false);
        option2.addActionListener(this);

        option3.setBounds(0,353,250,95);
        option3.setFocusable(false);
        option3.addActionListener(this);

        option4.setBounds(0,442,250,95);
        option4.setFocusable(false);
        option4.addActionListener(this);

        option5.setBounds(0,531,250,95);
        option5.setFocusable(false);
        option5.addActionListener(this);

        mainFrame.add(option1);
        mainFrame.add(option2);
        mainFrame.add(option3);
        mainFrame.add(option4);
        mainFrame.add(option5);

        mainFrame.add(mainPanel);
        mainFrame.add(welcomeLabel);
        mainFrame.add(label1);
        mainFrame.add(header);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Curriculum Manager");
        mainFrame.setSize(1000,650);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setBackground(new Color(212,220,228));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userField.setText("");
        }
        if (e.getSource() == enterButton) {
            if(userField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"You need to input a name.");
            } else {
                name = userField.getText();
                loginFrame.dispose();
                CurriculumManagerUI();
            }
        }
        if(e.getSource() == option5) {
            int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?", "Quit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                System.exit(0);
            } else if (result == JOptionPane.NO_OPTION) {
                CurriculumManagerUI();
            }
        }
    }
}
