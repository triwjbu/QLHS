public class NhanVienHanhChinh extends NhanVien {
    private int maNV;
    private String chucVu;

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

    @Override
    public int tienLuongMotGIo() {
        return luongGio;
    }

    @Override
    public int soGioLamViec() {
        return soGio;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Moi nhap ma nhan vien: ");
        setMaNV(Integer.parseInt(sc.nextLine()));
        System.out.println("Moi nhap chuc vu: ");
        setChucVu(sc.nextLine());
    }

    public void xuat(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "maNV=" + maNV + ", chucVu=" + chucVu ;
    }

}
