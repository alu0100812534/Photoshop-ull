package perrysoft;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interfaz {
	
	private JFileChooser selector;
	private BufferedImage imagenRetorno=null;
	private Image img=null;
	public JMenuItem load = new JMenuItem("Cargar");
	
	Interfaz(){
	    
		
		CrearVentana();
		
	}
	void CrearVentana(){
	
		
		JFrame ventana_ = new JFrame ("perrysofh");
		ventana_.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana_.setSize (700, 700);
		ventana_.setVisible (true);
		
		JPanel p1 = new JPanel ();
		p1.setLayout (new BorderLayout ());
		
		JMenuBar Mtop = new JMenuBar();
		JMenu file = new JMenu("Archivo");
		
		file.add(load);
		Mtop.add(file);

		

		p1.add (Mtop,BorderLayout.NORTH);
		ventana_.add (p1);
		

		
		
	}
	
void CrearVentanaI(ArrayList<BufferedImage> imagenes){
	
		
		JFrame ventana_ = new JFrame ("image");
		ventana_.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana_.setSize (700, 700);
		ventana_.setVisible (true);
		
		JPanel p1 = new JPanel ();
		p1.setLayout (new BorderLayout ());
		
		JMenuBar Mtop = new JMenuBar();
		JMenu file = new JMenu("Archivo");
		
		file.add(load);
		Mtop.add(file);

		

		p1.add (Mtop,BorderLayout.NORTH);
		ventana_.add (p1);
		

		
		
	}
	
	
	
	
	
	public Optional<File> openFileChooser() {
		   selector = new JFileChooser();
		   selector.setDialogTitle("Seleccionar Imagen");
		   int flag = selector.showOpenDialog(null);
		   if (flag == JFileChooser.APPROVE_OPTION){
			   return Optional.of(selector.getSelectedFile());
		   }
		   else{
			return Optional.empty();
		  }
	}
	
	
	/*
	
    private void errorImagen(){
        JOptionPane.showMessageDialog(null,"No se pudo cargar la imagen","Error",JOptionPane.ERROR_MESSAGE);
    }

	void ShowImage(){
		JFrame ventana_ = new JFrame ("Imagen Cargada");
		ventana_.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana_.setSize (200, 200);
		ventana_.setVisible (true);
		
		 JOptionPane.showMessageDialog(null,"CHORFIREEEEEEEEEEEEEE","Error",JOptionPane.ERROR_MESSAGE);
		
	}
	///------>
	public void abrirImagenLocal(){
        if(this.openFileChooser()==true){
            try {
                imagenRetorno = ImageIO.read(this.selector.getSelectedFile());
                if (imagenRetorno!=null){
                   transformToImage();
                   ShowImage();
                   
                }else{
                	errorImagen();
                }
            } catch (Exception e) {
                errorImagen();
            }
        }        
    }
	private void transformToImage(){
		img = (Image)imagenRetorno;	
	}
	public Image get_Image(){
		return img;
	}
	
	public BufferedImage get_Image_Buffered(){
		return imagenRetorno;
	}*/
}
