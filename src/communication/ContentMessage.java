package communication;


import java.awt.Color;
import java.io.Serializable;

public class ContentMessage implements Serializable{
	/**
	 * Sender's ID
	 */
	private int sender;
	/**
	 * Receiver's ID
	 */
	private int receiver;
	private int x;
	private int y;
	private Color color;
	private int type;
	
	public ContentMessage(int _sender, int _receiver, int _x, int _y, Color _color, int _type) {
		sender = _sender;
		receiver = _receiver;
		x=_x;
		y=_y;
		color = _color;
		type = _type;
	}

	public int getSender() {
		return sender;
	}
	
	public int getReceiver() {
		return receiver;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getType(){
		return type;
	}
	
}
