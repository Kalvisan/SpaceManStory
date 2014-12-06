package com.github.kalvisan.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			SpaceManStoryMain.getPlayer().up = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			SpaceManStoryMain.getPlayer().dn = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			SpaceManStoryMain.getPlayer().rt = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			SpaceManStoryMain.getPlayer().lt = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			SpaceManStoryMain.getPlayer().up = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			SpaceManStoryMain.getPlayer().dn = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			SpaceManStoryMain.getPlayer().rt = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			SpaceManStoryMain.getPlayer().lt = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
