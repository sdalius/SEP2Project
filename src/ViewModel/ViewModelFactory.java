package ViewModel;

import Model.BookingClientInterface;
import ViewModel.CreateAccount.CreateAccountViewModel;
import ViewModel.DoctorList.DoctorListViewModel;
import ViewModel.PatientView.PatientViewModel;
import ViewModel.Login.LoginViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private PatientViewModel patientViewModel;
    private DoctorListViewModel doctorListViewModel;

    public ViewModelFactory(BookingClientInterface bookingClientInterface) {
        loginViewModel = new LoginViewModel ( bookingClientInterface );
        createAccountViewModel = new CreateAccountViewModel ( bookingClientInterface );
        patientViewModel = new PatientViewModel ( bookingClientInterface );
        doctorListViewModel = new DoctorListViewModel(bookingClientInterface);
    }
    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
    public CreateAccountViewModel getCreateAccountViewModel() { return createAccountViewModel;}
    public PatientViewModel getPatientViewModel() { return patientViewModel;}
    public DoctorListViewModel getDoctorListViewModel() {
        return doctorListViewModel;
    }
}
