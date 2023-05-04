/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alexandru
 */
public class Paraules implements Comparator<String> {

    private String text;
    private List<String> paraules;

    public Paraules() {
        paraules = new ArrayList<>();
        this.text = "";
    }

    public boolean esText(String text) throws MaEx {
        if (text == null || text.isEmpty()) {
            throw new MaEx("El texto está vacío");
        }
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void afegir(String paraula) throws MaEx {
        if (paraula == null || paraula.isEmpty()) {
            throw new MaEx("No se puede introducir valores nulo o vacios");
        }
        String[] separa = paraula.split(" ");
        for (int i = 0; i < separa.length; i++) {
            paraules.add(separa[i]);
        }
    }

    public void borrar() {
        paraules.clear();
    }

    public String llistaParaules() {
        String cad = "Llistat de paraules\n--------------------------\n";
        int cont = 0;
        for (String paraula : paraules) {
            if (cont == 5) {
                cad += paraula + "\n";
                cont = 0;
            } else {
                cad += paraula + ", ";
                cont++;
            }
        }
        return cad;
    }

    public String llistaPalindroms() {
        String cad = "Llistat de Palindroms\n--------------------------\n";
        for (String paraula : paraules) {
            if (esPalindrom(paraula)) {
                cad += paraula + " ";
            }
        }
        return cad;
    }

    private boolean esPalindrom(String paraula) {
        String revesParaula = "";
        char[] reves = paraula.toCharArray();
        for (int i = paraula.length() - 1; i >= 0; i--) {
            revesParaula += paraula.charAt(i);
        }
        return paraula.equals(revesParaula);
    }

    public String llistaSenseRepetits() {
        String cad = "Llistat sense Repetits\n--------------------------\n";
        for (int i = 0; i < paraules.size(); i++) {
            if (esRepetit(paraules.get(i), i)) {
                cad += paraules.get(i) + " ";
            }
        }
        return cad;
    }

    private boolean esRepetit(String text, int pos) {
        for (int i = 0; i < paraules.size(); i++) {
            if (paraules.get(i).equals(text) && i != pos) {
                return false;
            }
        }
        return true;
    }

    public void ordenats() {
        Collections.sort(paraules, (String o1, String o2) -> o2.compareTo(o1));
    }

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }

    @Override
    public Comparator<String> reversed() {
        return Comparator.super.reversed();
    }

    public String llistaOrdenats() {
        String cad = "Llistat de Paraules Ordenats\n--------------------------\n";
        String alfabetic = "abcdefghijkmnñopkrsuvwxyz";

        for (int i = 0; i < alfabetic.length(); i++) {
            for (String paraula : paraules) {
                if (alfabetic.charAt(i) == paraula.charAt(0)) {
                    cad += paraula + " ";
                }
            }
        }
        return cad;
    }

}
