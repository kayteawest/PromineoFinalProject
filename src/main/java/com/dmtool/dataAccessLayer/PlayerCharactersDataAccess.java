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

import com.dmtool.interfaces.IPlayerCharactersDataAccessLayer;
import com.dmtool.models.PlayerCharacter;

@Service
@Component
public class PlayerCharactersDataAccess implements IPlayerCharactersDataAccessLayer {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertPlayerCharacter(int playerId, String characterName, int initiativeBonus) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_playerId", playerId);
		params.put("p_characterName", characterName);
		params.put("p_initiativeBonus", initiativeBonus);

		// Execute stored procedure and return result
		int playerCharacterId = jdbcTemplate.execute(
				"{call Insert_PlayerCharacter(:p_playerId,:p_characterName,:p_initiativeBonus)}", params,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						// Execute query
						ResultSet resultSet = ps.executeQuery();

						// Call next to read in first result
						resultSet.next();

						// Map first row/column value to id
						int id = resultSet.getInt(1);

						// Close the connection
						resultSet.close();

						// Return id
						return id;
					}
				});

		// Return playerCharacter id
		return playerCharacterId;
	}

	@Override
	public PlayerCharacter selectPlayerCharacterById(int characterId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_characterId", characterId);

		// Execute stored procedure and return result
		PlayerCharacter playerCharacter = jdbcTemplate.execute("{call Select_PlayerCharacter_ById(:p_characterId)}",
				params, new PreparedStatementCallback<PlayerCharacter>() {

					@Override
					public PlayerCharacter doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						// Execute query
						ResultSet resultSet = ps.executeQuery();

						// Call next to read in first result
						resultSet.next();

						// Create formatter to parse MySql DATETIME to LocalDateTime
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

						// Map first row to Player
						int characterId = resultSet.getInt(1);
						int playerId = resultSet.getInt(2);
						String characterName = resultSet.getString(3);
						LocalDateTime createdDate = LocalDateTime.parse(resultSet.getString(4), format);
						int initiativeBonus = resultSet.getInt(5);

						// Close the connection
						resultSet.close();

						// Return PlayerCharacter
						return new PlayerCharacter(characterId, playerId, characterName, createdDate, initiativeBonus);
					}
				});

		// Return PlayerCharacter
		return playerCharacter;
	}

	@Override
	public void updatePlayerCharacterById(int characterId, String characterName, int initiativeBonus) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_characterId", characterId);
		params.put("p_characterName", characterName);
		params.put("p_initiativeBonus", initiativeBonus);

		// Execute stored procedure
		jdbcTemplate.update("{call Update_PlayerCharacter_ById(:p_characterId,:p_characterName,:p_initiativeBonus)}",
				params);
	}

	@Override
	public void deletePlayerCharacterById(int characterId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_characterId", characterId);

		// Execute stored procedure
		jdbcTemplate.update("{call Delete_PlayerCharacter_ById(:p_characterId)}", params);
	}
}
