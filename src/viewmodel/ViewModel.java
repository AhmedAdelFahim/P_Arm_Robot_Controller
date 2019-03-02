package viewmodel;

import javafx.beans.property.*;
import model.VrepController;

public class ViewModel {

    private static final StringProperty status = new SimpleStringProperty();
    private static float jointVal_1=0 ;
    private static float jointVal_2=0 ;
    private static float jointVal_3=0 ;
    private static float jointVal_4=0 ;
    private static float jointVal_5=0 ;
    private static float jointVal_6=0 ;


    public static String getStatus() {
        return status.get();
    }

    public static StringProperty statusProperty() {
        return status;
    }

    public static void setStatus(String status) {
        ViewModel.status.set(status);
    }


    public static float getJointVal_1() {
        return jointVal_1;
    }

    public static void setJointVal_1(float jointVal_1) {
        ViewModel.jointVal_1 = jointVal_1;
        VrepController.getInstance().changeJointPosValue(0,jointVal_1);
    }

    public static float getJointVal_2() {
        return jointVal_2;
    }

    public static void setJointVal_2(float jointVal_2) {
        ViewModel.jointVal_2 = jointVal_2;
        VrepController.getInstance().changeJointPosValue(1,jointVal_2);
    }

    public static float getJointVal_3() {
        return jointVal_3;
    }

    public static void setJointVal_3(float jointVal_3) {
        ViewModel.jointVal_3 = jointVal_3;
        VrepController.getInstance().changeJointPosValue(2,jointVal_3);
    }

    public static float getJointVal_4() {
        return jointVal_4;
    }

    public static void setJointVal_4(float jointVal_4) {
        ViewModel.jointVal_4 = jointVal_4;
        VrepController.getInstance().changeJointPosValue(3,jointVal_4);
    }

    public static float getJointVal_5() {
        return jointVal_5;
    }

    public static void setJointVal_5(float jointVal_5) {
        ViewModel.jointVal_5 = jointVal_5;
        VrepController.getInstance().changeJointPosValue(4,jointVal_5);
    }

    public static float getJointVal_6() {
        return jointVal_6;
    }

    public static void setJointVal_6(float jointVal_6) {
        ViewModel.jointVal_6 = jointVal_6;
        VrepController.getInstance().changeJointPosValue(5,jointVal_6);
    }
}
