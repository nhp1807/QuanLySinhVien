package code;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class quanlyUI extends JFrame {
    private JButton btnThem, btnXoa, btnSua, btnThoat;
    private DefaultTableModel dtmTableDanhSach;
    private JTable tblDanhSach;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private int rowSelected = -1;

    public quanlyUI(String title){
        super(title);
        addControls();
        addEvents();
    }

    private void addControls(){
        //Tao panel danh sach
        JPanel pnDanhSach = new JPanel();
        pnDanhSach.setLayout(new BorderLayout());
        pnDanhSach.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
        dtmTableDanhSach = new DefaultTableModel();
        dtmTableDanhSach.addColumn("Họ tên");
        dtmTableDanhSach.addColumn("MSSV");
        dtmTableDanhSach.addColumn("Khoá");
        dtmTableDanhSach.addColumn("Lớp");
        dtmTableDanhSach.addColumn("GPA");
        dtmTableDanhSach.addColumn("ĐRL");
        tblDanhSach = new JTable(dtmTableDanhSach);
        Font headerFont = new Font("Bahnschrift", Font.PLAIN,15);
        JTableHeader tblHeader = tblDanhSach.getTableHeader();
        tblHeader.setFont(headerFont);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer = (DefaultTableCellRenderer) tblHeader.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblDanhSach.setDefaultEditor(Object.class, null);
        tblDanhSach.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblDanhSach.getColumnModel().getColumn(4).setPreferredWidth(10);
        tblDanhSach.getColumnModel().getColumn(5).setPreferredWidth(10);
        tblDanhSach.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblDanhSach.getColumnModel().getColumn(2).setPreferredWidth(10);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tblDanhSach.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tblDanhSach.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblDanhSach.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tblDanhSach.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        JScrollPane scrollDanhSach = new JScrollPane(tblDanhSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnDanhSach.add(scrollDanhSach, BorderLayout.CENTER);


        //Tao panel tim kiem
        JPanel pnTimKiem = new JPanel();
        pnTimKiem.setLayout(new GridBagLayout());
        pnTimKiem.setPreferredSize(new Dimension(100, 70));
        txtSearch = new JTextField(20);
        txtSearch.setPreferredSize(new Dimension(30,35));
        lblSearch = new JLabel();
        lblSearch.setIcon(new ImageIcon(Objects.requireNonNull(quanlyUI.class.getResource("/image/search.png"))));
        pnTimKiem.add(txtSearch);
        pnTimKiem.add(lblSearch);

        //Tao panel chuc nang
        JPanel pnChucNang = new JPanel();
        pnChucNang.setLayout(new GridBagLayout());
        pnChucNang.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Bahnschrift", Font.PLAIN, 18);
        btnThem = new JButton("Thêm");
        btnThem.setIcon(new ImageIcon(Objects.requireNonNull(quanlyUI.class.getResource("/image/add.png"))));
        btnThem.setFont(font);
        btnThem.setPreferredSize(new Dimension(120,50));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(8,0,8,0);
        pnChucNang.add(btnThem,gbc);
        btnXoa = new JButton("Xoá");
        btnXoa.setIcon(new ImageIcon(Objects.requireNonNull(quanlyUI.class.getResource("/image/erase.png"))));
        btnXoa.setFont(font);
        btnXoa.setPreferredSize(new Dimension(120,50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pnChucNang.add(btnXoa,gbc);
        btnSua = new JButton("Sửa");
        btnSua.setIcon(new ImageIcon(Objects.requireNonNull(quanlyUI.class.getResource("/image/edit.png"))));
        btnSua.setFont(font);
        btnSua.setPreferredSize(new Dimension(120,50));
        gbc.gridx = 0;
        gbc.gridy = 4;
        pnChucNang.add(btnSua,gbc);
        btnThoat = new JButton("Thoát");
        btnThoat.setIcon(new ImageIcon(Objects.requireNonNull(quanlyUI.class.getResource("/image/close.png"))));
        btnThoat.setFont(font);
        btnThoat.setPreferredSize(new Dimension(120,50));
        gbc.gridx = 0;
        gbc.gridy = 6;
        pnChucNang.add(btnThoat, gbc);

        //Tao container
        Container con = getContentPane();
        JPanel pnQuanLyDS = new JPanel();
        pnQuanLyDS.setLayout(new BorderLayout());
        pnQuanLyDS.add(pnDanhSach, BorderLayout.CENTER);
        pnQuanLyDS.add(pnChucNang, BorderLayout.EAST);
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.add(pnQuanLyDS, BorderLayout.CENTER);
        pnMain.add(pnTimKiem, BorderLayout.NORTH);
        con.add(pnMain);

    }

    private void addEvents(){
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rowSelected = tblDanhSach.getSelectedRow();
                if (rowSelected != -1){

                }
                else{
                    JOptionPane.showMessageDialog(quanlyUI.this, "Vui lòng chọn thông tin muốn xoá!");
                }
            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rowSelected = tblDanhSach.getSelectedRow();
                if (rowSelected != -1){

                }
                else{
                    JOptionPane.showMessageDialog(quanlyUI.this, "Vui loòng chọn thông tin muốn sửa!");
                }
            }
        });

        btnThoat.addActionListener(e -> quanlyUI.this.setVisible(false));

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


    }

    public void showWindows(){
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        quanlyUI ui = new quanlyUI("Quản lý sinh viên");
        ui.showWindows();
    }
}
