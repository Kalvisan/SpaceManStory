package com.github.kalvisan.gfx;

import java.awt.image.BufferedImage;

import com.github.kalvisan.main.RPGGameMain;

public class ImageManager {
	
	public BufferedImage player, grass1Tile, wall1Tile, rock1Tile;
	
	public ImageManager(SpriteSheet ss){
		player = ss.crop(0, 0, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		grass1Tile = ss.crop(1, 4, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		wall1Tile = ss.crop(0, 5, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		rock1Tile = ss.crop(0, 6, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
	}
	
}
