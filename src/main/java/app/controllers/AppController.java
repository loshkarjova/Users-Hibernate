package app.controllers;

import app.services.AppService;
import app.utils.Constants;
import app.views.AppView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppController {
    private final AppView view;
    private final AppService service;

    public void runApp(){
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice){
        switch (choice){
            case 1 -> service.createUser();
            case 2 -> service.readUsers();
            case 3 -> service.updateUser();
            case 4 -> service.deleteUser();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);
        }
    }


}
