import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        setVisible(true);


        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre;
                int curso;

                nombre = txtNombre.getText();
                curso = (int) spnCurso.getValue();

                Asignatura asignatura = new Asignatura(nombre, curso);
                listaAsignaturas.add(asignatura);

                dispose();
            }
        });
    }
}
