WITH INFO AS (SELECT FISH_TYPE, AVG(COALESCE(LENGTH, 10)) as AVG
FROM FISH_INFO 
GROUP BY FISH_TYPE
HAVING AVG >= 33)

SELECT COUNT(*) as FISH_COUNT, MAX(LENGTH) as MAX_LENGTH, FISH_INFO.FISH_TYPE
FROM FISH_INFO 
JOIN INFO ON FISH_INFO.FISH_TYPE = INFO.FISH_TYPE
GROUP BY FISH_INFO.FISH_TYPE
ORDER BY FISH_INFO.FISH_TYPE ASC