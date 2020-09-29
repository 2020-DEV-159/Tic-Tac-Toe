package com.bnpp.kata.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import com.bnpp.kata.exception.InvalidGridSizeException;
import com.bnpp.kata.exception.InvalidPositionException;
import com.bnpp.kata.exception.SpotUnavailableException;
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

	@Test
	public void givenACertainMovesPlayerXONoWinners() {

		assertThat(ticTacToe.play(1, 1), CoreMatchers.is(GameResult.NO_WINNER)); // X is NOT the WINNER
	}

	@Test
	public void givenACertainMovesPlayerXONoWinner() {

		assertThat(ticTacToe.play(1, 1), CoreMatchers.is(GameResult.NO_WINNER)); // X is NOT the WINNER
		assertThat(ticTacToe.play(1, 2), CoreMatchers.is(GameResult.NO_WINNER)); // O is NOT the WINNER
		assertThat(ticTacToe.play(2, 1), CoreMatchers.is(GameResult.NO_WINNER)); // X is NOT the WINNER
		assertThat(ticTacToe.play(2, 2), CoreMatchers.is(GameResult.NO_WINNER)); // O is NOT the WINNER
		assertThat(ticTacToe.play(3, 3), CoreMatchers.is(GameResult.NO_WINNER)); // X is NOT the WINNER
		assertThat(ticTacToe.play(3, 1), CoreMatchers.is(GameResult.NO_WINNER)); // O is NOT the WINNER
	}

	@Test
	public void givenXHasPlayedAllHorizontalLinesPlayerXIsTheWinner() {

		ticTacToe.play(3, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(3, 2); // X
		ticTacToe.play(2, 2); // O

		assertThat(ticTacToe.play(3, 3), CoreMatchers.is(GameResult.WINNER)); // X is the WINNER
	}

	@Test
	public void givenXHasPlayedAllHorizontalLinesPlayerOIsTheWinner() {

		ticTacToe.play(3, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(3, 2); // X
		ticTacToe.play(2, 2); // O

		assertThat(ticTacToe.play(3, 3), CoreMatchers.is(GameResult.WINNER)); // O is the WINNER
	}

	@Test
	public void givenAColumnIsOutsideOfBoardWhenRuntimeExceptionIsThrown() {

		assertThatThrownBy(() -> ticTacToe.play(2, 5)).isInstanceOf(InvalidPositionException.class);
	}

	@Test
	public void givenAPlayrSpotIsOccupiedRuntimeExceptionIsThrown() {

		ticTacToe.play(2, 2);

		assertThatThrownBy(() -> ticTacToe.play(2, 2)).isInstanceOf(SpotUnavailableException.class);
	}

	@Test
	public void givenXHasPlayedAllVerticalLinesPlayerXIsTheWinner() {

		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 3); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 3); // O

		assertThat(ticTacToe.play(3, 1), CoreMatchers.is(GameResult.WINNER)); // X is the WINNER
	}
}