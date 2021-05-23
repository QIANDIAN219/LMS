package Frame;

import Class.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ShowBook extends JFrame {
    public ShowBook(List<Book> list) {
        initComponents(list);
    }
    private void initComponents(List<Book> list) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        scrollPane = new JScrollPane();
        table = new JTable();
        button1 = new JButton("增加");
        button2 = new JButton("更新");
        button3 = new JButton("删除");

        String value[][] = CheckConditionBook.listToArray(list);
        String title[] = {" ", "图书编号", "图书名", "作者", "出版社", "类别", "状态"};
        DefaultTableModel tableModel = new DefaultTableModel(value, title){
            public boolean isCallEditable(int row, int colum){
                return false;
            }
        };

        table.setModel(tableModel);

        //======== scrollPane1 ========
        {
            scrollPane.setViewportView(table);
        }
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.add(scrollPane);
        int x = 50, y = 50, width = 700, height = 300;
        scrollPane.setBounds(x, y, width, height);
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(250, 450), button1.getPreferredSize()));
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new AddBook();
                    }
                }
        );
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(350, 450), button2.getPreferredSize()));
        button2.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new UpdateBook(list.get(table.getSelectedRow()));
                    }
                }
        );
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(450, 450), button3.getPreferredSize()));
        button3.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book book = list.get(table.getSelectedRow());
                        book.deleteBook();
                        JOptionPane.showMessageDialog(null, "删除成功", "删除", JOptionPane.INFORMATION_MESSAGE);
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
        contentPane.setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JScrollPane scrollPane;
    private JTable table;
    private JButton button1;
    private JButton button2;
    private JButton button3;
}
