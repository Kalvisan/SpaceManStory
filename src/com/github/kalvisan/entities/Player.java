package com.github.kalvisan.entities;

import java.awt.Graphics;

import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.main.RPGGameMain;

public class Player{

	private int			x;
	private int			y;
	private ImageManager	im;

	public boolean		up = false, dn = false, lt = false, rt = false;
	private final int	SPEED	= 2;

	public Player(int x, int y, ImageManager im) {
		this.x = x;
		this.y = y;
		this.im = im;
	}

	public void tick() {
		if (up) {
			y -= SPEED;
		}
		if (dn) {
			y += SPEED;
		}
		if (lt) {
			x -= SPEED;
		}
		if (rt) {
			x += SPEED;
		}
	}

	public void render(Graphics g) {
		g.drawImage(im.player, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE, null);
	}
}
