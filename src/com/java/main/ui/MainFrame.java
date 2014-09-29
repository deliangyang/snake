package com.java.main.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.java.main.creature.GameCanvas;
import com.java.main.creature.KeyHandler;
import com.java.main.creature.KeyTest;
import com.java.main.creature.SnakeThread;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		init();
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	private void init()
	{
		// 设置一个windows风格的界面
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		setSize(500, 400);
		setLocation(200, 100);
		
		GameCanvas gameCanvas = new GameCanvas();
		setContentPane(gameCanvas);
		//add(gameCanvas, BorderLayout.CENTER);
		addKeyListener(new KeyTest(gameCanvas));
		//gameCanvas.addKeyListener(new KeyTest(gameCanvas));
		new SnakeThread(gameCanvas).start();
		
		
		//setContentPane(new MainPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
