package Frame;
import Class.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Class.*;

public class ReturnBook extends JFrame {
    public ReturnBook() {
        initComponents();
    }

    public void initComponents(){
// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        button1 = new JButton("还书");
        label1 = new JLabel("图书编号");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(40, 90), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(100, 90, 90, textField1.getPreferredSize().height);
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(115, 120), button1.getPreferredSize()));
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book book = new Book(textField1.getText());
                        Record.returnBook(book);
                    }
                }
        );
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
        contentPane.setPreferredSize(new Dimension(300, 260));
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
    private JButton button1;
    private JLabel label1;
}
