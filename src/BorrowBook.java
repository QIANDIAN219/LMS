import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 18 10:27:20 CST 2021
 */



/**
 * @author unknown
 */
public class BorrowBook extends JFrame {
    public BorrowBook() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane = new JScrollPane();
        textField1 = new JTextField();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);


        contentPane.add(textField1);
        textField1.setBounds(100, 100, 90, 20);
        contentPane.add(textField2);
        textField2.setBounds(100, 130, 90, 20);
        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        contentPane.setPreferredSize(new Dimension(300, 300));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JTextField textField1;
    private JTextField textField2;
    private JScrollPane scrollPane;
}
