 package com.lds.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet
{
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	
	public SpriteSheet(String path, int SIZE)
	{
		this.path = path;
		this.SIZE = SIZE;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load()
	{
		try
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e)
		{
			System.out.println("spritesheet was not loaded :<");
			e.printStackTrace();
		}
	}
	

}
