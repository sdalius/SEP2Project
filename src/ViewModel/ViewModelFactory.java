package ViewModel;

import Model.BookingClientInterface;
import View.EditAppointment.EditAppointmentViewController;
import ViewModel.AppointmentList.AppointmentListViewModel;
import ViewModel.CreateAccount.CreateAccountViewModel;
import ViewModel.Doctor.DoctorViewModel;
import ViewModel.DoctorList.DoctorListViewModel;
import ViewModel.EditAppointment.EditAppointmentViewModel;
import ViewModel.PatientView.PatientViewModel;
import ViewModel.Login.LoginViewModel;
import ViewModel.PickADate.PickADateViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private PatientViewModel patientViewModel;
    private DoctorListViewModel doctorListViewModel;
    private PickADateViewModel pickADateViewModel;
    private DoctorViewModel doctorViewModel;
    private AppointmentListViewModel appointmentListViewModel;
    private EditAppointmentViewModel editAppointmentViewModel;

    public ViewModelFactory(BookingClientInterface bookingClientInterface) {
        loginViewModel = new LoginViewModel ( bookingClientInterface );
        createAccountViewModel = new CreateAccountViewModel ( bookingClientInterface );
        patientViewModel = new PatientViewModel ( bookingClientInterface );
        doctorListViewModel = new DoctorListViewModel(bookingClientInterface);
        pickADateViewModel = new PickADateViewModel (bookingClientInterface);
        doctorViewModel = new DoctorViewModel(bookingClientInterface);
        appointmentListViewModel = new AppointmentListViewModel(bookingClientInterface);
        editAppointmentViewModel = new EditAppointmentViewModel(bookingClientInterface);
    }
    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
    public CreateAccountViewModel getCreateAccountViewModel() { return createAccountViewModel;}
    public PatientViewModel getPatientViewModel() { return patientViewModel;}
    public DoctorListViewModel getDoctorListViewModel() {
        return doctorListViewModel;
    }
    public PickADateViewModel getPickADateViewModel() { return pickADateViewModel;}
    public DoctorViewModel getDoctorViewModel() { return doctorViewModel; }
    public AppointmentListViewModel getAppointmentListViewModel() { return appointmentListViewModel; }
    public EditAppointmentViewModel getEditAppointmentViewModel() { return editAppointmentViewModel; }
}
