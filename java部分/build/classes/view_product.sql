CREATE OR REPLACE VIEW view_product AS 
SELECT
	p.id,
	p.title,
	p.price,
	b.name AS brand,
	m.name AS model,
	c_s.comment_sum,
	p.sort,
	p_i. NAME AS img_name
FROM
	product p
LEFT JOIN brand b ON p.brand_id = b.id
LEFT JOIN model m ON p.model_id = m.id
LEFT JOIN comment_sum c_s ON p.id = c_s.product_id
LEFT JOIN product_img p_i ON p.id = p_i.product_id
AND p_i.sort = 0
ORDER BY
	p.sort ASC