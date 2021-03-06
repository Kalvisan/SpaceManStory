package com.github.kalvisan.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.github.kalvisan.entities.Player;
import com.github.kalvisan.gfx.ImageLoader;
import com.github.kalvisan.gfx.ImageManager;
import com.github.kalvisan.gfx.SpriteSheet;
import com.github.kalvisan.main.levels.Level;

/**
 * @author Kalvisan
 * @since 06.12.2014.
 */
public class RPGGameMain extends Canvas implements Runnable { // Runnable metode ļauj programmu darbin�?t atk�?rtoti ar nepartrauktu loop sistēmu // Canvas ļauj piekļūt grafiskajai videi
	private static final long	serialVersionUID	= 1L;
	private final static double	version				= 2.2;

	public static final int		WIDTH				= 640; //352
	public static final int		HEIGHT				= 512; //320
	public static final int		SCALE				= 1;		// Palīdz mainīt izmērus grafiskaj�? vidē
	public static final int		TILESIZE			= 32;

	public static boolean		running				= false;	// Parbauda vai programma vēl str�?d�?, ja nē tad izslēdz
	public Thread				gameThread;					// Ļauj veidot multi tasking, jeb vair�?kas funkcijas vienlaikus
	
	private BufferedImage spriteSheet;
	private static ImageManager im;
	
	private static Player player;
	private static Level level;
	
	public void init(){
		ImageLoader loader = new ImageLoader();
		spriteSheet = loader.load("/Sheet.png");
		
		SpriteSheet ss = new SpriteSheet(spriteSheet); // Ieguvu Sprite Sheet bildi kuru karēšu graizīt
		
		im = new ImageManager(ss);
		
		player = new Player(WIDTH * SCALE / 2 - 32, HEIGHT * SCALE / 2 - 32, im); // Speletaja ekrana X un Y koordinatas
		
		this.addKeyListener(new KeyManager());
		
		level = new Level(loader.load("/level_1.png"));
	}

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
		init();
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

	private void tick() { // Ļauj apdeitot visas uz ekr�?da atrodoš�?s bildes un visu atjaunin�?t, kas ir nepieciešams. Strada 60 tiki sekunde
		player.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3); // Ne vairak pa 15!
			return;
		}
		Graphics g = bs.getDrawGraphics();
							// ------------ RENDER HERE ----------------
			g.setColor(new Color(47,129,54));
			g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
			
			level.render(g);
			player.render(g);
							// ------------ END RENDER ----------------
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		RPGGameMain game = new RPGGameMain();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame("Space Man RPG Story v" + version);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE); // Izveido logu ar noteiktu izmēru
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Izslēdz programmu kad tiek nospiesta izslēgšan�?s poga
		frame.setLocationRelativeTo(null); // Novieto programmu ekr�?na vidū
		frame.setResizable(false); // Neļauj mainīt programmas izmērus
		frame.add(game);
		frame.setVisible(true); // Padara programmas vidi redzamu

		game.start();
	}
	
	public static Level getLevel() {
		return level;
	}
	
	public static  Player getPlayer(){
		return player;
	}
	
	public static ImageManager getImageManager() {
		return im;
	}

}
