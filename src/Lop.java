import java.util.Scanner;

public class Lop {
    private static int maLoptemp = 1;
    private int maLop;
    private String tenLop;
    private String khoa;
    private String coVanHocTap;
    private int trangThai = 1;
    Scanner sc = new Scanner(System.in);

    private Lop dsLop[];

    public Lop(int maLop, String tenLop, String khoa, String coVanHocTap, int trangThai) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoa = khoa;
        this.coVanHocTap = coVanHocTap;
        this.trangThai = trangThai;
    }

    public Lop(Lop x) {
        maLop = x.maLop;
        tenLop = x.tenLop;
        khoa = x.khoa;
        coVanHocTap = x.coVanHocTap;
        trangThai = x.trangThai;
    }

    public Lop() {
        this.maLop = maLoptemp++;
    }

    public Lop(int maLop) {
        // this.maLop = maLoptemp++;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getCoVanHocTap() {
        return coVanHocTap;
    }

    public void setCoVanHocTap(String coVanHocTap) {
        this.coVanHocTap = coVanHocTap;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void nhap() {
        System.out.print("moi nhap ten lop: ");
        setTenLop(sc.nextLine());
        System.out.print("moi nhap khoa: ");
        setKhoa(sc.nextLine());
        System.out.print("moi nhap co van hoc tap cua lop: ");
        setCoVanHocTap(sc.nextLine());
    }

    @Override
    public String toString() {
        return maLop + ";" + tenLop + ";" + khoa + ";" + coVanHocTap + ";" + trangThai + ";";
    }

    public void xuat() {
        System.out.printf("|\t %-8s \t|\t %-30s \t|\t %-15s \t|\t %-20s \t|\n", maLop, tenLop, khoa, coVanHocTap);
    }

    public void sua() {
        System.out.println("moi nhap ten lop: ");
        setTenLop(sc.nextLine());
        System.out.println("moi nhap khoa: ");
        setKhoa(sc.nextLine());
        System.out.println("moi nhap ten co van hoc tap: ");
        setCoVanHocTap(sc.nextLine());
    }
}