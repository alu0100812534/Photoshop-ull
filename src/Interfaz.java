package perrysoft;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Optional;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Interfaz {
	
	private JFileChooser selector;
	public JMenuItem load = new JMenuItem("Cargar");
	public JMenuItem save = new JMenuItem("Guardar");
	public JFrame ventana_ = new JFrame ("perrysoft");
	public JDesktopPane DPane = new JDesktopPane();
	public JPanel p1 = new JPanel ();
	int perry=0;
	
	Consumer<BufferedImage> bufferImageCallback;
	
	
	Interfaz(){
	    	
		CrearVentana();
		
	}
	
	void CrearVentana(){
		
		ventana_.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana_.setSize (1920, 1080);
		ventana_.setVisible (true);
		
		p1.setLayout (new BorderLayout ());
		
		JMenuBar Mtop = new JMenuBar();
		JMenu file = new JMenu("Archivo");
		
		file.add(load);
		file.add(save);
		Mtop.add(file);

		p1.add (Mtop,BorderLayout.NORTH);
		p1.add (DPane,BorderLayout.CENTER);
		ventana_.add (p1);
			
	}
	
	void CrearVentanaI(BufferedImage imagenes){
	
		
		JInternalFrame img_ = new JInternalFrame ("Imagen "+(++perry));
		img_.setResizable(true);
		img_.setClosable(true);
		img_.pack();
		img_.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		img_.setSize (imagenes.getWidth()+20,imagenes.getHeight()+40);
		img_.setVisible (true);
		img_.getContentPane().add(new JLabel(new ImageIcon(imagenes)));
		img_.setVisible(true);
		DPane.add(img_);
		
		img_.addInternalFrameListener(new InternalFrameListener() {

			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				bufferImageCallback.accept(imagenes);
	   			System.out.println("focus activate please");

				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
	   			System.out.println("focus deactivate please");

				
			}
			
		});		

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
	
	
	/*public void openFileSaver() {
		
	          
	}
	*/
}
