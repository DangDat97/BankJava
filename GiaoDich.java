package Bank;

import java.util.Date;

public class GiaoDich {
	private int id;
	private String sotk;
	private int loaitt;
	private int sotien;
	private Date ngaytao;
	private String noithuchientt;
	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void input() {
		
	}
	public GiaoDich(int id, String sotk, int loaitt, int sotien, Date ngaytao, String noithuchientt) {
		super();
		this.id = id;
		this.sotk = sotk;
		this.loaitt = loaitt;
		this.sotien = sotien;
		this.ngaytao = ngaytao;
		this.noithuchientt = noithuchientt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSotk() {
		return sotk;
	}
	public void setSotk(String sotk) {
		this.sotk = sotk;
	}
	public int getLoaitt() {
		return loaitt;
	}
	public void setLoaitt(int loaitt) {
		this.loaitt = loaitt;
	}
	public int getSotien() {
		return sotien;
	}
	public void setSotien(int sotien) {
		this.sotien = sotien;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public String getNoithuchientt() {
		return noithuchientt;
	}
	public void setNoithuchientt(String noithuchientt) {
		this.noithuchientt = noithuchientt;
	}
	
}
