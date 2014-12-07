package com.github.kalvisan.main.tiles;

import java.awt.Graphics;

import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.main.RPGGameMain;

public abstract class Tile {

	protected ImageManager	im;
	
	public static Tile grass1 = new Grass1Tile(RPGGameMain.getImageManager());
	public static Tile wall1 = new Wall1Tile(RPGGameMain.getImageManager());
	public static Tile rock1 = new Rock1Tile(RPGGameMain.getImageManager());

	public Tile(ImageManager im) {
		this.im = im;
	}

	public abstract void tick();
	public abstract void render(Graphics g, int x, int y);
	
}
