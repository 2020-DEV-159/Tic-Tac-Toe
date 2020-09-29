package com.bnpp.kata.game;

public class TicTacToe {
	private char lastPlayer;

	public char firstPlayer() {
		return 'X' ;
	}

	public char SecondPlayer() {
		return 'O';
	}

	public void play(int row, int column) {
		lastPlayer = SecondPlayer();
	}
}