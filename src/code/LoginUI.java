package code;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoginUI extends JFrame {
    JButton btnExit;
    JButton btnMinimize;
    JButton btnLogin;
    JTextField txtEmail;
    JPasswordField txtPassword;
    JCheckBox cbShowPass;

    public LoginUI(String title) {
        super(title);
        addControls();
        addEvent();
        showWindow();
    }

    private void addControls() {
        Container conMain = getContentPane();
        conMain.setLayout(new BorderLayout());
        //Setting panel main
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.setPreferredSize(new Dimension(800, 600));
        conMain.add(pnMain);

        //Setting panel Center and East
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.setPreferredSize(new Dimension(400, 600));
        pnCenter.setBackground(new Color(40, 65, 9));

        JPanel pnEast = new JPanel();
        pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));
        pnEast.setPreferredSize(new Dimension(400, 600));

        //Add panel Center and East -> panel main
        pnMain.add(pnCenter, BorderLayout.CENTER);
        pnMain.add(pnEast, BorderLayout.EAST);

        //Add cac panel vao panel Center
        //Panel app FB, Web,..
        JPanel pnApp = new JPanel();
        pnApp.setPreferredSize(new Dimension(400, 200));
        pnApp.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnApp.setBackground(new Color(165, 213, 255));
        pnCenter.add(pnApp);

        JLabel lblFb = new JLabel();
        lblFb.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/facebook_35px.png"))));
        JLabel lblYt = new JLabel();
        lblYt.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/youtube_logo_35px.png"))));
        JLabel lblMail = new JLabel();
        lblMail.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/mail_35px.png"))));
        JLabel lblGithub = new JLabel();
        lblGithub.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/github_35px.png"))));
        JLabel lblLinkedin = new JLabel();
        lblLinkedin.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/linkedin_35px.png"))));
        pnApp.add(lblFb);
        pnApp.add(lblGithub);
        pnApp.add(lblLinkedin);
        pnApp.add(lblYt);
        pnApp.add(lblMail);

        //Setting Panel Welcome
        JPanel pnWel = new JPanel();
        pnWel.setPreferredSize(new Dimension(400, 100));
        pnWel.setBackground(new Color(165, 213, 255));
        pnCenter.add(pnWel);

        JLabel lblWel = new JLabel();
        lblWel.setText("WELCOME!");
        lblWel.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        lblWel.setForeground(new Color(34, 68, 97));

        JLabel lblLoWel = new JLabel();
        lblLoWel.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/education_100px.png"))));
        pnWel.add(lblLoWel);
        pnWel.add(lblWel);

        //Setting Panel StudentManegement
        JPanel pnStu = new JPanel();
        pnStu.setPreferredSize(new Dimension(400, 100));
        pnStu.setBackground(new Color(165, 213, 255));
        pnCenter.add(pnStu);

        JLabel lblStu = new JLabel();
        lblStu.setText("STUDENT MANEGEMENT");
        lblStu.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        lblStu.setForeground(new Color(34, 68, 97));
        pnStu.add(lblStu);

        //Setting Panel Null Center
        JPanel pnNullCenter = new JPanel();
        pnNullCenter.setPreferredSize(new Dimension(400, 200));
        pnNullCenter.setBackground(new Color(165, 213, 255));
        pnCenter.add(pnNullCenter);

        //Add panel -> panel East
        //Setting panel Exit and Minimize
        JPanel pnExitMinimize = new JPanel();
        pnExitMinimize.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnExitMinimize.setPreferredSize(new Dimension(400, 50));
        pnExitMinimize.setBackground(new Color(93, 167, 232));
        pnEast.add(pnExitMinimize);

        btnExit = new JButton();
        btnExit.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/cancel_30px.png"))));
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setBorder(null);

        btnMinimize = new JButton();
        btnMinimize.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/macos_minimize_30px.png"))));
        btnMinimize.setOpaque(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setBorder(null);

        pnExitMinimize.add(btnMinimize);
        pnExitMinimize.add(btnExit);

        //Setting panel logo
        JPanel pnLogo = new JPanel();
        pnLogo.setPreferredSize(new Dimension(400, 150));
        pnLogo.setBackground(new Color(93, 167, 232));
        pnEast.add(pnLogo);

        //Add logo to panel logo
        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/user_shield_100px.png"))));
        pnLogo.add(lblLogo);

        //Setting panel email
        JPanel pnEmail = new JPanel();
        pnEmail.setPreferredSize(new Dimension(400, 20));
        pnEmail.setBackground(new Color(93, 167, 232));
        pnEast.add(pnEmail);

        JLabel lblEmail = new JLabel();
        lblEmail.setText("Email");
        lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        lblEmail.setForeground(Color.BLACK);
        pnEmail.add(lblEmail);

        //Setting add logo and email textfield
        JPanel pnEmailLogo = new JPanel();
        pnEmailLogo.setPreferredSize(new Dimension(400, 80));
        pnEmailLogo.setBackground(new Color(93, 167, 232));
        pnEmailLogo.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnEast.add(pnEmailLogo);

        //Add logo and email textfield
        JLabel lblEmailLogo = new JLabel();
        lblEmailLogo.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/male_user_35px.png"))));
        pnEmailLogo.add(lblEmailLogo);

        txtEmail = new JTextField(20);
        txtEmail.setBackground(new Color(93, 167, 232));
        txtEmail.setPreferredSize(new Dimension(20, 32));
        txtEmail.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        txtEmail.setForeground(new Color(255, 255, 255));
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnEmailLogo.add(txtEmail);

        //Null panel email
        JPanel pnNullEmail = new JPanel();
        pnNullEmail.setPreferredSize(new Dimension(400, 20));
        pnNullEmail.setBackground(new Color(93, 167, 232));
        pnEast.add(pnNullEmail);

        //Setting panel password
        JPanel pnPassword = new JPanel();
        pnPassword.setPreferredSize(new Dimension(400, 20));
        pnPassword.setBackground(new Color(93, 167, 232));
        pnEast.add(pnPassword);

        JLabel lblPassword = new JLabel();
        lblPassword.setText("Password");
        lblPassword.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        lblPassword.setForeground(Color.BLACK);
        pnPassword.add(lblPassword);

        //Setting add logo and password textfield
        JPanel pnPasswordLogo = new JPanel();
        pnPasswordLogo.setPreferredSize(new Dimension(400, 50));
        pnPasswordLogo.setBackground(new Color(93, 167, 232));
        pnPasswordLogo.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnEast.add(pnPasswordLogo);

        //Add logo and password textfield
        JLabel lblPassLogo = new JLabel();
        lblPassLogo.setIcon(new ImageIcon(Objects.requireNonNull(LoginUI.class.getResource("/image/lock_35px.png"))));
        pnPasswordLogo.add(lblPassLogo);

        txtPassword = new JPasswordField(20);
        txtPassword.setBackground(new Color(93, 167, 232));
        txtPassword.setPreferredSize(new Dimension(20, 32));
        txtPassword.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        txtPassword.setForeground(new Color(255, 255, 255));
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnPasswordLogo.add(txtPassword);

        //Null panel password
        JPanel pnNullPass = new JPanel();
        pnNullPass.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnNullPass.setPreferredSize(new Dimension(400, 60));
        pnNullPass.setBackground(new Color(93, 167, 232));
        pnEast.add(pnNullPass);

        //Add check box show password
        cbShowPass = new JCheckBox();
        cbShowPass.setText("Show password");
        cbShowPass.setBackground(new Color(93, 167, 232));
        cbShowPass.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        cbShowPass.setForeground(Color.BLACK);
        cbShowPass.setOpaque(false);
        cbShowPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbShowPass.setBorder(null);
        cbShowPass.setFocusPainted(false);
        pnNullPass.add(cbShowPass);

        //Setting panel login
        JPanel pnLogin = new JPanel();
        pnLogin.setPreferredSize(new Dimension(400, 100));
        pnLogin.setBackground(new Color(93, 167, 232));
        pnEast.add(pnLogin);

        //Add button login to panel login
        btnLogin = new JButton();
        btnLogin.setText("   Login   ");
        btnLogin.setPreferredSize(new Dimension(150, 32));
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnLogin.setForeground(new Color(93, 167, 232));
        btnLogin.setBorder(null);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        pnLogin.add(btnLogin);

        //Setting panel Null East
        JPanel pnNullEast = new JPanel();
        pnNullEast.setPreferredSize(new Dimension(400, 50));
        pnNullEast.setBackground(new Color(93, 167, 232));
        pnEast.add(pnNullEast);
    }

    private void addEvent() {
        //btn exit
        btnExit.addActionListener(e -> System.exit(0));

        //btn minimize
        btnMinimize.addActionListener(e -> setState(ICONIFIED));

        //check box show password
        cbShowPass.addActionListener(e -> {
            if (cbShowPass.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        });
    }

    public void showWindow() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new LoginUI("Login");

    }
}
