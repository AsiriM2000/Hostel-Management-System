package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.runtime.ListAdapter;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class ManageReserveFormController {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    public Label lblDate;
    public Label lblTime;
    public ComboBox cmbStudent;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtResId;
    public ComboBox cmbRoom;
    public TextField txtType;
    public TextField txtRoomQty;
    public TextField txtKeyMoney;
    public TextField txtQty;
    public TableView tblCart;
    public JFXButton btnAdd;

    public void initialize() {
        cmbStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    List<Student> student = studentDAO.search((String) newValue);
                    for (Student student1 : student){
                        txtName.setText(student1.getName());
                        txtAddress.setText(student1.getAddress());
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                txtName.clear();
                txtAddress.clear();
            }
        });
        loadAllID();
    }

    public void loadAllID() {
        try {
            List<Student> all = studentDAO.getAll();
            for (Student student : all) {
                cmbStudent.getItems().add(student.getStudent_Id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddOnAction(ActionEvent actionEvent) {

    }
}
