package Gui;

import java.awt.Color;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 

public class GuiTabs extends JFrame {
    JTabbedPane tabbedPane;
    int numTabs;
 
    public GuiTabs() {
       
    }
 

    /** create JTabbedPane contain 2 tab */
    public JTabbedPane createJTabbedPane() {
        /* create JTabbedPane */
        tabbedPane = new JTabbedPane(JTabbedPane.TOP,
                JTabbedPane.SCROLL_TAB_LAYOUT);
 
      
        /* add first tab */
        tabbedPane.add(createJPanel(), "Tab " + String.valueOf(numTabs),
                numTabs++);
        tabbedPane.setTabComponentAt(0, new CustomTab(this));
 
        /* add tab to add new tab when click */
      
        tabbedPane.add(new JPanel(), "+", numTabs++);
 
        tabbedPane.addChangeListener(changeListener);
        return tabbedPane; 
    }
 
    /** create JPanel contain a JLabel */
    private JPanel createJPanel() {
    	GuiTab panel = new GuiTab(); 
    	panel.startTab();
        return panel;
    }
    /** create JPanel contain a JLabel */
    public JPanel createJPanel(String url) {
    	System.out.println("oke bro ");
    	GuiTab panel = new GuiTab(url); 
    	panel.startTab();
        return panel;
    }
    private JPanel createTabHistory() {
    	GuiHistory panel = new GuiHistory(this);  
//    	panel.startTab();
        return panel;
    }
 
    ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            addNewTab();
        }
    };
 
    private void addNewTab() {
        int index = numTabs - 1;
        if (tabbedPane.getSelectedIndex() == index) { /* if click new tab */
            /* add new tab */
            tabbedPane.add(createJPanel(), "Tab " + String.valueOf(index),
                    index);
            /* set tab is custom tab */
            tabbedPane.setTabComponentAt(index, new CustomTab(this));
            tabbedPane.removeChangeListener(changeListener);
            tabbedPane.setSelectedIndex(index);
            tabbedPane.addChangeListener(changeListener);
            numTabs++;
        }
    }
    public void addNewTab(String url) {
    	System.out.println("Xin chào mợi người ");
        int index = numTabs - 1;
//        if (tabbedPane.getSelectedIndex() == index) { /* if click new tab */
            /* add new tab */
            tabbedPane.add(createJPanel(url), "Tab " + String.valueOf(index),
                    index);
            /* set tab is custom tab */
            tabbedPane.setTabComponentAt(index, new CustomTab(this));
            tabbedPane.removeChangeListener(changeListener);
            tabbedPane.setSelectedIndex(index);
            tabbedPane.addChangeListener(changeListener);
            numTabs++;
//        }
    }
    public void addTabHistory() {
    	
        	int index = numTabs - 1;
       
            /* add new tab */
            tabbedPane.add(createTabHistory(), "History " ,
                    index);
            /* set tab is custom tab */
            tabbedPane.setTabComponentAt(index, new CustomTab(this));
            tabbedPane.removeChangeListener(changeListener);
            tabbedPane.setSelectedIndex(index);
            tabbedPane.addChangeListener(changeListener);
            numTabs++;
     
    } 
    public void removeTab(int index) {
        tabbedPane.remove(index);
        numTabs--;
 
        if (index == numTabs - 1 && index > 0) {
            tabbedPane.setSelectedIndex(numTabs - 2);
        } else {
            tabbedPane.setSelectedIndex(index);
        }
 
        if (numTabs == 1) {
            addNewTab();
        }
    }
 
    public static void main(String[] args) {
        new GuiTabs();
    }
}