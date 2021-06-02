import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AnadirProfesor extends JFrame{

    private JPanel pnlPrincipal;
    private JLabel lblProfesor;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JComboBox cmbAsignatura;
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


        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni;
                String nombre;
                String asignatura;
                Profesor profesor;


                if (txtDni.getText().isEmpty() || txtNombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debes introducir todos los campos.");
                } else {

                    dni = txtDni.getText();
                    nombre = txtNombre.getText();
                    asignatura = listaAsignaturas.get(0).getNombre();
                    profesor = new Profesor(dni, nombre, asignatura);

                    listaProfesores.add(profesor);
                    System.out.println(listaProfesores.get(0));

                }
            }
        });
    }


}
