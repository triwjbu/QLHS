import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Nguoi {
    private static int iDtemp = 0;
    private int iD;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private String mail;
    static Scanner sc = new Scanner(System.in);

    public Nguoi() {
        this.iD = iDtemp++;
    }

    public Nguoi(int iD, String ten, String ngaySinh, String gioiTinh,String diaChi,String sdt,String mail) {
        this.iD = iD;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi=diaChi;
        this.mail=mail;
    }

    public Nguoi(Nguoi x) {
        iD = x.iD;
        ten = x.ten;
        ngaySinh = x.ten;
        gioiTinh = x.gioiTinh;
        sdt=x.sdt;
        diaChi=x.diaChi;
        mail=x.mail;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    public String getSDT(){
        return sdt;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public String getMail(){
        return mail;
    }
    // public void setSDT(String sdt){
    //     do{
    //         System.out.println("Nhap so dien thoai(10 so):");
    //         sdt=sc.nextLine();
    //     }while();
    //     this.sdt=sdt;
    // }
    public void setSDT(String sdt) {
        do {
            System.out.print("Nhap so dien thoai (10 so):");
            sdt = sc.nextLine();
    
            // Kiểm tra nếu độ dài của chuỗi là 10 và chỉ chứa số
            if (sdt.length() == 10 && sdt.matches("\\d+")) {
                this.sdt = sdt;
                break; // Thoát khỏi vòng lặp nếu số điện thoại hợp lệ
            }
        } while (true);
    }
    public void setDiaChi(String diaChi){
        this.diaChi=diaChi;
    }
    public void setEmail(String mail){
        this.mail=mail;
    }
    public void setGioiTinh(String gioiTinh) {
        do {
            System.out.print("Nhap gioi tinh(nam/nu):");
            gioiTinh = sc.nextLine();
        } while (!gioiTinh.equals("nam") && !gioiTinh.equals("nu") && !gioiTinh.equals(""));
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        do {
            System.out.print("Nhap ngay sinh theo chuan(dd/MM/yyyy):");
            ngaySinh = sc.nextLine();
        } while (!isValidNgaySinh(ngaySinh));
        this.ngaySinh = ngaySinh;
    }

    private boolean isValidNgaySinh(String ngaySinh) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(ngaySinh);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void nhap() {
        System.out.print("Moi nhap ho ten: ");
        setTen(sc.nextLine());
        // System.out.print("Moi nhap ngay sinh: ");
        setNgaySinh("23");
        setGioiTinh("NAM");
        System.out.print("Nhap dia chi:");
        setDiaChi(sc.nextLine());
        setSDT("1");
        System.out.print("Nhap mail:");
        setEmail(sc.nextLine());
    }

    public void xuat() {
        System.out.println(toString());
    }

    public void sua() {
        int choose;
        do{
            menu();
            choose=Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 0:
                    break;
                case 1:
                    System.out.print("Nhap ten:");
                    setTen(sc.nextLine());
                    break;
                case 2:
                    setNgaySinh("23");
                    break;
                case 3:
                    setGioiTinh("NU");
                    break;
                case 4:
                    System.out.print("Nhap dia chi:");
                    setDiaChi(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap sdt:");
                    setSDT(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhap email:");
                    setEmail(sc.nextLine());
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Moi nhap lai.");
            }
        }while (choose != 0);
    }
    public void menu(){
        System.out.println("----------------------------");
        System.out.println("-        1.Ho va Ten       -");
        System.out.println("-        2.Ngay sinh       -");
        System.out.println("-        3.Gioi tinh       -");
        System.out.println("-        4.Dia chi         -");
        System.out.println("-        5.SDT             -");
        System.out.println("-        6.Email           -");
        System.out.println("-        0.Thoat           -");
        System.out.println("-------------------------------");
        System.out.print("Moi nhap lua chon can sua :");
    }
    @Override
    public String toString() {
        return iD + ";" + ten + ";" + ngaySinh + ";" + gioiTinh + ";" + diaChi + ";" + sdt + ";" + mail + ";";
    }

}
