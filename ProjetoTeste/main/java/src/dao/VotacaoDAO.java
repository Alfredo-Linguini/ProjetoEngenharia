package dao;

import connectors.CriarConexao;
import dados.Candidatos;

public class VotacaoDAO extends CriarConexao {

	public int computaVoto(Candidatos c) {
		int voto = 0;
		int qtd = 0;

		try {
			this.stmt = this.getConnection().createStatement();
			System.out.println("Chega aqui?");
			this.rs = this.stmt
					.executeQuery("SELECT VOTOS as quantidade FROM CANDIDATOS WHERE NUMERO = '" + c.getNumero() + "'");
			System.out.println("E aqui?");
			
			if (rs.next()) {
			qtd = rs.getInt("quantidade");
			System.out.println("quantidade = " + qtd);
			voto = qtd + 1;}

			
			System.out.println("voto = " + voto);

			int linhas = this.stmt.executeUpdate(
					"UPDATE CANDIDATOS SET VOTOS = '" + voto + "' WHERE NUMERO ='" + c.getNumero() + "'");
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
