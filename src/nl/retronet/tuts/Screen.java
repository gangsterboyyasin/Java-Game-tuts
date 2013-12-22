package nl.retronet.tuts;

public class Screen {
	
	private int width, height;
	public int[] pixels;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void render(){
		//een dubelle for loop om de x en Y coordinaten te krijgen
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				//note de x en y coords is waar op het scherm wordt getekenddus je kan de x of y vervangen om alleen een plek  of meer te kleuren
				pixels[x + y * width] = 0x00ffff;/**dit is hex code voor kleuren als je html kan ken je dit waarschijnlijk wel behalve dat het inplaats van een # er 0x moet komen*/
			}
		}
	}
}
