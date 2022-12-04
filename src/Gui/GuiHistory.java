package Gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;

import Class.Packet;
import Class.handleFile;

import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.JList;

public class GuiHistory extends JPanel{
	JList list ; 
	private Vector<Packet> listData = new Vector<Packet>();
	GuiTabs guiTabs;
	/**
	 * Create the panel.
	 */
	public GuiHistory(GuiTabs guiTabs) {
		setLayout(new BorderLayout(0, 0));
		this.guiTabs = guiTabs; 
		JLabel lblNewLabel = new JLabel("History");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		list = new JList(listData);
		listData.add(new Packet("phan","https://github.com/phanvan2/UDP_MailServer/blob/master/src/Gui/GuiClient.java",  "phjfl")); 

		JScrollPane scroll  = new JScrollPane(list);
		list.updateUI();
		list.setCellRenderer(new CustomCell());
		list.addMouseListener(MouseClickList());
		InitGui(); 
		
		scroll.setPreferredSize(getPreferredSize());
		scroll.createVerticalScrollBar();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll, BorderLayout.CENTER);

	}
	public void InitGui() {
		listData.removeAllElements();
		Vector<Packet> packet1 = new handleFile().parseFile("Db\\history.txt"); 
//		packet1.add(new Packet("Hello", "bbyeyb", "oke bro")) ; 
		if(packet1 != null) {
			listData.addAll(packet1);
			list.updateUI();
		}

	}
	public static void main(String[] args) {
//		JFrame a = new JFrame() ; 
//		a.add(new GuiHistory());
//		a.setSize(400, 400);
//
//		a.setVisible(true);
	}
	public MouseListener MouseClickList() {
		return new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JList theList = (JList) e.getSource(); 

				int index = theList.locationToIndex(e.getPoint()); 
				Packet packetSelect = (Packet)theList.getModel().getElementAt(index);
				System.out.println("phan van "+ packetSelect.getUrl());
				guiTabs.addNewTab(packetSelect.getUrl()); 
				
				
				
			}
		};
	}
}

 class CustomCell implements ListCellRenderer{
	boolean ok = true ;
	int index1 = -1; 
	@Override
	public JPanel getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
		// TODO Auto-generated method stub
		GuiPacket panel = new GuiPacket((Packet)value);
		if(isSelected) {
			panel.setColor(Color.gray);

		}
		return panel;

	}
	
	
	
}
