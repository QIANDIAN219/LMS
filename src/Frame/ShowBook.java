package Frame;

import Class.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShowBook extends JFrame {
    public ShowBook(List<Book> list) {
        initComponents(list);
    }
    private void initComponents(List<Book> list) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        scrollPane = new JScrollPane();
        button1 = new JButton("增加");
        button2 = new JButton("更新");
        button3 = new JButton("删除");

        String value[][] = CheckConditionBook.listToArray(list);
        String title[] = {" ", "图书编号", "图书名", "作者", "出版社", "类别", "状态"};
        DefaultTableModel tableModel = new DefaultTableModel(value, title);
        table = new JTable(tableModel);

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
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(350, 450), button2.getPreferredSize()));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(450, 450), button3.getPreferredSize()));
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JScrollPane scrollPane;
    private JTable table;
    private JButton button1;
    private JButton button2;
    private JButton button3;
}
