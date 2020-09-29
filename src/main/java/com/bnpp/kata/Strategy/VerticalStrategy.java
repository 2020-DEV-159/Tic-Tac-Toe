package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public class VerticalStrategy implements PlayStrategy {

	@Override
	public boolean matches(TicTacToe game) {
		return false;
	}
}
