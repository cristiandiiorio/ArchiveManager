package programpackage;

import java.awt.BorderLayout;
import javax.swing.*;

public class MainWindow {

    FileHandler fileHandler = new FileHandler(null);
    
    JMenuBar menuBar = new JMenuBar();
    JButton listSeries = new JButton("List");
    JButton add = new JButton("Add");
    JButton change = new JButton("Change");
    JButton delete = new JButton("Delete");
    JButton settings =new JButton("Settings");
    
    JPanel topPanel = new JPanel();
    JLabel cercaLabel = new JLabel("Searching for:");
    JTextField cercaField = new JTextField(20);
    JButton cerca = new JButton("Search");
    JButton cercaFieldReset = new JButton("⌫");
    
    JPanel midPanel = new JPanel();
    JTextArea mainArea = new JTextArea(25,45);	
    JScrollPane mainScrollPane = new JScrollPane(mainArea);
	
    
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
    
    JDialog dialog1Mod = new JDialog();
    JPanel dialog1ModPane = new JPanel();
    JLabel nameLabel1Mod = new JLabel("Series' name: ");
    JTextField nameField1Mod = new JTextField("",20);
    JButton okButton1Mod = new JButton("Ok");
    JButton exitButton1Mod = new JButton("Cancel");
    
    JDialog dialog3Mod = new JDialog();
    JPanel dialog3ModPane = new JPanel();
    JLabel nameLabel3Mod = new JLabel("Series' status: ");
    JButton downloadedButtonMod = new JButton("Downloaded");
    JButton notDownloadedButtonMod = new JButton("Not Downloaded");
    
    JDialog deleteDialog = new JDialog();
    JPanel deleteDialogPane = new JPanel();
    JLabel deleteDialogNameLabel = new JLabel("Series' name: ");
    JTextField deleteDialogNameField = new JTextField("",20);
    JButton deleteDialogOkButton = new JButton("Delete");
    JButton deleteDialogCancelButton = new JButton("Cancel");
    
    JMenu dropdown = new JMenu("Settings");
    JButton lightButton = new JButton("Light theme");
    JButton darkButton = new JButton("Dark theme");
    JButton aboutButton = new JButton("About");
    
    JFrame mainFrame;
	public MainWindow() {
            
            mainFrame = new JFrame();
         
            acListener ac = new acListener(this);
            
            dialogListener1 dg1 = new dialogListener1(this);
            dialogListener2 dg2 = new dialogListener2(this);
            dialogListener3 dg3 = new dialogListener3(this);
            
            dialogListener1Mod dg1M = new dialogListener1Mod(this);
            dialogListener3Mod dg3M = new dialogListener3Mod(this);
            
            deleteListener dl = new deleteListener(this);
            
            setupMenuButton(add, ac);
            setupMenuButton(change, ac);
            setupMenuButton(listSeries, ac);
            setupMenuButton(settings , ac);
            setupMenuButton(delete, ac);
            
            menuBar.add(listSeries);
            menuBar.add(add);
            menuBar.add(change);
            menuBar.add(delete);
            menuBar.add(dropdown);
            
            dropdown.add(lightButton);
            dropdown.add(darkButton);
            dropdown.add(aboutButton);
            setupMenuButton(lightButton, ac);
            setupMenuButton(darkButton, ac);
            setupMenuButton(aboutButton, ac);
            
            //LIGHT AND DARK THEME SETUP
            String theme = null;
            theme = fileHandler.readTheme();
            if(theme.equals("light")){
                lightButton.setEnabled(false);
                darkButton.setEnabled(true);
            }
            else if(theme.equals("dark")){
                lightButton.setEnabled(true);
                darkButton.setEnabled(false);
            }
            
            setupMainDisplay(ac);
            
            setupAddDialog(dg1,dg2,dg3);
            
            setupChangeDialog(dg1M, dg3M);
            
            deleteDialog.setSize(250, 120);
            deleteDialog.setLocationRelativeTo(null);

            deleteDialog.add(deleteDialogNameLabel,BorderLayout.NORTH);
            deleteDialog.add(deleteDialogNameField,BorderLayout.CENTER);
            deleteDialog.add(deleteDialogPane, BorderLayout.SOUTH);
            deleteDialogPane.add(deleteDialogOkButton,BorderLayout.WEST);
            deleteDialogPane.add(deleteDialogCancelButton,BorderLayout.EAST);
            
            deleteDialogOkButton.addActionListener(dl);
            deleteDialogCancelButton.addActionListener(dl);
            
            
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
        
        public void setupMainDisplay(acListener ac){
            topPanel.add(cercaLabel);
            topPanel.add(cercaField);
            topPanel.add(cerca);
            topPanel.add(cercaFieldReset);
            cerca.addActionListener(ac);
            cercaFieldReset.addActionListener(ac);

            midPanel.add(mainScrollPane);
            mainArea.setEditable(false);
            mainScrollPane.setBorder(BorderFactory.createTitledBorder("Results"));
        }
        
        public void setupAddDialog(dialogListener1 dg1, dialogListener2 dg2, dialogListener3 dg3){
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
        }
        
        public void setupChangeDialog(dialogListener1Mod dg1M, dialogListener3Mod dg3M){
            dialog1Mod.setSize(250, 120);
            dialog1Mod.setLocationRelativeTo(null);

            dialog1Mod.add(nameLabel1Mod,BorderLayout.NORTH);
            dialog1Mod.add(nameField1Mod,BorderLayout.CENTER);
            dialog1Mod.add(dialog1ModPane, BorderLayout.SOUTH);
            dialog1ModPane.add(okButton1Mod,BorderLayout.WEST);
            dialog1ModPane.add(exitButton1Mod,BorderLayout.EAST);
            
            okButton1Mod.addActionListener(dg1M);
            exitButton1Mod.addActionListener(dg1M);
            
            dialog3Mod.setSize(250, 120);
            dialog3Mod.setLocationRelativeTo(null);

            dialog3Mod.add(nameLabel3Mod,BorderLayout.CENTER);
            dialog3Mod.add(dialog3ModPane, BorderLayout.SOUTH);
            dialog3ModPane.add(downloadedButtonMod,BorderLayout.WEST);
            dialog3ModPane.add(notDownloadedButtonMod,BorderLayout.EAST);
            
            downloadedButtonMod.addActionListener(dg3M);
            notDownloadedButtonMod.addActionListener(dg3M);
            nameLabel3Mod.setHorizontalAlignment(JLabel.CENTER);
            nameLabel3Mod.setVerticalAlignment(JLabel.CENTER);
        }
        
}
