import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.ArrayList;

public class UI {

	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 810;
	
	private JFrame frame = new JFrame();
	private BoardPanel boardPanel;	
	private InfoPanel infoPanel = new InfoPanel();
	private CommandPanel commandPanel = new CommandPanel();
	JPanel Right_Panel = new JPanel();
	
	UI (ArrayList<Player> players) {
		boardPanel = new BoardPanel(players);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Monopoly");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.add(boardPanel, BorderLayout.LINE_START);
		
		
		Right_Panel.setLayout(new BoxLayout(Right_Panel, BoxLayout.Y_AXIS));
		Right_Panel.add(infoPanel);
		Dimension info_panel_size = new Dimension(445,780);
		infoPanel.setPreferredSize(info_panel_size);
		Right_Panel.add(commandPanel);
		frame.add(Right_Panel,BorderLayout.LINE_END);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	int result = JOptionPane.showConfirmDialog(frame, "Exit the application?");
            	if (result==JOptionPane.YES_OPTION) {
            	    System.exit(0);     
            	}
            	if(result==JOptionPane.NO_OPTION){
            		
            		return;
            	}
            }
        });
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
