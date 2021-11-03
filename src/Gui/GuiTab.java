package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.sun.jdi.Location;



public class GuiTab extends JPanel {
	String url = ""; 
	GuiScreen viewPanel; 
	public JTextField locationInput = new JTextField("search Url", 40);
	public GuiTab() {
		url= "http:\\google.com" ; 
		viewPanel = new GuiScreen(url, locationInput) ; 
	}
	public GuiTab(String url) {
		this.url = url ; 
		viewPanel = new GuiScreen(this.url, locationInput) ; 
	}
	public void startTab() {
			      this.setLayout(new BorderLayout());
			       
			      
			      this.add(viewPanel,BorderLayout.CENTER);
			      
			      JToolBar toolbar = new JToolBar();
			      toolbar.setFloatable(false);
			      this.add(toolbar,BorderLayout.NORTH);
			      
			     
			      locationInput.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						if(e.getKeyCode() ==  KeyEvent.VK_ENTER) {
							String search = locationInput.getText(); 
							loadView(search);
							
						}
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
			      addIconButton("search.png", goButton, 25, 20);
			     
			      goButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String search = locationInput.getText(); 
						loadView(search);
					}
				});
			      
			      
			      JButton btn_back = new JButton("");
			      toolbar.add(btn_back);
			      addIconButton("iconBack1.jpg", btn_back, 25,20);
				
			      btn_back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						viewPanel.backHandle();
					}
				});
			      JButton btn_forward = new JButton("");
			      toolbar.add(btn_forward);
			      addIconButton("iconForward.jpg", btn_forward, 25, 20);
			     
			      
			      btn_forward.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						viewPanel.forwardHandle();
					}
				});
			      JButton btn_reload = new JButton(""); 
			      toolbar.add(btn_reload); 
			      addIconButton("iconReload.jpg", btn_reload, 25, 20);
			      btn_reload.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						viewPanel.reLoad();
					}
				});
		
			      toolbar.add( new JLabel(" Location: "));
			      toolbar.add(locationInput);
			      toolbar.addSeparator(new Dimension(5,0));
			      toolbar.add(goButton);
	}
	public void loadView(String search) {
		
//  	  	HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://daotao.vku.udn.vn/"))
//                .GET()
//                .build();
//		
//		try {
//			HttpResponse<String> response = client.send(request,
//			                HttpResponse.BodyHandlers.ofString());
//			viewPanel.loadViewToContent(response.body()) ; 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		if(search.contains("https://") || search.contains("http://"))
			viewPanel.loadViewToURL(search);
		
		else if(checkUrl(search)) {
			viewPanel.loadViewToURL("http://" + search) ; 
		}else {
       	 	String location ="https://www.google.com.ar/search?q="+search.replace(" ", "+");

			viewPanel.loadViewToURL(location);
		}
		// load input search 
		//locationInput.setText(viewPanel.getUrl()); 
		viewPanel.getHistory() ; 
	}
	
	// check url contain .com or .vn or ...
	public boolean checkUrl(String s) {
		int len = s.length(); 
		if(s.indexOf(".com") == (len - 4) || s.indexOf(".vn") == (len -3)){
			return true ; 
		}
		return false; 
	}
	
	// set icon cho button
	public void addIconButton(String path_image, JButton btn, int width, int height) {
		  try {
				
				BufferedImage bufferImage = ImageIO.read(new File(path_image));
				Icon icon1 = new ImageIcon(bufferImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
				btn.setIcon(icon1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Tab");
		frame.setLayout(new BorderLayout()) ; 
		GuiTab tab = new GuiTab() ; 
		
		frame.add(tab, BorderLayout.CENTER); 
		tab.startTab();
		frame.setSize(600, 300);
		frame.setVisible(true) ; 
		
		
		
	}

	
	
}
