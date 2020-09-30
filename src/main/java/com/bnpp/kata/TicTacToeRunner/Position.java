package com.bnpp.kata.TicTacToeRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position {
	public static final int DIM = 3;
	public static final int SIZE = DIM*DIM;
	private static final char EMPTY = ' ';
	public char turn;
	public char[] board;
	private Map<Integer, Integer> cache = new HashMap<Integer,Integer>();

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

	public int minimax() {
		Integer key = code();
		Integer value = cache.get(key);
		if(value != null ) return value;
		if(isWinFor('x')) return blanks();
		if(isWinFor('o')) return -blanks();
		if(blanks() == 0) return 0;
		List<Integer> list = new ArrayList<>();
		for(Integer idx : possibleMoves()) {
			list.add(move(idx).minimax());	
			unmove(idx);
		}
		value = turn == 'x' ? Collections.max(list) : Collections.min(list) ;
		cache.put(key, value);
		return value;
	}

	private int code() {
		int value = 0;
		for(int i= 0; i < SIZE ; i++) {
			value = value * 3;
			if(board[i] == 'x')
				value += 1;
			else if(board[i] == 'o')
				value += 2;
		}
		return value;
	}

	public int blanks() {
		int total =0;
		for(int i=0; i < SIZE ; i++) {
			if(board[i] == ' ')
				total++;
		}
		return total;	
	}
}
