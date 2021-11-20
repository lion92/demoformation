/*
 * Copyright (c) 2001-2017 Group JCDecaux.
 * 17 rue Soyer, 92523 Neuilly Cedex, France.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Group JCDecaux ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you
 * entered into with Group JCDecaux.
 */
package fr.jcdecaux.demo.api;

import fr.jcdecaux.demo.dao.entity.UserEntity;
import fr.jcdecaux.demo.dto.UserDto;
import fr.jcdecaux.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/users/{user-id}")
    public UserDto getById(@PathVariable("user-id") String id) {
        return this.userService.getById(Long.valueOf(id));
    }


    @PostMapping("/users")
    public UserDto save(@RequestBody UserEntity user) {
        return this.userService.save(user);
    }

    @PutMapping("/users/{user-id}")
    public UserDto update(@PathVariable("user-id") long id, @RequestBody UserEntity user) {
        Optional optional = this.userService.getAll().stream().filter(userServiceId -> userServiceId.getId() == id).findFirst();
        if (optional.isPresent()) {
            user.setId(id);
            return this.userService.save(user);
        } else {
            System.out.println("Id n'existe pas!");
            return null;
        }
    }

    @DeleteMapping("/users/{user-id}")
    public void delete(@PathVariable("user-id") long id, @RequestBody UserEntity user) {
        Optional optional = this.userService.getAll().stream().filter(userServiceId -> userServiceId.getId() == id).findFirst();
        if (optional.isPresent()) {
            user.setId(id);

            this.userService.delete(id);
            System.out.println("id supprimé");
        } else {
            System.out.println("Id n'existe pas!");

        }
    }

    // GetMapping("") PostMapping("") PutMapping("") OptionMapping("") DeleteMapping("")
    //  @PathVariable("nom"), @RequestBody
    //add put delete todo
}