import java.awt.*;  
import javax.swing.*;

  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;

	
    public static void main(String[] args) {
    	
        board m =new board();
        JFrame f = new JFrame();
        JPanel p = new JPanel(new BorderLayout());
        JTextField t =new JTextField("Hello"); 
        int width = 1000;
        int height = 1000;
        p.add(m, FlowLayout.LEFT);
        f.add(p);
        
        
       /* t.setAlignmentX(900);
        t.setAlignmentY(900);
        p.add(t);*/
        f.setSize(width, height); 
        f.setVisible(true);
        
        
    }
        

        
  
}
