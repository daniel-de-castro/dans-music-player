package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ButtonListener;
import model.Model;

public class MainWindow extends JFrame implements Observer {
	
	private Model model;
	private ButtonListener buttonListener;
	private CardLayout cl;
	
	private JPanel container;
	private JPanel beginPanel;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	
	private JLabel nowPlayingLabel;
	private JScrollPane playlistScroller;
	private JTextArea playlistDisplay;
	
	private JButton beginButton;
	private JButton playButton;
	private JButton pauseButton;
	private JButton prevButton;
	private JButton nextButton;
	private JButton shuffleButton;
	
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
		cl = new CardLayout();
		
		//============================ Text Related Stuff =============================
		
		

		//================================ Buttons ====================================
		
		beginButton = new JButton("BEGIN");
		playButton.addActionListener(buttonListener);
		playButton.setActionCommand("begin ac");
		
		playButton = new JButton();
		playButton.addActionListener(buttonListener);
		playButton.setActionCommand("play ac");
		
		pauseButton = new JButton();
		pauseButton.addActionListener(buttonListener);
		pauseButton.setActionCommand("pause ac");
		
		prevButton = new JButton();
		prevButton.addActionListener(buttonListener);
		prevButton.setActionCommand("prev ac");
		
		nextButton = new JButton();
		nextButton.addActionListener(buttonListener);
		nextButton.setActionCommand("next ac");
		
		shuffleButton = new JButton();
		shuffleButton.addActionListener(buttonListener);
		shuffleButton.setActionCommand("shuffle ac");
		
		//================================= Other =====================================

		//================================= Panels ====================================
		
		beginPanel = new JPanel(new BorderLayout());
		beginPanel.add(beginButton);
		
		mainPanel = new JPanel(new GridLayout(2, 2));
		
		container = new JPanel();
		container.setLayout(cl);
		container.add(mainPanel, "2");
		container.add(beginPanel, "1");

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
			System.out.println("begun");
			cl.show(container, "1");
			break;
		case "2":
			System.out.println("play pressed");
			break;
		case "3":
			System.out.println("pause pressed");
			break;
		case "4":
			System.out.println("prev pressed");
			break;
		case "5":
			System.out.println("next pressed");
			break;
		case "6":
			System.out.println("shuffle pressed");
			break;
		}
	}

}
