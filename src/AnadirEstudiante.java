import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

//Al heredar de JDialog, es un JDialog
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

                /*
                Se escogen las asignaturas de una JList y se añaden a su propia lista de asignaturas.
                Los profesores escogen la asignatura de un JComboBox y se debe añadir a la lista de asignaturas para profesores


                Así estamos dando TODAS las asignaturas al alumno, queremos dar solo las que escoga.
                listaAlumnos.get(contador).setListaAsignaturas(listaAsignaturas);
                 */

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

    private void anadirAlumno(Alumno alumno, ArrayList<Alumno> listaAlumnos) {
        listaAlumnos.add(alumno);
        dispose();
    }

    private void accesoConvocatoria(boolean estado) {
        lblConvocatoria.setEnabled(estado);
        spnConvocatoria.setEnabled(estado);
    }


}
