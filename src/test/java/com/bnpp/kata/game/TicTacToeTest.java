package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TicTacToeTest {
	
	@Test
	public void givenFirstTurnPlayerItShouldBeX() {

		TicTacToe ticTacToe = new TicTacToe();

		assertThat(ticTacToe.nextPlayer(), CoreMatchers.is('X'));
	}
}