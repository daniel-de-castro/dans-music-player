import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Model;
import view.MainWindow;

public class Dans {
	
	public static void main(String[] args){
		
		ImageIcon icon = new ImageIcon("media/images/discIcon16.png");
		
		JFrame loadingScreen = new JFrame("Dans music player");
		loadingScreen.setResizable(false);
		loadingScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());

		JLabel loadingMessage = new JLabel("Loading...");
		loadingMessage.setHorizontalAlignment(SwingConstants.CENTER);
		messagePanel.add(loadingMessage, BorderLayout.PAGE_START);

		loadingScreen.add(messagePanel);
		loadingScreen.setLocationRelativeTo(null);
		loadingScreen.setSize(400, 100);
		loadingScreen.setIconImage(icon.getImage());
		loadingScreen.setVisible(true);
		
		try {
			
			Model model = new Model();
			MainWindow view = new MainWindow(model);
			model.addObserver(view);
			loadingScreen.setVisible(false);
			view.setVisible(true);
			
		} catch (/*Throwable*/ IndexOutOfBoundsException e){
			
			loadingScreen.setVisible(false);
			JFrame warningScreen = new JFrame("Dans music player");
			loadingScreen.setResizable(false);
			loadingScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
			JPanel warningMessagePanel = new JPanel();
			warningMessagePanel.setLayout(new BorderLayout());
			
			JLabel warningMessage = new JLabel("Your playlist is empty!");
			warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
			warningMessagePanel.add(warningMessage, BorderLayout.CENTER);
			
			warningScreen.add(warningMessagePanel);
			warningScreen.setLocationRelativeTo(null);
			warningScreen.setSize(400, 100);
			warningScreen.setIconImage(icon.getImage());
			warningScreen.setVisible(true);
			
		}
	}
}
