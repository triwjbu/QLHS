public class NhanVienHanhChinh extends NhanVien {
    private int maNV;
    private String chucVu;
    private static int maNVtemp = 1;
    private int trangThai = 1;

    public NhanVienHanhChinh(int iD, String ten, String ngaySinh, String gioiTinh, int luongGio, int soGio,int maNV, String chucVu, int trangThai) {
        super(iD, ten, ngaySinh, gioiTinh, luongGio, soGio);
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }
    public NhanVienHanhChinh(NhanVienHanhChinh x) {
        super((NhanVien) x);
        maNV=x.maNV;
        chucVu = x.chucVu;
        trangThai = x.trangThai;
    }
    public NhanVienHanhChinh() {
        this.maNV=maNVtemp++;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int i) {
        this.maNV = i;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int tienLuongMotGIo() {
        return luongGio;
    }

    @Override
    public int soGioLamViec() {
        return soGio;
    }

    @Override 
    public int tinhLuong(){
        return super.tinhLuong() + 500000;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Moi nhap ma nhan vien: ");
        setMaNV(Integer.parseInt(sc.nextLine()));
        System.out.println("Moi nhap chuc vu: ");
        setChucVu(sc.nextLine());
    }
    @Override
    public void sua() {
        super.sua();
        System.out.print("Moi nhap chuc vu: ");
        setChucVu(sc.nextLine());
    }
    @Override
    public void xuat() {
        System.out.println(String.format("| %-12s | %-25s | %-10s | %-9s | %-20s | %-25s | %-15s | %-20s |",
             maNV , super.getTen() ,super.getNgaySinh(),super.getGioiTinh(),chucVu ,super.getLuongGio() , super.getSoGio() , tinhLuong() ));
    }


    @Override
    public String toString() {
        return super.toString() +  maNV + ";" + chucVu + ";" + trangThai + ";"; 
    }

}
