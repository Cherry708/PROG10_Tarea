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


    //listaAsignaturas con las Asignaturas creadas para rellenar la JList
    public AnadirEstudiante(ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas) {

        //Heredamos los métodos de JDialog
        setTitle("Añadir estudiante");
        setContentPane(pnlPrincipal);
        pack();
        setVisible(true);




        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String dni;
                String nombre;
                int curso;
                String nivelAcademico;
                ArrayList<Asignatura> listaAsignaturas; //Lista asignatura de la clase alumno
                Alumno alumno;

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
                    listaAsignaturas = (ArrayList<Asignatura>) lstAsignaturas.getSelectedValuesList();
                    alumno = new Presencial(dni, nombre, curso, nivelAcademico, listaAsignaturas);
                    listaAlumnos.add(alumno);

                    dispose();
                }
            }
        });
    }


}
