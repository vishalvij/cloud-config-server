package com.vishal.userservice.service;

import com.vishal.userservice.VO.Department;
import com.vishal.userservice.VO.ResponseTemplateVO;
import com.vishal.userservice.entity.User;
import com.vishal.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside SaveUser in ServiceController");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment in UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

//          Department department = restTemplate.getForObject("http://localhost:9002/departments/"+user.getDepartmentId(),Department.class);
            Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
