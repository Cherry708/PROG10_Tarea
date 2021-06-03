import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    private void anadirProfesor(Profesor profesor, ArrayList<Profesor> listaProfesores){
        listaProfesores.add(profesor);
        dispose();
    }
}
