package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.custom.LoginBO;
import lk.ijse.hibernate.dto.LoginDTO;

import java.util.List;

public class UpdatePasswordFormController {
    private final LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.LOGIN);
    public TextField txtOldPassword;
    public TextField txtNewPassword;
    public TextField txtUsername;

    public void initialize(){
        txtNewPassword.setEditable(false);
        txtUsername.setEditable(false);
        try {
            List<LoginDTO> dto = loginBO.findAll();
            for (LoginDTO loginDTO : dto){
                String username = loginDTO.getUsername();
                txtUsername.setText(username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateOnAction(ActionEvent actionEvent) {
        String newPassword = txtNewPassword.getText();
        String username = txtUsername.getText();
        try {
           boolean b =  loginBO.update(new LoginDTO(username,newPassword));
           if (b){
               new Alert(Alert.AlertType.CONFIRMATION,"Password update success").show();
           }else {
               new Alert(Alert.AlertType.ERROR,"Check your entered details").show();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtOldPassword.clear();
        txtNewPassword.clear();
        txtNewPassword.setEditable(false);
    }

    public void key_Entered(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.ENTER) {
            txtNewPassword.requestFocus();
            try {
                List<LoginDTO> dto = loginBO.findAll();
                for (LoginDTO loginDTO : dto){
                    String password = loginDTO.getPassword();
                    if (txtOldPassword.getText().equalsIgnoreCase(password)){
                        txtNewPassword.setEditable(true);
                    }else {
                        new Alert(Alert.AlertType.ERROR,"Old password is incorrect").show();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
