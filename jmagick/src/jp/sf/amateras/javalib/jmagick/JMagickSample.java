package jp.sf.amateras.javalib.jmagick;

import magick.ImageInfo;
import magick.MagickImage;

/**
 *  JMagick‚ÌƒTƒ“ƒvƒ‹
 * 
 * @author Naoki Takezoe
 */
public class JMagickSample {
	public static void main(String[] args) throws Exception {
		MagickImage image = new MagickImage(new ImageInfo("javalib.jpg"));
		
		int width = (int) image.getDimension().getWidth() / 2;
		int height = (int) image.getDimension().getHeight() / 2;
		MagickImage resized = image.scaleImage(width, height);
		
		resized.setFileName("javalib_mini.jpg");
		resized.writeImage(new ImageInfo());
	}
}
