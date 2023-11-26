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

public class DSQuanLiKhoa {
    private Khoa dskhoa[];
    Scanner sc = new Scanner(System.in);
    int n;

    public DSQuanLiKhoa() {
    }

    // ------------ Nhập mới danh sách ---------------
    public void nhap() {
        // nhập n từ bàn phím
        System.out.println("Nhap so khoa can them:");
        n = sc.nextInt();

        // nhap n giang vien
        dskhoa = new Khoa[n];

        for (int i = 0; i < n; i++) {
            dskhoa[i] = new Khoa();
            dskhoa[i].nhapkhoa();
            System.out.println();
        }
    }

    // -------------------Xuất danh sách -----------------
    public void xuat() {
        int n = 0;
        for (int i = 0; i < dskhoa.length; i++) {
            if (Integer.valueOf(dskhoa[i].getTrangThai()).equals(1)) {
                System.out.println("Khoa " + ++n + " la:");
                System.out.println(dskhoa[i]);
                // dskhoa[i].xuat();
            }
        }
    }

    // ---------------------Thêm giáo viên mới ------------------------
    public void them() {
        System.out.println("Them khoa moi:");
        n = dskhoa.length;
        dskhoa = Arrays.copyOf(dskhoa, n + 1);
        dskhoa[n] = new Khoa();
        dskhoa[n].setMaKhoa(n + 1);
        dskhoa[n].nhapkhoa();
        n++;
    }

    public void them(Khoa x) {
        n = dskhoa.length;
        dskhoa = Arrays.copyOf(dskhoa, n + 1);
        dskhoa[n] = new Khoa(x);
        n++;
    }

    // ---------------------- Xoa 1 Sinh Vien -----------------------------------
    public void xoa() throws IOException {
        Scanner sc = new Scanner(System.in);
        readFile();
        System.out.printf("Nhap ma khoa muon xoa: ");
        int findMaKhoa = sc.nextInt();
        int check = 0;
        for (int i = 0; i < dskhoa.length; i++) {
            if (Integer.valueOf(dskhoa[i].getMaKhoa()).equals(findMaKhoa)) {
                dskhoa[i].setTrangThai(0);
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
    public void sua() throws IOException {
        readFile();
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ma khoa muon sua: ");
        int editID = sc.nextInt();
        int check = 0;
        String Empty = "";
        for (int i = 0; i < dskhoa.length; i++) {
            if (Integer.valueOf(dskhoa[i].getMaKhoa()).equals(editID)) {
                check = 1;
                String ten = dskhoa[i].getKhoa();
                dskhoa[i].sua();
                if (dskhoa[i].getKhoa().equals(Empty)) {
                    dskhoa[i].setKhoa(Empty);
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
        File f = new File("DAO\\khoa.txt");
        try (FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw)) {
            // Ghi dữ liệu vào tệp tin
            bw.write(toString());
            System.out.println("Da ghi du lieu thanh cong");
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < dskhoa.length; i++) {
            s += dskhoa[i].toString() + "\n";
        }
        return s;
    }

    // ------------------- Đọc File -----------------------------
    public void readFile() throws IOException {
        int i = 0;
        dskhoa = new Khoa[0];
        FileReader fr = new FileReader("DAO\\sinhvien.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = br.readLine();
            while (line != null) {
                String tmp[] = line.split(";");
                int maKhoa = Integer.valueOf(tmp[0]);
                String khoa = tmp[1];
                String maChu = tmp[2];
                int trangThai = Integer.valueOf(tmp[3]);
                i++;
                dskhoa = Arrays.copyOf(dskhoa, i);
                dskhoa[i - 1] = new Khoa(maKhoa,khoa,maChu,trangThai);
                line = br.readLine();
            }
        } catch (Exception e) {
        } finally {
            br.close();
            fr.close();
        }
    }

    public Khoa[] getDskhoa() {
        return dskhoa;
    }

    public void setDskhoa(Khoa[] dskhoa) {
        this.dskhoa = dskhoa;
    }

}
