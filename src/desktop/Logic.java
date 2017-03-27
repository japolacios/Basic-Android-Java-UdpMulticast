package desktop;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import communication.CommunicationManager;
import communication.ContentMessage;
import communication.Empezar;
import processing.core.PApplet;

public class Logic implements Observer{

	// Atributes
	private	PApplet app;
	private boolean iniciar;
	
	// Relations
	private Ui ui;
	private CommunicationManager com;
	
	
	//Collections
	private ArrayList<Duck> ducks;

	// Constructor
	public Logic(PApplet _app) {
		app = _app;
		init();
	}

	// Initialize other Clases and Atributes
	private void init() {
		
		iniciar = false;
		
		//Create UI
		ui = new Ui(app);
		
		//Create Communication
		com = new CommunicationManager();
		com.addObserver(this);
		
		//Start Communication Thread
		new Thread(com).start();
		
		ducks = new ArrayList<Duck>();

	}

	// Add a Duck
	public void addDuck() {
		Duck tempDuck = new Duck(app);
		ducks.add(tempDuck);
		System.out.println("New Duck Added");
	}
	
	//Random to add Duck

	// Call the paint ducks from the UI
	public void addRandomDuck(){
		float probabilty = app.random(0,10000);
		if(probabilty >= 9980){
			addDuck();
		}
	}
	
	// Paint Method
	public void paint() {
		ui.paint();

		if (ui.getStage() == 2) {
			addRandomDuck();
			if (!ducks.isEmpty() && ducks != null) {
				for (int i = 0; i < ducks.size(); i++) {
					ducks.get(i).move();
					ui.paintDuck(ducks.get(i).getX(), ducks.get(i).getY());
				}
			}
		}

	}
	
	//------------------------------------------------------------------------------------------------------------
	public void click(){
		System.out.println("Click");
		if (ui.getStage() == 2) {
			if (!ducks.isEmpty() && ducks != null) {
				for (int i = 0; i < ducks.size(); i++) {
					if (app.dist(app.mouseX, app.mouseY,ducks.get(i).getX(), ducks.get(i).getY()) <= 50){
						System.out.println("Kill");
						ui.setScore(ui.getScore()+1);
						ducks.remove(i);
					}
				}
			}
		}
	}

	
	//-----------------------------------------------------------------------------------------------------------------
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof Empezar){
			iniciar = true;
		}
		
		if (arg instanceof ContentMessage) {
			ContentMessage message = (ContentMessage) arg;
			//System.out.println("Content received from " + message.getSender());
			if (com.getIdentifier() == message.getReceiver()) {
				
				//Check case for chars -> 'admin' case
				switch (com.getIdentifier()) {
				//When im 1
				case 1:
					if (message.getSender() == 2) {
						
					}
					
					
					break;
					//When im 2
				case 2:
					if (message.getSender() == 1) {
						
					}
					if (message.getSender() == 3) {
						
						
					}
					break;
					//When im 3
				case 3:
					if (message.getSender() == 2) {
						
							
					}
					break;
				default:
					break;
				}
			}
		}
		
		//End of Update
	}
	
	//End of Class
}
