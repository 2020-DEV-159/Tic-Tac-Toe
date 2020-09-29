package com.bnpp.kata.game;

import com.bnpp.kata.Strategy.HorizontalStrategy;
import com.bnpp.kata.exception.InvalidPositionException;

public class TicTacToe {
	private char lastPlayer;
	private final Board board;
	private static final char EMPTY = ' ';

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
		checkPosition(row);
		checkPosition(column);
		lastPlayer = nextPlayer();
		assignSpot(row, column, lastPlayer);
		return getPlayResult();
	}

	private GameResult getPlayResult() {
		if (new HorizontalStrategy().matches(this)) {
			return GameResult.WINNER;
		}
		return GameResult.NO_WINNER;
	}

	private void checkPosition(int position) {
		if (position < 1 || position > board.getSize())
			throw new InvalidPositionException("The position player is invalid!");
	}

	private void assignSpot(int row, int column, char player) {
		if (board.getGrid()[row - 1][column - 1] == EMPTY) {
			board.getGrid()[row - 1][column - 1] = player;
		}
	}

	public Board getBoard() {
		return board;
	}

	public char getLastPlayer() {
		return lastPlayer;
	}
}