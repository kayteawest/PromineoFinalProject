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

import com.dmtool.interfaces.ICampaignsDataAccessLayer;
import com.dmtool.models.Campaign;

@Service
@Component
public class CampaignsDataAccess implements ICampaignsDataAccessLayer {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertCampaign(String campaignName, String dungeonMaster) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_campaignName", campaignName);
		params.put("p_dungeonMaster", dungeonMaster);

		// Execute stored procedure and return result
		Integer campaignId = jdbcTemplate.execute("{call Insert_Campaign(:p_campaignName,:p_dungeonMaster)}", params,
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

		// Return campaign id
		return campaignId;

	}

	@Override
	public Campaign selectCampaignById(int campaignId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_campaignId", campaignId);

		// Execute stored procedure and return result
		Campaign campaign = jdbcTemplate.execute("{call Select_Campaign_ById(:p_campaignId)}", params,
				new PreparedStatementCallback<Campaign>() {

					@Override
					public Campaign doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						// Execute query
						ResultSet resultSet = ps.executeQuery();

						// Call next to read in first result
						resultSet.next();

						// Create formatter to parse MySql DATETIME to LocalDateTime
						var format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

						// Map first row to Campaign
						var campaignId = resultSet.getInt(1);
						var createdDate = LocalDateTime.parse(resultSet.getString(2), format);
						var campaignName = resultSet.getString(3);
						var dungeonMaster = resultSet.getString(4);

						// lastEncounterDate might be null from the database
						LocalDateTime lastEncounterDate = null;

						var lastEncounterString = resultSet.getString(5);

						// Parse the string if it's not null
						if (lastEncounterString != null) {
							lastEncounterDate = LocalDateTime.parse(resultSet.getString(5), format);
						}

						// Close the connection
						resultSet.close();

						// Return Campaign
						return new Campaign(campaignId, createdDate, campaignName, dungeonMaster, lastEncounterDate);
					}

				});

		// Return Campaign
		return campaign;

	}

	@Override
	public void updateCampaignById(int campaignId, String campaignName, String dungeonMaster) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_campaignId", campaignId);
		params.put("p_campaignName", campaignName);
		params.put("p_dungeonMaster", dungeonMaster);

		// Execute stored procedure
		jdbcTemplate.update("{call Update_Campaign_ById(:p_campaignId, :p_campaignName,:p_dungeonMaster)}", params);

	}

	@Override
	public void deleteCampaignById(int campaignId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_campaignId", campaignId);

		// Execute stored procedure
		jdbcTemplate.update("{call Delete_Campaign_ById(:p_campaignId)}", params);

	}

}
