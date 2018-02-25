package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ButtonListener implements ActionListener{
	
	private Model model;
	
	public ButtonListener(Model m){
		model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case "play button":
			model.play();
			break;
		case "pause button":
			model.pause();
			break;
		case "prev button":
			model.prev();
			break;
		case "next button":
			model.next();
			break;
		case "shuffle button":
			model.shuffle();
			break;
		}
	}

}
