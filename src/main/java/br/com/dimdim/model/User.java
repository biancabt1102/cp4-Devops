package br.com.dimdim.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "T_DCM_USUARIO")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_usuario")
	private Long id;

	@NotBlank(message = "Seu nome é obrigatório para realizar o cadastro.")
	@Column(name = "nm_cliente")
	private String name;

	@NotBlank(message = "O CPF é obrigatório")
    @Column(name = "ds_cpf")
    private String cpf;

    @NotBlank(message="O email é obrigatório")
    @Column(name = "ds_email")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Column(name = "ds_senha")
    private String senha;

    @NotNull
    @Column(name = "dt_nascimento")
    private String data;
    
    @NotBlank(message = "O telefone é obrigatório")
    @Column(name = "nr_telefone")
    private String telefone;
	
	@ToString.Exclude
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Endereco> endereco;
}
