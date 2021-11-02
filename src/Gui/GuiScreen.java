package Gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class GuiScreen extends JFXPanel {
	String url = ""; 
	String content = ""; 
	WebView view  ; 
	WebEngine webEngine; 
	public GuiScreen(String url) {
		this.url = url ; 
		this.setLayout(new BorderLayout());
		Platform.runLater(() -> {
	             view = new WebView();
	             webEngine = view.getEngine(); 
	             this.loadViewToURL(url); 
	             
	            this.setScene(new Scene(view));
	       });
	}
	public void loadViewToURL(String url) {
		Platform.runLater(() -> {
			this.webEngine.load(url);
		}); 
	}
	
	public void loadViewToContent(String content) {
		Platform.runLater(() -> {
			this.webEngine.loadContent(content,"text/html");
		}); 
	}
	public void backHistory() {
		Platform.runLater(() -> {
			this.webEngine.executeScript("history.back()");
		}); 

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Gui Screen");
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 500);
		GuiScreen guiScreen = new GuiScreen("http:\\google.com") ; 
		
		frame.add(guiScreen, BorderLayout.CENTER); 
		frame.setVisible(true);
		//guiScreen.loadViewToContent("<b> Phanvan</b>");
	
	}

}
