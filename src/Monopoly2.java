import java.awt.*;  
import javax.swing.JFrame;
import javax.swing.JTextField;  
  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;
	@Override
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("src/images/monopoly.jpg");  
        g.drawImage(i, 0,0,750,700,this);       	
    }
	
    public static void main(String[] args) {
    	
        Monopoly2 m=new Monopoly2();  
        JFrame f=new JFrame();  
        int width = 765;
        int height = 740;
        f.add(m);
        f.setSize(width, height); 
        f.setVisible(true);
    }  
}
