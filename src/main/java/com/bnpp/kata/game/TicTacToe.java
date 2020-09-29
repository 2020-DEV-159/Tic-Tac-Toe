package com.bnpp.kata.game;

import com.bnpp.kata.Strategy.PlayStrategy;

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

	public void secondRoundPlay(int row, int column) {
		lastPlayer = SecondPlayer();
	}

	public GameResult play(int row, int column) {
		lastPlayer = nextPlayer();
		return getPlayResult();
	}

	private GameResult getPlayResult() {
		if (PlayStrategy.matches(this)) {
			return GameResult.WINNER;
		}
		return GameResult.NO_WINNER;
	}
}