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


    public AnadirEstudiante(JPanel pnlListado) {
        //Heredamos los métodos de JDialog
        setTitle("Añadir estudiante");
        setContentPane(pnlPrincipal);
        pack();
        setVisible(true);


        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (rbtnPresencial.isSelected()){
                    ArrayList<Asignatura> listaAsignaturas;

                    String dni = txtDni.getText();
                    String nombre = txtNombre.getText();
                    int curso = spnCurso.getComponentCount();
                    listaAsignaturas = (ArrayList<Asignatura>) lstAsignaturas.getSelectedValuesList();
                    Alumno alumno = new Presencial(dni, nombre, curso, listaAsignaturas);



                    //Como añadir los componentes a la ventana de aplicación??????

                }
            }
        });
    }

}
