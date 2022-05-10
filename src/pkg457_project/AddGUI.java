package pkg457_project;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author killua
 */
public class AddGUI{
    private String gui_type;
    
    public AddGUI(String s){
        this.gui_type = s;
        
        switch (this.gui_type) {
            case "Employee" -> {
                new AddEmployeeGUI();
            }
            case "Contracts" -> {
                new AddContractsGUI();
            }
            case "Patient" -> {
                new AddPatientGUI();
            }
            case "Client" -> {
                new AddClientGUI();
            }
            case "CheckIn" -> {
                new AddCheckInGUI();
            }
            case "Administers" -> {
                new AddAdministerGUI();
            }
            case "Vendor" -> {
                new AddVendorGUI();
            }
            default -> {
            }
        }
    }
    
}
