package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import view.telefonia.PainelCadastroCliente;
import view.telefonia.PainelListagemCliente;
import view.telefonia.PainelListagemTelefone;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Principal {

	private JPanel contentPane;
	private JFrame frmSistemaDeTelefonia;
	private PainelListagemCliente painelListagemCliente;
	private PainelCadastroCliente painelCadastroCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					//Comando para iniciar a tela maximizada
					//window.frmSistemaDeTelefonia.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frmSistemaDeTelefonia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		frmSistemaDeTelefonia = new JFrame();
		frmSistemaDeTelefonia.setTitle("Sistema de Telefonia");
		frmSistemaDeTelefonia.setBounds(100, 100, 450, 300);
		frmSistemaDeTelefonia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeTelefonia.setJMenuBar(menuBar);
		menuBar.setBackground(new Color(255, 255, 255));
		//setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(Principal.class.getResource("/icones/clientes3.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroCliente = new PainelCadastroCliente(null);
				painelCadastroCliente.setVisible(true);
				frmSistemaDeTelefonia.setContentPane(painelCadastroCliente);
				frmSistemaDeTelefonia.revalidate();
			}
		});
		mntmCadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCadastrarCliente.setIcon(new ImageIcon(Principal.class.getResource("/icones/add.png")));
		mnClientes.add(mntmCadastrarCliente);
			
		JMenuItem mntmListarCliente = new JMenuItem("Listar");
		mntmListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelListagemCliente = new PainelListagemCliente();
				painelListagemCliente.getBtnEditar().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						painelCadastroCliente = new PainelCadastroCliente(painelListagemCliente.getClienteSelecionado());
						painelCadastroCliente.setVisible(true);
						frmSistemaDeTelefonia.setContentPane(painelCadastroCliente);
						frmSistemaDeTelefonia.revalidate();
					}
				});
				painelListagemCliente.setVisible(true);
				frmSistemaDeTelefonia.setContentPane(painelListagemCliente);
			}
		});
		mntmListarCliente.setIcon(new ImageIcon(Principal.class.getResource("/icones/lista.png")));
		mnClientes.add(mntmListarCliente);
		
		JMenu mnTelefone = new JMenu("Telefone");
		mnTelefone.setIcon(new ImageIcon(Principal.class.getResource("/icones/telefone3.png")));
		menuBar.add(mnTelefone);
		
		JMenuItem mntmCadastrarTel = new JMenuItem("Cadastrar");
		mntmCadastrarTel.setIcon(new ImageIcon(Principal.class.getResource("/icones/add.png")));
		mnTelefone.add(mntmCadastrarTel);
		
		JMenuItem mntmListarTel = new JMenuItem("Listar");
		mntmListarTel.setIcon(new ImageIcon(Principal.class.getResource("/icones/lista.png")));
		mntmListarTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evento de clique no botão -> instancia o painel e troca
				PainelListagemTelefone painelListagemTelefone = new PainelListagemTelefone();
				frmSistemaDeTelefonia.setContentPane(painelListagemTelefone);
			}
		});
		mnTelefone.add(mntmListarTel);
		
		JMenu mnEndereco = new JMenu("Endereço");
		mnEndereco.setIcon(new ImageIcon(Principal.class.getResource("/icones/endereco.png")));
		menuBar.add(mnEndereco);
		
		JMenuItem mntmCadastrarEnd = new JMenuItem("Cadastrar");
		mntmCadastrarEnd.setIcon(new ImageIcon(Principal.class.getResource("/icones/add.png")));
		mnEndereco.add(mntmCadastrarEnd);
		
		JMenuItem mntmListarEnd = new JMenuItem("Listar");
		mntmListarEnd.setIcon(new ImageIcon(Principal.class.getResource("/icones/lista.png")));
		mnEndereco.add(mntmListarEnd);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO chamar TelaSobreAutor
				JOptionPane.showMessageDialog(null, "Olá");
			}
		});
		mnSobre.setIcon(new ImageIcon(Principal.class.getResource("/icones/sobre.png")));
		menuBar.add(mnSobre);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
	}

}
