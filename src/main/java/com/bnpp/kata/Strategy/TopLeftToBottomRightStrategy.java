package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public class TopLeftToBottomRightStrategy implements PlayStrategy {

	@Override
	public boolean matches(TicTacToe game) {
		int numOfMatches = 0;
		for (int i = 0; i < game.getBoard().getSize(); i++) {
			if (game.getBoard().getGrid()[i][i] == 'X') {
				numOfMatches++;
			}
		}
		return numOfMatches == game.getBoard().getSize();
	}
}
