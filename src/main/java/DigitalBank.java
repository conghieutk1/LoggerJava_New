import Interfaces.IDigitalBank;
import Interfaces.IGiaoDien;
import Models.Customer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DigitalBank implements IDigitalBank {
    private static final Logger logger = Logger.getLogger(Main.class);
    IGiaoDien giaoDien = new GiaoDien();
    @Override
    public void showCustomer(String Id) {
        IDigitalBank digitalBank = new DigitalBank();
        IGiaoDien giaoDien = new GiaoDien();
        Customer customer = digitalBank.getCustomerById(Id);
        if (customer != null) {
            giaoDien.displayInfomation(customer);
        } else {
            System.out.println("Customer is null");
        }
    }

    @Override
    public Customer getCustomerById(String id) {
        Customer customer = new Customer();
        if  (id.equals("123456")) {
            customer.setID("123456");
            customer.setNAME("HIEU");
        }
        if (id.equals("111222")) {
            customer.setID("111222");
            customer.setNAME("HDBK");
        }
        return customer;
    }

    @Override
    public void ThucHienGD(String type, int stk, long sotiengd, double sodu, int vat) {
        System.setProperty("filename", "log1");
        String log4jConfPath = "D:\\Workspace\\JavaProject\\DigitalBank\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

//        if (type.equals("LOAN")) {
//            sodu = sodu + sotiengd + TinhVAT(type, sotiengd);
//        } else if (type.equals("SAVINGS")) {
//            sodu = sodu + sotiengd + TinhVAT(type, sotiengd);
//        } else if (type.equals("TRANSACTION")) {
//            sotiengd = -sotiengd;
//            sodu = sodu - sotiengd + TinhVAT(type, sotiengd);
//        }
        sodu = sodu + sotiengd + vat;
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedSoDuGD = formatter.format(sotiengd);
        String formattedSoDu = formatter.format((int)sodu);

        int width = 12;
        String formattedString = String.format("%" + 6 + "s", stk);
        formattedString += " | ";
        formattedString += String.format("%" + width + "s", type); // type
        formattedString += " | ";
        formattedString += String.format("%" + width + "s", formattedSoDuGD);
        formattedString += "đ | ";
        formattedString += String.format("%" + width + "s", formattedSoDu);
        formattedString += "đ";
        logger.info(formattedString);

    }

    @Override
    public void ReadFile() {
        //String sodu = "";
        try
        {
            File file = new File("D:\\Workspace\\JavaProject\\DigitalBank\\src\\main\\resources\\springtest.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuilder sb =new StringBuilder();    //constructs a string buffer with no characters StringBuffer
            String line = "";
            // int i = 0;
            while((line = br.readLine()) != null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String LaySoDu() {
        StringBuilder sodu = new StringBuilder();

        try
        {

            File file = new File("D:\\Workspace\\JavaProject\\DigitalBank\\src\\main\\resources\\springtest.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            // StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line = "";

            // dem so dong
            int i = 0;
            while((line = br.readLine())!=null)
            {
                i++;
            }
            // lay so du
            FileReader fr1=new FileReader(file);   //reads the file
            BufferedReader br1=new BufferedReader(fr1);
            int k = 0;
            while((line = br1.readLine())!=null)
            {
                if (k == i-1) {
                    for (int j = 62; j < line.length(); j++) {
                        if ((line).charAt(j) != ',' && (line).charAt(j) != 'đ' && (line).charAt(j) != ' ') {
                            sodu.append((line).charAt(j));
                        }
                    }

                }
                k++;
            }
            fr.close();    //closes the stream and release the resources
            fr1.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return sodu.toString();
    }

    @Override
    public String LayNgayGD() {
        StringBuilder ngayGD = new StringBuilder();
        try
        {
            File file = new File("D:\\Workspace\\JavaProject\\DigitalBank\\src\\main\\resources\\springtest.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            // StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line = "";

            // dem so dong
            int i = 0;
            while((line = br.readLine())!=null)
            {
                i++;
            }
            // lay ngay giao dich
            FileReader fr1=new FileReader(file);   //reads the file
            BufferedReader br1=new BufferedReader(fr1);
            int k = 0;
            while((line = br1.readLine())!=null)
            {
                if (k == i-1) {
                    for (int j = 0; j < 19; j++) {
                        ngayGD.append((line).charAt(j));
                    }
                }
                k++;
            }
            fr.close();    //closes the stream and release the resources
            fr1.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return String.valueOf(ngayGD);
    }
    @Override
    public int TinhVAT(String type, long sotiengd) {

        if (type.equals("SAVINGS")) {
            return 0;
        } else if (type.equals("LOAN") || type.equals("TRANSACTION")) {
            return (int) (-sotiengd * 0.01);
        }
        return -1;
    }

    @Override
    public void setSoDu(int stk, long sodu) {
        System.out.println("Bạn vừa nhập số dư là " + sodu + " VND vào tài khoản " + stk);
    }

    @Override
    public boolean checkSTK(String stk, int x, int y) {
        try {
            stk = stk.trim();
            if (stk.charAt(0) == '0' && stk.length() > 1) {
                giaoDien.displayError("Số tài khoản không hợp lệ vì bắt đầu bằng chữ số 0, vui lòng nhập lại");
                return false;
            }
            int num = Integer.parseInt(stk);
            if (num >= x && num < y) {
                return true;
            }
            giaoDien.displayError("Số tài khoản phải gồm 6 chữ số, vui lòng nhập lại");
        } catch (Exception ex) {
            if (stk.isEmpty()) {
                giaoDien.displayError("Bạn chưa nhập số tài khoản, vui lòng nhập lại");
                return false;
            }
            giaoDien.displayError("Số tài khoản không hợp lệ, vui lòng nhập lại");
            return false;
        }
        return false;
    }
    @Override
    public boolean checkChonChucNang(String input, int x, int y) {
        try {
            input = input.trim();
            if (input.charAt(0) == '0' && input.length() > 1) {
                giaoDien.displayError("Vui lòng nhập một chức năng duy nhất");
                return false;
            }
            int num = Integer.parseInt(input);
            if (num >= x && num <= y) {
                return true;
            }
            giaoDien.displayError("Chức năng không hợp lệ, vui lòng nhập lại");
        } catch (Exception ex) {
            if (input.isEmpty()) {
                giaoDien.displayError("Bạn chưa nhập chức năng, vui lòng nhập lại");
                return false;
            }
            giaoDien.displayError("Chức năng không hợp lệ, , vui lòng nhập lại");
            return false;
        }
        return false;
    }

    @Override
    public boolean checkChonKieuGD(String input, int x, int y) {
        try {
            input = input.trim();
            if (input.charAt(0) == '0' && input.length() > 1) {
                giaoDien.displayError("Vui lòng nhập một kiểu giao dịch duy nhất");
                return false;
            }
            int num = Integer.parseInt(input);
            if (num >= x && num <= y) {
                return true;
            }
            giaoDien.displayError("Kiểu giao dịch không hợp lệ, vui lòng nhập lại");
        } catch (Exception ex) {
            if (input.isEmpty()) {
                giaoDien.displayError("Bạn chưa nhập kiểu giao dịch, vui lòng nhập lại");
                return false;
            }
            giaoDien.displayError("Kiểu giao dịch không hợp lệ, , vui lòng nhập lại");
            return false;
        }
        return false;
    }

    @Override
    public boolean checkNhapSoDu(String sotien, long x, long y) {
        try {
            sotien = sotien.trim();
            int i = 0;
            while (i < sotien.length() && sotien.charAt(i) == '0') {
                i++; // Tìm vị trí đầu tiên không phải là ký tự '0'
            }
            sotien = sotien.substring(i);
            long num = Long.parseLong(sotien);
            if (num < x) {
                giaoDien.displayError("Số dư không thể bé hơn " + x + " VND");
                return false;
            } else if (num > y) {
                giaoDien.displayError("Số dư không thể lớn hơn " + y + " VND");
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            if (sotien.isEmpty()) {
                giaoDien.displayError("Bạn chưa nhập số dư, vui lòng nhập lại");
                return false;
            }
            giaoDien.displayError("Số dư không hợp lệ, vui lòng nhập lại");
            return false;
        }
    }

    @Override
    public boolean checkNhapSoTienGD(char type, String sotienGD, long sodu, long x, long y) {
        DigitalBank digitalBank = new DigitalBank();
        // x y là khoảng tiền thỏa mãn
        try {
            sotienGD = sotienGD.trim();
            int i = 0;
            while (i < sotienGD.length() && sotienGD.charAt(i) == '0') {
                i++; // Tìm vị trí đầu tiên không phải là ký tự '0'
            }
            sotienGD = sotienGD.substring(i);

            long sotienrut = Long.parseLong(sotienGD);
            if (sotienrut < x) {
                giaoDien.displayError("Số tiền giao dịch không thể bé hơn " + x + " VND");
                return false;
            }
            if (sotienrut > y) {
                giaoDien.displayError("Số tiền giao dịch không thể lớn hơn " + y + " VND");
                return false;
            }
            if (sotienrut % 10000 != 0) {
                giaoDien.displayError("Số tiền giao dịch phải là bội số của 10.000");
                return false;
            }
            if (type == '3' && (sodu - sotienrut + digitalBank.TinhVAT("TRANSACTION",sotienrut)) < 50000) {
                giaoDien.displayError("Tài khoản của bạn không đủ để thực hiện giao dịch");
                return false;
            }
            return true;
        } catch (Exception ex) {
            if (sotienGD.isEmpty()) {
                giaoDien.displayError("Bạn chưa nhập số tiền giao dịch, vui lòng nhập lại");
                return false;
            }
            giaoDien.displayError("Số tiền giao dịch không hợp lệ, , vui lòng nhập lại");
            return false;
        }

    }
}
