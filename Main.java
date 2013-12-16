Enter file contents herepackage nl.retronet.tuts

import javax.swing.*;
import java.awt.*;

public class Main extends Canvas implements Runnable{
	/*
	*Wees zeker dat je de Eclipse IDE gebruikt voor dieper uitkijk
	*/
	
	//grijpt de venster eigenschappen en ze worden doorgegeven in de createJFrame method
	public static String title;
	public static final int WIDTH;
	public static final int HEIGHT;
	
	//een boolean om te beslissen of je game loopt of niet
	public boolean isRunning = false;
	
	//Je maakt een Object van thread om de gameloop te starten
	private Thread thread;
	
	//lege constructor
	public Main(){
		//defineert de thread object om een Thread te worden (ps de this argument in thread houd de instance van thread dus waar je Runnable erbij haalt)
		thread = new Thread(this);
		thread.start();
	}
	
	//de start method wordt geroepen als de venster is gecreeérd
	public static void start(){
		if(isRunning)
			break;
			
		isRunning = true;
	}
	
	//een method om de game stoppen(allen als het een applet is)
	public static void stop(){
		if(!isRunning) 
			break;
			
			isRunning = false;
	}
	
	// een method dat elke milliseconden geroept wordt
	public void run(){
	
		//de game loop dus zolang isRunning true is doe wat er hier staat
		while(isRunning){
			
		
		}
	
	
	}
	
	//main method
	public static void main(String[] arg0){
		System.out.println("HelloWorld");
		
		//het roept de createJFrame method
		createJFrame(800, 600, "Frame");
	}
	
	public static void creatJFrame(int width, int height, String title){
		//geef de argumenten in de brackets van createJFrame aan de variablelen die we boven hebben gemaakt
		this.WIDTH = width;
		this.HEIGHT = height;
		this.title = title;
		
		//je maakt en defineert de JFrame dat is java's hulpclass voor ven=sters
		JFrame frame = new JFrame();
		
		/*geeft eigenschappen en andere info aan JFrame om een venster aan te maken*/
		frame.setResizable(false);
		frame.pack();
		frame.setTitle(title);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//roept de start method
		start();
}
