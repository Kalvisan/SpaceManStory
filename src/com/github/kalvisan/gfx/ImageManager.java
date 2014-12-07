package com.github.kalvisan.gfx;

import java.awt.image.BufferedImage;

import com.github.kalvisan.main.RPGGameMain;

public class ImageManager {
	
	public BufferedImage grass1Tile, wall1Tile, rock1Tile, rock2Tile, playerStill;
	public BufferedImage[] playerUp, playerDown, playerLeft, playerRight;
	
	public ImageManager(SpriteSheet ss){
			playerStill = ss.crop(0, 0, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		playerUp = new BufferedImage[4]; // Cik bildites satures playerUp array lists
			playerUp[0] = ss.crop(0, 3, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerUp[1] = ss.crop(1, 3, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerUp[2] = ss.crop(2, 3, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerUp[3] = ss.crop(3, 3, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		playerDown = new BufferedImage[4]; // Cik bildites satures player bufferis array lists
			playerDown[0] = ss.crop(0, 0, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerDown[1] = ss.crop(1, 0, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerDown[2] = ss.crop(2, 0, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerDown[3] = ss.crop(3, 0, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		playerLeft = new BufferedImage[4]; // Cik bildites satures player bufferis array lists
			playerLeft[0] = ss.crop(0, 1, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerLeft[1] = ss.crop(1, 1, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerLeft[2] = ss.crop(2, 1, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerLeft[3] = ss.crop(3, 1, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		playerRight = new BufferedImage[4]; // Cik bildites satures player bufferis array lists
			playerRight[0] = ss.crop(0, 2, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerRight[1] = ss.crop(1, 2, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerRight[2] = ss.crop(2, 2, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			playerRight[3] = ss.crop(3, 2, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
			
		grass1Tile = ss.crop(1, 4, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		wall1Tile = ss.crop(0, 5, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		rock1Tile = ss.crop(0, 6, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
		rock2Tile = ss.crop(1, 6, RPGGameMain.TILESIZE, RPGGameMain.TILESIZE);
	}
	
}
