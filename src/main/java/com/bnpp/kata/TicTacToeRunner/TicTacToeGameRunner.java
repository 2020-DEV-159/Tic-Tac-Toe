package com.bnpp.kata.TicTacToeRunner;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TicTacToeGameRunner extends JFrame{
	Position position =new Position();
	JButton[] buttons =new JButton[Position.SIZE];

	public TicTacToeGameRunner() {
		setLayout(new GridLayout(Position.DIM ,Position.DIM));
		for(int i= 0; i < Position.SIZE ; i++) {
			final JButton button = createButtons();
			buttons[i] =button;
			final int idx =i;
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					button.setText(Character.toString(position.turn));
					position.move(idx);
					if(!position.isGameEnd()) {
						int best =position.bestMove();
						buttons[best].setText(Character.toString(position.turn));
						position.move(best);

					}
					if(position.isGameEnd()) {;
					String message = position.isWinFor('X') ? "You Won!" :
						position.isWinFor('O') ? "Computer Won!" : "Draw";
					JOptionPane.showMessageDialog(null, message);
					}
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

