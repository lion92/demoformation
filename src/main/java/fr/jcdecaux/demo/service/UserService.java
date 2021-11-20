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
package fr.jcdecaux.demo.service;

import fr.jcdecaux.demo.dao.entity.UserEntity;
import fr.jcdecaux.demo.dao.repository.UserRepository;
import fr.jcdecaux.demo.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private UserRepository userRepository;
  private ModelMapper modelMapper;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    this.modelMapper = new ModelMapper();
  }

  public List<UserDto> getAll() {
    return this.modelMapper.map(this.userRepository.findAll(), new TypeToken<List<UserDto>>() {}.getType());
  }

  public UserDto save(UserEntity userEntity) {
    return this.modelMapper.map(this.userRepository.save(userEntity), UserDto.class);
  }

  public UserDto getAllByFirstName(String firstName) {
    return this.modelMapper.map(this.userRepository.findByFirstName(firstName), new TypeToken<List<UserDto>>() {}.getType());
  }

  public List<UserDto> getAllByLastName(String lastName) {
    return this.modelMapper.map(this.userRepository.findByLastName(lastName), new TypeToken<List<UserDto>>() {}.getType());
  }

  public UserDto getAllByFirstNameAndLastName(String firstName, String lastName) {
    return this.modelMapper.map(this.userRepository.findByFirstNameAndLastName(firstName, lastName), UserDto.class);
  }

  public UserDto getById(Long id) {
    return this.modelMapper.map(this.userRepository.findById(id).get(), UserDto.class);
  }
  public void delete(Long id){
    this.userRepository.deleteById(id);
  }
}