package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.IDN;
import java.net.URL;
import java.net.URI; 
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;



public class GuiMain extends JFrame {

	private JPanel contentPane;

    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain frame = new GuiMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiMain() {
		setTitle("webBrowser");
		JTabbedPane tabbedPane = new GuiTabs().createJTabbedPane(); 
		
	     
	      setBackground(Color.BLACK);
	      getContentPane().setLayout(new BorderLayout(1,1));
			
			try {// set icon giao dien---------------------------
				Image iconmes = ImageIO.read(new File("log.png"));
				this.setIconImage(iconmes); 
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			
			}
			

	      getContentPane().add(tabbedPane, BorderLayout.CENTER);

	     

	      setSize(900,700);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setLocation( (screenSize.width - getWidth())/2,
	            (screenSize.height - getHeight())/2 );
	      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      setVisible(true);
	     
	}
  
	   
}
