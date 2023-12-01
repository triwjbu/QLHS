import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSGiangVien extends GiangVien {
    private GiangVien dsgv[];
    Scanner sc = new Scanner(System.in);
    int n;

    public DSGiangVien() {
    }

    // ------------ Nhập mới danh sách ---------------
    public void nhap() {
        // nhập n từ bàn phím
        System.out.println("Nhap so giang vien can them:");
        n = sc.nextInt();

        // nhap n giang vien
        dsgv = new GiangVien[n];

        for (int i = 0; i < n; i++) {
            dsgv[i] = new GiangVien();
            dsgv[i].nhap();
        }
        writeFile();
    }

    // UPDATE

    // -------------------Xuất danh sách -----------------
    public void xuat() {
        System.out.println(
                "+-------+--------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-5s | %-17s | %-10s | %-4s | %-15s | %-12s | %-19s | %-12s | %-14s | %-11s |\n",
                "MGV", "Ho va ten", "Ngay sinh", "GT", "Dia chi", "SDT", "Chuyen mon", "Luong gio", "So gio lam",
                "TienLuong");
        System.out.println(
                "+-------+--------------------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < dsgv.length; i++) {

            if (Integer.valueOf(dsgv[i].getTrangThai()).equals(1)) {
                dsgv[i].xuat();
            }
            System.out.println(
                    "+-------+--------------------------------------------------------------------------------------------------------------------------------------------+");

        }
    }

    // Update có thể thêm 1 hoặc nhiều giảng viên

    // ---------------------Thêm giáo viên mới ------------------------
    public void them() {
        System.out.println("Them giao vien moi");

        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap so giang vien can them ");
        int a = Integer.parseInt(sc.nextLine());
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
                n = dsgv.length;

                dsgv = Arrays.copyOf(dsgv, n + 1);

                dsgv[n] = new GiangVien();
                dsgv[n].setiD(n + 1);
                dsgv[n].setMaGV(n + 1);
                dsgv[n].nhap();

                n++;
            }
        }

    }

    public void them(GiangVien x) {

        n = dsgv.length;

        dsgv = Arrays.copyOf(dsgv, n + 1);

        dsgv[n] = new GiangVien(x);
        n++;
    }

    // ---------------------- Xoa 1 Giao Vien -----------------------------------
    public void xoa() throws IOException {
        Scanner sc = new Scanner(System.in);
        readFile();
        System.out.printf("Nhap ma giao vien muon xoa: ");
        int findMaGV = sc.nextInt();
        int check = 0;
        for (int i = 0; i < dsgv.length; i++) {
            if (Integer.valueOf(dsgv[i].getMaGV()).equals(findMaGV)) {
                dsgv[i].setTrangThai(0);
                System.out.printf("Xoa thanh cong!!!\n");
                check = 1;
            }
        }
        if (check == 0) {
            System.out.printf("Ma giang vien khong ton tai !!!\n1.Nhap lai\n2.Exit\n");
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
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ma giang vien muon sua: ");
        int editID = sc.nextInt();
        int check = 0;
        String Empty = "";
        for (int i = 0; i < dsgv.length; i++) {
            if (Integer.valueOf(dsgv[i].getMaGV()).equals(editID)) {
                check = 1;
                String ten = dsgv[i].getTen();
                String ngaySinh = dsgv[i].getNgaySinh();
                int luongGio = dsgv[i].getLuongGio();
                int soGio = dsgv[i].getSoGio();
                String chuyenMon = dsgv[i].getChuyenMon();
                dsgv[i].sua();
                if (dsgv[i].getTen().equals(Empty)) {
                    dsgv[i].setTen(ten);
                }
                if (dsgv[i].getNgaySinh().equals(Empty)) {
                    dsgv[i].setNgaySinh(ngaySinh);
                }
                if (Integer.valueOf(dsgv[i].getLuongGio()).equals(Empty)) {
                    dsgv[i].setLuongGio(luongGio);
                }
                if (Integer.valueOf(dsgv[i].getSoGio()).equals(Empty)) {
                    dsgv[i].setSoGio(soGio);
                }
                if (dsgv[i].getChuyenMon().equals(Empty)) {
                    dsgv[i].setChuyenMon(chuyenMon);
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

    // UPDATE

    // -------------------------Tìm kiếm------------------------
    public void tim() {
        Scanner sc = new Scanner(System.in);
        n = dsgv.length;
        System.out.print("Nhap thong tin giang vien can tim: ");
        String input = sc.nextLine();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|  Ma Giao Vien |       Ho va Ten \t|\t Ngay sinh \t|   Gioi tinh \t|\tDia chi\t|\tSDT\t|\tMail\t\tChuyen mon\t|\t Luong gio \t|  So gio lam \t|      Tong Luong \t|");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // hàm tìm kiếm theo Mã giáo viên hoặc Tên hoặc Ngày sinh hoặc Chuyên
        // môn
        for (int i = 0; i < n; i++) {
            if (input.trim().equalsIgnoreCase(dsgv[i].getTen().trim()) || input.equals(dsgv[i].getNgaySinh())
                    || input.trim().equalsIgnoreCase(dsgv[i].getChuyenMon().trim())
                    || input.equals(Integer.toString(dsgv[i].getMaGV()))
                            && Integer.valueOf(dsgv[i].getTrangThai()).equals(1)) {
                // có thể copy hàm xuất từ GiangVien.java qua bên này
                dsgv[i].xuat();

            }

        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }

    // ---------------------- Ghi file ----------------------

    public void writeFile() {
        File f = new File("DAO\\giangvien.txt");
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
        for (int i = 0; i < dsgv.length; i++) {
            s += dsgv[i].toString() + "\n";
        }
        return s;
    }

    // ------------------- Đọc File -----------------------------

    public void readFile() throws IOException {
        int i = 0;
        dsgv = new GiangVien[0];
        FileReader fr = new FileReader("DAO\\giangvien.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = br.readLine();
            while (line != null) {
                String tmp[] = line.split(";");
                int iD = Integer.valueOf(tmp[0]);
                String ten = tmp[1];
                String ngaySinh = tmp[2];
                String gioiTinh = tmp[3];
                String diachi = tmp[4];
                String sdt = tmp[5];
                String email = tmp[6];
                int luongGio = Integer.valueOf(tmp[7]);
                int soGio = Integer.valueOf(tmp[8]);
                int maGV = Integer.valueOf(tmp[9]);
                String chuyenMon = tmp[10];
                int trangThai = Integer.valueOf(tmp[11]);
                int chunhiem = Integer.valueOf(tmp[12]);
                i++;
                dsgv = Arrays.copyOf(dsgv, i);
                dsgv[i - 1] = new GiangVien(iD, ten, ngaySinh, gioiTinh, diachi, sdt, email, luongGio, soGio, maGV,
                        chuyenMon, trangThai, chunhiem);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            br.close();
            fr.close();
        }
    }

    public GiangVien[] getDsgv() {
        return dsgv;
    }

    public void setDsgv(GiangVien[] dsgv) {
        this.dsgv = dsgv;
    }

}
