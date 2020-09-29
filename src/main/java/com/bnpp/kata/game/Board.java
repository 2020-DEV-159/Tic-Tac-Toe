package com.bnpp.kata.game;

import com.bnpp.kata.exception.InvalidGridSizeException;

public class Board {
	private final int size;
	private char[][] grid;

	public Board(int size) {
		this.size = size;	
		if (size > 2) {
			setUp();
		}
		else {
			throw new InvalidGridSizeException("In order for this game to work, grid sizes should be at least 3x3");
		}
	}

	private void setUp() {
		grid = new char[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				grid[row][column] = ' ';
			}
		}
	}
}
