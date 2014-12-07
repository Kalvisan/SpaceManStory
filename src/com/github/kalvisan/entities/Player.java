package com.github.kalvisan.entities;

import java.awt.Graphics;

import com.github.kalvisan.gfx.Animation;
import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.main.RPGGameMain;

public class Player{

	private int			x, xo, xs;
	private int			y, yo, ys;
	private ImageManager	im;

	public boolean		up = false, dn = false, lt = false, rt = false;
	private final int	SPEED	= 2;
	
	private Animation upAnimation, downAnimation, leftAnimation, rightAnimation;

	public Player(int x, int y, ImageManager im) {
		this.x = x;
		this.y = y;
		xo = 0;
		yo = 0;
		xs = 0;
		ys = 0;
		this.im = im;
		
		upAnimation = new Animation(im.playerUp, 100);
		downAnimation = new Animation(im.playerDown, 100);
		leftAnimation = new Animation(im.playerLeft, 100);
		rightAnimation = new Animation(im.playerRight, 100);
	}

	public void tick() {
		xs = 0;
		ys = 0;
		if (up) {
			ys -= SPEED;
		} else if (dn) {
			ys += SPEED;
		}
		if (lt) {
			xs -= SPEED;
		}else if (rt) {
			xs += SPEED;
		}
		move(xs, ys);
		
		upAnimation.tick();
		downAnimation.tick();
		leftAnimation.tick();
		rightAnimation.tick();
	}
	
	public void move(int xs, int ys){
		if (!collision(xs, 0)){
			xo += xs;
		}
		if (!collision(0, ys)){
			yo += ys;
		}
	}
	
	private boolean collision(int xs, int ys){
		if(RPGGameMain.getLevel().getTile((xo + xs + x) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE), (yo + ys + y) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE)).isSolid())
			return true;
		if(RPGGameMain.getLevel().getTile((xo + xs + x + RPGGameMain.TILESIZE * RPGGameMain.SCALE - 1) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE), (yo + ys + y) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE)).isSolid())
			return true;
		if(RPGGameMain.getLevel().getTile((xo + xs + x ) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE), (yo + ys + y + RPGGameMain.TILESIZE * RPGGameMain.SCALE - 1) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE)).isSolid())
			return true;
		if(RPGGameMain.getLevel().getTile((xo + xs + x + RPGGameMain.TILESIZE * RPGGameMain.SCALE - 1) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE), (yo + ys + y + RPGGameMain.TILESIZE * RPGGameMain.SCALE - 1) / (RPGGameMain.TILESIZE * RPGGameMain.SCALE)).isSolid())
			return true;
		
		return false;
		
	}

	public void render(Graphics g) {
		//g.drawImage(im.player, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE, null);
		if(up)
			upAnimation.render(g, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE);
		else if(dn)
			downAnimation.render(g, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE);
		else if(lt)
			leftAnimation.render(g, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE);
		else if(rt)
			rightAnimation.render(g, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE);
		else g.drawImage(im.playerStill, x, y, RPGGameMain.TILESIZE * RPGGameMain.SCALE, RPGGameMain.TILESIZE * RPGGameMain.SCALE, null);
	}
	
	public int getXo(){
		return xo;
	}
	public int getYo(){
		return yo;
	}
}
