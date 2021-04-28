package chat.with.bot;

public class User {

	private String userName;
	private String receivedMessage;
	
	public User(String userName) {
		this.userName = userName;
	}
	
	public void receiveMessage(String message) {
		receivedMessage = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReceivedMessage() {
		return receivedMessage;
	}

	public void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}
	
	
}
