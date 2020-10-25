package Game;

import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Rede.NetGames;
public class SupremaciaGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton conectarButton;
    private JButton desconectarButton;
    private JButton iniciarPartidaButton;
    private JPanel mainPanel;
    private boolean jogadorConectado = false;
    private NetGames net = new NetGames();
    private Tabuleiro tabuleiro;
    
    public SupremaciaGUI(String title){
    	super(title);
        mainPanel = new JPanel();
        panel = new JPanel();
        conectarButton = new JButton("conectar");
        desconectarButton = new JButton("desconectar"); 
        iniciarPartidaButton = new JButton("iniciar"); 
        this.mainPanel.add(conectarButton);
        this.mainPanel.add(desconectarButton);
        this.mainPanel.add(iniciarPartidaButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(1000,500));
        this.pack();
        
        conectarButton.addActionListener(e -> {
            this.conectar();
        });
        iniciarPartidaButton.addActionListener(e -> {
        	boolean iniciavel = iniciarPartida();
        	if (!iniciavel) {
        		JOptionPane.showMessageDialog(null,"Não foi possivel iniciar");
        	}
//        		String rodadas = JOptionPane.showInputDialog("Deseja configurar um numero de rodadas mÃ¡xima? Caso sim, digite o valor: ");
//                if (!rodadas.equals("")){
//                    tabuleiro.setMaxRodadas(Integer.parseInt(rodadas));
//                }
        	});
        desconectarButton.addActionListener(e ->{
        		this.desconectar();
        		});
    }
    public boolean iniciarPartida() {
    	boolean conectado = net.informarConectado();
		if(conectado) {
			net.iniciarPartida();
			JOptionPane.showMessageDialog(null,"Pedido de início enviado");
			return true;
		}
		JOptionPane.showMessageDialog(null,"Não conectado");
		return false;

    }
    public void iniciarByNetGames(Integer posicao) {
    	Tabuleiro tabuleiro = new Tabuleiro(null);
    	PApplet.main("Game.UsingProcessing");
        tabuleiro.setJogoEmProgresso(true);
    	
    }
    public void desconectar() {
    	System.out.println("desconnect");
    	this.jogadorConectado = this.net.informarConectado();
    	if (!jogadorConectado){
    		JOptionPane.showMessageDialog(null,"Não conectado");
    	} else {
    		JOptionPane.showMessageDialog(null,this.net.desconectar());
    	}
    }
    public void conectar() {
    	this.jogadorConectado = this.net.informarConectado();
    	if (!jogadorConectado){
            String servidor = JOptionPane.showInputDialog("Informe o servidor: ");
            String name = JOptionPane.showInputDialog("Informe o seu nome: ");
            String result = this.net.conectar(servidor, name);
            if (result == "Sucesso: conectado a Netgames Server") {
            	JOptionPane.showMessageDialog(null,"Conectado");
            	this.jogadorConectado = true;
            	net.addObserver(this);
            } else {
            	JOptionPane.showMessageDialog(null, result);
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Voce ja esta conectado");
        }
    }


}
