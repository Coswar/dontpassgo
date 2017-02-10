import java.awt.*;



public class token extends Canvas{  
	  
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {  
        Toolkit t = Toolkit.getDefaultToolkit();
        Toolkit s = Toolkit.getDefaultToolkit();
        Image i = t.getImage("src/images/monopoly-800x800.jpg");
        Image j = s.getImage("src/images/token.png"); 
        g.drawImage(i, 0,0,600,600,this);
        g.drawImage(j, 275, 272,50,50,this);
	}
	
}