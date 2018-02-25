package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonListener;
import model.Model;

public class MainWindow extends JFrame implements Observer {
	
	private Model model;
	private ButtonListener buttonListener;
	
	private JPanel container;
	
	private JButton button1;
	private JButton button2;
	
//	public class Background extends JComponent{
//		private BufferedImage image;
//		
//		public Background(){
//			try {
//				image = javax.imageio.ImageIO.read(new File("filepath after project name"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	    @Override
//	    protected void paintComponent(Graphics g) {
//	        super.paintComponent(g);
//	        g.drawImage(image, 0, 0, this);
//	    }
//	}
	
	public MainWindow(Model m){
		super("Dans music player");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setContentPane(new Background());
//		setIconImage(new ImageIcon("filepath after project name").getImage());
		buttonListener = new ButtonListener(m);
		
		//============================ Text Related Stuff =============================

		//================================ Buttons ====================================
				
		button1 = new JButton("first");
		button1.addActionListener(buttonListener);
		button1.setActionCommand("do func 1");
		
		button2 = new JButton("second");
		button2.addActionListener(buttonListener);
		button2.setActionCommand("do func 2");
		
		//================================= Other =====================================

		//================================= Panels ====================================
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		//container.setLayout(new GridLayout(rows, cols));
		container.add(button1, BorderLayout.PAGE_START);
		container.add(button2, BorderLayout.PAGE_END);

		//============================= Layout Manager ================================
		
		setLayout(new BorderLayout());
        add(container, BorderLayout.CENTER);
        setSize(1200, 741);
        setLocationRelativeTo(null);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		model = (Model) o;
        String command = (String) arg;
		
		switch (command){
		case "1":
			System.out.println("play pressed");
			break;
		case "2":
			System.out.println("pause pressed");
			break;
		case "3":
			System.out.println("prev pressed");
			break;
		case "4":
			System.out.println("next pressed");
			break;
		case "5":
			System.out.println("shuffle pressed");
			break;
		}
	}

}
