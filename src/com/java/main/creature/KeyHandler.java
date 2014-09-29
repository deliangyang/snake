package com.java.main.creature;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter
{
	private GameCanvas gameCanvas;
	
	public KeyHandler(GameCanvas gameCanvas) {
		this.gameCanvas = gameCanvas;
	}
	
	// °´ÏÂ¼üÅÌ
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {	
			case KeyEvent.VK_UP:
					gameCanvas.setDirection(DIRECTION.UP);
				break;
			case KeyEvent.VK_DOWN:
					gameCanvas.setDirection(DIRECTION.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				gameCanvas.setDirection(DIRECTION.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				gameCanvas.setDirection(DIRECTION.RIGHT);
				break;	
		}
	}
}
