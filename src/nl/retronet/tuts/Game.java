package nl.retronet.tuts;

import javax.swing.*;

import java.awt.*;
import java.awt.image.*;

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
	
	//een Buffered image object note:(de image wordt het hele scherm van de game dus note wel daty je dit niet kan missen anders is je hele scherm wit)
	public BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);/*Argumenten = WIDTH de breedte van het scherm, HEIGHT de hoogte van het Scherm, BufferedImage.TYPE_INT_RGB kleurrijke image*/
	//een array van alle pixels op het scherm note:(een DataBufferInt houdt volgens mij een herhaalende integer array in)
	public int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();/*je zet de pixels aan met een raster van de bufferedImage en dan grijp je de data*/
	
	//Je maakt een Object van thread om de gameloop te starten
	private Thread thread;
	private Screen screen;
	
	//lege constructor
	public Game(){
		screen = new Screen(WIDTH, HEIGHT);
		
		//het roept de createJFrame method
		createJFrame(800, 600, "Frame");
		
		//defineert de thread object om een Thread te worden (ps de this argument in thread houd de instance van thread dus waar je Runnable erbij haalt)
		thread = new Thread(this);
		thread.start();
	}
	
	//de start method wordt geroepen als de venster is gecree√©rd
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
	
	//een method om de tekenen op het scherm
	public void render() {
		//maakt een BufferStrategy instance alleen in de render method
		BufferStrategy bs = getBufferStrategy();
		//een if statement om uit te zoeken of er wel een buffer startegy is anders maakt hij er 3 aan
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		//een for loop om de pixels variabel hier door te geven aan de pixels in de Screen class
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		//maakt een instance van de Java.awt Graphics class en zet het als de graphics van een BufferStartegy
		Graphics g = bs.getDrawGraphics();
		
		//tekent de BufferedImage op het scherm momenteel laaat het een leeg zwart veld
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		//roept de render method in de Screen class
		screen.render();
		
		//leegt de graphics dus laat het telkens na het tekenen van het scherm het scherm leeg
		g.dispose();
		//maakt de vvolgende buffer zichtbaar
		bs.show();
	}
	
	//een method om je game te updaten elke keer dat je game loopt
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
		
		//je maakt en defineert de JFrame dat is java's hulpclass voor vensters
		JFrame frame = new JFrame();
		
		/*geeft eigenschappen en andere info aan JFrame om een venster aan te maken*/
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		System.out.println("Venster GecreeÈrd");
		
		//roept de start method
		start();
	}
}
