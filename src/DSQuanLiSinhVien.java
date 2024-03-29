import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSQuanLiSinhVien extends SinhVien {
    private SinhVien dssv[];
    private DSQuanLiLop dsLop;
    static Scanner sc = new Scanner(System.in);
    int n;

    public DSQuanLiSinhVien() {
    }

    // ------------ Nhập mới danh sách ---------------
    public void nhap() {
        // nhập n từ bàn phím
        System.out.print("Nhap so sinh vien can them:");
        n = sc.nextInt();
        // nhap n giang vien
        dssv = new SinhVien[n];

        nhapmoi();
        writeFile();

    }

    public void nhapmoi() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin Sinh vien thu " + (i + 1) + " : ");
            themSv(i);
        }
    }

    public void themSv(int i) {
        while (true) {
            dssv[i] = new SinhVien();
            dssv[i].nhap();

            // Kiem tra su ton tai cua lop
            // getlop là lấy mã lớp
            if (checkExistLop(dssv[i].getLop()) != 1) {
                System.out.println("Nhap lai!!!. Lop khong ton tai\n");
                continue;
            }

            dsLop = new DSQuanLiLop();
            try {
                dsLop.readFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (Lop lop : dsLop.getdsLop()) {
                if (String.valueOf(lop.getMaLop()).equalsIgnoreCase(String.valueOf(dssv[i].getLop()))) {
                    dssv[i].setLop(lop.getTenLop());
                }

            }

            break;
        }
    }

    // -------------------Xuất danh sách -----------------
    public void xuat() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-5s | %-17s | %-10s | %-4s | %-15s | %-12s | %-19s | %-12s |\n",
                "MGV", "Ho va ten", "Ngay sinh", "GT", "Dia chi", "SDT", "email", "lop");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < dssv.length; i++) {

            if (Integer.valueOf(dssv[i].getTrangThai()).equals(1)) {
                dssv[i].xuat();
            }

        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // ---------------------Thêm------------------------
    public void them() {
        System.out.println("Them sinh vien moi");
        System.out.print("\nNhap so sinh vien can them ");
        int a = sc.nextInt();
        if (a <= 0) {
            System.out.print("Gia tri khong phu hop!\n1.Nhap lai \n2.Thoat");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    them();
                    break;
                default:
                    break;
            }
        } else {
            for (int i = 0; i < a; i++) {
                n = dssv.length;

                dssv = Arrays.copyOf(dssv, n + 1);

                dssv[n] = new SinhVien();
                dssv[n].setiD(n + 1);
                dssv[n].setMaSV(n + 1);
                themSv(n);
                n++;
            }
        }

    }

    public void them(SinhVien x) {

        n = dssv.length;

        dssv = Arrays.copyOf(dssv, n + 1);

        dssv[n] = new SinhVien(x);
        n++;

    }

    // ---------------------- Xoa 1 Sinh Vien -----------------------------------
    public void xoa() throws IOException {
        readFile();
        System.out.printf("Nhap ma sinh vien muon xoa: ");
        int findMaSV = sc.nextInt();
        int check = 0;
        for (int i = 0; i < dssv.length; i++) {
            if (Integer.valueOf(dssv[i].getMaSV()).equals(findMaSV)) {
                dssv[i].setTrangThai(0);
                System.out.printf("Xoa thanh cong!!!\n");
                check = 1;
            }
        }
        if (check == 0) {
            System.out.printf("Ma sinh vien khong ton tai !!!\n1.Nhap lai\n2.Exit\n");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    xoa();
                    break;
                default:
                    break;
            }
        } else
            writeFile();
    }

    // -------------------------- Sua(Edit) ---------------------------------------
    public void sua() {
        try {
            readFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.printf("Nhap ma sinh vien muon sua: ");
        int editID = sc.nextInt();
        int check = 0;
        String Empty = "";
        for (int i = 0; i < dssv.length; i++) {
            if (Integer.valueOf(dssv[i].getMaSV()).equals(editID)) {
                int temp = dssv[i].getMaSV();
                check = 1;
                String ten = dssv[i].getTen();
                String ngaySinh = dssv[i].getNgaySinh();
                String gioiTinh = dssv[i].getSDT();
                String diachi = dssv[i].getDiaChi();
                String sdt = dssv[i].getSDT();
                String email = dssv[i].getMail();
                themSv(i);
                dssv[i].setMaSV(temp);
                 dssv[i].setiD(temp);
                if (dssv[i].getTen().equals(Empty)) {
                    dssv[i].setTen(ten);
                }
                if (dssv[i].getNgaySinh().equals(Empty)) {
                    dssv[i].setNgaySinh(ngaySinh);
                }
                if (dssv[i].getGioiTinh().equals(Empty)) {
                    dssv[i].setGioiTinh(gioiTinh);
                }
                if (dssv[i].getDiaChi().equals(Empty)) {
                    dssv[i].setDiaChi(diachi);
                }
                if (dssv[i].getSDT().equals(Empty)) {
                    dssv[i].setSDT(sdt);
                }
                if (dssv[i].getMail().equals(Empty)) {
                    dssv[i].setEmail(email);
                }
            }
        }
        if (check == 0) {
            System.out.printf("Ma nhap khong hop le, moi nhap lai !!!\n");
            sua();
            return;
        }
        writeFile();
    }

    // ---------------------- Ghi file ----------------------

    public void writeFile() {
        File f = new File("DAO\\sinhvien.txt");
        try (FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw)) {

            // Ghi dữ liệu vào tệp tin
            bw.write(toString());

            System.out.println("Da ghi du lieu thanh cong");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < dssv.length; i++) {
            s += dssv[i].toString() + "\n";
        }
        return s;
    }

    // ------------------- Đọc File -----------------------------

    public void readFile() throws IOException {
        int i = 0;
        dssv = new SinhVien[0];
        FileReader fr = new FileReader("DAO\\sinhvien.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = br.readLine();
            while (line != null) {
                String tmp[] = line.split(";");
                int iD = Integer.valueOf(tmp[0]);
                String ten = tmp[1];
                String ngaySinh = tmp[2];
                String gioiTinh = tmp[3];
                String diaChi = tmp[4];
                String sdt = tmp[5];
                String mail = tmp[6];
                int maSV = Integer.valueOf(tmp[7]);
                String lop = tmp[8];

                int trangThai = Integer.valueOf(tmp[9]);
                i++;
                dssv = Arrays.copyOf(dssv, i);
                dssv[i - 1] = new SinhVien(iD, ten, ngaySinh, gioiTinh, diaChi, sdt, mail, maSV, lop, trangThai);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            br.close();
            fr.close();
        }
    }

    public SinhVien[] getDssv() {
        return dssv;
    }

    public void setDsgv(SinhVien[] dssv) {
        this.dssv = dssv;
    }

    // -------------------------Tìm kiếm------------------------
    public void tim() {
        n = dssv.length;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin sinh vien can tim: ");
        String input = sc.nextLine();
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|  MSSV |\tHo va Ten\t|\tNgay sinh\t|   Gioi tinh   |   Dia chi\t|\t    SDT    \t|\t    Email    \t|");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");

        // hàm tìm kiếm theo Mã sinh viên hoặc Tên hoặc Ngày sinh
        for (int i = 0; i < n; i++) {
            if (input.trim().equalsIgnoreCase(dssv[i].getTen().trim()) || input.equals(dssv[i].getNgaySinh())
            /* || input.trim().equalsIgnoreCase(dssv[i].getLop().trim()) */
                    || input.equals(Integer.toString(dssv[i].getMaSV()))
                            && Integer.valueOf(dssv[i].getTrangThai()).equals(1)) {
                // có thể copy hàm xuất từ GiangVien.java qua bên này
                dssv[i].xuat();
            }

        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }

    public int checkExistLop(String string) {
        DSQuanLiLop dsL = new DSQuanLiLop();
        try {
            dsL.readFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Lop lop : dsL.getdsLop()) {
            System.out.println(lop.getMaLop());
            System.out.println(string);
            if (String.valueOf(lop.getMaLop()).equalsIgnoreCase(String.valueOf(string))) {
                return 1;
            }
        }
        return -1;
    }

}