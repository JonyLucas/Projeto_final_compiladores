/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.analisadores;

import infra.Container;
import model.Token;

/**
 *
 * @author Joao
 */
public class AnalisadorSintatico {
    private static int nWord = 0;
    private static Token token;
    
    private static Token next(){
        Token token = Container.get(nWord++);
        System.out.println("token lido: " + token.get_word());
        return token;
    }
    
    public static void analisar(){
        token = next();
        if(periodo()){
            
        }else{
            System.out.println("Erro: a sentença é inválida");
        }
    }
    
    private static boolean periodo(){
        if(oracao()){
            if(periodo()){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
    
    private static boolean oracao(){
        if(sujeito()){
            if(predicado()){
                return true;
            }else{
                return false;
            }
            
        }else if(predicado()){
            if(sujeito()){
                if(predicado()){
                    return true;
                }else{
                    return true;
                }
            }else{
                return false;
            }
            
        }else{
            return false;
        }
    }
    
    private static boolean sujeito(){
        if(sujeito_simples()){
            return true;
        }else if(sujeito_composto()){
            return false;
        }else{
            return true;
        }
    }
    
    private static boolean sujeito_composto(){
        if(sujeito_simples()){
            token = next();
            if(token.get_word().equals(",")){
                if(sujeito_composto()){
                    return true;
                }else{
                    return false;
                }
            }else if(conjuncao()){
                if(sujeito_composto()){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    private static boolean sujeito_simples(){
        if(adjunto_adnomial()){
            if(nome()){
                if(adjunto_adnomial()){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    private static boolean conjuncao(){
        return false;
    }
    
    private static boolean predicado(){
        return false;
    }
    
    private static boolean nome(){
        if(substantivo()){
            return true;
        }else if(pronome()){
            return true;
        }else if(verbo()){
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean adjunto_adnomial(){
        if(adjetivo()){
            return true;
        }else if(locucao_adjetiva()){
            return true;
        }else if(locucao_adverbial()){
            return true;
        }else if(artigo()){
            return true;
        }else if(pronome()){
            return true;
        }else if(numeral()){
            return true;
        }else{
            return true;
        }
    }
    
    private static boolean artigo(){
        if(artigo_definido()){
            return true;
        }else if(artigo_indefinido()){
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean artigo_definido(){
        if(token.get_word().matches("[oa]|os|as")){
            token = next();
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean artigo_indefinido(){
        if(token.get_word().matches("um|uma|uns|umas")){
            token = next();
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean numeral(){
        return false;
    }
    
    private static boolean locucao_adjetiva(){
        return false;
    }
    
    private static boolean locucao_adverbial(){
        return false;
    }
    
    private static boolean adjetivo(){
        return false;
    }
    
    private static boolean pronome(){
        return false;
    }
    
    private static boolean substantivo(){
        return false;
    }
    
    private static boolean verbo(){
        return false;
    }
    
}
