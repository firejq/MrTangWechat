package cn.adibio.web;

import cn.adibio.entity.ReceiveInfo;

import cn.adibio.entity.User;
import cn.adibio.service.ReceiveInfoService;
import cn.adibio.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wjq on 2017/3/14.
 */
@Controller
public class ReceiveInfoController {

    @Autowired
    UserService userService;

    @Autowired
    ReceiveInfoService receiveInfoService;

    @RequestMapping(value = "/receive_info/{openId}/show", method = RequestMethod.GET)
    public ModelAndView receiveInfoShow(@PathVariable("openId") String openId) {
        ModelAndView modelAndView = new ModelAndView("receive_info");
        List<ReceiveInfo> receiveInfoList = this.receiveInfoService.queryAllByOpenid(openId);
        modelAndView.addObject(receiveInfoList);

        return modelAndView;
    }

    @RequestMapping(value = "/receive_info/{openId}/choose", method = RequestMethod.GET)
    public ModelAndView chooseReceiveInfo(@PathVariable("openId")String openId){
        ModelAndView modelAndView = new ModelAndView("choose_recv_info");
        List<ReceiveInfo> receiveInfoList = this.receiveInfoService.queryAllByOpenid(openId);
        modelAndView.addObject(receiveInfoList);
        return modelAndView;
    }

    @RequestMapping(value = "/receive_info/{openId}/{info_index}/choose_ok", method = RequestMethod.GET)
    public ModelAndView chooseRecvInfoOk(@PathVariable("openId")String openId, @PathVariable("info_index")String infoIndex){
        ModelAndView modelAndView = new ModelAndView("purchase_detail");
        List<ReceiveInfo> receiveInfoList = this.receiveInfoService.queryAllByOpenid(openId);
        ReceiveInfo receiveInfo = receiveInfoList.get(Integer.valueOf(infoIndex));
        modelAndView.addObject(receiveInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/receive_info/{openId}/purchase_detail")
    public ModelAndView purchaseWithRecvInfo(@PathVariable("openId")String openId){
        ModelAndView modelAndView = new ModelAndView("purchase_detail");
        List<ReceiveInfo> receiveInfoList = this.receiveInfoService.queryAllByOpenid(openId);
        if (receiveInfoList != null && receiveInfoList.size() > 0){
            ReceiveInfo receiveInfo = receiveInfoList.get(0);
            modelAndView.addObject(receiveInfo);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/receive_info/{openId}/add", method = RequestMethod.POST)
    public String receiveInfoAdd(HttpServletRequest request) {
        ReceiveInfo receiveInfo = new ReceiveInfo(null, request.getParameter("openId"), request.getParameter
                ("name"),
                request.getParameter("gender"), Integer.valueOf(request.getParameter("age")),
                request.getParameter("address"),
                request.getParameter("phone"), null);
//      插入新的收货信息
        Integer res = this.receiveInfoService.insertReceiveInfo(receiveInfo);
        return (res > 0 ? "success/add_receive_success" : "fail/error");
    }

    @RequestMapping(value = "/receive_info/{id}/delete", method = RequestMethod.GET)
    public String receiveInfoDel(@PathVariable("id") Long id) {
        Integer res = this.receiveInfoService.deleteById(id);
        return (res > 0 ? "success/delete_receive_success" : "fail/error");
    }

    @RequestMapping(value = "/receive_info/{id}/edit", method = RequestMethod.GET)
    public ModelAndView receiveInfoUpd(@PathVariable("id") Long id) {
        ReceiveInfo receiveInfo = this.receiveInfoService.queryById(id);
        if (receiveInfo != null) {
            ModelAndView modelAndView = new ModelAndView("receinfo_upd");
            modelAndView.addObject(receiveInfo);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("fail/error");
            return modelAndView;
        }


    }

    @RequestMapping(value = "/receive_info/{id}/update", method = RequestMethod.POST)
    public String receiveInfoUpd(HttpServletRequest request, @PathVariable("id") Long id) {
        ReceiveInfo receiveInfo = new ReceiveInfo(request.getParameter("name"),
                request.getParameter("gender"),
                Integer.valueOf(request.getParameter("age")),
                request.getParameter("address"),
                request.getParameter("phone"));
        Integer res = this.receiveInfoService.updateById(id, receiveInfo);
        return (res > 0 ? "success/update_receive_success" : "fail/error");
    }


}
