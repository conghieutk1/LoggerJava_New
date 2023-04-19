import Interfaces.IDigitalBank;
import Interfaces.IFunction;
import Interfaces.IGiaoDien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IFunction function = new Function();
        char a;
        do {
            a = function.NhapChucNangMenuChinh();
            switch (a) {
                case '1' -> {
                    function.ChucNang1();
                }
                case '2' -> {
                    function.ChucNang2();
                }
                case '3' -> {
                    function.ChucNang3();
                }
                case '4' -> {
                    function.ChucNang4();
                }
                case '5' -> {
                    function.ChucNang5();
                }
                default -> {
                }
            }
        } while (a != '0');
    }
}
