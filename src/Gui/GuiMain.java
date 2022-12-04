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


/**
 * 
 * @author phanvan2
 * @github https://github.com/phanvan2
 *
 */


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
		setTitle("wBrowser");
		GuiTabs guitab  = new GuiTabs() ; 
		JTabbedPane tabbedPane = guitab.createJTabbedPane(); 
		
	     
	      //setBackground(Color.RED);
	      getContentPane().setLayout(new BorderLayout(1,1));
			
			try {// set icon giao dien---------------------------
				Image iconmes = ImageIO.read(new File("1.png"));
				this.setIconImage(iconmes); 
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			
			}
			
		JButton btn1 = new JButton("History") ; 
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubƯ
				
				System.out.print("hello") ; 
				guitab.addTabHistory() ; 
			}
		});
		getContentPane().add(btn1, BorderLayout.NORTH); 
	      getContentPane().add(tabbedPane, BorderLayout.CENTER);

	     

	      setSize(900,700);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setLocation( (screenSize.width - getWidth())/2,
	            (screenSize.height - getHeight())/2 );
	      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      setVisible(true);
	     
	}
  
	   
}
