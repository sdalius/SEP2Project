package View.Doctor;

import View.ViewHandler;
import ViewModel.Doctor.DoctorViewModel;

public class DoctorViewController {

    private DoctorViewModel doctorViewModel;
    private ViewHandler viewHandler;

    public void init(DoctorViewModel doctorViewModel, ViewHandler viewHandler) {
        this.doctorViewModel = doctorViewModel;
        this.viewHandler = viewHandler;
    }

    public void openAppointmentView() {
        viewHandler.openAppointmentListView();
    }
}
