import java.util.Scanner;

public class SinhVien extends Nguoi {
    private static int maSvtmp = 1;
    private int maSV;
    // private String lop;
    private int trangThai = 1;
    static Scanner sc = new Scanner(System.in);

    public SinhVien(int iD, String ten, String ngaySinh, String gioiTinh,String diaChi,String sdt,String mail,int maSV,int trangThai) {
        super(iD, ten, ngaySinh, gioiTinh,diaChi,sdt,mail);
        this.maSV = maSV;
        // this.lop = lop;
        this.trangThai = trangThai;
    }

    public SinhVien(SinhVien x) {
        super((SinhVien) x);
        maSV = x.maSV;
        // lop = x.lop;
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

    // public String getLop() {
    //     return lop;
    // }

    // public void setLop(String lop) {
    //     this.lop = lop;
    // }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public void nhap() {
        super.nhap();
        // System.out.print("Nhap lop:");
        // setLop(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + maSV + /*";" + lop +*/ ";" + trangThai + ";";
    }

    public void xuat() {
        System.out.println("|   " +maSV +"   |\t" +super.getTen() +"\t|\t"
        +super.getNgaySinh()+"\t|"+"\t"+ super.getGioiTinh()+"\t|   "+super.getDiaChi()+"\t|\t"+super.getSDT()+"\t|\t"
        +super.getMail()+"\t|");
    }

    @Override
    public void sua() {
        super.sua();
        
    }
}
