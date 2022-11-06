package com.binar.app.service;

import com.binar.app.dto.UserDTO;
import com.binar.app.model.User;
import com.binar.app.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        logger.info("Menyimpan pengguna baru {} ke Database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User result = findById(id);
        if(result != null) {
            result.setId(id);
            result.setUsername(user.getUsername());
            result.setEmailAddress(user.getEmailAddress());
            result.setPassword(user.getPassword());
            userRepository.save(user);
        }else {
            logger.error("Data pengguna tidak ditemukan");
        }
        return result;
    }

    @Override
    public Boolean delete(Long id) {
        final User result = findById(id);
        if (result != null) {
            // hard delete
            userRepository.deleteById(id);
            return true;
        } else {
            logger.error("Data pengguna yang akan di delete tidak ditemukan");
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        logger.info("Mengambil data pengguna dari database");
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()) {
            logger.info("Mengambil data pengguna dari database");
            return result.get();
        } else {
            logger.error("Id Data pengguna tidak ditemukan");
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public UserDTO mapToDto(User user) {
        return mapper.convertValue(user, UserDTO.class);
    }

    @Override
    public User mapToEntity(UserDTO userDTO) {
        return mapper.convertValue(userDTO, User.class);
    }

}
