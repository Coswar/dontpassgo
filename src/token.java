import java.awt.*;



public class token extends Canvas{  
	  
	private static final long serialVersionUID = 1L;
	int a;
	public token(int b)
	{
		
		a=b;
		
	}
	public void paint(Graphics g) {  
		int b = a;
        Toolkit t = Toolkit.getDefaultToolkit();
        Toolkit s = Toolkit.getDefaultToolkit();
        Image i = t.getImage("src/images/monopoly-original.jpg");
        Image j = s.getImage("src/images/token.png");
        int[] array_x = { 500,740,23,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
    	int[] array_y = { 272,200,563,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        g.drawImage(i, 0,0,777,700,this);
        g.drawImage(j, array_x[b], array_y[b],20,20,this);
 
	}
	
}