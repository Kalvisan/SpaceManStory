package com.github.kalvisan.main.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.github.kalvisan.main.RPGGameMain;
import com.github.kalvisan.main.tiles.Tile;

public class Level {

	private int[][] tiles;
	private int w,h;
	
	public Level(BufferedImage levelImage){
		w = levelImage.getWidth();
		h = levelImage.getHeight();
		loadLevel(levelImage);
	}
	
	public void loadLevel(BufferedImage levelImage){
		tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
		
		for(int y = 0;y < levelImage.getHeight(); y++){
			for(int x = 0;x < levelImage.getWidth();x++){
				Color c = new Color(levelImage.getRGB(x, y));
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
				
				switch(h){
					case "00ff00": // Grass - 1
						tiles[x][y] = 1;
						break;
					case "b0613d": // Wall - 2
						tiles[x][y] = 2;
						break;
					case "dbc655": // Rock - 3
						tiles[x][y] = 3;
						break;
						
					default:
						tiles[x][y] = 1;
						break;
				}
				
			}
		}
	}
	
	public void render(Graphics g){
		for(int y = 0;y < h; y++){
			for(int x = 0;x < w;x++){
				
				getTile(x,y).render(g, x * RPGGameMain.TILESIZE * RPGGameMain.SCALE, y * RPGGameMain.TILESIZE * RPGGameMain.SCALE);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		switch(tiles[x][y]){
			case 1:
				return Tile.grass1;
			case 2:
				return Tile.wall1;
			case 3:
				return Tile.rock1;
			default:
				return Tile.grass1;
		}
	}
}
