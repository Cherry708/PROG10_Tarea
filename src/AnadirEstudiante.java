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



    public AnadirEstudiante(ArrayList<Alumno> listaAlumnos) {

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
                String nivelAcademico;
                int curso;
                ArrayList<Asignatura> listaAsignaturas;
                Alumno alumno;

                if (rbtnPresencial.isSelected()){

                    dni = txtDni.getText();
                    nombre = txtNombre.getText();
                    nivelAcademico = txtNivelAcademico.getText();
                    curso = (int) spnCurso.getValue();
                    listaAsignaturas = (ArrayList<Asignatura>) lstAsignaturas.getSelectedValuesList();
                    alumno = new Presencial(dni, nombre, curso, nivelAcademico, listaAsignaturas);
                    listaAlumnos.add(alumno);

                    dispose();
                    //Como añadir los componentes a la ventana de aplicación??????

                }
            }
        });
    }


}
