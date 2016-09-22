/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayplanner;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;


/**
 *
 * @author Kabir
 */
public class DayPlannerGUI extends JFrame {
    
    private JPanel welcomePanel;
    private JPanel addPanel;
    private JPanel searchPanel;
    private JLabel welcomeLabel1;
    private JLabel welcomeLabel2;
    private JLabel addLabel;
    private JLabel typeLabel;
    private JLabel titleLabel;
    private JLabel stLabel;
    private JLabel etLabel;
    private JLabel locationLabel;
    private JLabel commentLabel;
    private JTextField titleField = new JTextField(13);
    private JTextField stField = new JTextField(15);
    private JTextField etField = new JTextField(15);
    private JTextField locationField = new JTextField(13);
    private JTextField commentField = new JTextField(13);
    private JTextArea messagesArea = new JTextArea(10, 40);
    private JTextArea searchArea = new JTextArea(10,40);
            
    private final DayPlanner DayPlans = new DayPlanner();
    private final Time times = new Time();
    private final Time timeNeg = new Time();
    private boolean checkTime;
    private boolean checkTime2;
    private boolean checkTimeNeg1;
    private boolean checkTimeNeg2;
    // Drop down list of types (home, school, and other)
    private String[] typeStrings = { "home", "school", "other"};
    private JComboBox typeList = new JComboBox(typeStrings);
    
    
    public DayPlannerGUI() {
        super("Day Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        
        JMenu commandsMenu = new JMenu("Commands");
        JMenu helpMenu = new JMenu("Help");
        
        getContentPane().setBackground(Color.GRAY);
        
        // Creating menu bar and menu choices
        JMenuBar bar = new JMenuBar( );
        bar.add(commandsMenu);
        bar.add(helpMenu);
        setJMenuBar(bar);
        
        JMenuItem addActivities = new JMenuItem("Add");
        JMenuItem searchActivities = new JMenuItem("Search");
        JMenuItem aboutActivities = new JMenuItem("About");
        
        commandsMenu.add(addActivities);
        commandsMenu.add(searchActivities);
        helpMenu.add(aboutActivities);
        
        // Creating Welcome Panel
        
        welcomeLabel1 = new JLabel("Welcome to the Day Planner.");
        welcomeLabel2 = new JLabel("Choose a command from the 'Commands' menu");

        setSize(485,525);
        
        welcomePanel = new JPanel( );
        welcomePanel.setBackground(Color.LIGHT_GRAY);
        welcomePanel.setLayout(new GridBagLayout());
        g.gridx = 0;
        g.gridy = 0;
        
        g.anchor = GridBagConstraints.NORTHWEST;
        welcomePanel.add(welcomeLabel1, g);
        g.gridy = 1;
        welcomePanel.add(welcomeLabel2, g);
        
        welcomePanel.setPreferredSize(new Dimension(300,75));
        g.weightx = 0;
        g.weighty = 0;
        add(welcomePanel, g);
        
        // Creating Add Panel
        addPanel = new JPanel( );
        
        // Creating Search Panel
        searchPanel = new JPanel( );
        
        // When user clicks on ADD
        addActivities.addActionListener(new addActivitiesListener( ));
        commandsMenu.add(addActivities);
        
        //When user clicks on SEARCH
        searchActivities.addActionListener(new searchActivitiesListener( ));
        commandsMenu.add(searchActivities);
        
        //When user clicks on ABOUT
        aboutActivities.addActionListener(new aboutListener( ));
        helpMenu.add(aboutActivities);
        
        
    }
    
    private class addActivitiesListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
               
        {
            // Creating labels
            addLabel = new JLabel("Adding an activity:");
            typeLabel = new JLabel("Type:");
            titleLabel = new JLabel("Title:");
            stLabel = new JLabel("Starting time (year, month, day, hour, minute):");
            etLabel = new JLabel("Ending time (year, month, day, hour, minute):");
            locationLabel = new JLabel("Location:");
            commentLabel = new JLabel("Comment:");
            
            addPanel.removeAll();
            searchPanel.removeAll();
            // Creating Add Panels
            addPanel = new JPanel( );
            addPanel.setBackground(Color.LIGHT_GRAY);
            
            addPanel.setLayout(new GridBagLayout());
            
            GridBagConstraints k = new GridBagConstraints();
            addPanel.setVisible(true);
            searchPanel.setVisible(false);
            welcomePanel.setVisible(false);
            
            k.weighty = 1;
            k.weightx = 1;
            k.anchor = GridBagConstraints.NORTHWEST;
            add(addPanel, k);
            
            // Addding all to panel
            k.insets = new Insets(5, 5, 5, 5);
            k.weighty = 0;
            k.weightx = 0;
            
            addPanel.add(addLabel, k);
            
            //k.insets = new Insets(10, 10, 0, 5);
            k.gridy = 1;
            addPanel.add(typeLabel, k);
            
            k.gridy = 2;
            addPanel.add(titleLabel, k);
            
            k.gridy = 3;
            k.gridwidth = 2;
            addPanel.add(stLabel, k);
            
            k.gridy = 5;
            addPanel.add(etLabel, k);
            
            k.gridy = 7;
            addPanel.add(locationLabel, k);
            
            k.gridy = 8;
            addPanel.add(commentLabel, k);
            
            k.gridx = 1;
            k.gridy = 1;
            
            typeList.setSelectedIndex(1);
            addPanel.add(typeList, k);
            
            locationLabel.setVisible(false);
            commentLabel.setVisible(false);
            locationField.setVisible(false);
            commentField.setVisible(false);
            
            typeList.addActionListener (new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    if (typeList.getSelectedItem().equals("other"))
                    {
                        locationLabel.setVisible(true);
                        commentLabel.setVisible(true);
                        locationField.setVisible(true);
                        commentField.setVisible(true);

                    } else if(typeList.getSelectedItem().equals("school") || typeList.getSelectedItem().equals("home"))
                    {
                        locationLabel.setVisible(false);
                        commentLabel.setVisible(false);
                        locationField.setVisible(false);
                        commentField.setVisible(false);
                    }
                }
            });
            
