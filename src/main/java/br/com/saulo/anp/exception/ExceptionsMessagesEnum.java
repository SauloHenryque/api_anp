
package br.com.saulo.anp.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.github.thiagonego.alfred.object.Objeto;

import br.com.saulo.anp.ultil.I18n;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum ExceptionsMessagesEnum {


	REGISTRO_NAO_ENCONTRADO(NOT_FOUND.value(), "registro_nao_encontrado", NotFoundException.class),
	
	NOME_JA_CADASTRADO(BAD_REQUEST.value(), "nome_ja_cadastrado", BadRequestException.class),
	
	EMAIL_JA_CADASTRADO(BAD_REQUEST.value(), "email_ja_cadastrado", BadRequestException.class)
	

	;
	
    @Getter
    private Integer codigo;

    @Getter
    private String key;

    @Getter
    private Class<? extends Exceptions> klass;

    ExceptionsMessagesEnum(int codigo, String key, Class<? extends Exceptions> klass) {

        this.key = key;
        this.klass = klass;
        this.codigo = codigo;

    }

    public static ExceptionsMessagesEnum getEnum(String key) {

        for (ExceptionsMessagesEnum e : ExceptionsMessagesEnum.values()) {

            if (e.getKey().equals(key)) {
                return e;
            }

        }

        return null;

    }

    public String getMessage() {

        return I18n.getMessage(this.key);

    }

    public void raise() {

        log.debug("Raising error: {}", this);
        raiseException(getMessage());

    }
    
    private void raiseException(String msg) {

        if (this.badRequest()) {

            throw new BadRequestException(key, msg);

        } else if (this.notFound()) {

            throw new NotFoundException(key, msg);

        }

    }

    public void raise(String... textoDinamico) {

        String texto = getMessage();
        if (textoDinamico != null) {

            Integer count = 0;
            while (Objeto.notBlank(texto) && texto.contains("{}")) {

                if (textoDinamico.length == 1) {

                    texto = texto.replace("{}", (String) Objeto.or(textoDinamico[count], ""));
                    break;

                } else {

                    texto = texto.replaceFirst("\\{\\}", (String) Objeto.or(textoDinamico[count], ""));

                }
                count++;

            }

        }

        raiseException(texto);

    }


    private Boolean badRequest() {

        return this.codigo == BAD_REQUEST.value();
    }

    private Boolean notFound() {

        return this.codigo == NOT_FOUND.value();
    }
}
