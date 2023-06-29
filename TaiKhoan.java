package Bank;

import java.sql.Date;
import java.util.Scanner;

public class TaiKhoan {
	private int id;
	private int kh_id;
	private String sotk;
	private int loaitk;
	private int trangthai;
	private Date ngaytao;
	private int sotien;
	private int hanmuc;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Nhap Vao Thong Tin Tai Khoan");
		do{
			System.out.println(" Nhap Vao So Tai Khoan");
			this.sotk=sc.nextLine();
		}while(this.sotk.length()!=6);
		
		String LoaiTk;
		do {
			System.out.println(" Nhap Vao Loai Tai Khoan TraTruoc/TraSau");
			LoaiTk=sc.nextLine();
		}while(!LoaiTk.equals("TraTruoc")&& !LoaiTk.equals("TraSau"));
		if(LoaiTk.equals("TraTruoc")) {
			this.loaitk=0;
		}else {
			this.loaitk=1;
		}
		do {
			System.out.println(" Nhap Vao Trang Thai Khoa/Mo");
			LoaiTk=sc.nextLine();
		}while(!LoaiTk.equals("Khoa")&& !LoaiTk.equals("Mo"));
		if(LoaiTk.equals("Khoa")) {
			this.loaitk=0;
		}else {
			this.loaitk=1;
		}
		String Date;
		do {
			System.out.println("Nhap vao ngay tao : nam-thang-ngay");
			Date= sc.nextLine();
		}while(KhachHang.StringToDate(Date)==null);
		this.ngaytao=KhachHang.StringToDate(Date);
		do {
			System.out.println(" Nhap Vao So Tien");
			this.sotien=sc.nextInt();
		}while(this.sotien<0);
	
	}
	
	public TaiKhoan(int id, int kh_id, String sotk, int loaitk, int trangthai, String ngaytao, int sotien, int hanmuc) {
		super();
		this.id = id;
		this.kh_id = kh_id;
		this.sotk = sotk;
		this.loaitk = loaitk;
		this.trangthai = trangthai;
		this.ngaytao = KhachHang.StringToDate(ngaytao);
		this.sotien = sotien;
		this.hanmuc = hanmuc;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKh_id() {
		return kh_id;
	}
	public void setKh_id(int kh_id) {
		this.kh_id = kh_id;
	}
	public String getSotk() {
		return sotk;
	}
	public void setSotk(String sotk) {
		this.sotk = sotk;
	}
	public int getLoaitk() {
		return loaitk;
	}
	public void setLoaitk(int loaitk) {
		this.loaitk = loaitk;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public int getSotien() {
		return sotien;
	}
	public void setSotien(int sotien) {
		this.sotien = sotien;
	}
	public int getHanmuc() {
		return hanmuc;
	}
	public void setHanmuc(int hanmuc) {
		this.hanmuc = hanmuc;
	}
	
}
