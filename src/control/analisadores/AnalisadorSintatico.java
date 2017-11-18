/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.analisadores;

import infra.Container;
import model.Token;
import control.analisadores.AnalisadorGramatical;

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
        // <Periodo> -> <Oracao> <Periodo>
        if(oracao()){
            if(periodo()){
                return true;
            }else{
                return false;
            }
        // Periodo -> VAZIO
        }else{
            return true;
        }
    }
    
    private static boolean oracao(){
        // <Oracao> -> <Sujeito> <Predicado> [.]
        if(sujeito()){
            if(predicado()){
                if(token.get_word().equals(".")){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        // <Oracao> -> <Predicado> <Sujeito> [.]
        }else if(predicado()){
            if(sujeito()){
                if(token.get_word().equals(".")){
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
    
    private static boolean sujeito(){
        // <Sujeito> -> <Sujeito_simples> | <Sujeito_simples> <Separador> <Sujeito>
        if(sujeito_simples()){
            if(separador()){
                if(sujeito()){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        // <Sujeito> -> VAZIO
        }else{
            return true;
        }
    }
    
    private static boolean separador(){
        // <Separador> -> [,]
        if(token.get_word().equals(",")){
            token = next();
            return true;
        // <Separador> -> <Conjuncao>
        }else if(conjuncao()){
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean sujeito_simples(){
        // <Sujeito_simples> -> <varios_adjunto_adnominal> <nucleo_sujeito> <varios_adjunto_adnominal>
        if(varios_adjunto_adnomial()){
            if(nucleo_sujeito()){
                if(varios_adjunto_adnomial()){
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
    
    private static boolean varios_adjunto_adnomial(){
        // <varios_adjuntos_adnomial> -> <varios_adjunto_adnomial> <adjunto_adnomial>
        if(adjunto_adnomial()){
            if(varios_adjunto_adnomial()){
                return true;
            }else{
                return false;
            }
        // <varios_adjunto_adnomial -> [VAZIO]
        }else{
            return true;
        }
    }
    
    private static boolean nucleo_sujeito(){
        // <nucleo_sujeito> -> <nome>
        if(nome()){
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean nome(){
        // <nome> -> <substantivo>
        if(substantivo()){
            return true;
        // <nome> -> <pronome>
        }else if(pronome()){
            return true;
        // <nome> -> <verbo>
        }else if(verbo()){
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean adjunto_adnomial(){
       // <adjunto_adnomial> -> <adjetivo>
        if(adjetivo()){
            return true;
        // <adjunto_adnominal> -> <locucao_adjetiva>
        }else if(locucao_adjetiva()){
            return true;
        // <adjunto_adnominal> -> [artigo]
        }else if(artigo()){
            return true;
        // <adjunto_adnominal> -> [pronome]
        }else if(pronome()){
            return true;
        // <adjunto_adnominal> -> [numeral]
        }else if(numeral()){
            return true;
        // <adjunto_adnominal> -> [vazio]
        }else{
            return true;
        }
    }
    
    private static boolean pronome(){
        if(AnalisadorGramatical.is_pronome(token)){
            token = next();
            return true;
        }else
            return false;
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
    
    private static boolean conjuncao(){
        if(AnalisadorGramatical.is_conjuncao(token)){
            token = next();
            return true;
        }
        else
            return false;
    }
    
    private static boolean locucao_adjetiva(){
        // <locucao_adjetiva> -> [preposicao] [substantivo] | <locucao_adjetiva> -> [preposicao] [adverbio]
        if(preposicao()){
            if(substantivo()){
                return true;
            }else if(adverbio()){
                return true;
            }
        }else
            return false;
    }
    
    private static boolean predicado(){
        // <predicado> -> <verbo_ligacao> <predicativo_sujeito> <adjunto_adverbial>
        if(verbo_ligacao()){
            if(predicado_sujeito()){
                if(adjunto_adverbial()){
                    return true;
                }
            }
        // <predicado> -> <verbo_intrasintivo> <adjunto_adverbial>
        }else if(verbo_intransitivo()){
            if(adjunto_adverbial()){
                return true;
            }else
                return false;
        }
        return false;
    }
    
    private static boolean numeral(){
        return false;
    }
    
    private static boolean locucao_adverbial(){
        return false;
    }
    
    private static boolean adjetivo(){
        return false;
    }
    
    private static boolean substantivo(){
        return false;
    }
    
    private static boolean verbo(){
        return false;
    }
    
}
