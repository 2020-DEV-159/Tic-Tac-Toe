package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TicTacToeTest {
	TicTacToe ticTacToe = new TicTacToe();

	@Test
	public void givenFirstTurnPlayerItShouldBeX() {

		assertThat(ticTacToe.nextPlayer(), CoreMatchers.is('X'));
	}

	@Test
	public void givenSecondTurnPlayerItShouldBePlayerY() {

		ticTacToe.play(2, 2); // X

		assertThat(ticTacToe.nextPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void givenSecondRoundPlayerItShouldBePlayerX() {

		ticTacToe.play(1, 1); // X

		assertThat(ticTacToe.firstPlayer(), CoreMatchers.is('X'));
	}

	@Test
	public void givenSecondRoundPlayerItShouldBePlayerI() {

		ticTacToe.secondRoundPlay(1, 1); // X

		assertThat(ticTacToe.firstPlayer(), CoreMatchers.is('X'));
	}

	@Test
	public void givenSecondRoundPlayerItShouldBePlayerII() {

		ticTacToe.secondRoundPlay(2, 2); // O

		assertThat(ticTacToe.SecondPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void givenSecondRoundPlayerItShouldBePlayerXANDY() {

		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 2); // O

		assertThat(ticTacToe.nextPlayer(), CoreMatchers.is('X'));
	}
}