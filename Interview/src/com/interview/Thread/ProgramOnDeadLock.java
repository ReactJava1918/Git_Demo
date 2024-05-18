package com.interview.Thread;

class Friend {
	private String name;

	public Friend(String name) {
		this.name = name;
	}

	public synchronized void passRacket(Friend friend) {
		System.out.println(this.name + " passes the racket to " + friend.name);
		friend.takeRacket();
	}

	public synchronized void takeRacket() {
		System.out.println(this.name + " takes the racket.");
	}
}

public class ProgramOnDeadLock {

	public static void main(String[] args) {
		Friend alice = new Friend("Alice");
		Friend bob = new Friend("Bob");

		// Thread 1
		new Thread(() -> {
			alice.passRacket(bob);
		}).start();

		// Thread 2
		new Thread(() -> {
			bob.passRacket(alice);
		}).start();
	}
}
