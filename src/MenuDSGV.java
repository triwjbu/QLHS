import java.io.IOException;
import java.util.Scanner;

public class MenuDSGV {

    public void menu() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            DSGiangVien dsgv = new DSGiangVien();

            dsgv.readFile();

        int choose = 0;
        do {
            System.out.println("      -----------------MENU ------------------------- ");
            System.out.println("      vui long chon chuc nang: ");
            System.out.print(
                    "             1.Tao Moi danh sach giao vien\n"
                            + "             2.In danh sach giao vien ra man hinh.\n"
                            + "             3.Them giao vien moi.\n"
                            + "             4.Xoa giao vien.\n"
                            + "             5.Sua giao vien.\n"
                            + "             6.Tim kiem giao vien.\n"
                            + "             7.Ghi danh sach giao vien vo file.\n"
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
                case 1:
                    dsgv.nhap();
                    break;
                case 2:
                    dsgv.xuat();
                    break;

                    // update
                    case 3:
                        dsgv.them();
                        break;
                        
                    case 4:
                        dsgv.xoa();
                        break;
                    case 5:
                        dsgv.sua();
                        break;

                // update
                case 6:
                    dsgv.tim();
                    break;
                    
                case 7:
                    dsgv.writeFile();
                    break;
                default:
                    break;
            }
        } while (choose != 0);
    }

}
