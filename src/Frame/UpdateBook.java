package Frame;

import Class.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UpdateBook extends JFrame {
    public UpdateBook(Book book){
        initComponents(book);
    }

    private void initComponents(Book book) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        label1 = new JLabel("图书编号");
        label2 = new JLabel("图书名称");
        label3 = new JLabel("图书作者");
        label4 = new JLabel("图书出版社");
        label5 = new JLabel("图书价格");
        label6 = new JLabel("图书摘要");
        label7 = new JLabel("图书分类");
        button1 = new JButton("更新");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 50), label1.getPreferredSize()));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(35, 80), label2.getPreferredSize()));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(35, 110), label3.getPreferredSize()));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 140), label4.getPreferredSize()));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(35, 170), label5.getPreferredSize()));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(35, 230), label6.getPreferredSize()));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(35, 290), label7.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(100, 50, 120, textField1.getPreferredSize().height);
        textField1.setText(book.getBookId());
        contentPane.add(textField2);
        textField2.setBounds(100, 80, 120, textField2.getPreferredSize().height);
        textField2.setText(book.getBookName());
        contentPane.add(textField3);
        textField3.setBounds(100, 110, 120, textField3.getPreferredSize().height);
        textField3.setText(book.getAuthor());
        contentPane.add(textField4);
        textField4.setBounds(100, 140, 120, textField4.getPreferredSize().height);
        textField4.setText(book.getPublisher());
        contentPane.add(textField5);
        textField5.setBounds(100, 170, 120, textField5.getPreferredSize().height);
        textField5.setText(Double.toString(book.getPrice()));
        contentPane.add(textField6);
        textField6.setBounds(100, 200, 200, textField6.getPreferredSize().height * 4);
        textField6.setText(book.getAbstracts());
        contentPane.add(textField7);
        textField7.setBounds(100, 290, 120, textField7.getPreferredSize().height);
        textField7.setText(book.getCatelog());

        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(100, 320), button1.getPreferredSize()));
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book book = new Book(textField1.getText(),textField2.getText(), textField3.getText(), textField4.getText(), Double.parseDouble(textField5.getText()), textField6.getText(), textField7.getText(), "在库");
                        book.updateBook();
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
        contentPane.setPreferredSize(new Dimension(400, 400));
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
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button1;
}
