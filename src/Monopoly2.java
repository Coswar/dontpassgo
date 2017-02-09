import java.awt.*;  
import javax.swing.*;

  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;

	
    public static void main(String[] args) {
    	  		
    	// Creating the frame,set window title and define the exit 
        JFrame f = new JFrame("Monopoly");
        
        // When we close the window the program will end
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create JPanels to encompass the various elements and define the layout manager used within each panel
        JPanel board_p = new JPanel(new BorderLayout());
        JPanel frame_p = new JPanel();
        JPanel right_p = new JPanel();
        JPanel output = new JPanel();
        JPanel input = new JPanel();
        
        // Define the Layout manager used within the JPanels
        frame_p.setLayout(new BoxLayout(frame_p, BoxLayout.X_AXIS));
        right_p.setLayout(new BoxLayout(right_p, BoxLayout.Y_AXIS));
        
        // Import the board image from the board class
        board board_image = new board();
        
        //grib layout testing - ignore for now
        
        //Gridlayout Layout new GridLayout(1,1);
        //right_p.(new GridLayout(1, 1));

        //create a text input panel, add text_box class to it
        text_display text_box_top_right = new text_display();
        output.add(text_box_top_right);
        output.setLayout(new BoxLayout(output, BoxLayout.X_AXIS));
        //disable editing within the dispay box
        text_box_top_right.setEditable(false);
        
        
        //create a text output panel, add text_display class to it 
        text_box text_box_bottom_right = new text_box();
        input.add(text_box_bottom_right);
        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
        
        // Colour in frames to see boundaries in order to size correctly
        frame_p.setBackground(Color.green);
        board_p.setBackground(Color.black);
        output.setBackground(Color.red);
        input.setBackground(Color.orange);
        
        //add sub-panels to the framing panel
        right_p.add(output);
        right_p.add(input);
        board_p.add(board_image);
        frame_p.add(board_p);
        frame_p.add(right_p);
         	
        // Add the frame-panel to the Jframe 
        f.add(frame_p);
        
        // Set the size and visibility of the frame
        f.setResizable(false);
        f.setSize(1210, 629);  
        f.setVisible(true);
        
        
    }
    
        

        
  
}
