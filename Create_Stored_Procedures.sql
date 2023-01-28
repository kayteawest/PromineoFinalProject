USE DMTool;

DELIMITER //

DROP PROCEDURE IF EXISTS Insert_Campaign;
DROP PROCEDURE IF EXISTS Select_Campaign_ById;
DROP PROCEDURE IF EXISTS Update_Campaign_ById;
DROP PROCEDURE IF EXISTS Delete_Campaign_ById;
DROP PROCEDURE IF EXISTS Insert_Encounter;
DROP PROCEDURE IF EXISTS Select_Encounter_ById;
DROP PROCEDURE IF EXISTS Delete_Encounter_ById;
DROP PROCEDURE IF EXISTS Insert_Encounter_PlayerCharacter;
DROP PROCEDURE IF EXISTS Delete_Encounter_PlayerCharacter_ByIds;
DROP PROCEDURE IF EXISTS Insert_Player;
DROP PROCEDURE IF EXISTS Insert_PlayerCharacter;
DROP PROCEDURE IF EXISTS Select_Player_ById;
DROP PROCEDURE IF EXISTS Select_PlayerCharacter_ById;
DROP PROCEDURE IF EXISTS Update_Player_ById;
DROP PROCEDURE IF EXISTS Update_PlayerCharacter_ById;
DROP PROCEDURE IF EXISTS Delete_Player_ById;
DROP PROCEDURE IF EXISTS Delete_PlayerCharacter_ById;

CREATE PROCEDURE Insert_Campaign(IN p_campaignName TEXT,
                                 IN p_dungeonMaster TEXT)
BEGIN
  INSERT INTO Campaigns (createdDate, campaignName, dungeonMaster)
  VALUES (Now(), p_campaignName, p_dungeonMaster);
  
  SELECT LAST_INSERT_ID();
END //

CREATE PROCEDURE Select_Campaign_ById(IN p_campaignId INT)
BEGIN
  SELECT *
  FROM Campaigns
  WHERE campaignId = p_campaignId;
END //

CREATE PROCEDURE Update_Campaign_ById(IN p_campaignId INT,
                                      IN p_campaignName TEXT,
                                      IN p_dungeonMaster TEXT)
BEGIN
  UPDATE Campaigns
  SET campaignName = COALESCE(p_campaignName, campaignName),
      dungeonMaster = COALESCE(p_dungeonMaster, dungeonMaster)
  WHERE campaignId = p_campaignId;
END //

CREATE PROCEDURE Delete_Campaign_ById(IN p_campaignId INT)
BEGIN
  DELETE FROM Campaigns
  WHERE campaignId = p_campaignId;
END //

CREATE PROCEDURE Insert_Encounter(IN p_encounterId INT)
BEGIN
  INSERT INTO Encounters (encounterId, createdDate)
  VALUES (p_encounterId, Now());
  
  SELECT LAST_INSERT_ID();
END //

CREATE PROCEDURE Select_Encounter_ById(IN p_encounterId INT)
BEGIN
  SELECT *
  FROM Encounters
  WHERE encounterId = p_encounterId;
END //

CREATE PROCEDURE Delete_Encounter_ById(IN p_encounterId INT)
BEGIN
  DELETE FROM Encounters
  WHERE encounterId = p_encounterId;
END //

CREATE PROCEDURE Insert_Encounter_PlayerCharacter(IN p_encounterId INT,
                                                  IN p_characterId INT)
BEGIN
  INSERT INTO Encounter_PlayerCharacter (encounterId, characterId)
  VALUES (p_encounterId, p_characterId);
  
  SELECT LAST_INSERT_ID();
END //

CREATE PROCEDURE Delete_Encounter_PlayerCharacter_ByIds(IN p_encounterId INT,
                                                        IN p_characterId INT)
BEGIN
  DELETE FROM EncounterPlayerCharacter
  WHERE encounterId = p_encounterId AND
        characterId = p_characterId;
END //

CREATE PROCEDURE Insert_Player(IN p_playerName TEXT)
BEGIN
  INSERT INTO Players (playerName, createdDate)
  VALUES (p_playerName, Now());
  
  SELECT LAST_INSERT_ID();
END //

CREATE PROCEDURE Insert_PlayerCharacter(IN p_playerId INT,
                                        IN p_characterName TEXT,
                                        IN p_initiativeBonus INT)
BEGIN
  INSERT INTO PlayerCharacters (playerId, characterName, createdDate, initiativeBonus)
  VALUES (p_playerId, p_characterName, Now(), p_initiativeBonus);
  
  SELECT LAST_INSERT_ID();
END //

CREATE PROCEDURE Select_Player_ById(IN p_playerId INT)
BEGIN
  SELECT *
  FROM Players
  WHERE playerId = p_playerId;
END //

CREATE PROCEDURE Select_PlayerCharacter_ById(IN p_characterId INT)
BEGIN
  SELECT *
  FROM PlayerCharacters
  WHERE characterId = p_characterId;
END //

CREATE PROCEDURE Update_Player_ById(IN p_playerId INT,
                                    IN p_playerName TEXT)
BEGIN
  UPDATE Players
  SET playerName = COALESCE(p_playerName, playerName)
  WHERE playerId = p_playerId;
END //

CREATE PROCEDURE Update_PlayerCharacter_ById(IN p_characterId INT,
                                             IN p_characterName TEXT,
                                             IN p_initiativeBonus INT)
BEGIN
  UPDATE PlayerCharacters
  SET characterName = COALESCE(p_characterName, characterName),
      initiativeBonus = COALESCE(p_initiativeBonus, initiativeBonus)
  WHERE characterId = p_characterId;
END //

CREATE PROCEDURE Delete_Player_ById(IN p_playerId INT)
BEGIN
  DELETE FROM Players
  WHERE playerId = p_playerId;
END //

CREATE PROCEDURE Delete_PlayerCharacter_ById(IN p_characterId INT)
BEGIN
  DELETE FROM PlayerCharacters
  WHERE characterId = p_characterId;
END //

DELIMITER ;
