package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Control implements ActionListener {

    private Formulario formulario;
    private Persona pTemp;
    private List<Persona> listaPersonas;
    private DefaultTableModel modeloTabla;
    private String[] cabeceraTabla;
    private String[] filaTabla;

    public Control() {
        this.formulario = new Formulario();
        this.modeloTabla = new DefaultTableModel();
        iniciarTabla();
        this.listaPersonas = new ArrayList<Persona>(2);
        this.formulario.getLimpiarBtn().addActionListener(this);
        this.formulario.getEliminarBtn().addActionListener(this);
        this.formulario.getGuardarBtn().addActionListener(this);
    }

    public void iniciar() {
        if (formulario == null) {
            formulario = new Formulario();
            formulario.setVisible(true);
        } else {
            formulario.setVisible(true);
        }
    }

    private void iniciarTabla() {
        cabeceraTabla = new String[6];
        cabeceraTabla[0] = "No.";
        cabeceraTabla[1] = "Nombres y Apellidos";
        cabeceraTabla[2] = "Identificación";
        cabeceraTabla[3] = "Telefono";
        cabeceraTabla[4] = "Edad";
        cabeceraTabla[5] = "Programa";
        modeloTabla.setColumnIdentifiers(cabeceraTabla);
        formulario.getTabla().setModel(modeloTabla);

    }

    private Object[] crearFila(Persona p, int indice) {
        filaTabla = new String[6];
        filaTabla[0] = (indice + 1) + "";
        filaTabla[1] = p.getNombres() + " " + p.getApellidos();
        filaTabla[2] = p.getIdentificacion();
        filaTabla[3] = p.getTelefono();
        filaTabla[4] = String.valueOf(p.getEdad());
        filaTabla[5] = p.getPrograma();
        return filaTabla;
    }

    private Persona obtenerPersona() {
        pTemp = new Persona();
        pTemp.setNombres(formulario.getNombresTxt().getText());
        pTemp.setApellidos(formulario.getApellidosTxt().getText());
        pTemp.setIdentificacion(formulario.getIdentificacionTxt().getText());
        pTemp.setTelefono(formulario.getTelefonoTxt().getText());
        pTemp.setDireccion(formulario.getDireccionTxt().getText());
        pTemp.setEdad(Integer.parseInt(formulario.getEdadTxt().getText()));
        pTemp.setSexo(formulario.getSexoTxt().getSelectedItem().toString());
        pTemp.setPrograma(formulario.getProgramaTxt().getText());
        return pTemp;
    }

    private Persona obtPersonaLista(String id) {
        Persona salida = null;
        for (Persona p : listaPersonas) {
            if (p.getIdentificacion().
                    equals(id)) {
                salida = p;
                break;
            }
        }
        return salida;
    }

    private void limpiarCampos() {
        formulario.getNombresTxt().setText("");
        formulario.getApellidosTxt().setText("");
        formulario.getIdentificacionTxt().setText("");
        formulario.getTelefonoTxt().setText("");
        formulario.getDireccionTxt().setText("");
        formulario.getEdadTxt().setText("");
        formulario.getSexoTxt().setSelectedIndex(0);
        formulario.getProgramaTxt().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.getGuardarBtn()) {
            pTemp = obtenerPersona();
            listaPersonas.add(pTemp);
            modeloTabla.addRow(crearFila(pTemp, listaPersonas.indexOf(pTemp)));
            formulario.getTabla().setModel(modeloTabla);
            limpiarCampos();
            pTemp = null;
        } else if (e.getSource() == formulario.getLimpiarBtn()) {
            limpiarCampos();
        } else if (e.getSource() == formulario.getEliminarBtn()) {
            String id = JOptionPane.showInputDialog(formulario.getRootPane(),
                    "Ingrese la Identificacion de la persona que desea Eliminar", "Eliminacion de asistentes",
                    JOptionPane.WARNING_MESSAGE);
            pTemp = obtPersonaLista(id);
            if (pTemp == null) {
                JOptionPane.showMessageDialog(formulario.getRootPane(),
                        "La persona que ingresó no se encuentra registrada",
                        "Eliminación de Asistentes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int confirmacionEliminacion = JOptionPane.showConfirmDialog(formulario.getRootPane(),
                        "Esta SEGURO que desea eliminar la persona " + pTemp.getNombres() + " " + pTemp.getApellidos() + "?",
                        "Eliminación de asistentes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if(confirmacionEliminacion == 0){
                    int index = listaPersonas.indexOf(pTemp);
                    listaPersonas.remove(pTemp);
                    modeloTabla.removeRow(index);
                    formulario.getTabla().setModel(modeloTabla);
                }
            }
        }
    }

}
