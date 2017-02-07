import java.awt.*;  
import javax.swing.*;

  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;

	
    public static void main(String[] args) {
    	
    	//creating the frame and sub containers to store items
        board m =new board();
        JFrame f = new JFrame();
        JPanel board_p = new JPanel(new BorderLayout());
        JPanel frame_p = new JPanel(new BorderLayout());
        JPanel text_p = new JPanel(new BorderLayout());
        
        //the size of the overall frame
        int width = 1000;
        int height = 1000;
        
        //implementing a text box
       /* JTextField t =new JTextField(8);
        t.setFont(t.getFont().deriveFont(50f));
        text_p.add(t);*/
        
        //add panels to the frame
        board_p.add(m, FlowLayout.LEFT);
        frame_p.add(board_p,FlowLayout.LEFT);
        //frame_p.add(text_p, FlowLayout.RIGHT);
        f.add(frame_p);
        
        //set the size and visibility of the frame
        f.setSize(width, height); 
        f.setVisible(true);
        
        
    }
        

        
  
}
