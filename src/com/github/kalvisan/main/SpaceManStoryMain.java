package com.github.kalvisan.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * @author Kalvisan
 * @since 06.12.2014.
 */
public class SpaceManStoryMain extends Canvas implements Runnable { // Runnable metode ļauj programmu darbin�?t atk�?rtoti ar nepartrauktu loop sistēmu // Canvas ļauj piekļūt grafiskajai videi
	private static final long	serialVersionUID	= 1L;
	private final static double	version				= 0.1;

	public static final int		WIDTH				= 360;
	public static final int		HEIGHT				= 240;
	public static final int		SCALE				= 2;		// Palīdz mainīt izmērus grafiskaj�? vidē

	public static boolean		running				= false;	// Parbauda vai programma vēl str�?d�?, ja nē tad izslēdz
	public Thread				gameThread;					// Ļauj veidot multi tasking, jeb vair�?kas funkcijas vienlaikus

	public synchronized void start() { // S�?k Thread classi, kas tiek atk�?rtota nep�?rtraukti
		if (running) return;
		running = true;

		gameThread = new Thread(this);
		gameThread.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		try { 							// Izlēdz programmu
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	public void run() {
		long lastTime = System.nanoTime();			//
		final double amountOfTicks = 60D;			// Izveido 60 FPS sistemu, kas ļauj uz visiem datoriem darbin�?t programmu uz 60 fps (60D laikam 60FPS) 
		double ns = 1000000000 / amountOfTicks;		//
		double delta = 0;							//
		
		while(running){
			long now = System.nanoTime();			//
			delta += (now - lastTime) / ns;			// Reķin�?šana priekš FPS
			lastTime = now;							//
			if(delta >= 1){
				tick();
				delta--;
			}
			render(); // Ļauj uzzimet visus objektus
		}
		stop();
	}

	private void tick() { // Ļauj apdeitot visas uz ekr�?da atrodoš�?s bildes un visu atjaunin�?t, kas ir nepieciešams
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3); // Ne vairak pa 15!
			return;
		}
		Graphics g = bs.getDrawGraphics();
							// ------------ RENDER HERE ----------------
			g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE- 100);
							// ------------ END RENDER ----------------
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		SpaceManStoryMain game = new SpaceManStoryMain();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame("TITLE RPG Story v" + version);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE); // Izveido logu ar noteiktu izmēru
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Izslēdz programmu kad tiek nospiesta izslēgšan�?s poga
		frame.setLocationRelativeTo(null); // Novieto programmu ekr�?na vidū
		frame.setResizable(false); // Neļauj mainīt programmas izmērus
		frame.add(game);
		frame.setVisible(true); // Padara programmas vidi redzamu

		game.start();
	}

}
