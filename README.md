The project used mTLS, no sample API for Department module since it can only be accessed by Users module.
In order to test endpoint from Department module, Users module is needed, unless the mTLS is disabled. Please use endpoint /username/{userName} in Users module to test Department module.
"Disclaimer: For evaluation convenience, the test keystores and truststores are committed inside the src/main/resources folder. In a production cloud deployment, these credentials would be stored in a secure secret manager (like HashiCorp Vault or AWS Secrets Manager) and injected via external file mounts or environment variables."

The database is MSSQL.

Below are the data samples can be used for the run:

INSERT INTO [dbo].[Users] ([UserID], [UserName], [Email], [CreatedDate], [UpdatedDate])
VALUES
(NEWID(), 'AliceSmith', 'alice.smith@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'BobJohnson', 'bob.johnson@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'CharlieBrown', 'charlie.brown@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'DianaPrince', 'diana.prince@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'EvanWright', 'evan.wright@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'FionaGallagher', 'fiona.g@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'GeorgeClark', 'george.clark@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'HannahAbbott', 'hannah.a@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'IanMalcolm', 'ian.malcolm@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'JuliaRoberts', 'julia.roberts@example.com', SYSUTCDATETIME(), SYSUTCDATETIME()),
(NEWID(), 'KevinBacon', 'kevin.bacon@example.com', SYSUTCDATETIME(), SYSUTCDATETIME());