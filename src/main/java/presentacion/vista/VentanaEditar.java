package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import dto.DomicilioHelper;

public class VentanaEditar extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JSpinner spinAltura;
	private JSpinner spinPiso;
	private JTextField txtDepto;
	private JComboBox comboProv;
	private JComboBox comboLocal;
	private JTextField txtEmail;
	private JButton btnEditarPersona;
	private static VentanaEditar INSTANCE;

	public static VentanaEditar getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VentanaEditar();
			return new VentanaEditar();
		} else
			return INSTANCE;
	}

	private VentanaEditar() {
		super();
		/*
		DomicilioHelper dmhelp = new DomicilioHelper();
		dmhelp.parseLocalidades();
		dmhelp.parseProvincias();
		*/

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 93, 113, 14);
		panel.add(lblEmail);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 134, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 175, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 216, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 257, 113, 14);
		panel.add(lblDepto);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 298, 113, 14);
		panel.add(lblProvincia);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 339, 113, 14);
		panel.add(lblLocalidad);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(133, 90, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		txtCalle = new JTextField();
		txtCalle.setBounds(133, 131, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);

		spinAltura = new JSpinner();
		spinAltura.setBounds(133, 172, 164, 20);
		panel.add(spinAltura);

		spinPiso = new JSpinner();
		spinPiso.setBounds(133, 213, 164, 20);
		panel.add(spinPiso);

		txtDepto = new JTextField();
		txtDepto.setBounds(133, 254, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);

		comboProv = new JComboBox();
		comboProv.setBounds(133, 295, 164, 20);
		panel.add(comboProv);

		comboLocal = new JComboBox();
		comboLocal.setBounds(133, 339, 164, 20);
		panel.add(comboLocal);

		btnEditarPersona = new JButton("Editar");
		btnEditarPersona.setBounds(208, 383, 89, 23);
		panel.add(btnEditarPersona);

		this.setVisible(false);
	}

	public void mostrarVentana() {
		this.setVisible(true);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public JSpinner getSpinAltura() {
		return spinAltura;
	}

	public JSpinner getSpinPiso() {
		return spinPiso;
	}

	public JTextField getTxtDepto() {
		return txtDepto;
	}

	public JComboBox getComboProv() {
		return comboProv;
	}

	public JComboBox getComboLocal() {
		return comboLocal;
	}

	public JButton getBtnEditarPersona() {
		return btnEditarPersona;
	}

	public void cerrar() {
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);

		// this.spinAltura.setText(null);
		// this.spinPiso.setText(null);

		this.dispose();
	}

}
