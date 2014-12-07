package com.github.kalvisan.main.tiles;

import java.awt.Graphics;

import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.main.RPGGameMain;

public class Wall1Tile extends Tile {

	public Wall1Tile(ImageManager im) {
		super(im);
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(im.wall1Tile, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE, null);
	}
}
