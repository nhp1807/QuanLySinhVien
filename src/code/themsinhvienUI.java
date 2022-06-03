package code;
import Model.SinhVien;
import connect.Service;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

public class themsinhvienUI extends JFrame {
    //Attribute
    private int width = 600;
    private int height = 400;
    private JButton btnThem, btnQuayLai, btnChonAnh;
    private JTextField txtHoTen, txtKhoa, txtMSSV, txtLop, txtGPA, txtDRL;
    private JLabel lbHoTen, lbKhoa, lbMSSV, lbLop, lbGPA, lbDRL;
    private Vector<SinhVien> dsSinhVien;
    private JPanel pnAnh;

    //Constructor
    public themsinhvienUI() {
        addControls();
        addEvents();
        showWindows();
    }

    //AddControls
    public void addControls() {
        //Thông tin sinh viên
        JPanel pnThongTin = new JPanel();
        pnThongTin.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbThongTin = new JLabel("Thông tin sinh viên");
        lbThongTin.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        pnThongTin.add(lbThongTin);
        pnThongTin.setBackground(new Color(143, 184, 255));

        //Nhập thông tin sinh viên
        JPanel pnNhapThongTin = new JPanel();
        pnNhapThongTin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel[] pnBang = new JPanel[6];
        for (int i = 0; i < 6; i++) {
            pnBang[i] = new JPanel();
            pnBang[i].setLayout(new FlowLayout(FlowLayout.CENTER));
            pnBang[i].setBackground(new Color(0, 0, 0, 0));
        }
        //Tên
        lbHoTen = new JLabel("Họ và tên: ");
//        lbHoTen.setPreferredSize(new Dimension(100, 25));
        customLabel(lbHoTen);
        txtHoTen = new JTextField(20);
        pnBang[0].add(lbHoTen);
        pnBang[0].add(txtHoTen);
        //Khoa
        lbKhoa = new JLabel("Khoá: ");
//        lbKhoa.setPreferredSize(lbHoTen.getPreferredSize());
        customLabel(lbKhoa);
        txtKhoa = new JTextField(20);
        pnBang[1].add(lbKhoa);
        pnBang[1].add(txtKhoa);
        //MSSV
        lbMSSV = new JLabel("MSSV: ");
//        lbMSSV.setPreferredSize(lbHoTen.getPreferredSize());
        customLabel(lbMSSV);
        txtMSSV = new JTextField(20);
        pnBang[2].add(lbMSSV);
        pnBang[2].add(txtMSSV);
        //Lop
        lbLop = new JLabel("Lớp: ");
//        lbLop.setPreferredSize(lbHoTen.getPreferredSize());
        customLabel(lbLop);
        txtLop = new JTextField(20);
        pnBang[3].add(lbLop);
        pnBang[3].add(txtLop);
        //GPA
        lbGPA = new JLabel("GPA: ");
//        lbGPA.setPreferredSize(lbHoTen.getPreferredSize());
        customLabel(lbGPA);
        txtGPA = new JTextField(20);
        pnBang[4].add(lbGPA);
        pnBang[4].add(txtGPA);
        //ĐRL
        lbDRL = new JLabel("ĐRL: ");
//        lbDRL.setPreferredSize(lbHoTen.getPreferredSize());
        customLabel(lbDRL);
        txtDRL = new JTextField(20);
        pnBang[5].add(lbDRL);
        pnBang[5].add(txtDRL);

        pnNhapThongTin.setLayout(new BoxLayout(pnNhapThongTin, BoxLayout.Y_AXIS));
        pnNhapThongTin.add(Box.createVerticalGlue());

        for (int i = 0; i < 6; i++) {
            pnNhapThongTin.add(pnBang[i]);
        }

        pnNhapThongTin.add(Box.createVerticalGlue());
        pnNhapThongTin.setBackground(new Color(252, 228, 192));

        //Ảnh sinh viên
        JLabel lbAnh = new JLabel();
        lbAnh.setIcon(new ImageIcon(Objects.requireNonNull(themsinhvienUI.class.getResource("/image/student.png"))));


        //Chức năng
        JPanel pnChucNang = new JPanel();
        pnChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnThem = new JButton("Thêm");
        btnQuayLai = new JButton("Quay lại");
        customButton(btnThem);
        customButton(btnQuayLai);
        pnChucNang.add(btnThem);
        pnChucNang.add(btnQuayLai);
        pnChucNang.setBackground(new Color(143, 184, 255));

        //Containter
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.add(pnThongTin, BorderLayout.NORTH);
        pnMain.add(pnChucNang, BorderLayout.SOUTH);
        pnMain.add(pnNhapThongTin, BorderLayout.CENTER);
        pnMain.add(lbAnh, BorderLayout.EAST);
        pnMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnMain.setBackground(new Color(143, 184, 255));
        con.add(pnMain);
    }

