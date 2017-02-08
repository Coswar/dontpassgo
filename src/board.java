import java.awt.*;  


public class board extends Canvas{  
  
	private static final long serialVersionUID = 1L;
	@Override
	
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("src/images/monopoly-800x800.jpg");  
        g.drawImage(i, 0,0,650,600,this);       	
	}
	
}