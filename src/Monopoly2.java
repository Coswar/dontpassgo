import java.awt.*;  
import javax.swing.*;

  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;

	
    public static void main(String[] args) {
    	
    		
    	//creating the frame 
        JFrame f = new JFrame();
        
        //set the JFrame's title
        f.setTitle("Monopoly");
        
        //create JPanels to encompass the various elements
        JPanel board_p = new JPanel(new BorderLayout());
        JPanel frame_p = new JPanel(new BorderLayout());
        JPanel text_p = new JPanel(new FlowLayout());
        
        //import the board image from the board class
        board board_image =new board();
        
        //implementing a text box
        text_box text_box = new text_box();
        text_p.add(text_box);
        
        //colour in frames to see boundries in order to size correctly
        board_p.setBackground(Color.black);
        text_p.setBackground(Color.red);
        
        //Construct the layout (x axis ; line elements up horizontally)
        frame_p.setLayout(new BoxLayout(frame_p, BoxLayout.X_AXIS));
        
        //set the size of the text box
        text_p.setPreferredSize(new Dimension(200,0));
        
        //add sub-panels to the framing panel
        board_p.add(board_image);
        frame_p.add(board_p);
        frame_p.add(text_p);
        
        //add the frame-panel to the Jframe 
        f.add(frame_p);
        
        //ints for the size of the overall frame
        int width = 1000;
        int height = 1000;
        
        //set the size and visibility of the frame
        f.setSize(width, height); 
        f.setVisible(true);
        
        
    }
        

        
  
}
