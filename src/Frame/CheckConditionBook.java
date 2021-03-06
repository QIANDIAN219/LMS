package Frame;

import Class.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class CheckConditionBook extends JFrame {
    public CheckConditionBook(){
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        label1 = new JLabel("图书编号");
        label2 = new JLabel("图书名称");
        label3 = new JLabel("作者");
        label4 = new JLabel("出版社");
        label5 = new JLabel("类别");
        button1 = new JButton("查询");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(95, 50), label1.getPreferredSize()));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(95, 80), label2.getPreferredSize()));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(105, 110), label3.getPreferredSize()));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(100, 140), label4.getPreferredSize()));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(105, 170), label5.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(160, 50, 120, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(160, 80, 120, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(160, 110, 120, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(160, 140, 120, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(160, 170, 120, textField5.getPreferredSize().height);
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 250), button1.getPreferredSize()));
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book book = new Book(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), 0, null, textField5.getText(), null);
                        List<Book> list = null;
                        try {
                            list = Book.getBooks(book);
                            new ShowBook(list);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static String[][] listToArray(List<Book> list){
        String[][] strings = null;
        Book book = null;
        if(list.size() != 0){
            strings = new String[list.size()][7];
            for(int i = 0; i < list.size(); i++){
                book = list.get(i);
                strings[i][0] = String.valueOf(i+1);
                strings[i][1] = book.getBookId();
                strings[i][2] = book.getBookName();
                strings[i][3] = book.getAuthor();
                strings[i][4] = book.getPublisher();
                strings[i][5] = book.getCatelog();
                strings[i][6] = book.getStatus();
            }
        }
        return strings;
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton button1;

}
