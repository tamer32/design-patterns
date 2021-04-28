package chat.with.bot;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

import java.util.ArrayList;

public class ChatRoom {
	private List<User> users = new ArrayList<>();
	private Bot bot;
	private Scanner scanner = new Scanner(System.in);
	private User loggedUser = null;
	
	public ChatRoom() {
		User user1 = new User("Gosho");
		User user2 = new User("Kiro");
		User user3 = new User("Pesho");
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	public void sendMessage(User sentFrom, String message) {
		System.out.println(String.format("User %s sent: %s", sentFrom.getUserName(), message));
		if(message.equalsIgnoreCase("addBot")) {
			bot = Bot.getInstance();
		}else if(nonNull(bot) && bot.shouldKickUser(message)) {
			users = users.stream().filter(user -> !user.equals(sentFrom)).collect(Collectors.toList());
			loggedUser = null;
			System.out.println(String.format("The user %s was kicked because he used cat! This word is forbiden", sentFrom.getUserName()));
			return;
		}
		users.forEach(user -> System.out.println(user.getUserName() + " received: " + message));
	}
	
	public void login() {
	if(Objects.isNull(loggedUser)) {
		System.out.println("Please login to the chatroom");
		System.out.println("Username: ");
		 String username = scanner.nextLine(); 
		 loggedUser = users.stream().filter(user -> user.getUserName().equals(username)).findFirst().orElse(null);
		 if(loggedUser == null) {
			 System.out.println("There is no such user in the chatroom! Please try again");
			 login();
		 }
		 System.out.println("You have successfully logged as " + username);
	}
	
	 System.out.println("Sent a message for others to see!");
	 sendMessage(loggedUser, scanner.nextLine());
	 System.out.println("Do you want to send another message?");
	 if(scanner.nextLine().equalsIgnoreCase("Yes")) {
		 login();
	 }
	 System.out.println("Thanks for using this app! See ya around ^^");
	}

	public List<User> getUsers() {
		return users;
	}
	
}
