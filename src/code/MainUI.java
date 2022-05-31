package code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.JPanel;

public class MainUI extends JFrame {
    //Attribute
    private int width = 700;
    private int height = 500;
    private JButton btnQuanLy, btnDanhSach, btnThongTin, btnThoat;

    //Constructor
    public MainUI(){
        addControls();
        addEvents();
        showWindows();
    }

    //Add control
    public void addControls(){
        //Tao khu vuc hien thi thong tin project
        JPanel pnThongTin = new JPanel();
        pnThongTin.setLayout(new BorderLayout());
        pnThongTin.setPreferredSize(new Dimension(0, 120));
        pnThongTin.setBackground(new Color(93, 167, 232));
        JLabel lbThongTin = new JLabel("Quản lý sinh viên");
        lbThongTin.setHorizontalAlignment(JLabel.CENTER);
        lbThongTin.setVerticalAlignment(JLabel.CENTER);
        lbThongTin.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        //lbThongTin.setForeground(Color.WHITE);
        JLabel lbCreatedBy = new JLabel("Created by nhp1807");
        lbCreatedBy.setHorizontalAlignment(JLabel.CENTER);
        lbCreatedBy.setVerticalAlignment(JLabel.CENTER);
        lbCreatedBy.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
        //lbCreatedBy.setForeground(Color.WHITE);

        JLabel lbLeft = new JLabel();
        lbLeft.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/school.png"))));
        lbLeft.setVerticalAlignment(JLabel.CENTER);
        lbLeft.setHorizontalAlignment(JLabel.CENTER);
        JLabel lbRight = new JLabel();
        lbRight.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/class.png"))));
        lbRight.setVerticalAlignment(JLabel.CENTER);
        lbRight.setHorizontalAlignment(JLabel.CENTER);

        pnThongTin.add(lbThongTin, BorderLayout.CENTER);
        pnThongTin.add(lbCreatedBy, BorderLayout.SOUTH);
        pnThongTin.add(lbLeft, BorderLayout.WEST);
        pnThongTin.add(lbRight, BorderLayout.EAST);

        //Tao khu vuc hien thi cac nut chuc nang
        JPanel pnChucNang = new JPanel();
        pnChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnQuanLy = new JButton("Quản lý");
        btnQuanLy.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/home.png"))));
        btnDanhSach = new JButton("Danh sách");
        btnDanhSach.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/list.png"))));
        btnThongTin = new JButton("Thông tin");
        btnThongTin.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/info.png"))));
        btnThoat = new JButton("Thoát");
        btnThoat.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/exit.png"))));
        customButton(btnQuanLy);
        customButton(btnDanhSach);
        customButton(btnThongTin);
        customButton(btnThoat);

        pnChucNang.add(btnQuanLy);
        pnChucNang.add(btnDanhSach);
        pnChucNang.add(btnThongTin);
        pnChucNang.add(btnThoat);
        pnChucNang.setBackground(new Color(165, 213, 255));
        pnChucNang.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));


        //Container
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.add(pnThongTin, BorderLayout.NORTH);
        pnMain.add(pnChucNang, BorderLayout.CENTER);
        con.add(pnMain);
    }

    //Function
    public void customButton(JButton btn){
        btn.setFocusable(false);
        btn.setIconTextGap(10);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(220, 150));
        btn.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    //Add event
    public void addEvents(){
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnQuanLy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new quanlyUI();
                setVisible(false);
            }
        });
    }
    //Show window
    public void showWindows(){
        setTitle("Quản lý sinh viên");
        setResizable(false);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Test main
    public static void main(String[] args) {
        new MainUI();
    }
}
