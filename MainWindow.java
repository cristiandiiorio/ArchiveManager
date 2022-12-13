import java.awt.BorderLayout;

import javax.swing.*;

public class MainWindow {

    JPanel hiPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JButton listSeries = new JButton("List");
    JButton add = new JButton("Add");
    JButton change = new JButton("Change");
    JButton about =new JButton("About");
    
    JPanel topPanel = new JPanel();
    JLabel cercaLabel = new JLabel("Searching for:");
    JTextField cercaField = new JTextField(20);
    JButton cerca = new JButton("Search");
    JButton cercaFieldReset = new JButton("x");
    
    JPanel midPanel = new JPanel();
    JTextArea mainArea = new JTextArea(25,45);	
	
    JDialog dialog1 = new JDialog();
    JPanel dialog1Pane = new JPanel();
    JLabel nameLabel1 = new JLabel("Series' name: ");
    JTextField nameField1 = new JTextField("",20);
    JButton okButton1 = new JButton("Ok");
    JButton exitButton1 = new JButton("Cancel");
    
    JDialog dialog2 = new JDialog();
    JPanel dialog2Pane = new JPanel();
    JLabel nameLabel2 = new JLabel("Series' link: ");
    JTextField nameField2 = new JTextField("",20);
    JButton okButton2 = new JButton("Ok");
    JButton exitButton2 = new JButton("Cancel");
    
    JDialog dialog3 = new JDialog();
    JPanel dialog3Pane = new JPanel();
    JLabel nameLabel3 = new JLabel("Series' status: ");
    JButton downloadedButton = new JButton("Downloaded");
    JButton notDownloadedButton = new JButton("Not Downloaded");
    
    JFrame mainFrame;
	public MainWindow() {
            
            mainFrame = new JFrame();
         
            acListener ac = new acListener(this);
            dialogListener1 dg1 = new dialogListener1(this);
            dialogListener2 dg2 = new dialogListener2(this);
            dialogListener3 dg3 = new dialogListener3(this);
            
            
            setupMenuButton(add, ac);
            setupMenuButton(change, ac);
            setupMenuButton(listSeries, ac);
            setupMenuButton(about, ac);
            
            menuBar.add(add);
            menuBar.add(change);
            menuBar.add(listSeries);
            menuBar.add(about);
            
            topPanel.add(cercaLabel);
            topPanel.add(cercaField);
            topPanel.add(cerca);
            topPanel.add(cercaFieldReset);
            cerca.addActionListener(ac);
            cercaFieldReset.addActionListener(ac);

            midPanel.add(mainArea);
            mainArea.setEditable(false);
            mainArea.setBorder(BorderFactory.createTitledBorder("Results"));

            
            dialog1.setSize(250, 120);
            dialog1.setLocationRelativeTo(null);

            dialog1.add(nameLabel1,BorderLayout.NORTH);
            dialog1.add(nameField1,BorderLayout.CENTER);
            dialog1.add(dialog1Pane, BorderLayout.SOUTH);
            dialog1Pane.add(okButton1,BorderLayout.WEST);
            dialog1Pane.add(exitButton1,BorderLayout.EAST);
            
            okButton1.addActionListener(dg1);
            exitButton1.addActionListener(dg1);
            
            dialog2.setSize(250, 120);
            dialog2.setLocationRelativeTo(null);

            dialog2.add(nameLabel2,BorderLayout.NORTH);
            dialog2.add(nameField2,BorderLayout.CENTER);
            dialog2.add(dialog2Pane, BorderLayout.SOUTH);
            dialog2Pane.add(okButton2,BorderLayout.WEST);
            dialog2Pane.add(exitButton2,BorderLayout.EAST);
            
            okButton2.addActionListener(dg2);
            exitButton2.addActionListener(dg2);
            
            dialog3.setSize(250, 120);
            dialog3.setLocationRelativeTo(null);

            dialog3.add(nameLabel3,BorderLayout.CENTER);
            dialog3.add(dialog3Pane, BorderLayout.SOUTH);
            dialog3Pane.add(downloadedButton,BorderLayout.WEST);
            dialog3Pane.add(notDownloadedButton,BorderLayout.EAST);
            
            downloadedButton.addActionListener(dg3);
            notDownloadedButton.addActionListener(dg3);
            nameLabel3.setHorizontalAlignment(JLabel.CENTER);
            nameLabel3.setVerticalAlignment(JLabel.CENTER);
            
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
