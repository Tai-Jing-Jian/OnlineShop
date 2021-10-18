package com.example.shop_buyer_web.controller;


import com.example.shop_buyer_web.service.BuyerService;
import com.example.shop_buyer_web.service.PromotionService;
import com.example.shop_buyer_web.util.RedisUtils;
import com.example.shop_buyer_web.util.ResponseResult;
import com.example.shop_dao.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author tai
 * @date: 2021-09-13 19:52
 * @description:
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private PromotionService promotionService;


    @RequestMapping("/toPromotion")
    public String toPromotion(Long buyerId, Model model){
        model.addAttribute("buyerId", buyerId);
        model.addAttribute("promotionGoodsList",promotionService.selectAll());
        return "promotion";
    }


    @PostMapping("/login")
    public String login(Long id, String password, Model model){
        Buyer buyer = buyerService.selectById(id);
        if(null != buyer) {
            if(buyer.getPassword().equals(password)){
                //重定向
                return "redirect:toPromotion?buyerId="+id;
            }else {
                model.addAttribute("password", "请输入正确的密码!!!");
                model.addAttribute("buyerId", id);
                return "login";
            }
        }else {
            model.addAttribute("idError", "该用户不存在");
            return "login";
        }
    }

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/promotion")
    @ResponseBody
    public ResponseResult buy(Long buyerId, Integer promotionId, Long goodsId){
        if(redisUtils.setnx(""+buyerId,""+promotionId,10L)){
            if(promotionService.buy(buyerId, promotionId, goodsId)){
                redisUtils.del(""+buyerId);
                return new ResponseResult(1, "购买成功");
            }else {
                redisUtils.del(""+buyerId);
                return new ResponseResult(0, "购买失败，数量不足");
            }
        }else {
            return new ResponseResult(0, "购买失败，该用户正在购买中，请稍后再抢购");
        }

    }


}
