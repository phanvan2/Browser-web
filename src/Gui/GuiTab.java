package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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


public class GuiTab extends JPanel {
	String url = ""; 
	GuiScreen viewPanel; 
	
	public GuiTab() {
		url= "http:\\google.com" ; 
		viewPanel = new GuiScreen(url) ; 
	}
	public GuiTab(String url) {
		this.url = url ; 
		viewPanel = new GuiScreen(this.url) ; 
	}
	public void startTab() {
			      this.setLayout(new BorderLayout());
			       
			      
			      this.add(viewPanel,BorderLayout.CENTER);
			      
			      JToolBar toolbar = new JToolBar();
			      toolbar.setFloatable(false);
			      this.add(toolbar,BorderLayout.NORTH);
			      
			      JTextField locationInput = new JTextField("search Url", 40);
			      
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
				      
			      goButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String search = locationInput.getText(); 
						loadView(search);
					}
				});
			      JButton btn_back = new JButton("back");
			      toolbar.add(btn_back);
			      btn_back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						viewPanel.backHistory();
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
		else if(search.contains(" ")) {
       	 	String location ="https://www.google.com.ar/search?q="+search.replace(" ", "+");

			viewPanel.loadViewToURL(location);
		}else {
			viewPanel.loadViewToURL("http://" + search) ; 
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
