import java.awt.BorderLayout;

import javax.swing.*;

public class MainWindow {

    JPanel hiPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JButton listSeries = new JButton("List");
    JButton add = new JButton("Add");
    JButton change = new JButton("Change");
    
    JPanel topPanel = new JPanel();
    JLabel cercaLabel = new JLabel("Searching for:");
    JTextField cercaField = new JTextField(20);
    JButton cerca = new JButton("Search");
    JButton cercaFieldReset = new JButton("x");
    
	
    JPanel midPanel = new JPanel();
    JTextArea mainArea = new JTextArea(25,45);	
    
    JPanel lowPanel = new JPanel();
	
	public MainWindow() {
            
            JFrame mainFrame = new JFrame("Archive Manager");
         
            acListener ac = new acListener(this);
            
            setupMenuButton(add, ac);
            setupMenuButton(change, ac);
            setupMenuButton(listSeries, ac);
            
            menuBar.add(add);
            menuBar.add(change);
            menuBar.add(listSeries);
            
            topPanel.add(cercaLabel);
            topPanel.add(cercaField);
            topPanel.add(cerca);
            topPanel.add(cercaFieldReset);
            cerca.addActionListener(ac);
            cercaFieldReset.addActionListener(ac);

            midPanel.add(mainArea);
            mainArea.setEditable(false);
            mainArea.setBorder(BorderFactory.createTitledBorder("Results"));

            
            mainFrame.setJMenuBar(menuBar);
            mainFrame.add(topPanel,BorderLayout.CENTER);
            mainFrame.add(midPanel,BorderLayout.SOUTH);

            mainFrame.pack();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
	}
        
        public void setupMenuButton(JButton button,acListener ac){
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusable(false);
            button.addActionListener(ac);
        }
}
