package com.bnpp.kata.game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bnpp.kata.TicTacToeRunner.Position;

public class PositionTest {

	@Test
	public void givenFirstPlayerPosition() throws Exception {

		Position position = new Position();

		assertEquals('X',position.turn);
		assertEquals("         ", position.toString());
	}

	@Test
	public void givenPlayerMovePosition() throws Exception {

		Position position = new Position().move(1);	

		assertEquals('O',position.turn);
		assertEquals(" X       ", position.toString());
	}

	@Test
	public void givenPlayerUnmovePosition() throws Exception {
		
		Position position = new Position().move(1).unmove(1);
		
		assertEquals('X',position.turn);
		assertEquals("         ", position.toString());
	}
}

