package Tarea10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * AñadirAsignatura muestra una interfaz gráfica
 * que permite instanciar asignaturas que serán
 * añadidos a una lista del controlador Aplicación.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class AnadirAsignatura extends JFrame {
    private JPanel pnlPrincipal;
    private JLabel lblAnadirAsignatura;
    private JTextField txtNombre;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JSpinner spnCurso;

    public AnadirAsignatura(ArrayList<Asignatura> listaAsignaturas){

        setTitle("Añadir asignatura");
        setContentPane(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre;
                int curso;

                nombre = txtNombre.getText();
                curso = (int) spnCurso.getValue();
                Asignatura asignatura = new Asignatura(nombre, curso);

                if (nombre.isEmpty() || String.valueOf(curso).isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debes introducir todos los campos.");
                } else if (curso < 0){
                    JOptionPane.showMessageDialog(null, "El curso no puede ser negativo.");
                } else
                    anadirAsignatura(asignatura, listaAsignaturas);
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    /**
     * Método que añade la asignatura suministrada a la lista de asignaturas suministrada y cierra la ventana.
     * @param asignatura Objeto de la clase Asignatura.
     * @param listaAsignaturas lista en que se añadirán las asignaturas.
     */
    private void anadirAsignatura(Asignatura asignatura, ArrayList<Asignatura> listaAsignaturas){
        listaAsignaturas.add(asignatura);
        dispose();
    }
}
