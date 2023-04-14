package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.TelefoneController;
import model.exception.CampoInvalidoException;
import model.vo.telefonia.Telefone;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class TelaCadastroTelefone {

	private JFrame frame;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JLabel lblDdd;
	private JLabel lblNumero;
	private JLabel lblMovel;
	private JButton btnSalvar;
	private JCheckBox checkBoxMovel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblDdd = new JLabel("DDD:");
		lblDdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDdd.setBounds(22, 32, 46, 14);
		frame.getContentPane().add(lblDdd);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumero.setBounds(22, 71, 61, 14);
		frame.getContentPane().add(lblNumero);
		
		lblMovel = new JLabel("Móvel:");
		lblMovel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMovel.setBounds(22, 109, 46, 14);
		frame.getContentPane().add(lblMovel);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(92, 30, 141, 20);
		frame.getContentPane().add(txtDdd);
		txtDdd.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(93, 69, 140, 20);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		checkBoxMovel = new JCheckBox("");
		checkBoxMovel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkBoxMovel.setBounds(89, 106, 121, 23);
		frame.getContentPane().add(checkBoxMovel);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Telefone telefone = new Telefone();
				telefone.setDdd(txtDdd.getText());
				telefone.setNumero(txtNumero.getText());
				telefone.setAtivo(false);
				telefone.setMovel(checkBoxMovel.isSelected());
				
				TelefoneController controller = new TelefoneController();
				try {
					controller.inserir(telefone);
					JOptionPane.showMessageDialog(null, "Telefone cadastrado com sucesso.");
				} catch(CampoInvalidoException e){
					JOptionPane.showMessageDialog(null, 
							"Preencha os seguintes campos: \n" +e.getMessage(),
							"Atenção", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
		});
		
		btnSalvar.setBounds(175, 200, 91, 31);
		frame.getContentPane().add(btnSalvar);
	}
}
