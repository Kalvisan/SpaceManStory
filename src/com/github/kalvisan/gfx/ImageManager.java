package com.github.kalvisan.gfx;

import java.awt.image.BufferedImage;

public class ImageManager {
	
	public BufferedImage player, grassTile;
	
	public ImageManager(SpriteSheet ss){
		player = ss.crop(0, 0, 32, 32);
		grassTile = ss.crop(1, 0, 32, 32);
	}
	
}
