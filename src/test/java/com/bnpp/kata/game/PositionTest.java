package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import com.bnpp.kata.TicTacToeRunner.Position;

public class PositionTest {

	@Test
	public void givenTestNewPosition() throws Exception {
		Position position = new Position();

		assertThat(position.turn, CoreMatchers.is('X'));
	}

	@Test
	public void givenTestNewSecondPosition() throws Exception {

		Position position = new Position().move(1);	

		assertThat(position.turn, CoreMatchers.is('O'));
	}
}