            k.gridx = 1;
            k.gridy = 2;
            //k.fill = GridBagConstraints.HORIZONTAL;
            addPanel.add(titleField, k);
            
            k.gridx = 0;
            k.gridy = 4;
            k.gridwidth = 2;
            addPanel.add(stField, k);
            
            k.gridx = 0;
            k.gridy = 6;
            addPanel.add(etField, k);
            
            k.gridx = 1;
            k.gridy = 7;
            
            addPanel.add(locationField, k);
            
            k.gridx = 1;
            k.gridy = 8;
            addPanel.add(commentField, k);
            
            // Messages Text Area Field
            k.gridx = 0;
            k.gridy = 9;
            
            messagesArea.setEditable(false);
            // Adding scrollbar
            JScrollPane scroll = new JScrollPane(messagesArea);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            k.gridwidth = 3;
            addPanel.add(scroll, k);
            
            // Creating Reset Button
            
            k.gridx = 2;
            k.gridy = 2;
            k.fill = GridBagConstraints.NONE;
            k.anchor = GridBagConstraints.CENTER;
            JButton ResetButton = new JButton("Reset");
            ResetButton.addActionListener(new ResetListener( ));
            addPanel.add(ResetButton, k);
            
            // Creating Enter Button
            k.gridx = 2;
            k.gridy = 7;
            JButton EnterButton = new JButton("Enter");
            EnterButton.addActionListener(new addEnterListener( ));
            addPanel.add(EnterButton, k);
            
        }
    }
    
    private class searchActivitiesListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            // Creating labels
            addLabel = new JLabel("Searching an activity:");
            typeLabel = new JLabel("Type:");
            titleLabel = new JLabel("Title:");
            stLabel = new JLabel("Starting time (year, month, day, hour, minute):");
            etLabel = new JLabel("Ending time (year, month, day, hour, minute):");
            locationLabel = new JLabel("Location:");
            commentLabel = new JLabel("Comment:");
            
            addPanel.removeAll();
            searchPanel.removeAll();
            // Creating Search Panel
            searchPanel = new JPanel( );
            searchPanel.setBackground(Color.LIGHT_GRAY);
            searchPanel.setLayout(new GridBagLayout());
            
            GridBagConstraints k = new GridBagConstraints();
            searchPanel.setVisible(true);
            addPanel.setVisible(false);
            welcomePanel.setVisible(false);
            
            k.weighty = 1;
            k.weightx = 1;
            k.anchor = GridBagConstraints.NORTHWEST;
            add(searchPanel, k);
            
            // Addding all to panel
            k.insets = new Insets(5, 5, 5, 5);
            k.weighty = 0;
            k.weightx = 0;
            searchPanel.add(addLabel, k);
            
            //k.insets = new Insets(10, 10, 0, 5);
            k.gridy = 1;
            searchPanel.add(typeLabel, k);
            
            k.gridy = 2;
            searchPanel.add(titleLabel, k);
            
            k.gridy = 3;
            k.gridwidth = 2;
            searchPanel.add(stLabel, k);
            
            k.gridy = 5;
            searchPanel.add(etLabel, k);
            
            k.gridy = 7;
            searchPanel.add(locationLabel, k);
            
            k.gridy = 8;
            searchPanel.add(commentLabel, k);
            
            k.gridx = 1;
            k.gridy = 1;
            
            typeList.setSelectedIndex(1);
            searchPanel.add(typeList, k);
            
            locationLabel.setVisible(false);
            commentLabel.setVisible(false);
            locationField.setVisible(false);
            commentField.setVisible(false);
            
            typeList.addActionListener (new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    if (typeList.getSelectedItem().equals("other"))
                    {
                        locationLabel.setVisible(true);
                        commentLabel.setVisible(true);
                        locationField.setVisible(true);
                        commentField.setVisible(true);

                    } else if(typeList.getSelectedItem().equals("school") || typeList.getSelectedItem().equals("home"))
                    {
                        locationLabel.setVisible(false);
                        commentLabel.setVisible(false);
                        locationField.setVisible(false);
                        commentField.setVisible(false);
                    }
                }
            });
            
            k.gridx = 1;
            k.gridy = 2;
            //k.fill = GridBagConstraints.HORIZONTAL;
            searchPanel.add(titleField, k);
            
            k.gridx = 0;
            k.gridy = 4;
            k.gridwidth = 2;
            searchPanel.add(stField, k);
            
            k.gridx = 0;
            k.gridy = 6;
            searchPanel.add(etField, k);
            
            k.gridx = 1;
            k.gridy = 7;
            
            searchPanel.add(locationField, k);
            
            k.gridx = 1;
            k.gridy = 8;
            searchPanel.add(commentField, k);
            
            // Search Text Area Field
            k.gridx = 0;
            k.gridy = 9;
            
            searchArea.setEditable(false);
            // Adding scrollbar
            JScrollPane scroll = new JScrollPane(searchArea);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            k.gridwidth = 3;
            searchPanel.add(scroll, k);
            
            // Creating Reset Button
            
            k.gridx = 2;
            k.gridy = 2;
            k.fill = GridBagConstraints.NONE;
            k.anchor = GridBagConstraints.CENTER;
            JButton ResetButton = new JButton("Reset");
            ResetButton.addActionListener(new ResetListener( ));
            searchPanel.add(ResetButton, k);
            
            // Creating Enter Button
            k.gridx = 2;
            k.gridy = 7;
            JButton EnterButton = new JButton("Enter");
            EnterButton.addActionListener(new searchEnterListener( ));
            searchPanel.add(EnterButton, k);
        }
    }
    
    private class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Setting text field to blank
            titleField.setText("");
            stField.setText("");
            etField.setText("");
            locationField.setText("");
            commentField.setText("");
            messagesArea.setText("");
            searchArea.setText("");
        }
        
    }
    
    private class addEnterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Checking if time is correct
            checkTime = times.checkDate(stField.getText());
            checkTime2 = times.checkDate(etField.getText());
            checkTimeNeg1 = timeNeg.TimeNeg(stField.getText());
            checkTimeNeg2 = timeNeg.TimeNeg(etField.getText());
            
            if(checkTime == true && checkTime2 == true )
            {
                DayPlans.add2(typeList.getSelectedItem().toString(), stField.getText(), etField.getText(), titleField.getText(), commentField.getText(), locationField.getText());
                if(typeList.getSelectedItem().toString().equals("other")){
                    messagesArea.setText("Type: " + typeList.getSelectedItem().toString() + "\nTitle: " + titleField.getText() + "\nStart Time: " + 
                        stField.getText() + "\nEnd Time: " + etField.getText() + "\nLocation: " + locationField.getText() + "\nComment: " + commentField.getText() + "\n");
                }else{
                    messagesArea.setText("Type: " + typeList.getSelectedItem().toString() + "\nTitle: " + titleField.getText() + "\nStart Time: " + 
                        stField.getText() + "\nEnd Time: " + etField.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null,"Enter correct time format");
            }
            
            //Checking if time is negative
            checkTimeNeg1 = timeNeg.TimeNeg(stField.getText());
            checkTimeNeg2 = timeNeg.TimeNeg(etField.getText());
            if(checkTimeNeg1 == false || checkTimeNeg2 == false)
            {
                JOptionPane.showMessageDialog(null,"Enter correct time format. Remember to enter non-negative values");
            }
        }
    }
    
    private class searchEnterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DayPlans.search(typeList.getSelectedItem().toString(), stField.getText(), etField.getText(), titleField.getText(), commentField.getText(), locationField.getText());
            searchArea.setText("Type: " + typeList.getSelectedItem().toString() + "\nTitle: " + titleField.getText() + "\nStart Time: " + 
                    stField.getText() + "\nEnd Time: " + etField.getText() + "\nLocation: " + locationField.getText() + "\nComment: " + commentField.getText() + "\n");
        }
        
    }
    
    private class aboutListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null,"Made by Kabir Singh");
        }
    }
}