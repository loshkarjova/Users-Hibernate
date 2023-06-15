package app.services;

import app.entities.User;
import app.repositories.UserReadRepository;
import app.utils.Constants;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class UserReadService {

    private final UserReadRepository repository;

    public String readUsers() {

        List<User> list = repository.readUsers();

        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getFirstName())
                                .append(" ")
                                .append(user.getLastName())
                                .append(", ")
                                .append(user.getPhone())
                                .append(", ")
                                .append(user.getEmail())
                                .append("\n")
                );
                return "\n______ USERS ___________\n" + stringBuilder.toString();
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }

}
