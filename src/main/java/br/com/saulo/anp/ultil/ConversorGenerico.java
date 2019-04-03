package br.com.saulo.anp.ultil;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;


public class ConversorGenerico {
	
	
    public static <E, T> E convertModelMapper(T source, Class<E> typeDestination, MatchingStrategy strategy) {
        E model = null;
        if (source != null && typeDestination != null) {

             ModelMapper modelMapper = new ModelMapper();

             modelMapper.getConfiguration().setMatchingStrategy(strategy);
             model = modelMapper.map(source, typeDestination);
        }

        return model;
   }

   public static <E, T> E convertModelMapper(T source, Class<E> typeDestination) {
        return convertModelMapper(source, typeDestination, MatchingStrategies.STRICT);
   }
    
   public static <E, T> List<E> convertModelMapper(List<T> source, Type destinationType) {
        return convertModelMapper(source, destinationType, MatchingStrategies.STRICT);
   }
   
   public static <E, T> List<E> convertModelMapper(List<T> source, Type destinationType, MatchingStrategy strategy) {

       List<E> model = null;
       if (source != null && destinationType != null) {

            ModelMapper modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(strategy);
            model = modelMapper.map(source, destinationType);
       }

       return model;
  }

}
