//package com.example.CRUD_SQL_JPA.Controller;
//
//import com.example.CRUD_SQL_JPA.Model.User;
//import com.example.CRUD_SQL_JPA.Service.UserService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/user")
//
//public class UserController {
//
//    @Autowired
//    UserService userService ;
//
//    @GetMapping("/create")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("CreateUser");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView save(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            ModelAndView modelAndView = new ModelAndView("CreateUser");
//            return modelAndView;
//        }
//        ModelAndView modelAndView = new ModelAndView("CreateUser");
//        userService.save(user);
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }
//
//
//    @GetMapping("/detail/{ID}")
//    public ModelAndView showLists(@PathVariable Long ID) throws ChangeSetPersister.NotFoundException {
//        ModelAndView modelAndView= new ModelAndView("DetailUser");
//        Optional<User> users = userService.findById(ID);
//        if(users.get()==null){
//            return new ModelAndView("error.404");
//        }else {
//            modelAndView.addObject("users", users.get());
//            return modelAndView;
//        }
//    }
//
//
//    @GetMapping("/Update/{ID}")
//    public ModelAndView updateCity(@PathVariable Long ID) throws ChangeSetPersister.NotFoundException {
//        Optional<User> user = (userService.findById(ID));
//        if(user.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("UpdateUser");
//            modelAndView.addObject("user",user);
//            return modelAndView;
//        }else {
//            ModelAndView modelAndView = new ModelAndView("error.404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/Update")
//    public ModelAndView update(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
//        if (bindingResult.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("UpdateUser");
//            return modelAndView;
//        }
//        userService.save(user);
//        ModelAndView modelAndView = new ModelAndView("UpdateUser");
//        Iterable <User> users = userService.findAll();
//        modelAndView.addObject("users", users);
//        return modelAndView;
//    }
//
//}



package com.example.CRUD_SQL_JPA.Controller;

import com.example.CRUD_SQL_JPA.Model.User;
import com.example.CRUD_SQL_JPA.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("listUser");
        Iterable user = userService.findAll();
        modelAndView.addObject("user", user);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("CreateUser");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("CreateUser");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        userService.save(user);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @GetMapping("/detail/{ID}")
    public ModelAndView showLists(@PathVariable("ID") Long ID) throws ChangeSetPersister.NotFoundException {
        ModelAndView modelAndView = new ModelAndView("DetailUser");
        Optional<User> users = userService.findById(ID);
        if (users.isEmpty()) {
            return new ModelAndView("error.404");
        } else {
            modelAndView.addObject("users", users.get());
            return modelAndView;
        }
    }


    @GetMapping("/update/{ID}")
    public ModelAndView showUpdateForm(@PathVariable("ID") Long ID) {
        Optional<User> user = userService.findById(ID);
        if (user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("UpdateUser");
            modelAndView.addObject("user", user.get());
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/update")
    public ModelAndView update(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("UpdateUser");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        userService.save(user);
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }
}
