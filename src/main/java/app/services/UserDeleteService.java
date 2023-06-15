package app.services;

import app.entities.User;
import app.repositories.UserDeleteRepository;
import app.utils.Constants;
import app.utils.IdChecker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDeleteService {
    private final UserDeleteRepository repository;

    public String deleteUser(User user){
        if (IdChecker.isIdExists(user)){
            return repository.deleteUser(user);
        }else {
           return Constants.ID_NO_EXISTS_MSG;
        }
    }

}
