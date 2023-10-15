package br.com.isadora.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    /*
     * Copia todas as propriedades que não são nulas do
     * objeto source para o target
     */
    public static void copyNonNullPrperties(Object source, Object target){

        //Responsável por copiar do source para o target utilizando o método como filtro
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }
    
    /*
     * Retorna todas os nomes das propriedades que possuem valor nulo
     */
    public static String[] getNullPropertyNames(Object source){

        /*
        * O BeanWrapper é uma interface que possui métodos para
        * acessar os atributos de um objeto
        */
        final BeanWrapper src = new BeanWrapperImpl(source);

        //Um array com todas as propriedades
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        //Propriedades com valores nulos
        Set<String> emptyNames = new HashSet<>();

        //Para cada propriedade
        for(PropertyDescriptor pd : pds){
            //Obtem o valor a propriedade
            Object srcValue = src.getPropertyValue(pd.getName());

            //Adiciona a propriedade na lista de nomes nulos
            if(srcValue == null){ 
                emptyNames.add(pd.getName());
            }
        }

        //Cria um array de String para as propriedades nulas
        String[] result = new String[emptyNames.size()];
        
        return emptyNames.toArray(result);
    }
}
