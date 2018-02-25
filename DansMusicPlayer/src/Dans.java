import view.MainWindow;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Model;

public class Dans {
	
	public static void main(String[] args){
		
		JFrame loadingScreen = new JFrame("title");
		loadingScreen.setResizable(false);
		loadingScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		
		JLabel loadingMessage = new JLabel("Loading...");
		messagePanel.add(loadingMessage, BorderLayout.PAGE_START);
		
		loadingScreen.add(messagePanel);
		loadingScreen.setLocationRelativeTo(null);
		loadingScreen.setSize(400, 100);
//		loadingScreen.setIconImage(new ImageIcon("filepath after project name").getImage());
		loadingScreen.setVisible(true);
		
		try {
			
			Model model = new Model();
			MainWindow view = new MainWindow(model);
			model.addObserver(view);
			loadingScreen.setVisible(false);
			view.setVisible(true);
			
		} catch (Throwable e){
			
			loadingScreen.setVisible(false);
			JFrame warningScreen = new JFrame("title");
			loadingScreen.setResizable(false);
			loadingScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
			JPanel warningMessagePanel = new JPanel();
			warningMessagePanel.setLayout(new BorderLayout());
			
			JLabel warningMessage = new JLabel("There seems to be no connection.");
			warningMessagePanel.add(warningMessage, BorderLayout.CENTER);
			
			warningScreen.add(warningMessagePanel);
			warningScreen.setLocationRelativeTo(null);
			warningScreen.setSize(400, 100);
//			warningScreen.setIconImage(new ImageIcon("filepath after project name").getImage());
			warningScreen.setVisible(true);
			
		}
	}
}
