package br.com.saulo.anp.dto.responses;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response Usuario")
public class UserResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
	/**
     * Código de Identificação.
     */
    @ApiModelProperty(value = "Identificação da Usuario", position = 1)
    private Long id;

    /**
     * Nome do Usuario.
     */
    @ApiModelProperty(value = "Nome da Usuario", position = 2)
    private String nome;
    
    /**
     * Response email
     */
    @ApiModelProperty(value = "Email da Usuario", position = 3)
    private String email;
    
    /**
     * Response password
     */
    @ApiModelProperty(value = "Password da Usuario", position = 4)
    private String password;
}
