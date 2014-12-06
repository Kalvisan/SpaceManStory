package com.github.kalvisan.main.tiles;

import java.awt.Graphics;

import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.main.SpaceManStoryMain;

public class GrassTile extends Tile{
	
	public GrassTile(ImageManager im) {
		super(im);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(im.grassTile, x, y, 32 * SpaceManStoryMain.SCALE, 32 * SpaceManStoryMain.SCALE, null);
	}
}
