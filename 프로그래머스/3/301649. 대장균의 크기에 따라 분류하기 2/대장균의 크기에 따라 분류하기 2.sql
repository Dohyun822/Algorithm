WITH RankedEcoli AS (
    SELECT 
        ID,
        SIZE_OF_COLONY,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS Quartile
    FROM 
        ECOLI_DATA
)
SELECT 
    ID,
    CASE 
        WHEN Quartile = 1 THEN 'CRITICAL'
        WHEN Quartile = 2 THEN 'HIGH'
        WHEN Quartile = 3 THEN 'MEDIUM'
        WHEN Quartile = 4 THEN 'LOW'
    END AS COLONY_NAME
FROM 
    RankedEcoli
ORDER BY 
    ID ASC;