package dio.desafio_projeto_dev_2024.service.impl;

import dio.desafio_projeto_dev_2024.domain.model.User;
import dio.desafio_projeto_dev_2024.domain.repository.UserRepository;
import dio.desafio_projeto_dev_2024.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userCreate) {
        if (userRepository.existsByAccountNumber(userCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userCreate);
    }
}
