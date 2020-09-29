package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void givenFirstTurnPlayerItShouldBeX() {

		TicTacToe ticTacToe = new TicTacToe();

		assertThat(ticTacToe.firstPlayer(), CoreMatchers.is('X'));
	}

	@Test
	public void givenSecondTurnPlayerItShouldBePlayerY() {

		TicTacToe ticTacToe = new TicTacToe();

		ticTacToe.play(2, 2); // X

		assertThat(ticTacToe.SecondPlayer() ,CoreMatchers.is('O'));
	}
}