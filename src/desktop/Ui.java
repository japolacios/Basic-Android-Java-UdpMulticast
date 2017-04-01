package desktop;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Ui {
	
	//Atributes
	private PApplet app;
	private int stage,alpha, score;
	private boolean reached,gameStarted;
	private PFont mainFont;
	
	
	//PImages
	PImage logo,background,duck,cursor;
	
	//Contructor
	public Ui(PApplet _app){
		System.out.println("Initializing UI");
		app = _app;
		System.out.println("Papplet Loaded On Ui");
		
		//Initializing Functions for Class
		init();
	}
	
	
	public void init(){
		loadAssets();
		loadFonts();
		stage = 0;
		
		//Initialize setting for intro animation
		alpha = 0;
		reached = false;
		
		//GameControl(stage start)
		gameStarted = false;
		
	}
	
	private void loadAssets(){
		
		logo = app.loadImage("./assets/logo.png");
		background = app.loadImage("./assets/background.png");
		duck = app.loadImage("./assets/duck.png");
		cursor = app.loadImage("./assets/aim.png");
		System.out.println("Assets Loaded to UI");
		
		
		
		
		
	
	}
	
	private void loadFonts(){
		mainFont = app.createFont("./assets/font.ttf", 32);
		app.textFont(mainFont);
		app.textAlign(app.CENTER,app.CENTER);
		System.out.println("Font Loaded");
	}
	
	//-----------------------------------------------------------------------------
	//Animations
	
	//Intro Animation
	private void intro(){
		app.imageMode(app.CENTER);
		app.tint(255, alpha);  // Apply transparency without changing color
		app.image(logo, app.width/2, app.height/2);
		if(alpha <= 255){
		alpha = alpha + 3;
		}
		if(alpha >= 255 && reached == false){
			reached = true;
		}
		if(reached == true){
			alpha = alpha - 10;
			if(alpha <= 0){
				stage = 1;
				alpha = 0;
				reached = false;
			}
		}
		
		
	}

	//GamePlayInitialAnimation
	private void introGame(){
		app.imageMode(app.CENTER);
		app.tint(255, alpha);  // Apply transparency without changing color
		app.image(background, app.width/2, app.height/2);
		app.image(cursor, app.mouseX, app.mouseY);
		if(alpha <= 255){
		alpha = alpha + 3;
		}
		if(alpha >= 255 && reached == false){
			reached = true;
				stage = 2;
				alpha = 0;
				reached = false;
		}
		
	}
	
	private void paintBasicAssets(){
		app.image(background, app.width/2, app.height/2);
		app.image(cursor, app.mouseX, app.mouseY);
		app.fill(229,189,19);
		app.text("Score "+score, app.width - 100, 50);
	}

	
	//----------------------------------------------------------------------------
	//Paints
	
	//MainPaintMethod
	public void paint(){
		if(stage == 0){
			intro();
		}
		if(stage == 1){
			//Makes the Intro for the gamePlay
				introGame();	
		}
		if(stage ==2){
			paintBasicAssets();
		}
	}
	
	public void paintDuck(float _x, float _y){
		app.image(duck, _x, _y);
	}
	
	//---------------------------------------------------------------------------
	//Set's
	public void setStage(int _stage){
		stage = _stage;
		System.out.println("Stage set to "+ stage);
	}
	
	public void setScore(int _score){
		score = _score;
	}
	
	
	//---------------------------------------------------------------------------
	//Getters
	
	public int getStage(){
		return stage;
	}
	
	public int getScore(){
		return score;
	}
}
