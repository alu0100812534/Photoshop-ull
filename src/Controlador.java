package perrysoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Controlador {
	private Interfaz interfaz;
	private Modelo modelo;

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
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		    		//interfaz.openFileSaver();
		    		javax.swing.JFileChooser jF1= new javax.swing.JFileChooser(); 
		    		String ruta = ""; 
		    		try{ 
		    		if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
		    			ruta = jF1.getSelectedFile().getAbsolutePath(); 
		    		} 
		    		}catch (Exception ex){ 
		    		ex.printStackTrace(); 
		    		} 
		    		try {
		    			//Cambiar ruta a la imagen elegida
						ImageIO.write(modelo.getImages(), "png", new File(ruta));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
		    		
		    	}
		    });
		 
		 //interfaz.DPane.img_.addActionListener(new ActionListener() {
		   // 	@Override
		    //	public void actionPerformed(ActionEvent e) {
		    		
		    
		    	//}
		    //});
		 
		 
		 
		 
		 
	}
	
   }

