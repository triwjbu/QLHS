import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSHanhChinh extends NhanVienHanhChinh {
    private NhanVienHanhChinh dshc[];
    Scanner sc = new Scanner(System.in);
    int n;

    public DSHanhChinh() {
    }

    // ------------ Nhập mới danh sách ---------------
    public void nhap() {
        // nhập n từ bàn phím
        System.out.println("Nhap so nhan vien hanh chinh can them:");
        n = Integer.parseInt(sc.nextLine());

        // nhap n nhan vien hanh chinh
        dshc = new NhanVienHanhChinh[n];

        for (int i = 0; i < n; i++) {
            dshc[i] = new NhanVienHanhChinh();
            dshc[i].nhap();
        }
    }

    // UPDATE

    // -------------------Xuất danh sách -----------------
    public void xuat() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| %-12s | %-25s | %-10s | %-9s | %-20s | %-25s | %-15s | %-20s |", 
        "Ma Nhan vien", "Ho va Ten", "Ngay sinh", "Gioi tinh", "Chuc vu", "Luong gio", "So gio lam","Tong Luong"));
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < dshc.length; i++) {

            if (Integer.valueOf(dshc[i].getTrangThai()).equals(1)) {
                dshc[i].xuat();
            }

        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // ---------------------Thêm giáo viên mới ------------------------
    public void them() {
        System.out.println("Them Nhan vien hanh chinh moi");

        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap so nhan vien hanh chinh can them ");
        int a = Integer.parseInt(sc.nextLine());
        if (a <= 0) {
            System.out.print("Gia tri khong phu hop!\n1.Nhap lai \n2.Thoat");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1->them();
            }
        } else {
            for (int i = 0; i < a; i++) {
                n = dshc.length;

                dshc = Arrays.copyOf(dshc, n + 1);

                dshc[n] = new NhanVienHanhChinh();
                dshc[n].setiD(n + 1);
                dshc[n].setMaNV(n + 1);
                dshc[n].nhap();

                n++;
            }
        }

    }

    public void them(NhanVienHanhChinh x) {

        n = dshc.length;

        dshc = Arrays.copyOf(dshc, n + 1);

        dshc[n] = new NhanVienHanhChinh(x);
        n++;

    }

    // ---------------------- Xoa 1 Nhan vien hanh chinh -----------------------------------
    public void xoa() throws IOException {
        Scanner sc = new Scanner(System.in);
        readFile();
        System.out.printf("Nhap ma Nhan vien hanh chinh muon xoa: ");
        int findMaNV = Integer.parseInt(sc.nextLine());
        int check = 0;
        for (int i = 0; i < dshc.length; i++) {
            if (Integer.valueOf(dshc[i].getMaNV()).equals(findMaNV)) {
                dshc[i].setTrangThai(0);
                System.out.printf("Xoa thanh cong!!!\n");
                check = 1;
            }
        }
        if (check == 0) {
            System.out.printf("Ma nhan vien khong ton tai !!!\n1.Nhap lai\n2.Exit\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1->xoa();
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
        System.out.printf("Nhap ma nhan vien muon sua: ");
        int editID = Integer.parseInt(sc.nextLine());
        int check = 0;
        String Empty = "";
        for (int i = 0; i < dshc.length; i++) {
            if (Integer.valueOf(dshc[i].getMaNV()).equals(editID)) {
                check = 1;
                String ten = dshc[i].getTen();
                String ngaySinh = dshc[i].getNgaySinh();
                int luongGio = dshc[i].getLuongGio();
                int soGio = dshc[i].getSoGio();
                String chucVu = dshc[i].getChucVu();
                dshc[i].sua();
                if (dshc[i].getTen().equals(Empty)) {
                    dshc[i].setTen(ten);
                }
                if (dshc[i].getNgaySinh().equals(Empty)) {
                    dshc[i].setNgaySinh(ngaySinh);
                }
                if (Integer.valueOf(dshc[i].getLuongGio()).equals(Empty)) {
                    dshc[i].setLuongGio(luongGio);
                }
                if (Integer.valueOf(dshc[i].getSoGio()).equals(Empty)) {
                    dshc[i].setSoGio(soGio);
                }
                if (dshc[i].getChucVu().equals(Empty)) {
                    dshc[i].setChucVu(chucVu);
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
        n = dshc.length;
        System.out.print("Nhap thong tin nhan vien hanh chinh can tim: ");
        String input = sc.nextLine();
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| %-12s | %-25s | %-10s | %-9s | %-20s | %-25s | %-15s | %-20s |", 
        "Ma Nhan vien", "Ho va Ten", "Ngay sinh", "Gioi tinh", "Chuc vu", "Luong gio", "So gio lam","Tong Luong"));
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            if (input.trim().equalsIgnoreCase(dshc[i].getTen().trim()) || input.equals(dshc[i].getNgaySinh())
                    || input.trim().equalsIgnoreCase(dshc[i].getChucVu().trim())
                    || input.equals(Integer.toString(dshc[i].getMaNV()))
                            && Integer.valueOf(dshc[i].getTrangThai()).equals(1)) {
                dshc[i].xuat();
            }

        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }

    // ---------------------- Ghi file ----------------------

    public void writeFile() {
        File f = new File("DAO\\hanhchinh.txt");
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
        for (int i = 0; i < dshc.length; i++) {
            s += dshc[i].toString() + "\n";
        }
        return s;
    }

    // ------------------- Đọc File -----------------------------

    public void readFile() throws IOException {
        int i = 0;
        dshc = new NhanVienHanhChinh[0];
        FileReader fr = new FileReader("DAO\\hanhchinh.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = br.readLine();
            while (line != null) {
                String tmp[] = line.split(";");
                int iD = Integer.valueOf(tmp[0]);
                String ten = tmp[1];
                String ngaySinh = tmp[2];
                String gioiTinh = tmp[3];
                int luongGio = Integer.valueOf(tmp[4]);
                int soGio = Integer.valueOf(tmp[5]);
                int maGV = Integer.valueOf(tmp[6]);
                String chucVu = tmp[7];
                int trangThai = Integer.valueOf(tmp[8]);
                i++;
                dshc = Arrays.copyOf(dshc, i);
                dshc[i - 1] = new NhanVienHanhChinh(iD, ten, ngaySinh, gioiTinh, luongGio, soGio, maGV, chucVu, trangThai);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            br.close();
            fr.close();
        }
    }

    public NhanVienHanhChinh[] getdshc() {
        return dshc;
    }

    public void setdshc(NhanVienHanhChinh[] dshc) {
        this.dshc = dshc;
    }

}
