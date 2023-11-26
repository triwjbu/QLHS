public class GiangVien extends NhanVien {
    private static int maGVtemp = 1;
    private int maGV;
    private String chuyenMon;
    private int trangThai = 1;

    // update
    private GiangVien dsgv[];

    public GiangVien(int iD, String ten, String ngaySinh, String gioiTinh, String diaChi, String sdt, String mail,
            int luongGio, int soGio, int maGV, String chuyenMon,
            int trangThai) {
        super(iD, ten, ngaySinh, gioiTinh, diaChi, sdt, mail, luongGio, soGio);
        this.maGV = maGV;
        this.chuyenMon = chuyenMon;
        this.trangThai = trangThai;
    }

    public GiangVien(GiangVien x) {
        super((NhanVien) x);
        maGV = x.maGV;
        chuyenMon = x.chuyenMon;
        trangThai = x.trangThai;
    }

    public GiangVien() {
        this.maGV = maGVtemp++;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
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
    public int tinhLuong() {
        return super.tinhLuong() + 200000;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Moi nhap chuyen mon: ");
        setChuyenMon(sc.nextLine());
        System.out.println();
    }

    // update
    @Override
    public void xuat() {
        System.out.printf("| %-5s | %-15s | %-10s | %-4s | %-15s | %-12s | %-15s | %-12s | %-14s | %-11s |\n",
                maGV, super.getTen(), super.getNgaySinh(), super.getGioiTinh(), super.getDiaChi(), super.getSDT(),
                chuyenMon, super.getLuongGio(), super.getSoGio(), tinhLuong());

    }
    @Override
    public void sua() {
        super.sua();
        System.out.print("Moi nhap chuyen mon: ");
        setChuyenMon(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + maGV + ";" + chuyenMon + ";" + trangThai + ";";
    }

}
