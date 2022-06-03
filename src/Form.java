import javax.swing.*;

public class Form extends JFrame {
    //Attribute
    /**
     * Khu vực để thêm các thuộc tính, các component
     */

    //Constructor
    /**
     * Constructor để khởi tạo đối tượng thuộc lớp
     */
    public Form(){
        addControls();
        addEvents();
        showWindow();
    }

    //addControls() method
    /**
     * Phương thức addControls() sử dụng để thiết kế giao diện
     */
    public void addControls(){

    }

    //addEvents() method
    /**
     * Phương thức addEvents() sử dụng để thêm hành động cho các
     * component được hiển thị trên giao diện
     */
    public void addEvents(){

    }

    //function
    /**
    * Viết các hàm phụ phát sinh trong quá trình làm
    */

    //showWindow() method
    /**
     * Phương thức showWindow() sử dụng để hiển thị cửa sổ lên màn hình
     */
    public void showWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,300);
        setVisible(true);
    }
    //Test Main
    /**
     * Phương thức main() để test code trong quá trình hoàn thiện
     */
    public static void main(String[] args) {
        new Form();
    }
}

    /**
     *                  NHIỆM VỤ
     * Phong:
     *      Màn hình splash screen
     *      Màn hình chính GUI và chức năng đi kèm
     *      Kết nối cơ sở dữ liệu và các chức năng đi kèm
     * Đoàn:
     *      Giao diện Login và chức năng đi kèm
     *      Giao diện danh sách GUI và các chức năng đi kèm
     * Hiếu:
     *      Giao diện quản lý GUI và các chức năng thêm, xoá, chỉnh sửa
     *      Giao diện thông tin GUI: Thông tin project và thông tin nhóm
     */

    /**                 QUẢN LÝ BRANCH
     * Phong:
     *      splashscreen
     *      mainUI
     *      database
     *      themsinhvienUI
     * Đoàn:
     *      loginUI
     *      danhsachUI
     * Hiếu:
     *      quanlyUI
     *      thongtinUI
     */

    /**
     *                  SỬ DỤNG GITHUB
     * Chỉ sử dụng nhánh mình quản lý: git checkout <branch>
     * Không tự ý pull code về nhánh mình hay nhánh người khác
     * Chỉ push code của mình lên đúng nhánh mình quản lý: git push origin <branch>
     */

    /**
     *                  CẤU TRÚC FOLDER SRC
     * Folder "image": Sử dụng chứa hình ảnh trong quá trình làm
     * Folder "code": Sử dụng chứa file code về giao diện
     * Folder "Model": sử dụng chứa các đối tượng
     * Folder "connect": sử dụng chứa các lớp thao tác với cơ sở dữ liệu (Không sử dụng)
     */
