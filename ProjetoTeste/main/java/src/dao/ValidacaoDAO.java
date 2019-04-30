package dao;

import connectors.CriarConexao;
import dados.Validacao;

public class ValidacaoDAO extends CriarConexao {

	public int validaUsuario(Validacao v) {

		int alteracao = 0;

		try {
			this.stmt = this.getConnection().createStatement();
			System.out.println("Chega aqui?");
			this.rs = this.stmt.executeQuery("SELECT COD_TITULO as quantidade FROM INFO_USUARIO WHERE COD_TITULO = '" + v.getTitulo()
					+ "' AND ZONA = '" + v.getZona() + "' AND SECAO_ELEITORAL = '" + v.getSecao() + "'");
			System.out.println("E aqui?");

			if (rs.next()) {
				alteracao = rs.getInt("quantidade");
				System.out.println("quantidade = " + alteracao);
			}
			
			String permite = v.getPermite_votar();
			System.out.println("permiteeee: "+ permite);
			int titulo = v.getTitulo();
			System.out.println("tituloooo: " + titulo);
			
			int linhas = this.stmt.executeUpdate(
					"UPDATE LOGIN_USUARIO SET PERMITE_VOTAR = '"+ permite +"' WHERE COD_TITULO = '"+ titulo +"'");
			
			System.out.println("Permite votar? "+ v.getPermite_votar());
			System.out.println("Linhas = " + linhas);
			if (linhas > 0)
				return 1;
			else
				return 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;

	}

}
