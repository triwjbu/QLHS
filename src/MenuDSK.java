import java.io.IOException;
import java.util.Scanner;

public class MenuDSK {
    public void menu() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            DSQuanLiKhoa dskhoa = new DSQuanLiKhoa();

            dskhoa.readFile();

            int choose = 0;
            do {
                System.out.println("-----------------MENU ------------------------- ");
                System.out.println("vui long chon chuc nang: ");
                System.out.print(
                        "             1.Tao Moi danh sach khoa\n"
                                + "             2.In danh sach khoa ra man hinh.\n"
                                + "             3.Them khoa moi.\n"
                                + "             4.xoa khoa.\n"
                                + "             5.sua khoa.\n"
                                + "             6.tim kim khoa.\n"
                                + "             7.Ghi danh sach khoa vo file.\n"
                                + "             0.Thoat khoi chuong trinh.\n"
                                + "Ban muon lam gi: ");
                try {
                    choose = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
                    continue; // Quay lại vòng lặp để yêu cầu nhập lại
                }
                System.out.println();
                switch (choose) {
                    case 1:
                        dskhoa.nhap();
                        break;
                    case 2:
                        dskhoa.xuat();
                        break;
                    case 3:
                        dskhoa.them();
                        break;
                    case 4:
                        dskhoa.xoa();
                        break;
                    case 5:
                        dskhoa.sua();
                        break;
                    case 6: 
                        dskhoa.tim();  
                        break;    
                    case 7:
                        dskhoa.writeFile();
                        break;
                    default:
                        break;
                }
            } while (choose != 0);
        }
    }

}