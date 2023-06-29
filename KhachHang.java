package Bank;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class KhachHang {
	private int id;
	private String makh;
	private String tenkh;
	private String cmt;
	private String sdt;
	private String email;
	private Date ngaysinh;
	private int gioitinh;
	private String diachi;
	private int loaikh;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int id, String makh, String tenkh, String cmt, String sdt, String email, String ngaysinh,
			int gioitinh, String diachi, int loaikh) {
		super();
		this.id = id;
		this.makh = makh;
		this.tenkh = tenkh;
		this.cmt = cmt;
		this.sdt = sdt;
		this.email = email;
		this.ngaysinh = StringToDate(ngaysinh);
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.loaikh = loaikh;
	}
	
	
	public KhachHang(int id, String makh, String tenkh, String cmt, String sdt, String email, Date ngaysinh,
			int gioitinh, String diachi, int loaikh) {
		super();
		this.id = id;
		this.makh = makh;
		this.tenkh = tenkh;
		this.cmt = cmt;
		this.sdt = sdt;
		this.email = email;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.loaikh = loaikh;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Nhap Vao Thong Tin Khach Hang");
		System.out.println(" Nhap vao Ma Khach Hang");
		this.makh= sc.nextLine();
		do {
			System.out.println(" Nhap vao CCCD ( *12 So)");
			this.cmt= sc.nextLine();
		}while(this.cmt.length()!=12);
		System.out.println(" Nhap vao Ten Khach Hang");
		this.tenkh= sc.nextLine();
		do {
			System.out.println(" Nhap vao SDT ( *10 So)");
			this.sdt= sc.nextLine();
		}while(this.sdt.length()!=10);
		
		do {
			System.out.println(" Nhap vao Email (* @gmail.com)");
			this.email= sc.nextLine();
		}while(this.email.contains("@gmail.com")==false);
		
		String Date;
		
		do {
			System.out.println("Nhap vao ngay sinh : nam-thang-ngay");
			Date= sc.nextLine();
		}while(StringToDate(Date)==null);
		this.ngaysinh=StringToDate(Date);
		String gt;
		do {
			System.out.println(" Nhap vao Gioi Tinh Nam/Nu/Khac");
			gt=sc.nextLine();
		}while(!gt.equals("Nam")&&!gt.equals("Nu")&&!gt.equals("Khac"));
		if(gt.equals("Nam")) {
			this.gioitinh=1;
		}else if(gt.equals("Nu")){
			this.gioitinh=0;
		}else {
			this.gioitinh=2;
		}
		System.out.println(" Nhap vao Dia Chi");
		this.diachi= sc.nextLine();
		String loaiKH;
		do {
			System.out.println(" Nhap vao Loai Khach Hang Thuong/Vip");
			loaiKH=sc.nextLine();
		}while(!loaiKH.equals("Thuong")&& !loaiKH.equals("Vip"));
		if(loaiKH.equals("Thuong")) {
			this.gioitinh=0;
		}else {
			this.gioitinh=1;
		}
	}
	
	
	
	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", makh=" + makh + ", tenkh=" + tenkh + ", cmt=" + cmt + ", sdt=" + sdt
				+ ", email=" + email + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", diachi=" + diachi
				+ ", loaikh=" + loaikh + "]";
	}
	public static Date StringToDate(String DateString) {
		java.sql.Date Date1 = null;
		try {
			Date1 = Date.valueOf(DateString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());  
		}
		return Date1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getLoaikh() {
		return loaikh;
	}
	public void setLoaikh(int loaikh) {
		this.loaikh = loaikh;
	}
	
}
