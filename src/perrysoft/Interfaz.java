package perrysoft;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Optional;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interfaz {
	
	private JFileChooser selector;
	public JMenuItem load = new JMenuItem("Cargar");
	public JMenuItem save = new JMenuItem("Guardar");
	public JFrame ventana_ = new JFrame ("Perrysoft");
	public JDesktopPane DPane = new JDesktopPane();
	
	public JPanel p1 = new JPanel ();

	int perry=0;
	
	Consumer<BufferedImage> bufferImageCallback;
	
	
	Interfaz(){
	    	
		CrearVentana();
		
	}
	
	
	
	void CrearVentana(){
		
		JButton bt3 = new JButton(new ImageIcon(((new ImageIcon("/Imgenesop/histog.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));

        bt3.setPreferredSize(new Dimension(40,40));
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imgenesop/Perry2.png"));
	     ventana_.setIconImage(icon);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ventana_.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana_.setSize (screenSize.width, screenSize.height);
		ventana_.setVisible (true);
		
		p1.setLayout (new BorderLayout ());
		
		JMenuBar Mtop = new JMenuBar();
		JPanel panelleft = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JMenu file = new JMenu("Archivo");
		//Image imagenExterna1 = new ImageIcon("fondo.jpg").getImage();
		//try {
			//BufferedImage imagenfondo = ImageIO.read(new File("C:/Users/Aduanich/workspace/Perrysoft/src/perrysoft/imagess/fondo.jpg"));
			//DPane.add(new JLabel(new ImageIcon(imagenfondo)));
			//DPane.setVisible(true);
			DPane.setBackground(Color.GRAY);
		//} catch (IOException e) {
			//e.printStackTrace();
		//} 
		file.add(load);
		file.add(save);
		Mtop.add(file);
		panelleft.add(bt3);
		p1.add (panelleft, BorderLayout.WEST);
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
	   		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png", "image-png");
	   		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("JPG", "jpg", "image-png");
	   		selector.setFileFilter(filter);
	   		selector.setFileFilter(filter2);
	   		selector.setAcceptAllFileFilterUsed(false);
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
