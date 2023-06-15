package app.controllers;

import app.services.UserReadService;
import app.utils.AppStarter;
import app.views.UserReadView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserReadController {
    private final UserReadService service;
    private final UserReadView view;

    public void readUsers(){
        view.getOutput(service.readUsers());
        AppStarter.startApp();
    }
}
