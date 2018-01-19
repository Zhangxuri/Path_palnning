package com.heitian.ssm.controller;

import com.heitian.ssm.model.Car;
import com.heitian.ssm.model.Product;
import com.heitian.ssm.model.ProductList;
import com.heitian.ssm.service.CarService;
import com.heitian.ssm.service.ProductListService;
import com.heitian.ssm.service.ProductService;
import com.heitian.ssm.utils.Calc;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
public class ProductController {

    private Logger log = Logger.getLogger(ProductController.class);

    @Resource
    private ProductService productService;
    @Resource
    private ProductListService productListService;
    @Resource
    private CarService carService;

    @RequestMapping(value = "/calc.do", method = RequestMethod.POST)
    public @ResponseBody
    JSONArray test(@RequestParam("str") String str) throws IOException {
        log.info("calc模块");
        return Calc.calc(str);
    }

    @RequestMapping(value = "/dataaddress.do", method = RequestMethod.POST)
    public String showUser(HttpServletRequest request, Model model) {
        log.info("查询所有用户信息");
        List<ProductList> productLists = productListService.find();
        List<String> respo = new ArrayList<>();
        respo.add("\"昌平区东小口中滩村\"");
        for (ProductList productList:productLists) {
            respo.add("\""+productList.getAddress()+"\"");
        }
        model.addAttribute("address",respo);
        return "dataaddress";
    }

    @RequestMapping(value = "/getcar.do")
    public @ResponseBody
    JSONArray getcar() throws IOException {
        log.info("getcar模块");

        double sum = 0;
        List<Long> p = productListService.findProduct();
        Iterator iterator = p.iterator();
        while (iterator.hasNext()) {
            Product product = productService.findbyId((Long) iterator.next());
            sum = sum + product.getWeight();
        }
        List<Car> cars = (List<Car>) carService.findbyVolumgreaterThan(sum);
        JSONArray jsonArray = JSONArray.fromObject(cars);
        return jsonArray;
    }

    @RequestMapping(value = "/getmsg.do")
    public @ResponseBody
    JSONArray getmsg() throws IOException {
        log.info("getmsg模块");

        List<ProductList> productLists = productListService.find();
        JSONArray jsonArray = JSONArray.fromObject(productLists);
        return jsonArray;
    }

    @RequestMapping(value = "/getpro.do")
    public @ResponseBody
    JSONArray getpro() throws IOException {
        log.info("getpro模块");

        List<Product> products = productService.find();
        JSONArray jsonArray = JSONArray.fromObject(products);
        return jsonArray;
    }
}
