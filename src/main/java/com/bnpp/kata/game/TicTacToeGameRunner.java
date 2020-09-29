package com.bnpp.kata.game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TicTacToeGameRunner extends JFrame{
	TicTacToe tictactoe =new TicTacToe(3);
	Board board =new Board(3);

	public TicTacToeGameRunner() {
		setLayout(new GridLayout(board.DIM ,board.DIM));
		for(int i= 0; i <  board.SIZE; i++) {
			final JButton button = createButtons();
			final int idx =i;
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					button.setText(Character.toString(tictactoe.nextPlayer()));
					tictactoe.play(idx, idx);
				}
			});
		}	
		pack();
		setVisible(true);
	}

	private JButton createButtons() {
		JButton button= new JButton();
		button.setPreferredSize(new Dimension(100,100));
		button.setFont(new Font(null, Font.PLAIN,50));
		add(button);
		return button;
	}

	public static void main(String[] args) {
		System.out.println("hello");      
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TicTacToeGameRunner();
			}
		});   	   
	}
}

