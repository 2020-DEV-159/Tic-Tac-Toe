package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public class BottomLeftToTopRightStrategy implements PlayStrategy {
	
	@Override
	public boolean matches(TicTacToe game) {
		int numOfMatches = 0;
		int column = 0;
		for (int row = (game.getBoard().getSize() - 1); row >= 0; row--) {
			if (game.getBoard().getGrid()[row][column] == game.getLastPlayer()) {
				numOfMatches++;
			}
			column++;
		}
		return numOfMatches == game.getBoard().getSize();
	}
}
