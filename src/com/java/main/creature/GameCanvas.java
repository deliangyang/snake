package com.java.main.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class GameCanvas extends JPanel
{
	private static final int WITDH = 300;
	private static final int HEIGHT = 300;
	private static final int BOX_WIDTH = 10;
	private static final int BOX_HEIGHT = 10;
	private static final int GRID_X = 30;
	private static final int GRID_Y = 30;
	
	private static final int X_OFFSET = (WIDTH - GRID_X * BOX_WIDTH) / 2;
	private static final int Y_OFFSET = (HEIGHT - GRID_Y * BOX_HEIGHT) / 2;
	
	private DIRECTION direction;
	
	private List<Point> snake;
	/*private Food food;
	private Poison poison;*/
	
	private Point food;
	
	private int socre = 0;
	
	public GameCanvas()
	{
		snake = new ArrayList<Point>();
		snake.add(new Point(7, 10));
		snake.add(new Point(7, 9));
		snake.add(new Point(7, 8));
		snake.add(new Point(7, 7));
		snake.add(new Point(7, 6));
		direction=DIRECTION.RIGHT;
		
		food = new Point(new Random().nextInt(GRID_X), new Random().nextInt(GRID_Y));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawDecoration(g);
		drawSnake(g);
		drawFood(g);
	}

	public void drawSnake(Graphics g)
	{
		g.setColor(Color.red);
		for (Point point : snake) 
			g.fillRect(point.x * BOX_WIDTH, point.y * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
	}
	
	public void drawFood(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(food.x * BOX_WIDTH, food.y * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
	}
	
	public void setDirection(DIRECTION direction)
	{
		
		switch (direction) {
			case UP:
				if (this.direction == DIRECTION.DOWN)
					return;
				break;
			case DOWN:
				if (this.direction == DIRECTION.UP)
					return;
				break;
			case LEFT:
				if (this.direction == DIRECTION.RIGHT)
					return;
				break;
			case RIGHT:
				if (this.direction == DIRECTION.LEFT)
					return;
				break;
		}
		
		this.direction = direction;
	}
	
	public void move()
	{
		Point head;
		switch (direction) {
			case UP:
				head = new Point(snake.get(0).x, snake.get(0).y - 1);
				break;
			case DOWN:
				head = new Point(snake.get(0).x, snake.get(0).y + 1);
				break;
			case LEFT:
				head = new Point(snake.get(0).x - 1, snake.get(0).y);
				break;
			case RIGHT:
				head = new Point(snake.get(0).x + 1, snake.get(0).y);
				break;
			default:
				head = new Point(0, 0);
				break;
		}
		snake.add(0, head);
		
		if (!getFood())
			snake.remove(snake.size() - 1);
		
		if (isGameOver())
			restart();
	}
	
	public void restart()
	{
		snake.clear();
		snake.add(new Point(7, 10));
		snake.add(new Point(7, 9));
		snake.add(new Point(7, 8));
		snake.add(new Point(7, 7));
		snake.add(new Point(7, 6));
		direction=DIRECTION.RIGHT;
	}
	
	public void drawDecoration(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawRect(0, 0, 300, 300);
	}
	
	private boolean checkBodyCollision()
	{
		Point head = snake.get(0);
		
		for (int i = 1; i < snake.size(); i++) {
			if (head.x == snake.get(i).x && head.y == snake.get(i).y)
				return true;
		}
		
		return false;
	}
	
	private boolean checkBoundCollision()
	{
		Point head = snake.get(0);
		
		if (head.x < 0 || head.y < 0 || head.x >= GRID_X || head.y >= GRID_Y)
			return true;
		
		return false;
	}
	
	public boolean isGameOver()
	{
		if (checkBodyCollision() || checkBoundCollision())
			return true;
		return false;
	}
	
	private boolean getFood()
	{
		Point head = snake.get(0);
		
		if (head.x == food.x && head.y == food.y) {
			food = new Point(new Random().nextInt(GRID_X), new Random().nextInt(GRID_Y));
			return true;
		}
		return false;
		
	}
	
}
