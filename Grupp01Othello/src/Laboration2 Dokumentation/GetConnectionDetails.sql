

/* Skapar proceduren GetConnectionDetails */
CREATE PROCEDURE GetConnectionDetails @groupID INT, @ipAddress VARCHAR(30) OUTPUT, @port VARCHAR(4) OUTPUT
AS
SELECT @ipAddress = o.ipAddress, @port = o.port
FROM OnlinePlayers o
WHERE o.groupID = @groupID
RETURN
GO

CREATE PROCEDURE GetConnectionDetails @groupID INT
AS
SELECT o.ipAddress, o.port
FROM OnlinePlayers o
WHERE o.groupID = @groupID
GO
/* execute f�r att testa den eller utf�ra */
  DECLARE @ip VARCHAR(30), @p VARCHAR(4)
  EXEC GetConnectionDetails 2, @ip OUTPUT, @p OUTPUT
  SELECT @ip, @p

  EXEC GetConnectionDetails 2


/* Drop f�r att ta bort proceduren */
DROP PROCEDURE GetConnectionDetails

SELECT * FROM OnlinePlayers