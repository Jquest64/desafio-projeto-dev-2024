package dio.desafio_projeto_dev_2024.service;

import dio.desafio_projeto_dev_2024.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userCreate);
}
