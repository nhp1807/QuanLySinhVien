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
    private JButton btnQuanLy, btnDanhSach, btnThongTin, btnThoat, btnCapNhat, btnCLB;

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
        pnThongTin.setPreferredSize(new Dimension(0, 200));
        pnThongTin.setBackground(new Color(93, 167, 232));
        JLabel lbThongTin = new JLabel("Quản lý sinh viên");
        lbThongTin.setHorizontalAlignment(JLabel.CENTER);
        lbThongTin.setVerticalAlignment(JLabel.CENTER);
        lbThongTin.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        //lbThongTin.setForeground(Color.WHITE);
        JLabel lbCreatedBy = new JLabel("Version 1.0");
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
        pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
        JPanel pn1 = new JPanel();
        pn1.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        pn1.setBackground(new Color(165, 213, 255));
        JPanel pn2 = new JPanel();
        pn2.setBackground(new Color(165, 213, 255));
        pn2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        JPanel pn3 = new JPanel();
        pn3.setLayout(new FlowLayout(FlowLayout.CENTER));
        pn3.setBackground(new Color(165, 213, 255));

        btnQuanLy = new JButton("Quản lý");
        btnQuanLy.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/home.png"))));
        btnDanhSach = new JButton("Danh sách");
        btnDanhSach.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/list.png"))));
        btnThongTin = new JButton("Thông tin");
        btnThongTin.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/info.png"))));
        btnThoat = new JButton("Thoát");
        btnThoat.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/exit.png"))));
        btnCLB = new JButton("CLB");
        btnCLB.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/team.png"))));
        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setIcon(new ImageIcon(Objects.requireNonNull(MainUI.class.getResource("/image/update.png"))));
        customButton(btnQuanLy);
        customButton(btnDanhSach);
        customButton(btnThongTin);
        customButton(btnThoat);
        customButton(btnCLB);
        customButton(btnCapNhat);
        JLabel lb = new JLabel("Menu");
        lb.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

        pn1.add(btnQuanLy);
        pn1.add(btnDanhSach);
        pn1.add(btnThongTin);
        pn2.add(btnCLB);
        pn2.add(btnCapNhat);
        pn2.add(btnThoat);
        pn3.add(lb);
        pnChucNang.add(Box.createVerticalGlue());
        pnChucNang.add(pn3);
        pnChucNang.add(pn1);
        pnChucNang.add(pn2);
        pnChucNang.add(Box.createVerticalGlue());
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
        btn.setIconTextGap(20);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(300, 250));
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
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
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
