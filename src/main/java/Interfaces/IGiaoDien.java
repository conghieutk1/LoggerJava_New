package Interfaces;

import Models.Customer;

public interface IGiaoDien {
    //public void displayHeader(String tenPM, String msHV, String version);
    public void displayHeaderB4(String tenPM, String msHV, String version);
    //public void displayBodyB3();
    public void displayBodyB4();
    public void displayInfomation(Customer customer);
    public void displayGD (String type, String ngayGD, int STK, long sotiengd, double sodu, int vat);
    public void LichSuGD();
    public void displayError(String error);
}
