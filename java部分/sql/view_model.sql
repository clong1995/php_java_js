CREATE OR REPLACE VIEW view_model AS 
SELECT
	b.id AS brand_id,
	b.name AS brand_name,
	group_concat(m.name) AS model_name
FROM
	brand b
LEFT JOIN model m ON b.id = m.brand_id
GROUP BY b.id
ORDER BY
	b.sort