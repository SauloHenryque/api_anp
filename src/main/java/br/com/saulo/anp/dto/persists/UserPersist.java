package br.com.saulo.anp.dto.persists;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Usuario Persist")
public class UserPersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	
    /**
     * Nome Usuario
     */
    @ApiModelProperty(value = "Nome do Usuario", position = 1)
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;
    
    /**
     * Email
     */
    @ApiModelProperty(value = "Email Usuario", position = 2)
    @NotNull(message = "Email não pode ser nulo")
    @Email()
    private String email;
    
    /**
     * Email
     */
    @ApiModelProperty(value = "Passord Usuario", position = 3)
    @NotNull(message = "Password não pode ser nulo")
    private String password;

}
