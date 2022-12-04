package Gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Class.Packet;

public class GuiPacket extends JPanel {
	private JPanel contentPane; 
	private JLabel lblTitle, lblurl,lblDate ; 
	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public GuiPacket(Packet packet) {
		
		this.setLayout(new BorderLayout());
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 lblTitle = new JLabel(packet.getTitle());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, BorderLayout.WEST);
		
		 lblurl = new JLabel(packet.getUrl());
		lblurl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblurl, BorderLayout.CENTER);
		
		 lblDate = new JLabel(packet.getDate());
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDate, BorderLayout.EAST);
		this.add(contentPane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void setColor(Color color) {
		 this.contentPane.setBackground(color); 
	}
	public JLabel getLblTitle() {
		return lblTitle;
	}
	public JLabel getLblurl() {
		return lblurl;
	}
	public JLabel getLblDate() {
		return lblDate;
	}
	

}
