/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanprojectjavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class LaundryController implements Initializable {

    @FXML
    private RadioButton cucikering;
    @FXML
    private ToggleGroup PilihanPaket;
    @FXML
    private RadioButton cucikeringsetrika;
    @FXML
    private RadioButton setrika;
    @FXML
    private TextField nama;
    @FXML
    private TextField alamat;
    @FXML
    private TextField berat;
    @FXML
    private TextField telp;
    @FXML
    private TextField tgl;
    @FXML
    private TextArea Hasil;
    @FXML
    private Button btnOke;
    @FXML
    private Button btnHapus;
    
    @FXML
    void proses(ActionEvent event) {
        String paket="";
        int harga=0;
        
        if(cucikering.isSelected())
            paket = "Cuci Kering";
        else if(cucikeringsetrika.isSelected())
            paket = "Cuci Kering Setrika";
        else if(setrika.isSelected())
            paket = "Setrika";
        else
            paket = "";
        
        if(!(cucikering.isSelected() || cucikeringsetrika.isSelected() || setrika.isSelected() )){
            JOptionPane.showMessageDialog(null, "Harap Pilih Paket Layanan");
        }else{
            String Nama = nama.getText();
            String Alamat = alamat.getText();
            String Berat = berat.getText();
            String tanggal = tgl.getText();
            
            int hitung = Integer.parseInt(berat.getText());
            
            if (cucikering.isSelected())
                harga = hitung*5000;
            if (cucikeringsetrika.isSelected())
                harga = hitung*8000;
            if (setrika.isSelected())
                harga = hitung*4000;
            
            String NoTelp = telp.getText();
            
            Hasil.setText("Nama: "+Nama+"\n"+"Alamat: "+Alamat+"\n"+"Berat Cucian: "+Berat+"\n"+"Nomor Telepon: "
                         +NoTelp+"\n"+"Pilihan Paket: "+paket+"\n"+"Tanggal Pengambilan: "+tanggal+"\n"+"Pembayaran yang harus dibayar: "
                          +harga );
        }
    }
    
     @FXML
    void hapus(ActionEvent event) {
        nama.setText("");
        alamat.setText("");
        berat.setText("");
        telp.setText("");
        tgl.setText("");
        cucikering.setSelected(false);
        cucikeringsetrika.setSelected(false);
        setrika.setSelected(false);
        Hasil.setText("");
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
