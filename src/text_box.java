import javax.swing.*;


public class text_box extends JTextField{  
  
	private static final long serialVersionUID = 1L;
	
	
	public void text() {

		JTextField t =new JTextField("Input Box");
	    t.setFont(t.getFont().deriveFont(50f));
    
	}
}