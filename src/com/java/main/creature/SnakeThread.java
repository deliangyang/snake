package com.java.main.creature;

public class SnakeThread extends Thread
{
	private GameCanvas gameCanvas;
	
	public SnakeThread(GameCanvas gameCanvas) {
		this.gameCanvas = gameCanvas;
	}
	
	@Override
	public void run()
	{
		while (true) {
			gameCanvas.move();
			gameCanvas.repaint();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
