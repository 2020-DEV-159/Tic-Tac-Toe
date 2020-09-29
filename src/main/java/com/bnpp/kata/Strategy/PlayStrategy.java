package com.bnpp.kata.Strategy;

import com.bnpp.kata.game.TicTacToe;

public interface PlayStrategy {

	boolean matches(TicTacToe game);
}
