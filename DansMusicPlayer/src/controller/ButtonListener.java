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
		case "begin ac":
			model.begin();
			break;
		case "play ac":
			model.play();
			break;
		case "pause ac":
			model.pause();
			break;
		case "prev ac":
			model.prev();
			break;
		case "next ac":
			model.next();
			break;
		case "shuffle ac":
			model.shuffle();
			break;
		}
	}

}
