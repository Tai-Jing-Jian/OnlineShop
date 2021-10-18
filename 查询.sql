SELECT `t_promotiongoods`.`id` AS `promotion_id`, `t_promotiongoods`.`goods_id`, `t_goods`.`name`, `t_promotiongoods`.`total`, `t_promotiongoods`.`price`, `t_promotiongoods`.`start_time`, `t_promotiongoods`.`end_time`, `t_promotiongoods`.`is_active`
FROM `t_promotiongoods`
         LEFT JOIN `t_goods` ON (`t_promotiongoods`.`goods_id` = `t_goods`.`id`)
         LEFT JOIN `t_goodsclass` ON (`t_goods`.`class_id` = `t_goodsclass`.`id`)
WHERE (`t_goodsclass`.`is_active` = 1 AND `t_goods`.`is_active` = 1 AND `t_promotiongoods`.`is_active` = 1)


UPDATE t_promotiongoods SET total=total-1 WHERE id=1