package chat.with.bot;

import java.util.Objects;

public class Bot {
	private static Bot botInstance;
	
	private Bot() {
	}
	
	public static Bot getInstance() {
		if(Objects.isNull(botInstance)) {
			return new Bot();
		}
		return botInstance;
	}
	
	public boolean shouldKickUser(String message) {
		if(message.equalsIgnoreCase("cat")) {
			return true;
		}
		return false;
	}
}
