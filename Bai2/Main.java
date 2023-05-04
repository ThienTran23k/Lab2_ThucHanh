package Bai2;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapCD(CDObject cd) {
    	cd.setMaCD(999999);
        System.out.print("Nhập mã CD : ");
        cd.setMaCD(sc.nextInt());
        sc.nextLine();
        cd.setTuaCD("Chưa xác định");
        System.out.print("Nhập tựa CD : ");
        cd.setTuaCD(sc.nextLine());
        System.out.print("Nhập số lượng bài hát : ");
        cd.setSoBaiHat(sc.nextInt());
        System.out.print("Nhập giá thành : ");
        cd.setGiaThanh(sc.nextFloat());
    }
    public static void main(String[] args) {
    	CDObject alb[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            
            System.out.println("\n1.Nhập thông tin CD \n" +
                    "2.Xuất danh sách CD.\n" + "3.Tổng số lượng CD \n" + "4.Tính tổng giá thành của các CD \n" +
                    "5.Sắp xếp giảm dần theo giá thành\n"+"6.Sắp xếp tăng dần theo tựa CD\n"+"0.Để thoát \n");
            System.out.println("Bạn chọn : ");
            a = sc.nextInt();
            switch (a) {
            	case 0 :
            		System.out.println("Chào tạm biệt");
            		flag = false;
            		break;
                case 1:
                    System.out.println("Nhập số lượng CD : ");
                    n = sc.nextInt();
                    alb = new CDObject[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("CD thứ " + (i + 1)+": ");
                        alb[i] = new CDObject ();
                        nhapCD(alb[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-10s %-15s \n", "Mã CD", "Tên CD", "Số bài hát", "Giá thành");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThi();
                    }
                    break;
                case 3:
                    System.out.println("Tổng số lượng CD là : " + n);
                    break;    
                case 4:
                    int tong = 0;
                    for (int i = 0; i < n; i++) {
                        tong += alb[i].getGiaThanh();
                    }
                    System.out.println("" +
                            "Tổng giá thành là : " + tong);
                    break;
                
                case 5:
                	CDObject temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sau khi sắp xếp giảm dần theo giá thành: ");
                    System.out.printf("%-10s %-20s %-10s %-20s \n", "Mã CD", "Tên CD", "Số bài hát", "Giá thành");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThi();
                    }
                    break;
                case 6:
                    temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getTuaCD().compareTo(alb[j].getTuaCD())>0) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sau khi sắp xếp tăng dần theo tựa CD : ");
                    System.out.printf("%-10s %-20s %-15s %-20s \n", "Mã CD", "Tựa CD", "Số bài hát", "Giá thành");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThi();
                    }
                    break;
                default:
			    System.out.println("Chào tạm biệt");
			    flag = false;
			    break;
            	}
				}while (flag) ;
    }
}