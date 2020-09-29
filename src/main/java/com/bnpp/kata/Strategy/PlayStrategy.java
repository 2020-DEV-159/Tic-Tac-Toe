package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public interface PlayStrategy {

	static boolean matches(TicTacToe game) {
		return false;
	}
}
