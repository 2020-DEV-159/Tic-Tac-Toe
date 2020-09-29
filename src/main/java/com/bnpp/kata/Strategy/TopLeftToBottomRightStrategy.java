package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public class TopLeftToBottomRightStrategy implements PlayStrategy {

	@Override
	public boolean matches(TicTacToe game) {		
		return false;
	}
}
