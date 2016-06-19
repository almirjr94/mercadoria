package br.com.valemobi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.valemobi.factory.ConnectionFactory;
import br.com.valemobi.model.Mercadoria;
import br.com.valemobi.model.TipoNegocio;

public class MercadoriaDAO {

	private Connection con;

	public MercadoriaDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void insert(Mercadoria mercadoria) {

		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO mercadoria(cod_mercadoria,tipo_mercadoria,nm_mercadoria,qt_mercadoria,vl_mercadoria,tipo_negocio_mercadoria) "
							+ "VALUES(NEXTVAL('seq_prin'),?,?,?,?,?)");

			statement.setString(1, mercadoria.getTipo());
			statement.setString(2, mercadoria.getNome());
			statement.setLong(3, mercadoria.getQuantidade());
			statement.setDouble(4, mercadoria.getPreco());
			statement.setString(5, mercadoria.getTipoNegocio().toString());

			statement.execute();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Mercadoria mercadoria) {

		try {
			PreparedStatement statement = con.prepareStatement(
					"UPDATE mercadoria SET tipo_mercadoria = ?,nm_mercadoria = ?,qt_mercadoria = ?,vl_mercadoria = ?,tipo_negocio_mercadoria = ?"
							+ "WHERE cod_mercadoria = ?");

			statement.setString(1, mercadoria.getTipo());
			statement.setString(2, mercadoria.getNome());
			statement.setLong(3, mercadoria.getQuantidade());
			statement.setDouble(4, mercadoria.getPreco());
			statement.setString(5, mercadoria.getTipoNegocio().toString());
			statement.setLong(6, mercadoria.getCodigo());

			statement.execute();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Long codigo) {

		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM mercadoria WHERE cod_mercadoria = ?");

			statement.setLong(1, codigo);

			statement.execute();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Mercadoria> selectAll() {
		try {
			List<Mercadoria> mercadorias = new ArrayList<>();
			ResultSet rs = con
					.prepareStatement(
							"SELECT cod_mercadoria,tipo_mercadoria,nm_mercadoria,qt_mercadoria,vl_mercadoria,tipo_negocio_mercadoria FROM mercadoria")
					.executeQuery();

			while (rs.next()) {
				Mercadoria mercadoria = new Mercadoria(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getDouble(5), TipoNegocio.valueOf(rs.getString(6)));

				mercadorias.add(mercadoria);
			}
			rs.close();
			return mercadorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Mercadoria selectByCod(Long codigo) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT cod_mercadoria,tipo_mercadoria,nm_mercadoria,qt_mercadoria,vl_mercadoria,tipo_negocio_mercadoria FROM mercadoria WHERE cod_mercadoria = ?");

			statement.setLong(1, codigo);
			ResultSet rs = statement.executeQuery();
			Mercadoria mercadoria = null;
			if (rs.next()) {
				mercadoria = new Mercadoria(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getDouble(5), TipoNegocio.valueOf(rs.getString(6)));

			}
			statement.close();
			rs.close();
			return mercadoria;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
