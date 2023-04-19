package Interfaces;

import Models.Customer;

public interface IDigitalBank {
    public void showCustomer(String Id);
    public Customer getCustomerById(String id);
    public void ThucHienGD(String type, int stk, long sotiengd, double sodu, int vat);
    public void ReadFile();
    public String LaySoDu();
    public String LayNgayGD();
    public int TinhVAT (String type, long sotiengd);
    public void setSoDu(int stk, long sodu);
    public boolean checkSTK(String stk, int x, int y);
    public boolean checkChonChucNang(String result, int x, int y);
    public boolean checkChonKieuGD(String result, int x, int y);
    public boolean checkNhapSoDu(String sotien, long x, long y);
    public boolean checkNhapSoTienGD(char type, String sotien, long sodu, long x, long y);
}
