The project used mTLS, sample API for Department module is there to show that the mTLS is working. 
Postman collection can be referred to Spring Boot Int - Users & Department APIs.postman_collection.json.
In order to test endpoint from Department module, Users module is needed, unless the mTLS is disabled. Please use endpoint /username/{userName} in Users module to test Department module.

"Disclaimer: For evaluation convenience, the test keystores and truststores are committed inside the src/main/resources folder. In a production cloud deployment, these credentials would be stored in a secure secret manager (like HashiCorp Vault or AWS Secrets Manager) and injected via external file mounts or environment variables."

The database is MSSQL.

Below are the data samples can be used for the run:

CREATE TABLE dbo.Users (
    UserID UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID() NOT NULL,
    UserName NVARCHAR(100) NOT NULL,
    Email NVARCHAR(255) NOT NULL,
    Active BIT NOT NULL,
    CreatedDate DATETIME2 NOT NULL DEFAULT SYSUTCDATETIME(),
    UpdatedDate DATETIME2 NOT NULL DEFAULT SYSUTCDATETIME(),
    
    CONSTRAINT PK_Users PRIMARY KEY CLUSTERED (UserID)
);

INSERT INTO [dbo].[Users] ([UserID], [UserName], [Email], [Active], [CreatedDate], [UpdatedDate])
VALUES
(NEWID(), 'AliceSmith', 'alice.smith@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'BobJohnson', 'bob.johnson@example.com', 0, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'CharlieBrown', 'charlie.brown@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'DianaPrince', 'diana.prince@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'EvanWright', 'evan.wright@example.com', 0, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'FionaGallagher', 'fiona.g@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'GeorgeClark', 'george.clark@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'HannahAbbott', 'hannah.a@example.com', 0, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'IanMalcolm', 'ian.malcolm@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'JuliaRoberts', 'julia.roberts@example.com', 1, SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'KevinBacon', 'kevin.bacon@example.com', 0, SYSUTCDATETIME(), SYSUTCDATETIME());