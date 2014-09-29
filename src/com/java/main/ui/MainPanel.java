package com.java.main.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.java.main.creature.GameCanvas;
import com.java.main.creature.KeyHandler;
import com.java.main.creature.KeyTest;
import com.java.main.creature.SnakeThread;

public class MainPanel extends JPanel 
{
	
	public MainPanel()
	{
		setLayout(new BorderLayout());
		GameCanvas gameCanvas = new GameCanvas();
		add(gameCanvas, BorderLayout.CENTER);
		//addKeyListener(new KeyTest(gameCanvas));
		gameCanvas.addKeyListener(new KeyTest(gameCanvas));
		new SnakeThread(gameCanvas).start();
	}
}
