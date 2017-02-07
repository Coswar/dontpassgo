import java.awt.*;  


public class board extends Canvas{  
  
	private static final long serialVersionUID = 1L;
	@Override
	
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("src/images/monopoly.jpg");  
        g.drawImage(i, 0,0,750,700,this);       	
	}
	
}