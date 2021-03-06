package br.com.saulo.anp.dto.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Request Usuario")
public class UserRequest implements Serializable{
	
	 private static final long serialVersionUID = 3589073168426445707L;
	 
	    @ApiModelProperty(value = "Identificação da Usuario", position = 1)
	    private Long id;

	    @ApiModelProperty(value = "Nome da Usuario", position = 2)
	    private String nome;
	    
	    @ApiModelProperty(value = "Email da Usuario", position = 3)
	    private String email;
	  
	    @ApiModelProperty(value = "Password da Usuario", position = 4)
	    private String password;

}
