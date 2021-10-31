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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
	     
	      setBackground(Color.BLACK);
	      getContentPane().setLayout(new BorderLayout(1,1));
			
			try {// set icon giao dien---------------------------
				Image iconmes = ImageIO.read(new File("log.png"));
				this.setIconImage(iconmes); 
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			
			}
			

	      getContentPane().add(tabbedPane, BorderLayout.CENTER);
	      tabbedPane.add(newTAb(),"tab1") ; 
	      
	      JButton btnNewButton = new JButton("New Tab");
	      btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel panel1 = newTAb();
				
				tabbedPane.add(panel1, "new tab") ; 
				
			}
		});
	      getContentPane().add(btnNewButton, BorderLayout.NORTH);
//	      setContentPane(content);
	     

	      setSize(900,700);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setLocation( (screenSize.width - getWidth())/2,
	            (screenSize.height - getHeight())/2 );
	      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      setVisible(true);
	     
	}


	   
 
	   private class GoListener implements ActionListener {
	      public void actionPerformed(ActionEvent evt) {
	       
	      }
	   }
  
	   
	   /**
	    * Loads the document at the specified URL into the edit pane.
	    */
	   private void loadURL(URL url,  JEditorPane editPane) {
	   

	   }
	   public JPanel newTAb() {
		   	JPanel panelTab = new JPanel();
		      panelTab.setLayout(new BorderLayout());
		      GuiScreen viewPanel = new GuiScreen("http:\\google.com") ;  
		      
		      panelTab.add(viewPanel,BorderLayout.CENTER);
		      
		      JToolBar toolbar = new JToolBar();
		      toolbar.setFloatable(false);
		      panelTab.add(toolbar,BorderLayout.NORTH);
		      ActionListener goListener = new GoListener();
		      JTextField locationInput = new JTextField("search Url", 40);
		      locationInput.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					// TODO Auto-generated method stub
					  URL url;
				         try {
				            String location = locationInput.getText().trim();
				            if (location.length() == 0)
				               throw new Exception();
				            if(location.contains(" ")) {
				            	//String s = "https://coccoc.com/search?query=chfo%20m%E1%BB%8Di%20ng%C6%B0%E1%BB%9D"
				            	 location ="https://coccoc.com/search?query="+location.replace(" ", "%20");
				            	
				            }else if (!location.contains("://"))
				               location = "http://" + location;
				            
				            url = new URL(location);
				            System.out.println(url.toString());
				         }
				         catch (Exception e) {
				            JOptionPane.showMessageDialog(GuiMain.this, 
				                  "The Location input box does not\nccontain a legal URL.");
				            return;
				         }
				      //   loadURL(url, viewPanel);
				         locationInput.selectAll();
				         locationInput.requestFocus();
					
				}
			});
		      locationInput.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(locationInput.getText().equals("")) {
						locationInput.setText("search Url") ; 
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(locationInput.getText().equals("search Url")) {
						locationInput.setText(""); 
					}
				}
			});
		      JButton goButton = new JButton("");
		      Icon icon;
				try {
					//icon = new ImageIcon(ImageIO.read(new File("search1jpg.jpg")));
					
					
					BufferedImage bufferImage = ImageIO.read(new File("search.png"));
					icon = new ImageIcon(bufferImage.getScaledInstance(25, 20, Image.SCALE_SMOOTH));
					goButton.setIcon(icon);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			      
		      goButton.addActionListener(goListener);
		      toolbar.add( new JLabel(" Location: "));
		      toolbar.add(locationInput);
		      toolbar.addSeparator(new Dimension(5,0));
		      toolbar.add(goButton);
		    return panelTab ; 
	   }
}
