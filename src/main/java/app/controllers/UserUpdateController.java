package app.controllers;

import app.services.UserUpdateService;
import app.utils.AppStarter;
import app.views.UserUpdateView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserUpdateController {
    private final UserUpdateService service;
    private final UserUpdateView view;

    public void updateUser(){
        view.getOutput(service.updateContact(view.doInputs()));
        AppStarter.startApp();
    }
}
