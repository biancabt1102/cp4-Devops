package br.com.dimdim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "T_DCM_ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_endereco")
	private Long id;

	@NotBlank(message = "A rua é obrigatória")
    @Column(name = "ds_rua")
    private String rua;

    @NotBlank(message = "O número é obrigatório")
    @Column(name = "nm_endereco")
    private String numero;

    @NotBlank(message = "A cidade é obrigatória")
    @Column(name = "ds_cidade")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Column(name = "ds_estado")
    private String estado;

    @NotBlank(message = "O CEP é obrigatório")
    @Column(name = "cep_cliente")
    private String cep;

	@ManyToOne
	@JoinColumn(name = "cd_usuario")
	private User user;
}
