package com.pedrolima.clientcrud.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pedrolima.clientcrud.dto.ClientDto;

public interface ClientService {

	Page<ClientDto> findAllPaged(Pageable pageable);
	ClientDto findById(Long id);
	ClientDto insert(ClientDto clientDto);
	ClientDto update(Long id, ClientDto clientDto);
	void delete(Long id);
}
