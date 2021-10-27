package com.pedrolima.clientcrud.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedrolima.clientcrud.dto.ClientDto;
import com.pedrolima.clientcrud.entities.Client;
import com.pedrolima.clientcrud.mapper.ClientMapper;
import com.pedrolima.clientcrud.repositories.ClientRepository;
import com.pedrolima.clientcrud.serviceimpl.exceptions.DatabaseException;
import com.pedrolima.clientcrud.serviceimpl.exceptions.ResourceNotFoundException;
import com.pedrolima.clientcrud.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientMapper clientMapper;
	
	@Override
	@Transactional
	public Page<ClientDto> findAllPaged(Pageable pageable) {
		return clientRepository
				.findAll(pageable)
				.map((client) -> clientMapper
						.toDto(client));
	}

	@Override
	@Transactional
	public ClientDto findById(Long id) {
		return clientMapper
				.toDto(clientRepository
						.findById(id)
						.orElseThrow(() ->
						new ResourceNotFoundException("Resource not found! id: "+ id)));
	}

	@Override
	@Transactional
	public ClientDto insert(ClientDto clientDto) {
		Client client = clientMapper.toEntity(clientDto);
		client.setId(null);
		return clientMapper.toDto(clientRepository.save(client));
	}

	@Override
	@Transactional
	public ClientDto update(Long id, ClientDto clientDto) {
		Client client = clientRepository
		.findById(id)
		.orElseThrow(() ->
		new ResourceNotFoundException("Resource not found! id: "+ id));
		client.setName(clientDto.getName());
		client.setCpf(clientDto.getCpf());
		client.setIncome(clientDto.getIncome());
		client.setChildren(clientDto.getChildren());
		client.setBirthDate(clientDto.getBirthDate());
		return clientMapper
				.toDto(clientRepository
						.save(client));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Product not found! Id = " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
		
	}

}
