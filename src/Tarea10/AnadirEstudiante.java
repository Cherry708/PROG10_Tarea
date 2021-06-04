package Tarea10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * AñadirEstudiante muestra una interfaz gráfica
 * que permite instanciar estudiantes que serán
 * añadidos a una lista del controlador Aplicación.
 *
 * @author Rubén Serrano Cano.
 * @version 1.0
 */
public class AnadirEstudiante extends JFrame {
    private JPanel pnlPrincipal;
    private JLabel lblEstudiante;
    private JLabel lblDni;
    private JLabel lblNombre;
    private JLabel lblCurso;
    private JTextField txtDni;
    private JLabel lblAsignatura;
    private JList lstAsignaturas;
    private JRadioButton rbtnPresencial;
    private JRadioButton rbtnLibre;
    private JLabel lblConvocatoria;
    private JLabel lblTipo;
    private JSpinner spnConvocatoria;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JSpinner spnCurso;
    private JTextField txtNombre;
    private JTextField txtNivelAcademico;
    private JLabel lblNivel;

    public AnadirEstudiante(ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas) {

        //Heredamos los métodos de JDialog
        setTitle("Añadir estudiante");
        setContentPane(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultListModel modelo = new DefaultListModel();
        for (Asignatura asignatura : listaAsignaturas){
            modelo.addElement(asignatura);
        }
            lstAsignaturas.setModel(modelo);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String dni;
                String nombre;
                int curso;
                String nivelAcademico;
                ArrayList<Asignatura> listaAsignaturasAlumno; //Lista asignatura de la clase alumno
                String tipoDeAlumno;
                int convocatoria;
                Alumno alumno;

                listaAsignaturasAlumno = new ArrayList<>();

                if (rbtnPresencial.isSelected()){

                    dni = txtDni.getText();
                    nombre = txtNombre.getText();
                    curso = (int) spnCurso.getValue();
                    nivelAcademico = txtNivelAcademico.getText();
                    try {
                        listaAsignaturasAlumno = (ArrayList<Asignatura>) lstAsignaturas.getSelectedValuesList();
                    } catch (ClassCastException ignored){}
                    tipoDeAlumno = rbtnPresencial.getText();
                    convocatoria = (int) spnConvocatoria.getValue();
                    alumno = new Presencial(dni, nombre, curso, nivelAcademico, listaAsignaturasAlumno, tipoDeAlumno, convocatoria);
                    if (dni.isEmpty() || nombre.isEmpty() || String.valueOf(curso).isEmpty()
                            || nivelAcademico.isEmpty() || String.valueOf(convocatoria).isEmpty() || listaAsignaturasAlumno.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Debes introducir todos los campos.");
                    } else if ((int)spnCurso.getValue() < 0){
                        JOptionPane.showMessageDialog(null, "El curso no puede ser negativo.");
                    } else if ((int)spnConvocatoria.getValue() < 0){
                        JOptionPane.showMessageDialog(null, "La convocatoria no puede ser negativa.");
                    } else
                        anadirAlumno(alumno, listaAlumnos);

                } else if (rbtnLibre.isSelected()){

                    dni = txtDni.getText();
                    nombre = txtNombre.getText();
                    curso = (int) spnCurso.getValue();
                    nivelAcademico = txtNivelAcademico.getText();
                    try {
                        listaAsignaturasAlumno = (ArrayList<Asignatura>) lstAsignaturas.getSelectedValuesList();
                    } catch (ClassCastException ignored){}
                    tipoDeAlumno = rbtnLibre.getText();
                    alumno = new Libre(dni, nombre, curso, nivelAcademico, listaAsignaturasAlumno, tipoDeAlumno);
                    if (dni.isEmpty() || nombre.isEmpty() || String.valueOf(curso).isEmpty() || nivelAcademico.isEmpty()
                    || listaAsignaturasAlumno.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Debes introducir todos los campos.");
                    } else if (curso < 0){
                        JOptionPane.showMessageDialog(null,"El curso no puede ser negativo.");
                    } else
                        anadirAlumno(alumno, listaAlumnos);
                }
            }
        });

        rbtnPresencial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accesoConvocatoria(true);
            }
        });
        rbtnLibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accesoConvocatoria(false);
            }
        });
    }

    /**
     * Método que añade el alumno suministrado a la lista de alumnos suministrada y cierra la ventana.
     * @param alumno Objeto de la clase alumno.
     * @param listaAlumnos lista en que se añadirán los alumnos.
     */
    private void anadirAlumno(Alumno alumno, ArrayList<Alumno> listaAlumnos) {
        listaAlumnos.add(alumno);
        dispose();
    }

    /**
     * Método que determina si se puede interactuar con el componente spnConvocatoria.
     * @param estado establece si se puede o no modificar el componente spnConvocatoria.
     */
    private void accesoConvocatoria(boolean estado) {
        lblConvocatoria.setEnabled(estado);
        spnConvocatoria.setEnabled(estado);
    }


}
