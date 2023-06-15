package app.controllers;

import app.services.UserDeleteService;
import app.utils.AppStarter;
import app.views.UserDeleteView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDeleteController {
    private final UserDeleteService service;
    private final UserDeleteView view;

     public void deleteUser(){
         view.getOutput(service.deleteUser(view.getData()));
         AppStarter.startApp();
     }

}
