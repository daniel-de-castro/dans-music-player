package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

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
	
	public class BeginBackground extends JComponent{
		private BufferedImage image;
		
		public BeginBackground(){
			try {
				image = javax.imageio.ImageIO.read(new File("media/images/beginBackground.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	    }
	}
	
	public class MainBackground extends JComponent{
		private BufferedImage image;
		
		public MainBackground(){
			try {
				image = javax.imageio.ImageIO.read(new File("media/images/mainBackground.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	    }
	}
	
	public MainWindow(Model m){
		super("Dans music player");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setIconImage(icon.getImage());
		buttonListener = new ButtonListener(m);
		cl = new CardLayout();
		
		//============================ Text Related Stuff =============================
		
		nowPlayingLabel = new JLabel("Welcome to Dans music player");
		nowPlayingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nowPlayingLabel.setFont(new Font("Futura", Font.PLAIN, 16));
		nowPlayingLabel.setBackground(Color.BLACK);
		nowPlayingLabel.setForeground(Color.CYAN);
		
		playlistScroller = new JScrollPane();
		playlistDisplay = new JTextArea("PLAYLIST\n\n");
		nowPlayingLabel.setFont(new Font("Futura", Font.PLAIN, 13));
		for (String n : model.getNames()){
			playlistDisplay.append(n + "\n");
		}
		playlistScroller.setViewportView(playlistDisplay);

		//================================ Buttons ====================================
		
		beginButton = new JButton("Begin");
		beginButton.addActionListener(buttonListener);
		beginButton.setActionCommand("begin ac");
		
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
		
		beginPanel = new JPanel();
		beginPanel.add(beginButton);
		
		buttonPanel = new JPanel(new GridLayout(3, 2));
		buttonPanel.add(playButton);
		buttonPanel.add(pauseButton);
		buttonPanel.add(prevButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(shuffleButton);
		
		mainPanel = new JPanel(new GridLayout(2, 2));
		mainPanel.add(nowPlayingLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(playlistScroller);
		
		container = new JPanel();
		container.setLayout(cl);
		container.add(beginPanel, "1");
		container.add(mainPanel, "2");

		//============================= Layout Manager ================================
		
		setLayout(new BorderLayout());
        add(container, BorderLayout.CENTER);
        setSize(1000, 618);
        setLocationRelativeTo(null);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		model = (Model) o;
        String command = (String) arg;
		nowPlayingLabel.setText("Now playing: " + model.getNowPlaying());
		switch (command){
		case "1":
			System.out.println("begun");
			cl.show(container, "2");
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
