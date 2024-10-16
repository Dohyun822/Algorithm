WITH INFO AS (
    SELECT YEAR(DIFFERENTIATION_DATE) as YEAR, MAX(SIZE_OF_COLONY) as SIZE
    FROM ECOLI_DATA
    GROUP BY YEAR
)

SELECT YEAR(DIFFERENTIATION_DATE) as YEAR, (INFO.SIZE - SIZE_OF_COLONY) as YEAR_DEV, ID
FROM ECOLI_DATA ED
JOIN INFO ON YEAR(ED.DIFFERENTIATION_DATE) = INFO.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC;