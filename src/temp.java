import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class temp {
  private static Container layoutComponents(String title, float alignment) {
    String labels[] = { "-", "-", "-" };

    JPanel container = new JPanel();
    container.setBorder(BorderFactory.createTitledBorder(title));
    BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
    container.setLayout(layout);
    for (int i = 0, n = labels.length; i < n; i++) {
      JButton button = new JButton(labels[i]);
      button.setAlignmentY(alignment);
      container.add(button);
    }
    return container;
  }

  public static void main(String args[]) {
    JFrame frame = new JFrame("Alignment Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container panel1 = layoutComponents("Top", Component.TOP_ALIGNMENT);
    Container panel2 = layoutComponents("Center", Component.CENTER_ALIGNMENT);
    Container panel3 = layoutComponents("Bottom", Component.BOTTOM_ALIGNMENT);

    frame.setLayout(new GridLayout(1, 3));
    frame.add(panel1);
    frame.add(panel2);
    frame.add(panel3);

    frame.setSize(400, 150);
    frame.setVisible(true);
  }
}