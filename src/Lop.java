import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Lop implements Comparable<Lop>,Serializable{
    private static int maLoptemp = 0;
    private int maLop;
    private String tenLop;
    private String maKhoa;
    private String khoa;
    private String coVanHocTap;
    private int trangThai = 1;
    Scanner sc = new Scanner(System.in);

    private Lop dsLop[];

    public Lop(int maLop, String tenLop,String maKhoa, String khoa, String coVanHocTap, int trangThai) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
        this.khoa = khoa;
        this.coVanHocTap = coVanHocTap;
        this.trangThai = trangThai;
    }

    public Lop(Lop x) {
        maLop = x.maLop;
        tenLop = x.tenLop;
        maKhoa = x.maKhoa;
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

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
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
        System.out.print("moi ma khoa: ");
        setMaKhoa(sc.nextLine());
        System.out.print("moi nhap ma co van hoc tap cua lop: ");
        setCoVanHocTap(sc.nextLine());
    }

    @Override
    public String toString() {
        return maLop + ";" + tenLop + ";"+ maKhoa + ";" + khoa + ";" + coVanHocTap + ";" + trangThai + ";";
    }

    public void xuat() {
        System.out.printf("|\t %-8s \t|\t %-30s \t|\t %-15s \t|\t %-20s \t|\n", maLop, tenLop, khoa, coVanHocTap);
    }

    public void sua() {
        System.out.println("moi nhap ten lop: ");
        setTenLop(sc.nextLine());
        System.out.println("moi nhap khoa: ");
        setMaKhoa(sc.nextLine());
        System.out.println("moi nhap ten co van hoc tap: ");
        setCoVanHocTap(sc.nextLine());
    }


    // kiểm tra xem hai đối tượng có bằng nhau không.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lop other = (Lop) obj;
        return Objects.equals(this.maLop, other.maLop);
    }

    // so sánh hai đối tượng của lớp Lop để có thể sắp xếp chúng.
    @Override
    public int compareTo(Lop o) {
        return Integer.compare(this.maLop,o.maLop);
    }
}