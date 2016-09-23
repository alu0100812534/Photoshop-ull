package perrysoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


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
	}
	

	
   }

