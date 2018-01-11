package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.service.ItemCatService;

@Controller
public class ItemCatController {

	@Autowired
	ItemCatService itemCatService;

	@ResponseBody
	@RequestMapping("/item/cat/list")
	private List<EasyUITreeNode> getSelectCatItem(@RequestParam(value = "id", defaultValue = "0") long parentId) {

		List<EasyUITreeNode> list = itemCatService.getSelectTreeNodes(parentId);

		return list;

	}

}
