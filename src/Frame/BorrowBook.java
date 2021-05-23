package Frame;

import Class.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        textField1 = new JTextField();
        textField2 = new JTextField();
        label1 = new JLabel("图书证编号");
        label2 = new JLabel("图书编号");
        button1 = new JButton("借书");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 90), label1.getPreferredSize()));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(40, 130), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(100, 90, 90, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(100, 130, 90, textField2.getPreferredSize().height);
        contentPane.add(button1);
        button1.setBounds(115, 160, 60, 20);
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Reader reader = new Reader(textField1.getText());
                        Book book = new Book(textField2.getText());
                        Record.borrowBook(book, reader);
                        JOptionPane.showMessageDialog(null, "借书成功", "借书", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
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
        contentPane.setPreferredSize(new Dimension(300, 300));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
}
