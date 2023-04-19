import Interfaces.IDigitalBank;
import Interfaces.IFunction;
import Interfaces.IGiaoDien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Function implements IFunction {
    IGiaoDien giaodien = new GiaoDien();
    IDigitalBank digitalBank = new DigitalBank();
    Scanner input = new Scanner(System.in);
    Scanner wait = new Scanner(System.in);
    String tenPM = "NGAN HANG DIEN TU";
    String version = "@1.0.0";
    boolean check = true;
    int input1 = 0;
    String result = "";
    @Override
    public char NhapChucNangMenuChinh() {
        do {
            giaodien.displayHeaderB4(tenPM, "FX123", version);
            giaodien.displayBodyB4();
            try {
                System.out.print("Nhập chức năng: ");
                result = input.nextLine().trim();
                check = digitalBank.checkChonChucNang(result, 0, 5);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (!check);
        result = result.trim();
        return  result.charAt(0);
    }

    @Override
    public void ChucNang1() {
        digitalBank.showCustomer("111222");
        System.out.print("Nhấn phím bất kỳ để tiếp tục...");
        wait.nextLine();
    }

    @Override
    public void ChucNang2() {
        do {
            System.out.print("Nhập số tài khoản ATM (6 chữ số): ");
            result = input.nextLine().trim();
            check = digitalBank.checkSTK(result, 100000, 1000000);
        } while (!check);
        int stk = Integer.parseInt(result);
        System.out.println("Bạn vừa nhập số tài khoản tín dụng: " + stk);

        String sodu;
        do {
            System.out.print("Nhập số dư (bé hơn 1 tỷ VND): ");
            sodu = input.nextLine().trim();
            check = digitalBank.checkNhapSoDu(sodu, 0 ,2000000000);
        } while (!check);
        long num = Long.parseLong(sodu);
        digitalBank.setSoDu(stk ,num);
        System.out.print("Nhấn phím bất kỳ để tiếp tục...");
        wait.nextLine();
    }

    @Override
    public void ChucNang3() {
        do {
            System.out.print("Nhập số tài khoản tín dụng (6 chữ số): ");
            result = input.nextLine().trim();
            check = digitalBank.checkSTK(result, 100000, 1000000);
        } while (!check);
        int stk = Integer.parseInt(result);
        System.out.println("Bạn vừa nhập số tài khoản tín dụng: " + stk);
        System.out.print("Nhấn phím bất kỳ để tiếp tục...");
        wait.nextLine();
    }

    @Override
    public void ChucNang4() {
        StringBuilder ngayGD;
        StringBuilder _sodu;
        _sodu = new StringBuilder(digitalBank.LaySoDu());
        int soduTK = Integer.parseInt(_sodu.toString());
        long sotienrut;
        int vat;
        char a;
        String type;
        System.out.println("Số dư của bạn là: " + soduTK);

        do {
            System.out.println("Chọn kiểu giao dịch");
            System.out.println("1. LOAN");
            System.out.println("2. SAVINGS");
            System.out.println("3. TRANSACTION");

            try {
                System.out.print("Bạn chọn ? ");
                result = input.nextLine().trim(); // kết hợp ký tự đầu tiên và chuỗi còn lại thành một chuỗi String
                check = digitalBank.checkChonKieuGD(result, 1, 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!check);
        result = result.trim();
        a = result.charAt(0);
        if (a == '1') {
            type = "LOAN";
        } else if (a == '2') {
            type = "SAVINGS";
        } else {
            type = "TRANSACTION";
        }
        String _sotienrut;
        do {
            System.out.println("Giao dịch " + type);
            System.out.print("Nhập số tiền giao dịch: ");
            _sotienrut = input.nextLine().trim();
            check = digitalBank.checkNhapSoTienGD(a, _sotienrut, soduTK,50000 ,5000000);
        } while (!check);

        sotienrut = Long.parseLong(_sotienrut);
        System.out.println("Bạn vừa nhập số tiền giao dịch: " + sotienrut);
        vat = digitalBank.TinhVAT(type, sotienrut);
        if (a == '3') sotienrut = -sotienrut;

        digitalBank.ThucHienGD(type, 123456, sotienrut, soduTK, vat);
        // Sau khi thực hiện giao dịch xong, lấy ngày GD để hiện thị lên biên lai
        ngayGD = new StringBuilder(digitalBank.LayNgayGD());
        // Cập nhật số dư
        _sodu = new StringBuilder(digitalBank.LaySoDu());
        soduTK = Integer.parseInt(_sodu.toString());
        //In biên lai giao dịch
        giaodien.displayGD(type, ngayGD.toString(), 123456, sotienrut, soduTK, vat);
        System.out.print("Nhấn phím bất kỳ để tiếp tục...");
        wait.nextLine();
    }
    @Override
    public void ChucNang5() {
        giaodien.LichSuGD();
        System.out.print("Nhấn phím bất kỳ để tiếp tục...");
        wait.nextLine();
    }
}
