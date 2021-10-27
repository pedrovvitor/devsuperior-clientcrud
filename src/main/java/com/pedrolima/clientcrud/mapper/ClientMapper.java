package com.pedrolima.clientcrud.mapper;

import org.springframework.stereotype.Component;

import com.pedrolima.clientcrud.dto.ClientDto;
import com.pedrolima.clientcrud.entities.Client;

@Component
public class ClientMapper {

	public Client toEntity(ClientDto dto) {
		return new Client(
				dto.getId(),
				dto.getName(),
				dto.getCpf(),
				dto.getIncome(),
				dto.getBirthDate(),
				dto.getChildren());
	}
	
	public ClientDto toDto(Client entity) {
		return new ClientDto(
				entity.getId(),
				entity.getName(),
				entity.getCpf(),
				entity.getIncome(),
				entity.getBirthDate(),
				entity.getChildren());
	}
}
