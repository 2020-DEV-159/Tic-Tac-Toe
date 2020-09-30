package com.bnpp.kata.TicTacToeRunner;

public class Position {
	public static final int DIM = 3;
	public static final int SIZE = DIM*DIM;
	public char turn;
	public char[] board;

	public Position() {
		turn = 'X';
		board = new char[SIZE];
		for(int i=0; i < SIZE ; i++) {
			board[i] = ' ';	
		}
	}

	public Position(String string, char c) {
		this.board =string.toCharArray();
		this.turn = turn;
	}

	@Override
	public String toString() {
		return new String(board);
	}

	public Position move(int idx) {
		board[idx] = turn;
		turn = turn == 'X' ? 'O' : 'X';
		return this;
	}

	public Position unmove(int idx) {
		board[idx] = ' ';
		turn = turn == 'X' ? 'O' : 'X';
		return this;
	}
}
