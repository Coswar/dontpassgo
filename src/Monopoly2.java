import java.awt.*;  
import javax.swing.*;

  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;

	
    public static void main(String[] args) {
    	
    		
    	//creating the frame 
        JFrame f = new JFrame();
        
        //set the JFrame's title
        f.setTitle("Monopoly");
        
        //create JPanels to encompass the various elements and define the layout manager used within each panel
        JPanel board_p = new JPanel(new BorderLayout());
        JPanel frame_p = new JPanel();
        JPanel text_p = new JPanel();
        JPanel text_p2 = new JPanel();
        
        //define the Layout manager used within the JPanels
        //BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
        
        //import the board image from the board class
        board board_image =new board();
        
        //import a text box from text box class
        text_box text_box_top_right = new text_box();
        
        //add to a panel and set layout and aligment
        text_p.add(text_box_top_right);
        text_p.setLayout(new BoxLayout(text_p, BoxLayout.X_AXIS));
        text_p.setAlignmentY(Component.TOP_ALIGNMENT);
        
        //second text box for testing purposes
        text_box text_box_bottom_right = new text_box();
        text_p2.add(text_box_bottom_right);
        text_p2.setLayout(new BoxLayout(text_p2, BoxLayout.X_AXIS));
        text_p2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        
        
        //colour in frames to see boundries in order to size correctly
        board_p.setBackground(Color.black);
        text_p.setBackground(Color.red);
        text_p2.setBackground(Color.orange);
        
        //Construct the layout (x axis ; line elements up horizontally)
        frame_p.setLayout(new BoxLayout(frame_p, BoxLayout.X_AXIS));
        
        //set the size of the panels
        board_p.setPreferredSize(new Dimension(100,100));
        text_p.setPreferredSize(new Dimension(100,100));
        
        //add sub-panels to the framing panel
        board_p.add(board_image);
        frame_p.add(board_p);
        frame_p.add(text_p);
        frame_p.add(text_box_top_right);
        
        //add the frame-panel to the Jframe 
        f.add(frame_p);
        
        //set the size and visibility of the frame
        f.setSize(1315, 638); 
        f.setVisible(true);
        
        
    }
        

        
  
}
