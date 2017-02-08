import javax.swing.*;


public class text_box extends JTextField{  
  
	private static final long serialVersionUID = 1L;
	
	
	public void text() {
		int width = 100, height = 10;
		JTextField t =new JTextField("Input Box");
	    t.setFont(t.getFont().deriveFont(50f));
	    t.setBounds(width, height, width, height);
    
	}
}	