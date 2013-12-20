package nl.retronet.tuts;

import javax.swing.*;

import java.awt.*;

//een waarschuwing supressor negeert onnodige waarschuwingen die java geeft
@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{
	/*
	*Wees zeker dat je de Eclipse IDE gebruikt voor dieper uitkijk
	*/
	
	//grijpt de venster eigenschappen en ze worden doorgegeven in de createJFrame method
	public String title;
	public int width;
	public int height;
	
	//een boolean om te beslissen of je game loopt of niet
	public boolean isRunning = false;
	
	//Je maakt een Object van thread om de gameloop te starten
	private Thread thread;
	
	//lege constructor
	public Game(){
		//het roept de createJFrame method
		createJFrame(800, 600, "Frame");
		
		//defineert de thread object om een Thread te worden (ps de this argument in thread houd de instance van thread dus waar je Runnable erbij haalt)
		thread = new Thread(this);
		thread.start();
	}
	
	//de start method wordt geroepen als de venster is gecreeÃ©rd
	public void start(){
		if(isRunning)
			return;
			
		isRunning = true;
		System.out.println("Game loopt");
	}
	
	//een method om de game stoppen(allen als het een applet is)
	public void stop(){
		if(!isRunning) 
			return;
			
			isRunning = false;
	}
	
	// een method dat elke milliseconden geroept wordt
	public void run(){
		//de game loop dus zolang isRunning true is doe wat er hier staat
		while(isRunning){
			//roept de render en update methods die we gaan gebruiken voor de Game(momenteel leeg)
			update();
			render();
		}
	
	
	}
	
	public void render() {
		
	}

	public void update() {
		
	}

	//main method
	public static void main(String[] arg0){
		System.out.println("Game Booted!");
		
		//roept de constructor van Game.java
		new Game();
	}
	
	public void createJFrame(int width, int height, String title){
		//geef de argumenten in de brackets van createJFrame aan de variablelen die we boven hebben gemaakt
		this.width = width;
		this.height = height;
		this.title = title;
		System.out.println("eigenschappen gekregen");
		
		//je maakt en defineert de JFrame dat is java's hulpclass voor ven=sters
		JFrame frame = new JFrame();
		
		/*geeft eigenschappen en andere info aan JFrame om een venster aan te maken*/
		frame.setResizable(false);
		frame.pack();
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		System.out.println("Venster Gecreeérd");
		
		//roept de start method
		start();
	}
}
