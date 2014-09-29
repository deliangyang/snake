package com.java.main.creature;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTest implements KeyListener
{
	private GameCanvas gameCanvas;
	
	public KeyTest(GameCanvas gameCanvas) {
		this.gameCanvas = gameCanvas;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
