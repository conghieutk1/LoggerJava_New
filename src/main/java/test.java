import javax.swing.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
public class test {

    public static void main(String[] args) {

        String sotien = "100%00000";
        for (char c : sotien.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Co ky tu la");
            }
        }
//        try {
//            System.out.println("Nhập vào: ");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            int x = System.in.read(); // đọc một ký tự từ đầu vào chuẩn
//            String input = reader.readLine(); // đọc toàn bộ chuỗi còn lại từ đầu vào chuẩn
//            String result = (char) x + input; // kết hợp ký tự đầu tiên và chuỗi còn lại thành một chuỗi String
//            if (x == '\n') System.out.println("Bạn đã nhập phím Enter!");
//            if (x == '\t') System.out.println("Bạn đã nhập phím Tab!");
//            System.out.println("Chuỗi nhập vào: " + result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        JFrame frame = new JFrame();
//        KeyListener keyListener = new KeyListener();
//
//        frame.addKeyListener(keyListener);
//        while (true) {
//            try {
//                char c = (char) System.in.read();
//                if (c == 'a') {
//                    System.out.println("Bạn đã nhập phím a");
//                } else if (c == 'b') {
//                    System.out.println("Bạn đã nhập phím b");
//                } else if (c == '\t') {
//                System.out.println("Bạn đã nhập phím Tab");
//                }else if (c == '\n') {
//                    System.out.println("Bạn đã nhập phím Enter. Tạm biệt!");
//                    break;
//                } else {
//                    System.out.println("Bạn đã nhập phím không xác định: " + c);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
