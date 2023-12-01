import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DSQuanLiLop extends Lop {
    private Lop dsLop[];
    private static DSQuanLiKhoa dsk;
    private static DSGiangVien dsgv;
    Scanner sc = new Scanner(System.in);
    int n;

    public DSQuanLiLop() {
    }

    // ------------ Nhập mới danh sách ---------------
    public void nhap() {
        // Nhập số lớp từ bàn phím
        System.out.println("Nhap so lop can them:");
        n = sc.nextInt();
        sc.nextLine();

        // Nhập thông tin cho từng lớp
        dsLop = new Lop[n];
        nhapmoi();
        writeFile();
    }

    public void nhapmoi() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin lop thu " + (i + 1) + " : ");
            themlop(i);
        }
    }

    public void themlop(int i) {
        while (true) {

            dsLop[i] = new Lop();
            dsLop[i].nhap();

            // Kiểm tra tồn tại của khoa
            if (checkExistKhoa(dsLop[i].getMaKhoa()) != 1) {
                System.out.println("Nhap lai !! Khoa khong ton tai\n");
                continue; // Yêu cầu nhập lại thông tin cho lớp
            }

            // Kiểm tra giáo viên
            int result = checkExistGV(dsLop[i].getCoVanHocTap());
            if (result == -1) {
                System.out.println("Giao vien khong ton tai !!");
                System.out.println("Nhap lai !! \n");
                continue; // Yêu cầu nhập lại thông tin cho lớp
            } else if (result == 2) {
                System.out.println("Giao vien da co lop chu nhiem !!");
                System.out.println("Nhap lai !! \n");
                continue; // Yêu cầu nhập lại thông tin cho lớp
            }

            // lấy tên khoa từ mã
            dsk = new DSQuanLiKhoa();
            try {
                dsk.readFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (Khoa khoa : dsk.getDskhoa()) {
                if (khoa.getMaChu().equalsIgnoreCase(dsLop[i].getMaKhoa())) {
                    dsLop[i].setKhoa(khoa.getKhoa());
                }

            }

            // lấy tên giáo viên từ mã
            dsgv = new DSGiangVien();
            try {
                dsgv.readFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (GiangVien gv : dsgv.getDsgv()) {
                if (String.valueOf(gv.getMaGV()).equalsIgnoreCase(String.valueOf(dsLop[i].getCoVanHocTap()))) {
                    dsLop[i].setCoVanHocTap(gv.getTen());
                }

            }
            System.out.println();
            // Nếu không có lỗi, thoát khỏi vòng lặp
            break;
        }
    }

    // -------------------Xuất danh sách -----------------
    public void xuat() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|\t %-8s \t|\t %-30s \t|\t %-15s \t|\t %-20s \t|\n", "Ma Lop", "Ten Lop", "Khoa",
                "Co van Hoc tap");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < dsLop.length; i++) {
            if (Integer.valueOf(dsLop[i].getTrangThai()).equals(1)) {
                dsLop[i].xuat();
                // System.out.printf("|\t %-8d \t|\t %-30s \t|\t %-15s \t|\t %-20s \t|\n",
                // dsLop[i].getMaLop(), dsLop[i].getTenLop(), dsLop[i].getKhoa(),
                // dsLop[i].getCoVanHocTap());
            }
        }

        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // ---------------------Thêm lớp mới ------------------------
    public void them() {
        System.out.println("them lop moi: ");

        System.out.print("nhap so lop ban muon them: ");
        int temp = Integer.parseInt(sc.nextLine());
        if (temp <= 0) {
            System.out.print("\ngia tri khong hop le!!!\n1.Nhap lai \n2.Thoat");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    them();
                    break;
                default:
                    break;
            }
        } else {
            for (int i = 0; i < temp; i++) {
                n = dsLop.length;

                dsLop = Arrays.copyOf(dsLop, n + 1);

                dsLop[n] = new Lop();
                dsLop[n].setMaLop(n + 1);
                themlop(n);
                n++;
            }
        }
    }

    public void them(Lop x) {
        n = dsLop.length;

        dsLop = Arrays.copyOf(dsLop, n + 1);

        dsLop[n] = new Lop(x);
        n++;
    }

    // ---------------------- Xoa 1 lop ---------------------------------
    public void xoa() throws IOException {
        Scanner sc = new Scanner(System.in);
        readFile();
        System.out.printf("Nhap ma lop ban muon xoa: ");
        int findMaLop = sc.nextInt();
        int check = 0;
        for (int i = 0; i < dsLop.length; i++) {
            if (Integer.valueOf(dsLop[i].getMaLop()).equals(findMaLop)) {
                dsLop[i].setTrangThai(0);
                System.out.printf("Xoa thanh cong!\n");
                check = 1;
            }
        }
        if (check == 0) {
            System.out.printf("ma lop khong ton tai!!!\n1.Nhap lai\n2.Exit.\n");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    xoa();
                    break;
                default:
                    break;
            }
        } else {
            writeFile();
        }
    }

    // ---------------------- sua(edit) ---------------------------------
    public void sua() {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("nhap ma lop ban muon sua: ");
        int findID = sc.nextInt();
        int check = 0;
        String Empty = "";
        for (int i = 0; i < dsLop.length; i++) {
            if (Integer.valueOf(dsLop[i].getMaLop()).equals(findID)) {
                check = 1;
                String tenLop = dsLop[i].getTenLop();
                String khoa = dsLop[i].getKhoa();
                String coVanHocTap = dsLop[i].getCoVanHocTap();

                sualop(i);
                if (dsLop[i].getTenLop().equals(Empty)) {
                    dsLop[i].setTenLop(tenLop);
                }
                if (dsLop[i].getKhoa().equals(Empty)) {
                    dsLop[i].setKhoa(khoa);
                }
                if (dsLop[i].getCoVanHocTap().equals(Empty)) {
                    dsLop[i].setCoVanHocTap(coVanHocTap);
                }
            }
        }
        if (check == 0) {
            System.out.printf("Ma lop khong hop le!!!, moi ban nhap lai: ");
            sua();
            return;
        }
        writeFile();
    }

    public void sualop(int i) {
        while (true) {
            // hàm set lại chủ nhiêm cho hàm sửa
            updateChuNhiem(dsLop[i].getCoVanHocTap());

            dsLop[i] = new Lop();
            dsLop[i].sua();

            // Kiểm tra tồn tại của khoa
            if (checkExistKhoa(dsLop[i].getMaKhoa()) != 1) {
                System.out.println("Nhap lai !! Khoa khong ton tai\n");
                continue; // Yêu cầu nhập lại thông tin cho lớp
            }

            // Kiểm tra giáo viên
            int result = checkExistGV(dsLop[i].getCoVanHocTap());
            if (result == -1) {
                System.out.println("Giao vien khong ton tai !!");
                System.out.println("Nhap lai !! \n");
                continue; // Yêu cầu nhập lại thông tin cho lớp
            } else if (result == 2) {
                System.out.println("Giao vien da co lop chu nhiem !!");
                System.out.println("Nhap lai !! \n");
                continue; // Yêu cầu nhập lại thông tin cho lớp
            }

            // lấy tên khoa từ mã
            dsk = new DSQuanLiKhoa();
            try {
                dsk.readFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (Khoa khoa : dsk.getDskhoa()) {
                if (khoa.getMaChu().equalsIgnoreCase(dsLop[i].getMaKhoa())) {
                    dsLop[i].setKhoa(khoa.getKhoa());
                }

            }

            // lấy tên giáo viên từ mã
            dsgv = new DSGiangVien();
            try {
                dsgv.readFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (GiangVien gv : dsgv.getDsgv()) {
                if (String.valueOf(gv.getMaGV()).equalsIgnoreCase(String.valueOf(dsLop[i].getCoVanHocTap()))) {
                    dsLop[i].setCoVanHocTap(gv.getTen());
                }

            }

            // Nếu không có lỗi, thoát khỏi vòng lặp
            break;
        }
    }

    // ---------------------- tim kiem lop ----------------------
    public void tim() {
        n = dsLop.length;
        System.out.print("Nhap thong tin lop ma ban muon tim: ");
        String input = sc.nextLine();

        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|\t %-8s \t|\t %-30s \t|\t %-15s \t|\t %-20s \t|\n", "Ma Lop", "Ten Lop", "Khoa",
                "Co van Hoc tap");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            if (input.equals(Integer.toString(dsLop[i].getMaLop()))
                    || input.trim().equalsIgnoreCase(dsLop[i].getTenLop().trim())
                    || input.trim().equalsIgnoreCase(dsLop[i].getKhoa().trim())
                    || input.trim().equalsIgnoreCase(dsLop[i].getCoVanHocTap().trim())) {
                dsLop[i].xuat();
            }
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // ---------------------- Ghi file ----------------------
    public void writeFile() {
        File f = new File("DAO\\lop.txt");
        try (FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw)) {
            // Ghi dữ liệu vào tệp tin
            bw.write(toString());

            System.out.printf("da ghi du lieu thanh cong\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < dsLop.length; i++) {
            s += dsLop[i].toString() + "\n";
        }
        return s;
    }

    // ------------------- Đọc File -----------------------------
    public void readFile() throws IOException {
        int i = 0;
        dsLop = new Lop[0];
        FileReader fr = new FileReader("DAO\\lop.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = br.readLine();
            while (line != null) {
                String tmp[] = line.split(";");
                int maLop = Integer.valueOf(tmp[0]);
                String tenLop = tmp[1];
                String maKhoa = tmp[2];
                String khoa = tmp[3];
                String coVanHocTap = tmp[4];
                int trangThai = Integer.valueOf(tmp[5]);
                i++;
                dsLop = Arrays.copyOf(dsLop, i);
                dsLop[i - 1] = new Lop(maLop, tenLop, maKhoa, khoa, coVanHocTap, trangThai);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR");
        } finally {
            br.close();
            fr.close();
        }
    }

    public Lop[] getdsLop() {
        return dsLop;
    }

    public void setLop(Lop[] dsLop) {
        this.dsLop = dsLop;
    }

    // kiểm tra tồn tại khoa
    public int checkExistKhoa(String Khoa) {
        DSQuanLiKhoa dsk = new DSQuanLiKhoa();
        try {
            dsk.readFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Khoa khoa : dsk.getDskhoa()) {
            if (khoa.getMaChu().equalsIgnoreCase(Khoa)) {
                return 1;
            }
        }
        return -1;
    }

    // kiểm tra tồn tại giảng viên
    public int checkExistGV(String GiangVien) {
        dsgv = new DSGiangVien();
        try {
            dsgv.readFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (GiangVien gv : dsgv.getDsgv()) {
            if (String.valueOf(gv.getMaGV()).equalsIgnoreCase(GiangVien)) {

                if (gv.getChunhiem() == 0) {
                    // giảng viên đã có lớp chủ nhiệm
                    return 2;
                } else {
                    gv.setChunhiem(0);
                    dsgv.writeFile();
                    // giảng viên phù hợp
                    return 1;
                }
            }
        }
        // giảng viên không tồn tại
        return -1;
    }

    public void updateChuNhiem(String GiangVien) {
        DSGiangVien dsgv = new DSGiangVien();
        try {
            dsgv.readFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (GiangVien gv : dsgv.getDsgv()) {
            if (gv.getTen().trim().equalsIgnoreCase(GiangVien)) {

                if (gv.getChunhiem() == 0) {
                    gv.setChunhiem(1);
                    dsgv.writeFile();
                }
            }
        }

    }
}
