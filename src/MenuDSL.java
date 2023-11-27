
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuDSL {
    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        DSQuanLiLop dsLop = new DSQuanLiLop();

        dsLop.readFile();

        int choose = 0;
        do {
            System.out.println("---------------------MENU---------------------");
            System.out.println("Vui long chon chuc nang: ");
            System.out.println(
                                "           1.Tao moi danh sach lop\n"
                                + "           2.In danh sach lop ra man hinh.\n"               
                                + "           3.Them lop moi.\n"
                                + "           4.Xoa lop.\n"
                                + "           5.Sua lop.\n"
                                + "           6.Tim kiem lop.\n"  
                                + "           7.Ghi danh sach lop vao file.\n"
                                + "           0.Thoat khoi chuong trinh.\n"
                                +"Ban muon chon chuc nang nao: ");
            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("vui long nhap mot so nguyen hop le!!!");
                continue; // Quay lại vòng lặp để yêu cầu nhập lại
            }
            System.out.println();
            switch (choose) {
                case 1:
                    dsLop.nhap();
                    break;
                case 2:
                    dsLop.xuat();
                    break;
                case 3:
                    dsLop.them();
                    break;
                case 4:
                    dsLop.xoa();
                    break;
                case 5:
                    dsLop.sua();
                    break;
                case 6:
                    dsLop.tim();
                    break;
                case 7:
                    dsLop.writeFile();
                    break;
                default:
                    break;
            }
        } while(choose != 0);
    }    
}
