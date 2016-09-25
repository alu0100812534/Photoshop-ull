package perrysoft;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Modelo {
	private ArrayList<BufferedImage> imagenes = new ArrayList<BufferedImage>();
	Modelo(){}
	
	public void lee(File file) {
		String fileName = file.getName();
		fileName=fileName.substring(fileName.lastIndexOf(".")+1);
		
		switch(fileName){
		case "png":
			try {
				BufferedImage image = ImageIO.read(file); 
			    imagenes.add(image);
			} catch (IOException e) {
				System.err.println("La imagen esta apestando1");
			}
			
		break;
		case "jpg":
			
			try {
				BufferedImage image = ImageIO.read(file); 
			    imagenes.add(image);
			} catch (IOException e) {
				System.err.println("La imagen esta apestando2");
			}
			
		break;
		
		default:
			System.err.println("No soportamos dicho formato");
        break;
		
		}
	}
	
	 public BufferedImage getImages(){
	    return imagenes.get(imagenes.size()-1);
	}
	
}
