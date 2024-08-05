WITH SALE AS (SELECT PRODUCT_ID, SUM(AMOUNT) AS AMOUNT
             FROM FOOD_ORDER
             WHERE DATE_FORMAT(PRODUCE_DATE, '%Y-%m') = '2022-05'
             GROUP BY PRODUCT_ID)
             
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, (FP.PRICE * S.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT FP
JOIN SALE S ON FP.PRODUCT_ID = S.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, FP.PRODUCT_ID
