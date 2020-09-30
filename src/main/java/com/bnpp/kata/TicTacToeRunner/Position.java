package com.bnpp.kata.TicTacToeRunner;

import java.util.ArrayList;
import java.util.List;

public class Position {
	public static final int DIM = 3;
	public static final int SIZE = DIM*DIM;
	private static final char EMPTY = ' ';
	public char turn;
	public char[] board;

	public Position() {
		turn = 'X';
		board = new char[SIZE];
		for(int i=0; i < SIZE ; i++) {
			board[i] = EMPTY;	
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
		board[idx] = EMPTY;
		turn = turn == 'X' ? 'O' : 'X';
		return this;
	}

	public List<Integer> possibleMoves() {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i < board.length ; i++) {
			if(board[i] == EMPTY )
				list.add(i);	
		}
		return list;
	}

	public boolean isWinFor(char turn) {
		boolean isWin =false;
		for(int i=0; i < SIZE ; i+=DIM) {
			isWin =isWin || lineMatch(turn, i, i + DIM, 1);

		}
		for(int i=0; i < DIM ; i++) {
			isWin =isWin || lineMatch(turn, i, SIZE, DIM);

		}
		isWin = isWin || lineMatch(turn, 0, SIZE, DIM+1);
		isWin = isWin || lineMatch(turn, DIM-1, SIZE-1, DIM-1);
		return isWin;
	}

	private boolean lineMatch(char turn, int start, int end, int step) {
		for(int i=start; i < end ; i+=step) {
			if(board[i] != turn )
				return false;	
		}
		return true;
	}
}
