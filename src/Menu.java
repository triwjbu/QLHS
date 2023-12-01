import java.io.IOException;
import java.util.Scanner;


public class Menu {
    public void menu() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            int choose = 0;
            do {
                System.out.println("                       +------------------------ MENU--------------------------+");
                System.out.println("                       |          1. Quan li giang vien                        |");
                System.out.println("                       |          2. Quan Li sinh vien                         |");
                System.out.println("                       |          3. Quan Li lop                               |");
                System.out.println("                       |          4. Quan Li khoa                              |");
                System.out.println("                       |          0. Exit                                      |");
                System.out.println("                       +-------------------------------------------------------+");
                System.out.print("Nhap lua chon: ");
                try {
                    choose = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
                    continue; // Quay lại vòng lặp để yêu cầu nhập lại
                }
                switch (choose) {
                    case 1:
                        MenuDSGV dsgv = new MenuDSGV();
                        dsgv.menu();
                        break;
                    case 2:
                        MenuDSSV dssv = new MenuDSSV();
                        dssv.menu();
                        break;
                    case 3:
                        MenuDSL dsl = new MenuDSL();
                        dsl.menu();
                        break;
                    case 4:
                        MenuDSK dsk = new MenuDSK();
                        dsk.menu();
                        break;
                    case 0:
                        break;
                }
            } while (choose != 0);
        }
    }
}
