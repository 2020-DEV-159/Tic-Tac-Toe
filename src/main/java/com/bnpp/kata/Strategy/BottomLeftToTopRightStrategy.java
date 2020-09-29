package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public class BottomLeftToTopRightStrategy implements PlayStrategy {

	@Override
	public boolean matches(TicTacToe game) {
		return false;
	}
}
