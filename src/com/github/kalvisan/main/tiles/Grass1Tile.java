package com.github.kalvisan.main.tiles;

import java.awt.Graphics;

import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.main.RPGGameMain;

public class Grass1Tile extends Tile {

	public Grass1Tile(ImageManager im) {
		super(im);
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(im.grass1Tile, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE, null);
	}
}
