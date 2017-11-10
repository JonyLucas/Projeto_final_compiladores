/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joao
 */

import java.util.ArrayList;

public class Token {
    
    private String word;
    private String gramatical_class;
    private int position;
    private ArrayList<String> synonyms = new ArrayList<String>();
    
    /**-- Construtores --**/
    
    public Token(String word){
        this(word, null, -1);
    }
    
    public Token(String word, int position){
        this(word, null, position);
    }
    
    public Token(String word, String gramatical_class, int position){
        this.word = word;
        this.gramatical_class = gramatical_class;
        this.position = position;
    }
    
    /**-- Metodos Gets --**/
    
    public String get_word(){
        return this.word;
    }
    
    public String get_gramatical_class(){
        return this.gramatical_class;
    }
    
    public int get_position(){
        return this.position;
    }
    
    public ArrayList<String> get_synonyms(){
        return this.synonyms;
    }
    
    /**-- Metodos Sets --**/
    
    public void set_position(int pos){
        position = pos;
    }
    
    public void set_gramatical_class(String gc){
        gramatical_class = gc;
    }
    
    public void add_synonym(String synonymous){
        synonyms.add(synonymous);
    }
}
