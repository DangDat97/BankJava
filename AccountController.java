package Bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AccountController {
	public static boolean checkIDKh(String kh_id) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "Select * from khachhang" +
                            " WHERE id="+kh_id+";");
            int updated = pstmt.executeUpdate();
            if(updated != 0) {
                return true;
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	public static boolean checkStk(String sotk) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(
//                    "Select * from taikhoan" +
//                            " WHERE sotk ="+sotk+";");
//            int updated = pstmt.executeUpdate();
//            if(updated != 0) {
//                return true;
//            }
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            	if(rs.next()==true){
                	return true;
                }
            
            
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	
	public static boolean checkLoaiTk(String sotk) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            while(rs.next()) {
            	if(rs.getInt("loaitk")==0) {
                	return true;
                }
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	public static boolean checkMoney(String sotk,int MoneyWithdraw) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            while(rs.next()) {
            	if(rs.getInt("sotien")>=MoneyWithdraw) {
                	return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	public static boolean checkMoneyHanMuc(String sotk,int MoneyWithdraw) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            if(rs.getInt("hanmuc")>=MoneyWithdraw) {
            	return true;
            }
            conn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	public static boolean checkLoaiKH(int kh_id) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From khachhang WHERE khid="+kh_id);
            while(rs.next()) {
            	if(rs.getInt("loaikh")==0) {
                	return true;
                }
            }
            
            conn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	
	public static void addNewAccount(TaiKhoan TK,int kh_id) throws Exception {
        try {
            Connection conn =  DButil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO taikhoan(khid,sotk,loaitk,trangthai,ngaytao,sotien,hanmuc)" +
                            " VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, kh_id);
            pstmt.setString(2, TK.getSotk());
            pstmt.setInt(3, TK.getLoaitk());
            pstmt.setInt(4, TK.getTrangthai());
            pstmt.setDate(5, TK.getNgaytao());
            pstmt.setInt(6, TK.getSotien());
//            java.sql.Date sqlDate = new java.sql.Date(KH.getNgaysinh().getTime());
            
            if(TK.getLoaitk()==0) {
            	pstmt.setInt(7, 0);
            }else {
            	if(checkLoaiKH(TK.getKh_id())==true) {
            		pstmt.setInt(7, 1000000);// KH Thuong
            	}else {
            		pstmt.setInt(7, 3000000);// KH VIP
            	}
            }

            int updated = pstmt.executeUpdate();
            if(updated > 0) {
                System.out.println("Insert Account success!!!");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
	
	public static void rechargeAccount(String sotk,int numMoney) throws Exception{
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            int money=0;
            while(rs.next()) {
            	money= rs.getInt("sotien");
            }
             
            money=money+numMoney;
            PreparedStatement pstmt1 = conn.prepareStatement(
                    "UPDATE taikhoan "
                    + " SET sotien = "+money+" Where sotk ='"+sotk+"'");
            
//            SimpleDateFormat fomatter = new SimpleDateFormat("");
//            java.util.Date date = new Date(0);
//            
////            Date date = fomatter.format(date);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            LocalDateTime Date=java.time.LocalDateTime.now();
            int updated = pstmt1.executeUpdate();
            if(updated > 0) {
                System.out.println("Recharge Money success!!!");
                
            }
            PreparedStatement pstmt2 = conn.prepareStatement(
                    "INSERT INTO giaodich(sotk, loaitt, sotien,ngaytao,noithuchien)" +
                            " VALUES (?,?,?,?,?)");
            pstmt2.setString(1, sotk);
            pstmt2.setInt(2, 0);
            pstmt2.setInt(3, numMoney);
            pstmt2.setDate(4, KhachHang.StringToDate(timeStamp));
            pstmt2.setString(5, "RechargeAccount");

            int updated1 = pstmt2.executeUpdate();
            if(updated1 > 0) {
                System.out.println("Insert recharge Account success!!!");
            }
            pstmt1.close();
            pstmt2.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}
	public static void withdrawAccount(String sotk,int numMoney) throws Exception{
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            int money=0;
            while(rs.next()) {
            	money = rs.getInt("sotien");
            }
            money=money-numMoney;
            PreparedStatement pstmt1 = conn.prepareStatement(
                    "UPDATE taikhoan "
                    + " SET sotien = "+money+" Where sotk ='"+sotk+"'");
            
            int updated = pstmt1.executeUpdate();
            if(updated > 0) {
                System.out.println("Withdraw Money success!!!");
            }

            pstmt1.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}
	public static void withdrawAccountHanMuc(String sotk,int numMoney) throws Exception{
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From taikhoan WHERE sotk='"+sotk+"'");
            int hanmuc=0;
            while(rs.next()) {
            	hanmuc = rs.getInt("hanmuc");
            }
            hanmuc=hanmuc-numMoney;
            PreparedStatement pstmt1 = conn.prepareStatement(
                    "UPDATE taikhoan "
                    + " SET hanmuc = "+hanmuc+" Where sotk ='"+sotk+"'");
            
            int updated = pstmt1.executeUpdate();
            if(updated > 0) {
                System.out.println("Withdraw Visa Money success!!!");
            }

            pstmt1.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public static void getInfoAccount(String sotk)  throws Exception{
		try {
            Connection connection = DButil.getConnection();
            Statement stmt= connection.createStatement();
            ResultSet rs = stmt.executeQuery("select taikhoan.*,khachhang.* "
            		+ "From taikhoan LEFT JOIN khachhang "
            		+ "ON taikhoan.khid = khachhang.id "
            		+ "Where sotk ='"+sotk+"'");
            while (rs.next()){
                System.out.println("=====Thong Tin Khach Hang======");
                int id = rs.getInt("id");
                System.out.println("ID:"+id);
                String makh = rs.getString("makh");
                System.out.println("Ma KH:"+makh);
                String tenkh= rs.getString("tenkh");
                System.out.println("Ten KH:"+tenkh);
                String cmt= rs.getString("cmt");
                System.out.println("CCCD"+cmt);
                String sodt = rs.getString("sodt");
                System.out.println("SO Dien Thoai"+sodt);
                String email= rs.getString("email");
                System.out.println("Email"+email);
                String ngaysinh= rs.getString("ngaysinh");
                System.out.println("Ngay Sinh"+ngaysinh);
                int gioitinh = rs.getInt("gioitinh");
                System.out.println("Gioi Tinh"+gioitinh);
                String address= rs.getString("address");
                System.out.println("Dia Chi:"+address);
                int loaikh = rs.getInt("loaikh");
                System.out.println(loaikh);
                int sotien = rs.getInt("sotien");
                System.out.println("So Tien:"+sotien);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}
	public static void getInfoAccountId(int id)  throws Exception{
		try {
            Connection connection = DButil.getConnection();
            Statement stmt= connection.createStatement();
            ResultSet rs = stmt.executeQuery("select taikhoan.*,khachhang.* "
            		+ "From taikhoan LEFT JOIN khachhang "
            		+ "ON taikhoan.khid = khachhang.id "
            		+ "Where taikhoan.khid ="+id);
            while (rs.next()){
                System.out.println("=====Thong Tin Khach Hang======");
                int ids = rs.getInt("id");
                System.out.println("ID:"+ids);
                String makh = rs.getString("makh");
                System.out.println("Ma KH:"+makh);
                String tenkh= rs.getString("tenkh");
                System.out.println("Ten KH:"+tenkh);
                String cmt= rs.getString("cmt");
                System.out.println("CCCD"+cmt);
                String sodt = rs.getString("sodt");
                System.out.println("SO Dien Thoai"+sodt);
                String email= rs.getString("email");
                System.out.println("Email"+email);
                String ngaysinh= rs.getString("ngaysinh");
                System.out.println("Ngay Sinh"+ngaysinh);
                int gioitinh = rs.getInt("gioitinh");
                System.out.println("Gioi Tinh"+gioitinh);
                String address= rs.getString("address");
                System.out.println("Dia Chi:"+address);
                int loaikh = rs.getInt("loaikh");
                System.out.println(loaikh);
                int sotien = rs.getInt("sotien");
                System.out.println("So Tien:"+sotien);
                String sotk = rs.getString("sotk");
                System.out.println("So Tai Khoan:"+sotk);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}
}
