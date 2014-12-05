package com.github.kalvisan;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * @author Kalvisan
 * @since 06.12.2014.
 */
public class CircleStoryMain extends Canvas implements Runnable { // Runnable metode ļauj programmu darbināt atkārtoti ar nepartrauktu loop sistēmu // Canvas ļauj piekļūt grafiskajai videi
	private static final long	serialVersionUID	= 1L;
	private final static double	version				= 0.1;

	public static final int		WIDTH				= 360;
	public static final int		HEIGHT				= 240;
	public static final int		SCALE				= 2;		// Palīdz mainīt izmērus grafiskajā vidē

	public static boolean		running				= false;	// Parbauda vai programma vēl strādā, ja nē tad izslēdz
	public Thread				gameThread;					// Ļauj veidot multi tasking, jeb vairākas funkcijas vienlaikus

	public synchronized void start() { // Sāk Thread classi, kas tiek atkārtota nepārtraukti
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
		final double amountOfTicks = 60D;			// Izveido 60 FPS sistemu, kas ļauj uz visiem datoriem darbināt programmu uz 60 fps (60D laikam 60FPS) 
		double ns = 1000000000 / amountOfTicks;		//
		double delta = 0;							//
		
		while(running){
			long now = System.nanoTime();			//
			delta += (now - lastTime) / ns;			// Reķināšana priekš FPS
			lastTime = now;							//
			if(delta >= 1){
				tick();
				delta--;
			}
			render(); // Ļauj uzzimet visus objektus
		}
		stop();
	}

	private void tick() { // Ļauj apdeitot visas uz ekrāda atrodošās bildes un visu atjaunināt, kas ir nepieciešams
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3); // Ne vairak pa 15!
			return;
		}
	}

	public static void main(String[] args) {
		CircleStoryMain game = new CircleStoryMain();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame("Circle Story v" + version);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE); // Izveido logu ar noteiktu izmēru
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Izslēdz programmu kad tiek nospiesta izslēgšanās poga
		frame.setLocationRelativeTo(null); // Novieto programmu ekrāna vidū
		frame.setResizable(false); // Neļauj mainīt programmas izmērus
		frame.add(game);
		frame.setVisible(true); // Padara programmas vidi redzamu

		game.start();
	}

}
