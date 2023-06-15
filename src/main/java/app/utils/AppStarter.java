package app.utils;

import app.controllers.AppController;
import app.services.AppService;
import app.views.AppView;

public class AppStarter {
    public static void startApp() {
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }
}
