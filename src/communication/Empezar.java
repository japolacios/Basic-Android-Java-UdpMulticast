package communication;
import java.io.Serializable;

public class Empezar implements Serializable{
	
	/**
	 * Sender's ID
	 */
	private int sender;
	/**
	 * Receiver's ID
	 */
	private int receiver;
	public Empezar(int _sender, int _receiver){
		sender = _sender;
		receiver = _receiver;
	}
	
	public int getSender() {
		return sender;
	}
	
	public int getReceiver() {
		return receiver;
	}
}
