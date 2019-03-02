package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import model.VrepController;
import viewmodel.ViewModel;

import java.net.URL;
import java.util.ResourceBundle;


public class View implements Initializable {

    @FXML
    private ToggleButton connectBtn;
    @FXML
    private Label status;
    @FXML
    private Slider joint1S,joint2S,joint3S,joint4S,joint5S,joint6S;

    @FXML
    public void onToggleClicked(MouseEvent mouseEvent)
    {
        if(connectBtn.isSelected())
        {
            VrepController.getInstance().connect();
            if(VrepController.getInstance().clientID != -1) {
                connectBtn.setText("DISCONNECT");
                connectBtn.setStyle("-fx-background-color :  #0000ff ; -fx-text-fill: #ffffff;");
            }
            else
            {
                connectBtn.setSelected(false);
            }
        }
        else
        {
            VrepController.getInstance().disConnect();
            connectBtn.setText("CONNECT");
            connectBtn.setStyle("-fx-background-color :  #00ff00 ;");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        connectBtn.setStyle("-fx-background-color :  #00ff00 ;");
        status.textProperty().bindBidirectional(ViewModel.statusProperty());
        //joint1S.valueProperty().bindBidirectional(ViewModel.jointVal_1Property());
        joint1S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_1( newValue.floatValue());
            }
        });

        joint2S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_2( newValue.floatValue());
            }
        });
        /*joint2S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_2( newValue.floatValue());
            }
        });
*/
        joint3S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_3( newValue.floatValue());
            }
        });


        joint4S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_4( newValue.floatValue());
            }
        });

        joint5S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_5( newValue.floatValue());
            }
        });

        joint6S.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ViewModel.setJointVal_6( newValue.floatValue());
            }
        });

    }



}
