import java.util.Scanner;

public class SinhVien extends Nguoi {
    private static int maSvtmp = 0;
    private int maSV;
    private String lop;
    private int trangThai = 1;
    static Scanner sc = new Scanner(System.in);

    public SinhVien(int iD, String ten, String ngaySinh, String gioiTinh,String diaChi,String sdt,String mail,int maSV,String lop,int trangThai) {
        super(iD, ten, ngaySinh, gioiTinh,diaChi,sdt,mail);
        this.maSV = maSV;
        this.lop = lop;
        this.trangThai = trangThai;
    }

    public SinhVien(SinhVien x) {
        super((SinhVien) x);
        maSV = x.maSV;
        lop = x.lop;
        trangThai = x.trangThai;
    }

    public SinhVien() {
        this.maSV = maSvtmp++;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap ma lop:");
        setLop(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + maSV + ";" + lop + ";" + trangThai + ";";
    }

    public void xuat() {

        System.out.printf("| %-5s | %-17s | %-10s | %-4s | %-15s | %-12s | %-19s | %-12s |\n",
                maSV, super.getTen(), super.getNgaySinh(), super.getGioiTinh(), super.getDiaChi(), super.getSDT(),
                super.getMail(), lop);
    }

    @Override
    public void sua() {
        super.sua();
        
    }
}
