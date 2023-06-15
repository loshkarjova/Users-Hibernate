package app.services;

import app.entities.User;
import app.exceptions.CreateException;
import app.repositories.UserCreateRepository;
import app.utils.Constants;
import app.utils.EmailValidator;
import app.utils.PhoneValidator;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserCreateService {

    private final UserCreateRepository repository;

    public String createUser(User user) {
        Map<String, String> errors = validateData(user);

        if (errors.size() > 0){
            try {
                throw new CreateException("Check inputs", errors);
            }catch (CreateException e){
                return e.getErrors(errors);
            }
        }return repository.createUser(user);
    }

    private Map<String, String> validateData(User user) {

        Map<String, String> errors = new HashMap<>();

        if (user.getFirstName().isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);

        if (user.getLastName().isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);

        if (PhoneValidator.isPhoneValid(user.getPhone()))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        if (EmailValidator.isEmailValid(user.getEmail()))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }


}
