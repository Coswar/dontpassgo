import java.awt.*;  
import javax.swing.JFrame;  
  
public class Monopoly extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("images/monopoly.jpg");  
        g.drawImage(i, 0,0,800,700,null);  
          
    }  
        public static void main(String[] args) {  
        Monopoly m=new Monopoly();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(400,400);  
        f.setVisible(true);  
    }  
  
}
