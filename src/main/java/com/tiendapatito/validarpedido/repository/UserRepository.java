package com.tiendapatito.validarpedido.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tiendapatito.validarpedido.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> {

	Optional<User>findByEmail(String email);
}
