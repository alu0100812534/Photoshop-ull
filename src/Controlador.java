package perrysoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Controlador {
	private Interfaz interfaz;
	private Modelo modelo;
	
	private BufferedImage actualImage = null;
	
	//

	Controlador(){
		interfaz = new Interfaz();
		modelo = new Modelo();
		//listener
		 interfaz.load.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		    		interfaz.openFileChooser().ifPresent(
		    				(File file) -> {
		    					modelo.lee(file);
		    					interfaz.CrearVentanaI(modelo.getImages());
		    				});
		    	}
		    });
		 
		 interfaz.save.addActionListener(new ActionListener() {
		    	@SuppressWarnings("static-access")
				@Override
		    	public void actionPerformed(ActionEvent e) {
		    		//interfaz.openFileSaver();
		    		javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(); 
		    		String ruta = ""; 
		    		try{ 
			    		if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
			    			ruta = jF1.getSelectedFile().getAbsolutePath(); 
			    		} 
			    		if (actualImage != null) {
			    			ImageIO.write(actualImage, "png", new File(ruta));
			    		}
			    		else {
			   			 System.out.println("No hay imagen seleccionada"); // TODO: JOptionPane

			    		}
		    		}catch (Exception ex){ 
		    			ex.printStackTrace(); 
		    		}		    		
		    	}
		    });
		 
		 interfaz.bufferImageCallback = (bufferImage) -> {
			 actualImage = bufferImage;
		 }; 		 
		 
	}
	
   }

