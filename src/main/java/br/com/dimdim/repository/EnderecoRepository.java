package br.com.dimdim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dimdim.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    public List<Endereco> findByUserId(Long userId);
}