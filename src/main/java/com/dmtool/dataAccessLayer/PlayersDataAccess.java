package com.dmtool.dataAccessLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dmtool.interfaces.IPlayersDataAccessLayer;
import com.dmtool.models.Player;

@Service
@Component
public class PlayersDataAccess implements IPlayersDataAccessLayer {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertPlayer(String playerName) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_playerName", playerName);

		// Execute stored procedure and return result
		Integer playerId = jdbcTemplate.execute("{call Insert_Player(:p_playerName)}", params,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						// Execute query
						ResultSet resultSet = ps.executeQuery();

						// Call next to read in first result
						resultSet.next();

						// Map first row/column value to id
						Integer id = resultSet.getInt(1);

						// Close the connection
						resultSet.close();

						// Return id
						return id;
					}

				});

		// Return player id
		return playerId;

	}

	@Override
	public Player selectPlayerById(int playerId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_playerId", playerId);

		// Execute stored procedure and return result
		Player player = jdbcTemplate.execute("{call Select_Player_ById(:p_playerId)}", params,
				new PreparedStatementCallback<Player>() {

					@Override
					public Player doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

						// Execute query
						ResultSet resultSet = ps.executeQuery();

						// Call next to read in first result
						resultSet.next();

						// Create formatter to parse MySql DATETIME to LocalDateTime
						var format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

						// Map first row to Player
						var playerId = resultSet.getInt(1);
						var playerName = resultSet.getString(2);
						var createdDate = LocalDateTime.parse(resultSet.getString(3), format);

						// Close the connection
						resultSet.close();

						// Return Player
						return new Player(playerId, playerName, createdDate);
					}

				});

		// Return Player
		return player;

	}

	@Override
	public void updatePlayerById(int playerId, String playerName) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_playerId", playerId);
		params.put("p_playerName", playerName);

		// Execute stored procedure
		jdbcTemplate.update("{call Update_Player_ById(:p_playerId,:p_playerName)}", params);

	}

	@Override
	public void deletePlayerById(int playerId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_playerId", playerId);

		// Execute stored procedure
		jdbcTemplate.update("{call Delete_Player_ById(:p_playerId)}", params);

	}

}
