package com.interview.Thread;

class FriendFix {
	private String name;
	private static final Object lock = new Object();

	public FriendFix(String name) {
		this.name = name;
	}

	public void passRacket(FriendFix friend) {
		synchronized (lock) {
			System.out.println(this.name + " passes the racket to " + friend.name);
			friend.takeRacket();
		}
	}

	public void takeRacket() {
		synchronized (lock) {
			System.out.println(this.name + " takes the racket.");
		}
	}
}

public class ProgramToFixDeadLock {

	public static void main(String[] args) {

		FriendFix alice = new FriendFix("Alice");
		FriendFix bob = new FriendFix("Bob");

		// Thread 1
		new Thread(() -> {
			alice.passRacket(bob);
		}).start();

		// Thread 2
		new Thread(() -> {
			bob.passRacket(alice);
		}).start();
	}

	// TODO Auto-generated method stub

}
