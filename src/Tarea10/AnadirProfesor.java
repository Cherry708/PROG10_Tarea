package Tarea10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * AñadirProfesor muestra una interfaz gráfica
 * que permite instanciar profesores que serán
 * añadidos a una lista del controlador Aplicación.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class AnadirProfesor extends JFrame{

    private JPanel pnlPrincipal;
    private JLabel lblProfesor;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JComboBox<Asignatura> cmbAsignatura;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel lblAsignatura;
    private JLabel lblNombre;
    private JLabel lblDni;

    public AnadirProfesor(ArrayList<Profesor> listaProfesores, ArrayList<Asignatura> listaAsignaturas){
        setTitle("Añadir profesor");
        setContentPane(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        for (Asignatura asignatura : listaAsignaturas){
            cmbAsignatura.addItem(asignatura);
        }

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni;
                String nombre;
                String asignaturaProfesor;
                Profesor profesor;

                dni = txtDni.getText();
                nombre = txtNombre.getText();
                asignaturaProfesor = cmbAsignatura.getSelectedItem().toString();
                profesor = new Profesor(dni, nombre, asignaturaProfesor);

                if (dni.isEmpty()|| nombre.isEmpty() || asignaturaProfesor.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debes introducir todos los campos.");
                } else {
                    anadirProfesor(profesor, listaProfesores);
                }
            }
        });
    }

    /**
     * Método que añade el profesor suministrado a la lista de profesores suministrada y cierra la ventana.
     * @param profesor Objeto de la clase Profesor.
     * @param listaProfesores lista en que se añadirán los profesores.
     */
    private void anadirProfesor(Profesor profesor, ArrayList<Profesor> listaProfesores){
        listaProfesores.add(profesor);
        dispose();
    }
}
