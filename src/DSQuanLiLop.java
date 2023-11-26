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

public class DSQuanLiLop {
    private Lop dsLop[];
    Scanner sc = new Scanner(System.in);
    int n;

    public DSQuanLiLop() {
    }
    // ------------ Nhập mới danh sách ---------------
    public void nhap (){
        // nhập n từ bàn phím
        System.out.println("Nhap so lop can them:");
        n = sc.nextInt();
        sc.nextLine();
        //nhap n lop
        dsLop = new Lop[n];

        for (int i = 0; i < n; i++){
            dsLop[i] = new Lop();
            dsLop[i].nhap();
            System.out.println();
        }
    }

    // -------------------Xuất danh sách -----------------
    public void xuat(){
        int n = 0;
        for (int i = 0; i < dsLop.length; i++){

            if (Integer.valueOf(dsLop[i].getTrangThai()).equals(1)) {
                System.out.print("Lop "+ ++n + " la: ");
                System.out.println(dsLop[i]);
            }
        }
    }

    // ---------------------Thêm giáo viên mới ------------------------
    public void them(){
        System.out.println("them lop moi: ");
        n=dsLop.length;
        dsLop = Arrays.copyOf(dsLop, n + 1);

        dsLop[n] = new Lop();
        dsLop[n].setMaLop(n+1);
        dsLop[n].nhap();

        n++;
    }

    public void them(Lop x){
         n = dsLop.length;

         dsLop = Arrays.copyOf(dsLop, n + 1);

         dsLop[n] = new Lop(x);
         n++;
    }

    // ---------------------- Xoa 1 Giao Vien ---------------------------------
    public void xoa() throws IOException {
        Scanner sc = new Scanner(System.in);
        readFile();
        System.out.printf("Nhap ma lop ban muon xoa: ");
        int findMaLop = sc.nextInt();
        int check = 0;
        for (int i = 0; i <dsLop.length; i++){
            if (Integer.valueOf(dsLop[i].getMaLop()).equals(findMaLop)){
                dsLop[i].setTrangThai(0);
                System.out.printf("Xoa thanh cong!\n");
                check=1;
            }
        }
        if (check==0){
            System.out.printf("ma giao vien khong ton tai!!!\n1.Nhap lai\n2.Exit.\n");
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
    public void sua() throws IOException {
        readFile();
        System.out.printf("nhap ma lop ban muon sua: ");
        int findID = sc.nextInt();
        int check = 0;
        String Empty = "";
        for (int i = 0; i < dsLop.length; i++){
            if (Integer.valueOf(dsLop[i].getMaLop()).equals(findID)){
                check = 1;
                String tenLop = dsLop[i].getTenLop();
                String khoa = dsLop[i].getKhoa();
                String coVanHocTap = dsLop[i].getCoVanHocTap();

                dsLop[i].sua();
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
        if (check==0) {
            System.out.printf("Ma lop khong hop le!!!, moi ban nhap lai: ");
            sua();
            return;
        }
        writeFile();
    }

     // ---------------------- Ghi file ----------------------
    public void writeFile(){
        File f = new File("DAO\\lop.txt");
        try(FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw)){
            // Ghi dữ liệu vào tệp tin
            bw.write(toString());

            System.out.printf("da ghi du lieu thanh cong\n");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public String toString(){
        String s = "";
        for (int i = 0; i <dsLop.length; i++){
            s += dsLop[i].toString() + "\n";
        }
        return s;
    }

    // ------------------- Đọc File -----------------------------
    public void readFile() throws IOException{
        int i=0;
        dsLop = new Lop[0];
        FileReader fr = new FileReader("DAO\\lop.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line = br.readLine();
            while (line != null) {
                String tmp[] = line.split(";");
                int maLop = Integer.valueOf(tmp[0]);
                String tenLop = tmp[1];
                String khoa = tmp[2];
                String coVanHocTap = tmp[3];
                int trangThai = Integer.valueOf(tmp[4]);
                i++;
                dsLop = Arrays.copyOf(dsLop, i);
                dsLop[i-1] = new Lop(maLop, tenLop, khoa, coVanHocTap, trangThai);
                line = br.readLine();
            }
            } catch (IOException e) {
                System.out.println("ERROR");
            } finally{
                br.close();
                fr.close();
            }
    }

    public Lop[] getLops(){
        return dsLop;
    }

    public void setLop(Lop[] dsLop){
        this.dsLop = dsLop;
    }
}
