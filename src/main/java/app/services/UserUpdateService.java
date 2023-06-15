package app.services;

import app.entities.User;
import app.exceptions.UpdateException;
import app.repositories.UserUpdateRepository;
import app.utils.Constants;
import app.utils.IdChecker;
import app.utils.PhoneValidator;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
public class UserUpdateService {

  private final UserUpdateRepository repository;

    public String updateContact(User user) {

        Map<String, String> errors = validateData(user);

        if (errors.size() > 0) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(user);
    }

    private Map<String, String> validateData(User user) {
        Map<String, String> errors = new HashMap<>();

        if (Integer.toString(user.getId()).isEmpty())
            errors.put("id", Constants.INPUT_REQ_MSG);

        if (user.getId() <= 0) {
            errors.put("id", Constants.ID_NO_EXISTS_MSG);
        }

        if (!IdChecker.isIdExists(user)) {
            errors.put("id", Constants.ID_NO_EXISTS_MSG);
        }

        if (PhoneValidator.isPhoneValid(user.getPhone()))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        return errors;
    }
}
