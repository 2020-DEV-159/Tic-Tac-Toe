package com.bnpp.kata.game;

public class TicTacToe {
	private char lastPlayer;
	private final Board board;

	public TicTacToe(int boardSize) {
		board = new Board(boardSize);
	}

	public char firstPlayer() {
		return 'X' ;
	}

	public char SecondPlayer() {
		return 'O';
	}

	public char nextPlayer() {
		return lastPlayer == 'X' ? 'O' : 'X' ;
	}

	public void play(int row, int column) {
		lastPlayer = nextPlayer();
	}

	public void secondRoundPlay(int row, int column) {
		lastPlayer = SecondPlayer();
	}
}