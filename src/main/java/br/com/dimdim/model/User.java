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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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

	@NotBlank(message = "O nome do cliente é obrigatório para realizar o cadastro.")
	@Size(min = 3, max = 50)
	@Column(name = "nm_cliente")
	private String name;

	@NotBlank(message = "O CPF é obrigatório")
    @Column(name = "ds_cpf")
	@Size(min = 11, max = 14)
    private String cpf;

    @NotBlank(message="O email é obrigatório")
    @Column(name = "ds_email")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
	@Size(min = 8, max = 30)
    @Column(name = "ds_senha")
    private String senha;

    @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dt_nascimento")
    private LocalDate data;
    
    @NotBlank(message = "O telefone é obrigatório")
	@Size(min = 10, max = 15)
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
