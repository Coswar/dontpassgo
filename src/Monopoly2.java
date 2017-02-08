import java.awt.*;  
import javax.swing.*;

  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;

	
    public static void main(String[] args) {
    	  		
    	//creating the frame,set window title and define the exit 
        JFrame f = new JFrame("Monopoly");
        
        //when we close the window the program will end
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create JPanels to encompass the various elements and define the layout manager used within each panel
        JPanel board_p = new JPanel(new BorderLayout());
        JPanel frame_p = new JPanel();
        JPanel text_p = new JPanel();
        JPanel text_p2 = new JPanel();
        
        //define the Layout manager used within the JPanels
        frame_p.setLayout(new BoxLayout(frame_p, BoxLayout.X_AXIS));
        
        //import the board image from the board class
        board board_image = new board();
        
        //import a text box from text box class
        text_box text_box_top_right = new text_box();
        
        //add to a panel and set layout and alignment
        text_p.add(text_box_top_right);
        text_p.setLayout(new BoxLayout(text_p, BoxLayout.X_AXIS));
        
        //set the size of the text panel
        text_p.setBounds(10,50,50,50);
        text_p.setAlignmentY(Component.TOP_ALIGNMENT);
        
        //second text box for testing purposes
        text_display text_box_bottom_right = new text_display();
        text_p2.add(text_box_bottom_right);
        text_p2.setLayout(new BoxLayout(text_p2, BoxLayout.X_AXIS));
        text_p2.setBounds(100,100,100,100);
        
        
        //colour in frames to see boundries in order to size correctly
        frame_p.setBackground(Color.green);
        board_p.setBackground(Color.black);
        text_p.setBackground(Color.red);
        text_p2.setBackground(Color.orange);
        
        //add sub-panels to the framing panel
        board_p.add(board_image);
        frame_p.add(board_p);
        frame_p.add(text_p);
        frame_p.add(text_p2);
         	
        //add the frame-panel to the Jframe 
        f.add(frame_p);
        
        //set the size and visibility of the frame
        f.setResizable(false);
        f.setSize(1315, 638);  
        f.setVisible(true);
        
        
    }
    
        

        
  
}
