/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import oovv.MaEx;
import oovv.Paraules;
import vista.FPrincipal;

/**
 *
 * @author Alexandru
 */
public class CFPrincipal implements ActionListener {

    private FPrincipal finestra;
    private Paraules model;

    public CFPrincipal(FPrincipal finestra) {
        this.finestra = finestra;
        this.model = new Paraules();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Llegir Text":
                try {
                    boolean noesText;
                String text = "";
                do {
                    text = JOptionPane.showInputDialog(finestra, "Introduce el texto:");
                    if (model.esText(text)) {
                        noesText = false;
                    } else {
                        noesText = true;
                        JOptionPane.showMessageDialog(finestra, "No puede ser digitos, solo letras y caracteres");
                    }
                } while (noesText);
                model.afegir(text);
                finestra.canvia(!noesText);
            } catch (MaEx maEx) {
            }
                
            break;
            case "Paraules":
                finestra.mostrar(model.llistaParaules());
                break;
            case "Palindroms":
                finestra.mostrar(model.llistaPalindroms());
                break;
            case "Repetits":
                finestra.mostrar(model.llistaSenseRepetits());
                break;
            case "Ordenats":
                model.ordenats();
                break;
            case "Visualitzar Ordenats":
                finestra.mostrar(model.llistaOrdenats());
                break;
            case "Borrar Visualització":
                finestra.borrar();
                break;
            case "Borrar":
                model.borrar();
                finestra.canvia(false);
                break;
            case "Exit":
                System.exit(0);
                break;

        }
    }
}
