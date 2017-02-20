import java.awt.BorderLayout;
import javax.swing.JFrame;

import java.util.ArrayList;

public class UI {

	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 800;
	
	private JFrame frame = new JFrame();
	private BoardPanel boardPanel;	
	private InfoPanel infoPanel = new InfoPanel();
	private CommandPanel commandPanel = new CommandPanel();
	
	UI (ArrayList<Player> players) {
		boardPanel = new BoardPanel(players);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Monopoly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(boardPanel, BorderLayout.LINE_START);
		frame.add(infoPanel, BorderLayout.LINE_END);
		frame.add(commandPanel,BorderLayout.PAGE_END);
		frame.setResizable(false);
		frame.setVisible(true);
		return;
	}
	
	public String getCommand () {
		return commandPanel.getCommand();
	}
	
	public void display () {
		boardPanel.refresh();
		return;
	}
	
	public void displayString (String string) {
		infoPanel.addText(string);
		return;
	}
	
}
