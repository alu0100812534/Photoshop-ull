package perrysoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		    		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png", "image-png");
		    		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("JPG", "jpg", "image-png");
		    		jF1.setFileFilter(filter);
		    		jF1.setFileFilter(filter2);
		    		jF1.setAcceptAllFileFilterUsed(false);
		    		String ruta = ""; 
		    		try{ 
			    		if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
			    			ruta = jF1.getSelectedFile().getAbsolutePath(); 
			    		} 
			    		if (actualImage != null) {
			    			ImageIO.write(actualImage, "png", new File(ruta +".png"));
			    		}
			    		else {
			   			 //System.out.println("No hay imagen seleccionada"); // TODO: JOptionPane
			    			JOptionPane.showMessageDialog(null,
			    			        "No se ha seleccionado imagen",
			    			        "Advertencia",JOptionPane.WARNING_MESSAGE);
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

