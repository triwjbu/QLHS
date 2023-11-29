import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Khoa implements Comparable<Khoa>,Serializable{
    private String khoa;
    private int maKhoa;
    private String maChu;
    private static int maKhoatmp = 1;
    private int trangThai = 1;
    static Scanner sc = new Scanner(System.in);

    public Khoa(int maKhoa, String khoa, String maChu, int trangThai) {
        this.khoa = khoa;
        this.maKhoa = maKhoa;
        this.trangThai = trangThai;
        this.maChu = maChu;
    }

    public Khoa(Khoa x) {
        khoa = x.khoa;
        maKhoa = x.maKhoa;
        trangThai = x.trangThai;
        maChu = x.maChu;
    }

    public String getKhoa() {
        return khoa;
    }

    public String getMaChu() {
        return maChu;
    }

    public Khoa() {
        this.maKhoa = maKhoatmp++;
    }

    public void setMaChu(String maChu) {
        this.maChu = maChu;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaKhoaTmp() {
        return maKhoatmp;
    }

    public void setMaKhoaTmp(int maKhoatmp) {
        this.maKhoatmp = maKhoatmp;
    }

    public void nhapkhoa() {
        System.out.println("Nhap ten khoa: ");
        setKhoa(sc.nextLine());

        // Nhập chữ mã khoa (VD: Công nghệ thông tin --> DCT)
        System.out.println("Nhap chu ma khoa: ");
        setMaChu(sc.nextLine());
        
    }

    public String toString() {
        return maKhoa + ";" + khoa + ";" + maChu + ";" + trangThai + ";";
    }

    public void xuat() {
        System.out.println("|\t" + getMaKhoa() + "\t|\t" + getKhoa() + "\t|\t" + getMaChu() + "\t|");
    }

    public void sua() {
        setKhoa(khoa);
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
        final Khoa other = (Khoa) obj;
        return Objects.equals(this.maKhoa, other.maKhoa);
    }

    // so sánh hai đối tượng của lớp Khoa để có thể sắp xếp chúng.
    @Override
    public int compareTo(Khoa o) {
        return Integer.compare(this.maKhoa,o.maKhoa);
    }
}