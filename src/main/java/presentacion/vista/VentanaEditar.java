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
	private JButton btnEditarPersona;
	private JComboBox comboEtiqueta;
	private JComboBox comboDestino;
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
		panel.setBounds(10, 11, 307, 650);
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
		
		JLabel lblEtiqueta = new JLabel("Etiqueta");
		lblEtiqueta.setBounds(10, 257, 113, 14);
		panel.add(lblEtiqueta);

		JLabel lblDestino = new JLabel("Destino preferido");
		lblDestino.setBounds(10, 298, 113, 14);
		panel.add(lblDestino);

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
		
		String[] etiquetas = new String[] {"Friends", "Family", "Work", "Others"};
		comboEtiqueta = new JComboBox(etiquetas);
		comboEtiqueta.setBounds(133, 254, 164, 20);
		panel.add(comboEtiqueta);

		
		comboDestino = new JComboBox(dmhelp.getCountries());
		comboDestino.setBounds(133, 291, 164, 20);
		panel.add(comboDestino);
		
		btnEditarPersona = new JButton("Editar");
		btnEditarPersona.setBounds(208, 336, 89, 23);
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
	
	public String getComboEtiqueta() {
		if (comboEtiqueta.getSelectedItem() == null || comboEtiqueta.getSelectedItem().toString().equals("Select an option")){
			return "";
		}
		return comboEtiqueta.getSelectedItem().toString();
	}
	
	public String getComboDestino() {
		if (comboDestino.getSelectedItem() == null || comboDestino.getSelectedItem().toString().equals("Select an option")){
			return "";
		}
		return comboDestino.getSelectedItem().toString();
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
		String[] etiquetas = new String[] {"Friends", "Family", "Work", "Others"};
		this.comboEtiqueta.setModel(new DefaultComboBoxModel<String>(etiquetas));
		this.comboDestino.setModel(new DefaultComboBoxModel<String>(dmhelp.getCountries()));
		
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
