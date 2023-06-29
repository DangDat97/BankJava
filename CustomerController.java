package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerController {
	public static boolean checkMaKH(String maKH) throws Exception {
		try {
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From khachhang WHERE makh='"+maKH+"'");
            if(rs.next()) {
            	return true;
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return false;
	}
	public static int getIdtoMKH(String maKH) throws Exception {
		int Id = 0;
		try {
			
            Connection conn =  DButil.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * From khachhang WHERE makh='"+maKH+"'");
            
            while(rs.next()) {
            	Id = rs.getInt("id");
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return Id;
	}
	
	 public static void addNewCustomer(KhachHang KH) throws Exception {
	        try {
	            Connection conn =  DButil.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(
	                    "INSERT INTO khachhang(makh, tenkh, cmt,sodt,email,ngaysinh,gioitinh,address,loaikh)" +
	                            " VALUES (?,?,?,?,?,?,?,?,?)");
	            pstmt.setString(1, KH.getMakh());
	            pstmt.setString(2, KH.getTenkh());
	            pstmt.setString(3, KH.getCmt());
	            pstmt.setString(4, KH.getSdt());
	            pstmt.setString(5, KH.getEmail());
	            pstmt.setDate(6, KH.getNgaysinh());
	            pstmt.setInt(7, KH.getGioitinh());
	            pstmt.setString(8, KH.getDiachi());
	            pstmt.setInt(9, KH.getLoaikh());

	            int updated = pstmt.executeUpdate();
	            if(updated > 0) {
	                System.out.println("Insert Customer success!!!");
	            }

	            pstmt.close();
	            conn.close();

	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
	    }
	 public static void updateCustomer(KhachHang KH, String maKH) throws Exception{
		 try {
	            Connection conn =  DButil.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(
	                    "UPDATE khachhang "
	                    + " SET tenkh = ?, cmt = ?, sodt = ?,"
	                    + "	email = ?, ngaysinh =?,gioitinh =?,"
	                    + "address = ?,loaikh =?" +
	                            " Where makh=? ;");
	            
	            pstmt.setString(1, KH.getTenkh());
	            pstmt.setString(2, KH.getCmt());
	            pstmt.setString(3, KH.getSdt());
	            pstmt.setString(4, KH.getEmail());
	            pstmt.setDate(5, KH.getNgaysinh());
	            pstmt.setInt(6, KH.getGioitinh());
	            pstmt.setString(7, KH.getDiachi());
	            pstmt.setInt(8, KH.getLoaikh());
	            pstmt.setString(9, maKH);
	            int updated = pstmt.executeUpdate();
	            if(updated > 0) {
	                System.out.println("Update Customer success!!!");
	            }

	            pstmt.close();
	            conn.close();

	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
	 }
	 
	 public static void deleteCustomer(String maKH) throws Exception {
		 try {
	            Connection conn =  DButil.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(
	                    "DELETE FROM khachhang" +
	                            " Where makh=?");
	            
	            pstmt.setString(1, maKH);
	            int updated = pstmt.executeUpdate();
	            if(updated > 0) {
	                System.out.println("Delete Customer success!!!");
	            }

	            pstmt.close();
	            conn.close();

	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
	 }
	 
	 public static boolean checkCusdelete(String maKH) throws Exception{
		 try {
	            Connection conn =  DButil.getConnection();
	            Statement stmt= conn.createStatement();
	            ResultSet rs = stmt.executeQuery("select * From khachhang WHERE makh='"+maKH+"'");
	            int id=0;
	            while(rs.next()) {
	            	id=rs.getInt("id");
	            }
	            rs=stmt.executeQuery("select * From taikhoan WHERE khid='"+id+"'");
	            if(rs.next()) {
	            	return true;
	            }

	            rs.close();
	            conn.close();

	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
		 return false;
	 }

	 public static ArrayList<KhachHang> getListKH(){
			ArrayList<KhachHang> ListKH = new ArrayList<>();
			Connection conn=null;
			try {
				conn = DButil.getConnection();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(conn == null)
				return ListKH;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				String sql ="Select * from khachhang";
				ps = conn.prepareStatement(sql);
				rs = (ResultSet) ps.executeQuery();
				KhachHang record = new KhachHang();
				while(rs.next()) {
					record.setId(rs.getInt("id"));
					record.setMakh(rs.getString("makh"));
					record.setTenkh(rs.getString("tenkh")); 
					record.setCmt(rs.getString("cmt"));
					record.setSdt(rs.getString("sdt"));
					record.setEmail(rs.getString("email"));
					record.setNgaysinh(rs.getDate("ngaysinh"));
					record.setGioitinh(rs.getInt("gioitinh"));
					record.setDiachi(rs.getString("diachi"));
					record.setLoaikh(rs.getInt("loaikh"));
					ListKH.add(record);
				}
				
			}catch(Exception e ){
				e.printStackTrace();
			}finally {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return ListKH;
		}
	 public static void getAll() throws Exception {
	        try {
	            Connection connection = DButil.getConnection();
	            Statement stmt= connection.createStatement();
	            ResultSet rs = stmt.executeQuery("select * From khachhang");
	            while (rs.next()){
	                System.out.println("=====khachhang======");
	                int id = rs.getInt("id");
	                System.out.println(id);
	                String makh = rs.getString("makh");
	                System.out.println(makh);
	                String tenkh= rs.getString("tenkh");
	                System.out.println(tenkh);
	                String cmt= rs.getString("cmt");
	                System.out.println(cmt);
	                String sodt = rs.getString("sodt");
	                System.out.println(sodt);
	                String email= rs.getString("email");
	                System.out.println(email);
	                String ngaysinh= rs.getString("ngaysinh");
	                System.out.println(ngaysinh);
	                int gioitinh = rs.getInt("gioitinh");
	                System.out.println(gioitinh);
	                String address= rs.getString("address");
	                System.out.println(address);
	                int loaikh = rs.getInt("loaikh");
	                System.out.println(loaikh);
	            }

	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
	    }
}
