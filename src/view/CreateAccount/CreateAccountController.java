package view.CreateAccount;

import view.ViewHandler;
import viewmodel.CreateAccount.CreateAccountViewModel;

public class CreateAccountController {

    private CreateAccountViewModel createAccountViewModel;
    private ViewHandler viewHandler;

    public void init(CreateAccountViewModel createAccountViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.createAccountViewModel = createAccountViewModel;
        }
}
