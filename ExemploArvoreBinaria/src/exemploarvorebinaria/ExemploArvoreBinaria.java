/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemploarvorebinaria;

import arvorebinaria.ArvoreABB;

/**
 *
 * @author profslabs
 */
public class ExemploArvoreBinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArvoreABB a = new ArvoreABB();
        
        a.insere(10);
        a.insere(50);
        a.insere(5);
        a.insere(4);
        a.insere(1);
        a.insere(8);
        a.insere(20);
        a.printIncurso();
        
    }
    
}
