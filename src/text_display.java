import java.awt.Component;

import javax.swing.*;


public class text_display extends JTextArea{  
  
	private static final long serialVersionUID = 1L;
	
	
	public static void text() {
		
		int width = 100, height = 10;
		JTextArea t =new JTextArea("hello");
	    t.setFont(t.getFont().deriveFont(50f));
	    t.setBounds(width, height, width, height);
	    t.setAlignmentY(Component.TOP_ALIGNMENT);
    
	}
}	