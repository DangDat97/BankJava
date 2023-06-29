package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class MainBank {
	public static void main(String[] args) {
//		KhachHang kh= new KhachHang();
//		kh.input();
//		CustomerController.addNewCustomer(kh);
		CustomerController customerController = new CustomerController();
		AccountController accountController = new AccountController();
////		KhachHang kh1 = new KhachHang(1, "KH1", "Dang Van Dat", "036097005125", "0862442297", "dangvandat09@gmail.com", "20/10/1997", 0, "Dong My Thanh Tri Ha Noi", 1);
////		System.out.println(kh1.toString());
//		try {
//			KhachHang kh1 = new KhachHang(6, "KH6", "Dang Van Dat", "036097105728", "0612422317", "dangvandat128@gmail.com", "1997-10-20", 0, "Dong My Thanh Tri Ha Noi", 1);
//			CustomerController.addNewCustomer(kh1);;
//			KhachHang kh2 = new KhachHang(1, "KH1", "Dang Van Dat2", "036097005225", "0862442397", "dangvandat09@gmail.com", "1997-10-20", 0, "Dong My Thanh Tri Ha Noi", 1);
//			CustomerController.updateCustomer(kh2,"KH1");
//			CustomerController.deleteCustomer("KH5");
//			ArrayList<KhachHang> ListKH = CustomerController.getListKH();
//			for (KhachHang item : ListKH) {
//	            item.toString();
//	        }
//			
//			CustomerController.getAll();
//			
//			TaiKhoan tk = new TaiKhoan(1,2,"lhsdwq", 0, 1,"1997-10-20",2000, 1);
//			AccountController.addNewAccount(tk);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//		
		int choose = 0;
        Scanner sc = new Scanner(System.in);

        try {
            do {
                System.out.println("1. Them Moi Khach Hang");
                System.out.println("2. Cap Nhat Thong Tin Khach Hang");
                System.out.println("3. Xoa Khach Hang");
                System.out.println("4. Tao Moi Tai Khoan");
                System.out.println("5. Nap Tien Vao Tai Khoan");
                System.out.println("6. Rut Hoac Thanh Toan Tien");
                System.out.println("7. Hien Thi Tat Ca Khach Hang");
                System.out.println("8. Hien Thi Thong Tin Tai Khoan Tu So Tai Khoan");
                System.out.println("9. Hien Thi Thong Tin Cac Tai Khoan Tu Ma Khach Hang ");
                System.out.println("10. Exit");
                System.out.println("Chosen Menu");
                choose = sc.nextInt();

                switch (choose) {
                    case 1: {
                        KhachHang Kh = new KhachHang();
                        Kh.input();
                        if(CustomerController.checkMaKH(Kh.getMakh())==false) {
                        	CustomerController.addNewCustomer(Kh);
                        }else {
                        	System.out.println("Ma Khach Hang Da Ton Tai");
                        }
                        
                    }
                    break;
                    case 2: {
                        System.out.println("Nhap Ma Khach Hang:");
                        sc.nextLine();
                        String maKH2 = sc.nextLine();
                        if(CustomerController.checkMaKH(maKH2)==true) {
                        	KhachHang KH2 = new KhachHang();
                        	KH2.input();
                        	CustomerController.updateCustomer(KH2, maKH2);
                        }else {
                        	System.out.println("Ma Khach Hang Khong Ton Tai");
                        }
                    }
                    break;
                    case 3: {
                    	System.out.println("Nhap Ma Khach Hang:");
                    	sc.nextLine();
                        String maKH3 = sc.nextLine();
                        if(CustomerController.checkMaKH(maKH3)==true) {
                        	if(CustomerController.checkCusdelete(maKH3)==true) {
                        		System.out.println("Khach Hang Da Tao Tai Khoan");
                        	}else {
                        		CustomerController.deleteCustomer(maKH3);
                        	}
                        	
                        }else {
                        	System.out.println("Ma Khach Hang Khong Ton Tai");
                        }
                    }
                    break;
                    case 4: {
                    	System.out.println("Nhap Ma Khach Hang:");
                    	sc.nextLine();
                        String maKH4 = sc.nextLine();
                        if(CustomerController.checkMaKH(maKH4)==true) {
                        	TaiKhoan Tk = new TaiKhoan();
                        	Tk.input();
                        	AccountController.addNewAccount(Tk,CustomerController.getIdtoMKH(maKH4));
                        }else {
                        	System.out.println("Ma Khach Hang Khong Ton Tai");
                        }
                    }
                    break;
                    case 5: {
                    	System.out.println("Nhap Vao So Tai Khoan:");
                    	sc.nextLine();
                        String stk5 = sc.nextLine();
                        if(AccountController.checkStk(stk5)==true) {
                        	if(AccountController.checkLoaiTk(stk5)==true) {
                        		System.out.println("Nhap Vao So Tien Nap:");
                                int numMoney = sc.nextInt();
                            	AccountController.rechargeAccount(stk5, numMoney);
                        	}else {
                        		System.out.println("Tai Khoan Tra Sau Khong Nap Tien");
                        	}
                        }else {
                        	System.out.println("So Tai Khoan Khong Ton Tai");
                        }
                    }
                    break;
                    case 6: {
                    	System.out.println("Nhap Vao So Tai Khoan:");
                    	sc.nextLine();
                        String stk6 = sc.nextLine();
                        if(AccountController.checkStk(stk6)==true) {
                        	if(AccountController.checkLoaiTk(stk6)==true) {
                        		System.out.println("Nhap Vao So Tien Rut/ Thanh Toan:");
                                int numMoney6 = sc.nextInt();
                                if(AccountController.checkMoney(stk6, numMoney6)==true) {
                                	AccountController.withdrawAccount(stk6, numMoney6);
                                }else {
                                	System.out.println("So Tien Trong Tai Khoan Khong Du");
                                }
                            	
                        	}else {
                        		System.out.println("Nhap Vao So Tien Rut/ Thanh Toan:");
                                int numMoney6 = sc.nextInt();
                                if(AccountController.checkMoneyHanMuc(stk6, numMoney6)==true) {
                                	AccountController.withdrawAccountHanMuc(stk6, numMoney6);
                                }else {
                                	System.out.println("So Tien Trong Tai Khoan Khong Du");
                                }
                        	}
                        }else {
                        	System.out.println("So Tai Khoan Khong Ton Tai");
                        }
                    }
                    break;
                    case 7: {
                    	CustomerController.getAll();
                    }
                    break;
                    case 8: {
                    	System.out.println("Nhap Vao So Tai Khoan:");
                    	sc.nextLine();
                        String stk8 = sc.nextLine();
                        if(AccountController.checkStk(stk8)==true) {
                        	AccountController.getInfoAccount(stk8);
                        }else {
                        	System.out.println("So Tai Khoan Khong Ton Tai");
                        }
                    }
                    break;
                    case 9: {
                    	System.out.println("Nhap Vao Ma Khach Hang:");
                    	sc.nextLine();
                        String stk8 = sc.nextLine();
                        if(CustomerController.checkMaKH(stk8)==true) {
                        	int id=CustomerController.getIdtoMKH(stk8);
                        	if(id !=0) {
                            	AccountController.getInfoAccountId(id);
                        	}else {
                        		System.out.println("Khach Hang Chua co Tai Khoan");
                        	}
                        	
                        }else {
                        	System.out.println("Ma Khach Hang Khong Ton Tai");
                        }
                    }
                    break;
                    case 10:{
                    	return;
                    }
                    
                }
            } while(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		

		
		
	}
}
