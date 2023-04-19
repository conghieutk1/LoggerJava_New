import Interfaces.IDigitalBank;
import Interfaces.IGiaoDien;
import Models.Customer;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GiaoDien implements IGiaoDien {
    Scanner wait = new Scanner(System.in);
    @Override
    public void displayHeaderB4(String tenPM, String msHV, String version) {
        System.out.println("+--------------------------------+");
        System.out.println("| "+ tenPM +" | " + msHV + version +  " |");
    }
    @Override
    public void displayBodyB4() {
        System.out.println("+---------------------------------+");
        System.out.println("|1. Thông tin khách hàng          |");
        System.out.println("|2. Thêm tài khoản ATM            |");
        System.out.println("|3. Thêm tài khoản tín dụng       |");
        System.out.println("|4. Rút tiền                      |");
        System.out.println("|5. Lịch sử giao dịch             |");
        System.out.println("|0. Thoát                         |");
        System.out.println("+---------------------------------+");
    }

    @Override
    public void displayInfomation(Customer customer) {
        System.out.println("Tên khách hàng: " + customer.getNAME());
        System.out.println("ID khách hàng: " + customer.getID());
    }

    @Override
    public void displayGD(String type, String ngayGD, int STK, long sotiengd, double sodu, int vat) {
        IDigitalBank digitalBank = new DigitalBank();
        int width = 50;
        DecimalFormat formatter = new DecimalFormat("#,###");

        System.out.println("+" + "-".repeat(width) +"+");

        String TYPE = "         BIEN LAI GIAO DICH " + type;
        System.out.println(TYPE);
//        String str = String.format("%" + width/2 + "s%s%" + width/2 + "s", "", TYPE, "");
        System.out.println("+" + "-".repeat(width) +"+");

        System.out.print("NGAY G/D:");
        String str = String.format("%" + 41 + "s", ngayGD);
        System.out.println(str);

        System.out.print("ATM ID:");
        str = String.format("%" + 43 + "s", "DIGITAL-BANK-ATM 2023");
        System.out.println(str);

        System.out.print("SO TK:");
        str = String.format("%" + 44 + "s", STK);
        System.out.println(str);

        System.out.print("SO TIEN:");
        String formatted = formatter.format(sotiengd);
        str = String.format("%" + 41 + "s", formatted);
        System.out.println(str + "đ");

        System.out.print("PHI + VAT:");
        formatted = formatter.format(vat);
        str = String.format("%" + 39 + "s", formatted);
        System.out.println(str + "đ");

        System.out.print("SO DU:");
        formatted = formatter.format((int)sodu);
        str = String.format("%" + 43 + "s", formatted);
        System.out.println(str + "đ");

        System.out.println("+" + "-".repeat(width) +"+");
    }

    @Override
    public void LichSuGD() {
        IDigitalBank digitalBank = new DigitalBank();
        System.out.println("+" + "-".repeat(75) +"+");
        System.out.println("                             LICH SU GIAO DICH ");
        System.out.println();
        digitalBank.ReadFile();
        System.out.println("+" + "-".repeat(75) +"+");
    }
    @Override
    public void displayError(String error) {
        System.out.println(error);
        System.out.print("Nhấn phím bất kỳ để tiếp tục...");
        wait.nextLine();
    }


}
