import java.io.IOException;
import java.util.Scanner;

public class MenuDSHC {

    public void menu() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            DSHanhChinh dshc = new DSHanhChinh();

            dshc.readFile();

            int choose = 0;
            do {
                System.out.println("      -----------------MENU ------------------------- ");
                System.out.println("      vui long chon chuc nang: ");
                System.out.print(
                        "             1.Tao Moi danh sach nhan vien hanh chinh\n"
                                + "             2.In danh sach nhan vien hanh chinh ra man hinh.\n"
                                + "             3.Them nhan vien hanh chinh moi.\n"
                                + "             4.xoa nhan vien hanh chinh.\n"
                                + "             5.sua nhan vien hanh chinh.\n"
                                + "             6.tim kiem nhan vien hanh chinh.\n"
                                + "             7.Ghi danh sach nhan vien hanh chinh vo file.\n"
                                + "             0.Thoat khoi chuong trinh.\n\n"
                                + "Ban muon lam gi: ");
                try {
                    choose = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Vui long nhap mot so hop le!!");
                    continue; // Quay lại vòng lặp để yêu cầu nhập lại
                }
                System.out.println();
                switch (choose) {
                    case 1-> dshc.nhap();
                    case 2-> dshc.xuat();
                    case 3-> dshc.them();
                    case 4-> dshc.xoa();
                    case 5-> dshc.sua();
                    case 6-> dshc.tim();
                    case 7-> dshc.writeFile();
                }
            } while (choose != 0);
        }
    }

}