    //AddEvents
    public void addEvents() {
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten = txtHoTen.getText().trim();
                if (ten != null && ten.length() > 0) {
                    String khoa = txtKhoa.getText().trim();
                    if (khoa != null && khoa.length() > 0) {
                        String mssv = txtMSSV.getText().trim();
                        if (mssv != null && mssv.length() > 0) {
                            if (!kiemTraSinhVienTonTai(mssv)) {
                                String lop = txtLop.getText().trim();
                                if (lop != null && lop.length() > 0) {
                                    String gpa = txtGPA.getText().trim();
                                    if (gpa != null && gpa.length() > 0) {
                                        String drl = txtDRL.getText().trim();
                                        if (drl != null && drl.length() > 0) {
                                            SinhVien sv = new SinhVien(ten, Integer.parseInt(khoa), mssv, lop, Double.parseDouble(gpa), Integer.parseInt(drl));
                                            boolean status = Service.themSinhVien(sv);
                                            //System.out.println(status);
                                            if (status) {
                                                JOptionPane.showMessageDialog(themsinhvienUI.this, "Thêm sinh viên thành công !");
                                                setVisible(false);
                                                //new quanlyUI();
                                            }
                                        } else if (drl != null && drl.equals("")) {
                                            JOptionPane.showMessageDialog(themsinhvienUI.this, "Điểm rèn luyện không được để trống", "Waring", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else if (gpa != null && gpa.equals("")) {
                                        JOptionPane.showMessageDialog(themsinhvienUI.this, "GPA không được để trống", "Waring", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else if (lop != null && lop.equals("")) {
                                    JOptionPane.showMessageDialog(themsinhvienUI.this, "Lớp không được để trống", "Waring", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(themsinhvienUI.this, "Sinh viên đã tồn tại");
                            }
                        } else if (mssv != null && mssv.equals("")) {
                            JOptionPane.showMessageDialog(themsinhvienUI.this, "MSSV không được để trống", "Waring", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (khoa != null && khoa.equals("")) {
                        JOptionPane.showMessageDialog(themsinhvienUI.this, "Khoá không được để trống", "Waring", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (ten != null && ten.equals("")) {
                    JOptionPane.showMessageDialog(themsinhvienUI.this, "Họ và tên không được để trống", "Waring", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //new quanlyUI();
            }
        });
    }

    //Function
    public void customButton(JButton btn) {
        btn.setFocusable(false);
        btn.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(100, 30));
        btn.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public void customLabel(JLabel lbl){
        lbl.setPreferredSize(new Dimension(100, 25));
        lbl.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
    }

    private boolean kiemTraSinhVienTonTai(String MSSV) {
        docDuLieu();
        for (SinhVien sv : dsSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(MSSV)) {
                return true;
            }
        }
        return false;
    }

    private void docDuLieu() {
        dsSinhVien = Service.layDanhSachSinhVien();
    }


    //ShowWindow
    public void showWindows() {
        setTitle("Thêm sinh viên");
        setUndecorated(true);
        pack();
        setResizable(false);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //TestMain
    public static void main(String[] args) {
        new themsinhvienUI();
    }
}
