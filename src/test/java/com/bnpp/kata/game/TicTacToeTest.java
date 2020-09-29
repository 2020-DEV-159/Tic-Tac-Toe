package com.bnpp.kata.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import com.bnpp.kata.exception.InvalidGridSizeException;
import static org.junit.Assert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
	private TicTacToe ticTacToe;

	@Before
	public void setUp() {
		ticTacToe = new TicTacToe(3);
	}

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

	@Test
	public void givenAnInvalidGridSizeNewTicTacToeInvalidGridSizeExceptionIsThrown() {

		assertThatThrownBy(() -> new TicTacToe(2)).isInstanceOf(InvalidGridSizeException.class);
	}
}