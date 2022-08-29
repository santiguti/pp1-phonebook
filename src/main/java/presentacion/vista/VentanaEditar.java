package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import dto.DomicilioHelper;

public class VentanaEditar extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JSpinner spinDiaCumple;
	private JSpinner spinMesCumple;
	private JSpinner spinAnioCumple;
	private JTextField txtCalle;
	private JSpinner spinAltura;
	private JSpinner spinPiso;
	private JTextField txtDepto;
	private JComboBox comboPais;
	private JComboBox comboProv;
	private JComboBox comboLocal;
	private JButton btnEditarPersona;
	private DomicilioHelper dmhelp = new DomicilioHelper();
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
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 600);
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
		
		JLabel lblDiaCumple = new JLabel("Dia nacimiento");
		lblDiaCumple.setBounds(10, 134, 113, 14);
		panel.add(lblDiaCumple);
		
		JLabel lblMesCumple = new JLabel("Mes Nacimiento");
		lblMesCumple.setBounds(10, 175, 113, 14);
		panel.add(lblMesCumple);
		
		JLabel lblAnioCumple = new JLabel("Anio Nacimiento");
		lblAnioCumple.setBounds(10, 216, 113, 14);
		panel.add(lblAnioCumple);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 257, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 298, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 339, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 380, 113, 14);
		panel.add(lblDepto);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 421, 113, 14);
		panel.add(lblPais);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 462, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 503, 113, 14);
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
		
		SpinnerModel spinDiaModel = new SpinnerNumberModel(1, 1, 31, 1);
		spinDiaCumple = new JSpinner(spinDiaModel);
		spinDiaCumple.setBounds(133, 131, 164, 20);
		panel.add(spinDiaCumple);
		
		SpinnerModel spinMesModel = new SpinnerNumberModel(1, 1, 12, 1);
		spinMesCumple = new JSpinner(spinMesModel);
		spinMesCumple.setBounds(133, 172, 164, 20);
		panel.add(spinMesCumple);
		
		SpinnerModel spinAnioModel = new SpinnerNumberModel(1900, 1900, 2022, 1);
		spinAnioCumple = new JSpinner(spinAnioModel);
		spinAnioCumple.setBounds(133, 213, 164, 20);
		panel.add(spinAnioCumple);

		txtCalle = new JTextField();
		txtCalle.setBounds(133, 254, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);

		spinAltura = new JSpinner();
		spinAltura.setBounds(133, 295, 164, 20);
		panel.add(spinAltura);

		spinPiso = new JSpinner();
		spinPiso.setBounds(133, 336, 164, 20);
		panel.add(spinPiso);

		txtDepto = new JTextField();
		txtDepto.setBounds(133, 377, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		comboPais = new JComboBox(dmhelp.getCountries());
		comboPais.setBounds(133, 418, 164, 20);
		panel.add(comboPais);
		comboPais.addActionListener(a -> countryChosen(a));

		comboProv = new JComboBox();
		comboProv.setBounds(133, 459, 164, 20);
		panel.add(comboProv);
		comboProv.addActionListener(b -> stateChosen(b));

		comboLocal = new JComboBox();
		comboLocal.setBounds(133, 500, 164, 20);
		panel.add(comboLocal);

		btnEditarPersona = new JButton("Agregar");
		btnEditarPersona.setBounds(208, 541, 89, 23);
		panel.add(btnEditarPersona);

		this.setVisible(false);
	}
	

	public void mostrarVentana() {
		this.setVisible(true);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}
	
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
	
	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}
	
	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}
	
	public int getDiaCumple() {
		return (int) spinDiaCumple.getValue();
	}
	
	public void setDiaCumple(int dia) {
		this.spinDiaCumple.setValue(dia);
	}
	
	public int getMesCumple() {
		return (int) spinMesCumple.getValue();
	}
	
	public void setMesCumple(int mes) {
		this.spinMesCumple.setValue(mes);
	}
	
	public int getAnioCumple() {
		return (int) spinAnioCumple.getValue();
	}
	
	public void setAnioCumple(int anio) {
		this.spinAnioCumple.setValue(anio);
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}
	
	public void setTxtCalle(String txtCalle) {
		this.txtCalle.setText(txtCalle);
	}

	public int getAltura() {
		return (int) spinAltura.getValue();
	}
	
	public void setAltura(int altura) {
		this.spinAltura.setValue(altura);
	}

	public int getPiso() {
		return (int) spinPiso.getValue();
	}
	
	public void setPiso(int piso) {
		this.spinPiso.setValue(piso);
	}

	public JTextField getTxtDepto() {
		return txtDepto;
	}
	
	public void setTxtDepto(String txtDepto) {
		this.txtDepto.setText(txtDepto);
	}
	
	public String getComboPais() {
		if (comboPais.getSelectedItem() == null || comboPais.getSelectedItem().toString().equals("Select an option")){
			return "";
		}
		return comboPais.getSelectedItem().toString();
	}


	public String getComboProv() {
		if (comboProv.getSelectedItem() == null){
			return "";
		}
		return comboProv.getSelectedItem().toString();
	}

	public String getComboLocal() {
		if (comboLocal.getSelectedItem() == null){
			return "";
		}
		return comboLocal.getSelectedItem().toString();
	}

	public JButton getBtnEditarPersona() {
		return btnEditarPersona;
	}

	public void cerrar() {
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.spinDiaCumple.setValue(1);
		this.spinMesCumple.setValue(1);
		this.spinAnioCumple.setValue(1900);
		this.txtCalle.setText(null);
		this.spinAltura.setValue(0);
		this.spinPiso.setValue(0);
		this.txtDepto.setText(null);
		

		this.dispose();
	}
	
	public void countryChosen(ActionEvent a) {
		String comboPaisValue = (String)comboPais.getSelectedItem().toString();
        
		if (!comboPaisValue.equals("Select an option")) {
			comboProv.setModel(new DefaultComboBoxModel<String>(dmhelp.getStatesOf(comboPaisValue)));
		}
				
	}
	
	public void stateChosen(ActionEvent b) {
		String comboPaisValue = (String)comboPais.getSelectedItem().toString();
		String comboProvValue = (String)comboProv.getSelectedItem().toString();
        		
		if (!comboPaisValue.equals("Select an option") && !comboProvValue.equals("Select an option")) {
			comboLocal.setModel(new DefaultComboBoxModel<String>(dmhelp.getCitiesOf(comboPaisValue, comboProvValue)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
