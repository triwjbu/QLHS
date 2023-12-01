import java.io.IOException;
import java.util.Scanner;

public class MenuDSSV {
    public void menu() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            DSQuanLiSinhVien dssv = new DSQuanLiSinhVien();

            dssv.readFile();

            int choose = 0;
            do {
                System.out.println("      -----------------MENU ------------------------- ");
                System.out.println("      Vui long chon chuc nang: ");
                System.out.print(
                        "             1.Tao Moi danh sach sinh vien\n"
                                + "             2.In danh sach sinh vien ra man hinh.\n"
                                + "             3.Them sinh vien moi.\n"
                                + "             4.Xoa sinh vien.\n"
                                + "             5.Sua sinh vien.\n"
                                + "             6.Tim kiem sinh vien.\n"
                                // + "             7.Ghi danh sach sinh vien vo file.\n"
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
                        dssv.nhap();
                        break;
                    case 2:
                        dssv.xuat();
                        break;
                    case 3:
                        dssv.them();
                        break;
                    case 4:
                        dssv.xoa();
                        break;
                    case 5:
                        dssv.sua();
                        break;
                    case 6:
                        dssv.tim();
                        break;
                    // case 7:
                    //     dssv.writeFile();
                    //     break;
                    default:
                        break;
                }
            } while (choose != 0);
        }
    }

}
