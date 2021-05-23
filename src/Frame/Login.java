package Frame;

import Class.Account;
import Class.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame{
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        textField2 = new JTextField();
        label1 = new JLabel("管理员账号");
        label2 = new JLabel("管理员密码");
        button1 = new JButton("登录");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 90), label1.getPreferredSize()));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 130), label2.getPreferredSize()));
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
                        String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=?";
                        Connection connection = JDBC.LinkConnection();
                        PreparedStatement pstmt = null;
                        try {
                            pstmt = connection.prepareStatement(sql);
                            pstmt.setString(1, textField1.getText());
                            pstmt.execute();
                            ResultSet rs = pstmt.getResultSet();
                            rs.next();
                            Account account = new Account(rs);
                            if(account.getPassword().equals(textField2.getText())) {
                                JOptionPane.showMessageDialog(null, "登录成功", "登录", JOptionPane.INFORMATION_MESSAGE);
                                new Main();
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "账号或密码错误", "错误", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException throwables) {
                            JOptionPane.showMessageDialog(null, "账号或密码错误", "错误", JOptionPane.INFORMATION_MESSAGE);
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