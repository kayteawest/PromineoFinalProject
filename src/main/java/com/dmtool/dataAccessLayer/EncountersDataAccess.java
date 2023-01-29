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

import com.dmtool.interfaces.IEncountersDataAccessLayer;
import com.dmtool.models.Encounter;

@Service
@Component
public class EncountersDataAccess implements IEncountersDataAccessLayer {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertEncounter(int campaignId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_campaignId", campaignId);

		// Execute stored procedure and return result
		int encounterId = jdbcTemplate.execute("{call Insert_Encounter(:p_campaignId)}", params,
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

		// Return encounter id
		return encounterId;
	}

	@Override
	public Encounter selectEncounterById(int encounterId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_encounterId", encounterId);

		// Execute stored procedure and return result
		Encounter encounter = jdbcTemplate.execute("{call Select_Encounter_ById(:p_encounterId)}", params,
				new PreparedStatementCallback<Encounter>() {

					@Override
					public Encounter doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						// Execute query
						ResultSet resultSet = ps.executeQuery();

						// Call next to read in first result
						resultSet.next();

						// Create formatter to parse MySql DATETIME to LocalDateTime
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

						// Map first row to Encounter
						int encounterId = resultSet.getInt(1);
						int campaignId = resultSet.getInt(2);
						LocalDateTime createdDate = LocalDateTime.parse(resultSet.getString(3), format);

						// Close the connection
						resultSet.close();

						// Return Encounter
						return new Encounter(encounterId, campaignId, createdDate);
					}
				});

		// Return Encounter
		return encounter;
	}

	@Override
	public void deleteEncounterById(int encounterId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_encounterId", encounterId);

		// Execute stored procedure
		jdbcTemplate.update("{call Delete_Encounter_ById(:p_encounterId)}", params);
	}
}
