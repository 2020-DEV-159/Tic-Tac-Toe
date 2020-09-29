package com.bnpp.kata.game;

import com.bnpp.kata.Strategy.BottomLeftToTopRightStrategy;
import com.bnpp.kata.Strategy.HorizontalStrategy;
import com.bnpp.kata.Strategy.TopLeftToBottomRightStrategy;
import com.bnpp.kata.Strategy.VerticalStrategy;
import com.bnpp.kata.exception.InvalidPositionException;
import com.bnpp.kata.exception.SpotUnavailableException;

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
		if (new HorizontalStrategy().matches(this)
				|| new VerticalStrategy().matches(this)
				|| new TopLeftToBottomRightStrategy().matches(this)
				|| new BottomLeftToTopRightStrategy().matches(this)){
			return GameResult.WINNER;
		}
		if (isDraw()) {
			return GameResult.DRAW;
		}
		return GameResult.NO_WINNER;
	}

	private boolean isDraw() {
		return false;
	}
	
	private void checkPosition(int position) {
		if (position < 1 || position > board.getSize())
			throw new InvalidPositionException("The position player is invalid!");
	}

	private void assignSpot(int row, int column, char player) {
		if (board.getGrid()[row - 1][column - 1] == EMPTY) {
			board.getGrid()[row - 1][column - 1] = player;
		}
		else {
			throw new SpotUnavailableException("This spot has already been taken");
		}
	}

	public Board getBoard() {
		return board;
	}

	public char getLastPlayer() {
		return lastPlayer;
	}
}