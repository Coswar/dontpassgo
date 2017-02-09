import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.DefaultCaret;



  
public class Monopoly2 extends Canvas{  
  
	private static final long serialVersionUID = 1L;
	private static String ENTER = "Enter";
    static JButton enterButton;
    public static JTextArea text_box_top_right;
    public static JTextField text_box_bottom_right;
	
    public static void main(String[] args) {
    	  		
    	// Creating the frame,set window title and define the exit 
        JFrame f = new JFrame("Monopoly");
        
        // When we close the window the program will end
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create JPanels to encompass the various elements and define the layout manager used within each panel
        JPanel board_p = new JPanel(new BorderLayout());
        JPanel frame_p = new JPanel();
        JPanel right_p = new JPanel();
        JPanel output = new JPanel();
        JPanel input = new JPanel();
        
        // Define the Layout manager used within the JPanels
        frame_p.setLayout(new BoxLayout(frame_p, BoxLayout.X_AXIS));
        right_p.setLayout(new BoxLayout(right_p, BoxLayout.Y_AXIS));
        
        // Import the board image from the board class
        board board_image = new board();
        
        //grib layout testing - ignore for now
        
        //Gridlayout Layout new GridLayout(1,1);
        //right_p.(new GridLayout(1, 1));

        //create a text input panel, add text_box class to it
        text_box_top_right = new JTextArea(15, 50);
        output.add(text_box_top_right);
        output.setLayout(new BoxLayout(output, BoxLayout.X_AXIS));
        JScrollPane scroller = new JScrollPane(text_box_top_right);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //disable editing within the display box
        text_box_top_right.setWrapStyleWord(true);
        text_box_top_right.setEditable(false);
        text_box_top_right.setWrapStyleWord(true);
        DefaultCaret caret = (DefaultCaret) text_box_top_right.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        
        //create a text output panel, add text_display class to it 
        text_box_bottom_right = new JTextField(20);
        input.add(text_box_bottom_right);
        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
        ButtonListener buttonListener = new ButtonListener();
        enterButton = new JButton("Enter");
        enterButton.setActionCommand(ENTER);
        enterButton.addActionListener(buttonListener);
        text_box_bottom_right.setActionCommand(ENTER);
        text_box_bottom_right.addActionListener(buttonListener);
        text_box_bottom_right.requestFocus();
        
        // Colour in frames to see boundaries in order to size correctly
        frame_p.setBackground(Color.green);
        board_p.setBackground(Color.black);
        output.setBackground(Color.red);
        input.setBackground(Color.orange);
        
        //resizing area for size of right panel vs left
        Dimension temp = new Dimension(300,629);
        right_p.setPreferredSize(temp);
        right_p.setMaximumSize(temp);
        right_p.setMinimumSize(temp);
        right_p.add(scroller);
        //add sub-panels to the framing panel
        right_p.add(output);
        right_p.add(input);
        board_p.add(board_image);
        frame_p.add(board_p);
        frame_p.add(right_p);
         	
        // Add the frame-panel to the Jframe 
        f.add(frame_p);
        
        // Set the size and visibility of the frame
        f.setResizable(false);
        f.setSize(906, 629);  
        f.setVisible(true);
        
        
    }
    
    //class to print input to output panel
    public static class ButtonListener implements ActionListener
    {

        public void actionPerformed(final ActionEvent ev)
        {
            if (!text_box_bottom_right.getText().trim().equals(""))
            {
                String cmd = ev.getActionCommand();
                if (ENTER.equals(cmd))
                {
                	text_box_top_right.append(text_box_bottom_right.getText());
                	text_box_top_right.append("\n");
                }
            }
            text_box_bottom_right.setText("");
            text_box_bottom_right.requestFocus();
        }
    }
    
   
}
