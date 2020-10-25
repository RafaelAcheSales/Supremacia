package Rede;


import Game.SupremaciaGUI;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class NetGames implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;
	protected Proxy proxy;
	protected boolean conectado = false;
	private SupremaciaGUI gui;
	public NetGames() {
		super();
		this.proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	
	public void addObserver(SupremaciaGUI gui) {
		this.gui = gui;
	}
	public String conectar(String servidor, String nome) {
			try {
				proxy.conectar(servidor, nome);
			} catch (JahConectadoException e) {
				e.printStackTrace();
				return "Voce ja esta conectado";
			} catch (NaoPossivelConectarException e) {
				e.printStackTrace();
				return "Nao foi possivel conectar";
			} catch (ArquivoMultiplayerException e) {
				e.printStackTrace();
				return "Voce esqueceu o arquivo de propriedades";
			}
			this.definirConectado(true);
			return "Sucesso: conectado a Netgames Server";
	}

	public String desconectar() {
			try {
				proxy.desconectar();
			} catch (NaoConectadoException e) {
				e.printStackTrace();
				return "Não foi possivel desconectar";
			}
			this.definirConectado(false);
			return "Desconectado com sucesso";
	}

	public void iniciarPartida() {
		System.out.println("iniciar");
		try {
			proxy.iniciarPartida(2);
			System.out.println("iniciou");
		} catch (NaoConectadoException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		gui.iniciarByNetGames(posicao);
	}

	@Override
	public void finalizarPartidaComErro(String message) {

	}

	@Override
	public void receberMensagem(String msg) {
	}

	@Override
	public void receberJogada(Jogada jogada) {

	}

	@Override
	public void tratarConexaoPerdida() {
		
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		
	}
	
	public void enviarJogada() {
		try {
			proxy.enviaJogada(null);
		} catch (NaoJogandoException e) {
			e.printStackTrace();
		}
	}
	
	public boolean informarConectado() {
		return conectado;
	}

	public void definirConectado(boolean valor) {
		conectado = valor;
	}
	
	public void encerrarPartida() {
		try {
			proxy.finalizarPartida();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
		} catch (NaoJogandoException e) {
			e.printStackTrace();
		}
	}


}
