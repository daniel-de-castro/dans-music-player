package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
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
	
	public class Background extends JComponent{
		private BufferedImage image;
		
		public Background(){
			try {
				image = javax.imageio.ImageIO.read(new File("media/images/background.png"));
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
		setContentPane(new Background());
		setIconImage(new ImageIcon("media/images/discIcon16.png/").getImage());
		buttonListener = new ButtonListener(m);
		cl = new CardLayout();
		
		//============================ Text Related Stuff =============================
		
		nowPlayingLabel = new JLabel("Welcome to Dans music player");
		nowPlayingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nowPlayingLabel.setFont(new Font("Futura", Font.PLAIN, 16));
		nowPlayingLabel.setForeground(new Color(0, 225, 255));
		nowPlayingLabel.setOpaque(false);
		
		playlistScroller = new JScrollPane();
		playlistDisplay = new JTextArea("PLAYLIST\n\n");
		playlistDisplay.setFont(new Font("Futura", Font.PLAIN, 13));
		for (String n : m.getNames()){
			playlistDisplay.append(n + "\n");
		}
		playlistDisplay.setOpaque(false);
		playlistScroller.setViewportView(playlistDisplay);
		playlistScroller.setOpaque(false);

		//================================ Buttons ====================================
		
		beginButton = new JButton("Begin");
		beginButton.addActionListener(buttonListener);
		beginButton.setActionCommand("begin ac");
		beginButton.setBounds(447, 300, 100, 25);
		beginButton.setOpaque(false);
		
		playButton = new JButton(new ImageIcon("media/images/playIcon.png"));
		playButton.addActionListener(buttonListener);
		playButton.setActionCommand("play ac");
		playButton.setOpaque(false);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		
		pauseButton = new JButton(new ImageIcon("media/images/pauseIcon.png"));
		pauseButton.addActionListener(buttonListener);
		pauseButton.setActionCommand("pause ac");
		pauseButton.setOpaque(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		
		prevButton = new JButton(new ImageIcon("media/images/leftIcon.png"));
		prevButton.addActionListener(buttonListener);
		prevButton.setActionCommand("prev ac");
		prevButton.setOpaque(false);
		prevButton.setContentAreaFilled(false);
		prevButton.setBorderPainted(false);
		
		nextButton = new JButton(new ImageIcon("media/images/rightIcon.png"));
		nextButton.addActionListener(buttonListener);
		nextButton.setActionCommand("next ac");
		nextButton.setOpaque(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setBorderPainted(false);
		
		shuffleButton = new JButton(new ImageIcon("media/images/shuffleIcon.png"));
		shuffleButton.addActionListener(buttonListener);
		shuffleButton.setActionCommand("shuffle ac");
		shuffleButton.setOpaque(false);
		shuffleButton.setContentAreaFilled(false);
		shuffleButton.setBorderPainted(false);
		
		//================================= Other =====================================

		//================================= Panels ====================================
		
		beginPanel = new JPanel(null);
		beginPanel.add(beginButton);
		beginPanel.setOpaque(false);
		
		buttonPanel = new JPanel(new GridLayout(3, 2));
		buttonPanel.add(playButton);
		buttonPanel.add(pauseButton);
		buttonPanel.add(prevButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(shuffleButton);
		buttonPanel.setOpaque(false);
		
		mainPanel = new JPanel(new GridLayout(2, 2));
		mainPanel.add(nowPlayingLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(playlistScroller);
		mainPanel.setOpaque(false);
		
		container = new JPanel();
		container.setLayout(cl);
		container.add(beginPanel, "1");
		container.add(mainPanel, "2");
		container.setOpaque(false);

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
		if (!command.equals("1")) nowPlayingLabel.setText("Now playing: " + model.getNowPlaying());
		else cl.show(container, "2");
	}

}
