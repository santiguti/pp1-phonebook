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

public class VentanaPersona extends JFrame 
{
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
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
		DomicilioHelper dmhelp = new DomicilioHelper();
		dmhelp.parseLocalidades();
		dmhelp.parseProvincias();
		
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
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 93, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 134, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 175, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 216, 113, 14);
		panel.add(lblDepto);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 257, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 298, 113, 14);
		panel.add(lblLocalidad);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 90, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		spinAltura = new JSpinner();
		spinAltura.setBounds(133, 131, 164, 20);
		panel.add(spinAltura);
		
		spinPiso = new JSpinner();
		spinPiso.setBounds(133, 172, 164, 20);
		panel.add(spinPiso);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(133, 213, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		comboProv = new JComboBox(dmhelp.getProvinciasArray());
		comboProv.setBounds(133, 254, 164, 20);
		panel.add(comboProv);
		
		comboLocal = new JComboBox(dmhelp.getLocalidadesArray());
		comboLocal.setBounds(133, 295, 164, 20);
		panel.add(comboLocal);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(208, 339, 89, 23);
		panel.add(btnAgregarPersona);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtCalle() 
	{
		return txtCalle;
	}
	
	public JSpinner getSpinAltura() 
	{
		return spinAltura;
	}
	
	public JSpinner getSpinPiso() 
	{
		return spinPiso;
	}
	
	public JTextField getTxtDepto() 
	{
		return txtDepto;
	}
	
	public JComboBox getComboProv() 
	{
		return comboProv;
	}

	public JComboBox getComboLocal() 
	{
		return comboLocal;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.dispose();
	}
	
}

