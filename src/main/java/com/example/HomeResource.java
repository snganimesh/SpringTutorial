package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeResource {


          @Autowired
           MyDetailsService myDetailsService;
          @Autowired
          UserRepository userRepository;
         @GetMapping("/")
          public String home()
         {
             return ("<h1>Welcome Home</h1>");
         }

         @GetMapping("/user")
         public String user()
         {
             return ("<h1>Welcome User</h1>");
         }
        @GetMapping("/admin")
        public String admin()
        {
            return ("<h1>Welcome Admin</h1>");
        }

        @GetMapping("/create")
        public List<User> createUser()
        {
            User user = new User();
            user.setUserName("Ani");
            user.setPassword("Pass");
            user.setActive(true);
            user.setRoles("ROLE_USER");
            userRepository.save(user);

            return userRepository.findAll();
        }

}
