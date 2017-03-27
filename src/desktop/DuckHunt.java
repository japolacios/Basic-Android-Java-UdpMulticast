package desktop;

import processing.core.PApplet;


//Taller 2 - Programacion en Redes - 2017-1
//DuckHunt
//------------------------------------------------------------------------------------


//Contructor
public class DuckHunt extends PApplet{
	

	//Relations
	private Logic logic;

	//Canvas Size
	private int canvasWidth = 1200;
	private int canvasHeight = 800;

	//Main Class to Run
	public static void main(String[] args) {
		PApplet.main("desktop.DuckHunt");
	}
	
	
	public void settings(){
		size(canvasWidth, canvasHeight);
		
	}
	
	public void setup(){
		 logic = new Logic(this);
		 noCursor();
	}
	
	public void draw(){
		background(19,99,170);
		logic.paint();
	}
	
	
	//-------------------------------------------------------------------------------------
	//Interaction
	
	public void mousePressed(){
		logic.click();
	}
	
	
}
