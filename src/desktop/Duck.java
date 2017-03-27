package desktop;

import processing.core.PApplet;
import processing.core.PVector;

public class Duck {

	//Atributes
	private PVector position,speed;
	private PApplet app;
	
	//Constructor
	public Duck(PApplet _app){
	app = _app;
	position = new PVector(app.random(400,800), 850);
	speed= new PVector(app.random(-10,10),app.random(-18,-12));
		
	}
	
	public void move(){
		position.add(speed);
	}
	
	public float getX(){
		return position.x;
	}
	
	public float getY(){
		return position.y;
	}
}
