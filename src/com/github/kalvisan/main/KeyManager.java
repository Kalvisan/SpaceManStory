package com.github.kalvisan.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			RPGGameMain.getPlayer().up = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			RPGGameMain.getPlayer().dn = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			RPGGameMain.getPlayer().rt = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			RPGGameMain.getPlayer().lt = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			RPGGameMain.getPlayer().up = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			RPGGameMain.getPlayer().dn = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			RPGGameMain.getPlayer().rt = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			RPGGameMain.getPlayer().lt = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
