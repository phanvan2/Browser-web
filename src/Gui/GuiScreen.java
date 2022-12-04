package Gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Class.handleFile;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class GuiScreen extends JFXPanel {
	String url = ""; 
	String content = ""; 
	WebView view  ; 
	WebEngine webEngine; 
	String location = "" ; 
	JTextField locationInput ; 
	public GuiScreen(String url, JTextField locationInput) {
		this.url = url ; 
		this.locationInput = locationInput; 
		handleFile handleFile = new handleFile(); 
		
		this.setLayout(new BorderLayout());
		Platform.runLater(() -> {
	             view = new WebView();
	             webEngine = view.getEngine(); 
	             this.loadViewToURL(url);     
	             this.setScene(new Scene(view));
	             webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
	                     this.locationInput.setText(webEngine.getLocation());  

	                 if (newState == Worker.State.SUCCEEDED){
	                	 	handleFile.writeFile("Db\\history.txt", webEngine.getTitle()+ "&&&" + webEngine.getLocation() + "&&&" + getDateTime() + "\r\n");

	                 }
	             });
	             
	       });
	}
	public void loadViewToURL(String url) {
		this.url = url ; 
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
	public String getUrl() {
		System.out.println("load url");

		return (this.webEngine.getLocation()); 
		//return url; 
	}
	public void reLoad() {
		Platform.runLater(()-> {
			System.out.println("load url");

			this.webEngine.reload(); 
		});
	}
	
	
    public void backHandle(){
        if(webEngine.getHistory().getCurrentIndex()>0){
        	Platform.runLater(()-> {
    			this.webEngine.getHistory().go(-1);
    		});
        }
    }

    public void forwardHandle(){
        if (webEngine.getHistory().getCurrentIndex()+1 < webEngine.getHistory().getEntries().size()){
        	Platform.runLater(()-> {
    			this.webEngine.getHistory().go(1);
    		});
        	
        }
    }
	
	
	public void getHistory() {
		System.out.println(this.webEngine.getHistory().getEntries().toString()); 
	}
	public String getTitle() {

		return this.webEngine.getTitle() ; 
	}
	
	public String getDateTime() {
		String d = String.valueOf( java.time.LocalDate.now());
		String h = String.valueOf(java.time.LocalTime.now());
		String[] timeArr = h.split("\\.");
		System.out.print(h);
		System.out.println(timeArr.length);
		return d + " " + timeArr[0] ; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Gui Screen");
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 500);
		JTextField local = new JTextField(); 
		GuiScreen guiScreen = new GuiScreen("https://daotao.vku.udn.vn/", local) ; 
		
		frame.add(guiScreen, BorderLayout.CENTER); 
		frame.setVisible(true);
		System.out.println(guiScreen.getUrl());
		//guiScreen.loadViewToContent("<b> Phanvan</b>");
	
	}

}
