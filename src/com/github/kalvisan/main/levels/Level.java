package com.github.kalvisan.main.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.github.kalvisan.main.RPGGameMain;
import com.github.kalvisan.main.tiles.Tile;

public class Level {

	private int[][]	tiles;
	private int		w, h;

	public Level(BufferedImage levelImage) {
		w = levelImage.getWidth();
		h = levelImage.getHeight();
		loadLevel(levelImage);
	}

	public void loadLevel(BufferedImage levelImage) {
		tiles = new int[levelImage.getWidth()][levelImage.getHeight()];

		for (int y = 0; y < levelImage.getHeight(); y++) {
			for (int x = 0; x < levelImage.getWidth(); x++) {
				Color c = new Color(levelImage.getRGB(x, y));
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());

				switch (h) {
					case "00ff00": // Grass - 1
						tiles[x][y] = 1;
					break;
					case "b0613d": // Wall - 2
						tiles[x][y] = 2;
					break;
					case "dbc655": // Rock - 3
						tiles[x][y] = 3;
					break;
					case "8eab2e": // Rock2 - 4
						tiles[x][y] = 4;
					break;

					default:
						tiles[x][y] = 1;
					break;
				}

			}
		}
	}

	public void render(Graphics g) {
		int xo = RPGGameMain.getPlayer().getXo();
		int yo = RPGGameMain.getPlayer().getYo();

		int x0 = Math.max(xo / (RPGGameMain.TILESIZE * RPGGameMain.SCALE), 0);
		int y0 = Math.max(yo / (RPGGameMain.TILESIZE * RPGGameMain.SCALE), 0);
		int x1 = Math.min((xo + RPGGameMain.WIDTH * RPGGameMain.SCALE) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE) + 1, w);
		int y1 = Math.min((yo + RPGGameMain.HEIGHT * RPGGameMain.SCALE) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE) + 1, h);

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {

				getTile(x, y).render(g, x * RPGGameMain.TILESIZE * RPGGameMain.SCALE - xo, y * RPGGameMain.TILESIZE * RPGGameMain.SCALE - yo);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= w || y >= h) return Tile.grass1;
		
		switch (tiles[x][y]) {
			case 1:
				return Tile.grass1;
			case 2:
				return Tile.wall1;
			case 3:
				return Tile.rock1;
			case 4:
				return Tile.rock2;
			default:
				return Tile.grass1;
		}
	}
}
