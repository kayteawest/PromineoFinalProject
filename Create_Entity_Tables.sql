CREATE DATABASE DMTool;

USE DMTool;

DROP TABLE IF EXISTS Encounter_PlayerCharacter;
DROP TABLE IF EXISTS PlayerCharacters;
DROP TABLE IF EXISTS Encounters;
DROP TABLE IF EXISTS Players;
DROP TABLE IF EXISTS Campaigns;



CREATE TABLE Campaigns (
    campaignId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    createdDate DATETIME NOT NULL,
    campaignName TEXT NULL,
    dungeonMaster TEXT NULL,
    lastEncounterDate DATETIME NULL
);

CREATE TABLE Players (
    playerId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    playerName TEXT NOT NULL,
    createdDate DATETIME NOT NULL
);

CREATE TABLE Encounters (
    encounterId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    campaignId INT NOT NULL,
    createdDate DATETIME NOT NULL,
    
    CONSTRAINT FK_Campaign_To_Encounter_By_Id
      FOREIGN KEY (campaignId)
      REFERENCES Campaigns(campaignId)
      ON DELETE CASCADE
);

CREATE TABLE PlayerCharacters (
  characterId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  playerId INT NOT NULL,
  characterName TEXT NOT NULL,
  createdDate DATETIME NOT NULL,
  initiativeBonus INT NOT NULL,
  
  CONSTRAINT FK_Player_To_PlayerCharacter_By_Id
    FOREIGN KEY (playerId)
    REFERENCES Players(playerId)
    ON DELETE CASCADE
);

CREATE TABLE Encounter_PlayerCharacter(
    EncounterId INT NOT NULL,
    CharacterId INT NULL,
    
    CONSTRAINT FK_EPC_To_Encounter_By_Id
      FOREIGN KEY (EncounterId)
      REFERENCES Encounters(EncounterId)
      ON DELETE CASCADE,

    CONSTRAINT FK_EPC_To_PlayerCharacter_By_Id
      FOREIGN KEY (CharacterId)
      REFERENCES PlayerCharacters(CharacterId)
);