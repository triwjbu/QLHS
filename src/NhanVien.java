public abstract class NhanVien extends Nguoi {
    protected int luongGio;
    protected int soGio;

    public NhanVien() {
    }

    public NhanVien(int iD, String ten, String ngaySinh, String gioiTinh,String diaChi,String sdt,String mail, int luongGio, int soGio) {
        super(iD, ten, ngaySinh, gioiTinh,diaChi,sdt,mail);
        this.luongGio = luongGio;
        this.soGio = soGio;
    }

    public NhanVien(NhanVien x) {
        super((Nguoi) x);
        luongGio = x.luongGio;
        soGio = x.soGio;
    }

    public abstract int tienLuongMotGIo();

    public abstract int soGioLamViec();

    public int tinhLuong() {
        return tienLuongMotGIo() * soGioLamViec();
    }

    public int getLuongGio() {
        return luongGio;
    }

    public void setLuongGio(int luongGio) {
        this.luongGio = luongGio;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Moi nhap so tien luong/gio: ");
        luongGio = Integer.parseInt(sc.nextLine());
        System.out.print("Moi nhap so gio lam viec: ");
        soGio = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        System.out.println(toString());
    }

    @Override
    public void sua() {
        super.sua();
        System.out.print("Moi nhap so tien luong/gio: ");
        luongGio = Integer.parseInt(sc.nextLine());
        System.out.print("Moi nhap so gio lam viec: ");
        soGio = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + luongGio + ";" + soGio + ";";
    }
}
