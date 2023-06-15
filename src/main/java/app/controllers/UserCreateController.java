package app.controllers;

import app.services.UserCreateService;
import app.utils.AppStarter;
import app.views.UserCreateView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCreateController {

    private final UserCreateService service;
    private final UserCreateView view;

    public void createUser(){
        view.getOutput(service.createUser(view.getData()));
        AppStarter.startApp();
    }
}
