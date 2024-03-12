package database.com.user.service;

import database.com.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import database.com.user.model.UserEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository; // 스프링이 자동으로 찾아준다. 어떻게? 빈으로 등록되어있으므로

    public UserEntity save(UserEntity user) {
        // save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score) {
        return userRepository.findAllScoreGreaterThen(score);
    }
}
