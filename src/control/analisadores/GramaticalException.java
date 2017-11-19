/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.analisadores;

/**
 *
 * @author Joao
 */
public class GramaticalException extends RuntimeException{
    public GramaticalException(String mensagem){
        super(mensagem);
    }
    
    public GramaticalException(){
        this("Frase inválida: Erro gramatical");
    }
}
