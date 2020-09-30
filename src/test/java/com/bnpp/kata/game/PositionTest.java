package com.bnpp.kata.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
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

	@Test
	public void givenPossibleMoves() throws Exception {

		List<Integer> list = new ArrayList<>();	
		for(int i=0; i < Position.SIZE ; i++) {
			list.add(i);	
		}
		list.remove(new Integer(1));
		list.remove(new Integer(2));	

		assertEquals(list, new Position().move(1).move(2).possibleMoves());
	}

	@Test
	public void givenPlayerIsWinFor() throws Exception {

		assertFalse(new Position().isWinFor('x'));	
		assertTrue(new Position("xxx    " , 'x').isWinFor('x'));
		assertTrue(new Position(
				"x  "
						+ "x  "
						+ "x  " , 'x').isWinFor('x'));
		assertTrue(new Position(
				"o  "
						+ " o "
						+ "  o" , 'x').isWinFor('o'));
		assertTrue(new Position(
				"  o"
						+ " o "
						+ "o  " , 'x').isWinFor('o'));
	}
	
	@Test
	public void givenPossibleMinimax() throws Exception {
		
		assertEquals( 6, new Position("xxx      ", 'x').minimax());
		assertEquals(-6, new Position("ooo      ", 'o').minimax());
		assertEquals( 0, new Position("xoxxoxoxo", 'x').minimax());
		assertEquals( 6, new Position("xxx       ", 'x').minimax());
		assertEquals(-6, new Position("ooo       ", 'o').minimax());
		assertEquals( 0, new Position().minimax());
	}
}

