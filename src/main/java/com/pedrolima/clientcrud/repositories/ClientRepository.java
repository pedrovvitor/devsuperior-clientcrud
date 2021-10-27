package com.pedrolima.clientcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrolima.clientcrud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
