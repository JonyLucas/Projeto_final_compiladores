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
    
    public static void analisar() throws GramaticalException{
        token = next();
        if(periodo()){
            System.out.println("Frase aceita");
        }else{
            System.out.println("Erro: a sentença é inválida");
            throw new GramaticalException();
        }
    }
    
    private static boolean periodo(){
        
        // Periodo -> VAZIO
        if(token.get_position() == Container.get_size()){
            return true;
        // <Periodo> -> <Oracao> <Periodo>
        }else if(oracao()){
            if(periodo()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    private static boolean oracao(){
        // <Oracao> -> <Sujeito> <Predicado> [.]
        if(sujeito()){
            if(predicado()){
                if(token.get_word().equals(".")){
                    token = next();
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
                    token = next();
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
        if(varios_adjunto_adnominal()){
            if(nucleo_sujeito()){
                if(varios_adjunto_adnominal()){
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
    
    private static boolean varios_adjunto_adnominal(){
        // <varios_adjuntos_adnomial> -> <varios_adjunto_adnomial> <adjunto_adnomial>
        if(adjunto_adnomial()){
            if(varios_adjunto_adnominal()){
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
            return false;
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
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean predicado(){
        // <predicado> -> <verbo_ligacao>
        if(verbo_ligacao()){
            return true;
        // <predicado> -> <verbo_intrasintivo>
        }else if(verbo_intransitivo()){
            return true;
        // <predicado> -> <verbo_trans_indireto> <objeto_indireto> <predicativo_objeto> <adjunto_adverbial>
        }else if(verbo_transitivo_indireto()){
            if(objeto_indireto()){
                if(predicativo_objeto()){
                    if(adjunto_adverbial()){
                        return true;
                    }
                    else
                        return false;
                }else
                    return false;
            }else
                return false;
        // <predicado> -> <verbo_trans_direto>
        }else if(verbo_transitivo_direto()){
            return true;
        // <predicado> -> <locucao_verbal> <agente_passiva>
        }else if(locucao_verbal()){
            if(agente_passiva()){
                return true;
            }else{
                return false;
            }
        }else
            return false;
    }
    
    private static boolean verbo_ligacao(){
        // <verbo_ligacao> -> <verbo> <predicativo_sujeito> | <verbo> <adjunto_adverbial>
        if(verbo()){
            if(predicativo_sujeito()){
                return true;
            }else if(adjunto_adverbial()){
                return true;
            }else
                return false;
        }else
            return false;
    }
    
    public static boolean verbo_intransitivo(){
        // <verbo_intrasintivo> -> <verbo> <adjunto_adverbial> | <verbo>
        if(verbo()){
            if(adjunto_adverbial()){
                return true;
            }else{
                return true;
            }
        }else
            return false;
    }
    
    public static boolean verbo_transitivo_indireto(){
        // <verbo_trans_indireto> -> <verbo> [preposicao] <objeto_direto> | <verbo> [preposicao] <predicativo_objeto>
        if(verbo()){
            if(preposicao()){
                if(objeto_direto()){
                    return true;
                }else if(predicativo_objeto()){
                    return true;
                }else
                    return false;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean verbo_transitivo_direto(){
        // <verbo_trans_direto> -> <verbo> <objeto_direto> | <verbo> <adjunto_adverbial>
        if(verbo()){
            if(objeto_direto()){
                return true;
            }else if(adjunto_adverbial()){
                return true;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean objeto_direto(){
        // <objeto_direto> -> <varios_adjunto_adnominal> <nome> <varios_adjunto_adnominal> <complemento_nominal>
        if(varios_adjunto_adnominal()){
            if(nome()){
                if(varios_adjunto_adnominal()){
                    if(complemento_nominal()){
                        return true;
                    }else
                        return false;
                }else
                    return false;
            }else
                return false;
        }else 
            return false;
    }
    
    private static boolean objeto_indireto(){
        // <objeto_indireto> -> [preposicao] <varios_adjunto_adnominal> <nome> <varios_adjunto_adnominal> <complemento_nominal>
        if(preposicao()){
            if(varios_adjunto_adnominal()){
                if(nome()){
                    if(varios_adjunto_adnominal()){
                        if(complemento_nominal()){
                            return true;
                        }else
                            return false;
                    }else
                        return false;
                }else
                    return false;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean predicativo_objeto(){
        // <predicativo_objeto> -> [adjetivo]
        if(adjetivo()){
            return true;
        }else
            return false;
    }
    
    private static boolean predicativo_sujeito(){
        // <predicativo_sujeito> -> [adjetivo]
        if(adjetivo()){
            return true;
        // <predicativo_sujeito> -> [substantivo]
        }else if(substantivo()){
            return true;
        // <predicativo_sujeito> -> [pronome]
        }else if(pronome()){
           return true; 
        // <predicativo_sujeito> -> [numeral]
        }else if(numeral()){
            return true;
        }else
            return false;
    }
    
    private static boolean adjunto_adverbial(){
        // <adjunto_adverbial> -> [adverbio]
        if(adverbio()){
            return true;
        // <adjunto_adverbial> -> <locucao_adverbial>
        }else if(locucao_adverbial()){
            return true;
        }else
            return false;
    }
    
    private static boolean locucao_adverbial(){
        // <locucao_adverbial> -> [preposicao] [substantivo] | [preposicao] [adjetivo] | [preposicao] [adverbio]
        if(preposicao()){
            if(substantivo()){
                return true;
            }else if(adjetivo()){
                return true;
            }else if(adverbio()){
                return true;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean complemento_nominal(){
        // <complemento_nominal> -> [preposicao] <varios_adjunto_adnominal> <nome> <varios_adjunto_adnominal>
        if(preposicao()){
            if(varios_adjunto_adnominal()){
                if(nome()){
                    if(varios_adjunto_adnominal()){
                        return true;
                    }else
                        return false;
                }else
                    return false;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean locucao_verbal(){
        // <locucao_verbal> -> <verbo_auxiliar> [verbo]
        if(verbo_auxiliar()){
            if(verbo()){
                return true;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean verbo_auxiliar(){
        // <verbo_auxiliar> -> "ser"(conjugado)
        if(token.get_word().equals("ser") || token.get_word().equals("estar") || token.get_word().equals("ter") || token.get_word().equals("haver")){
            token = next();
            return true;
        }else
            return false;
    }
    
    private static boolean agente_passiva(){
        // <agente_passiva> -> "por" <sub_pron> || "de" <sub_pron>
        String word = token.get_word();
        if(word.equals("por") || word.equals("de")){
            token = next();
            if(sub_pron()){
                return true;
            }else
                return false;
        }else
            return false;
    }
    
    private static boolean sub_pron(){
        if(substantivo()){
            return true;
        }else if(pronome()){
            return true;
        }else
            return false;
    }
    
    private static boolean adverbio(){
        if(AnalisadorGramatical.is_adverbio(token)){
            token = next();
            return true;
        }else
            return false;
    }
    
    private static boolean preposicao(){
        if(AnalisadorGramatical.is_preposicao(token)){
            token = next();
            return true;
        }else
            return false;
    }
    
    private static boolean numeral(){
        if(AnalisadorGramatical.is_numeral(token)){
            token = next();
            return true;
        }else
            return false;
    }
    
    private static boolean adjetivo(){
        if(AnalisadorGramatical.is_adjetivo(token)){
            token = next();
            return true;
        }else{
            return false;
        }
    }
    
    private static boolean substantivo(){
        if(AnalisadorGramatical.is_substantivo(token)){
            token = next();
            return true;
        }else
            return false;
    }
    
    private static boolean verbo(){
        if(AnalisadorGramatical.is_verbo(token)){
            token = next();
            return true;
        }else
            return false;
    }
    
}
