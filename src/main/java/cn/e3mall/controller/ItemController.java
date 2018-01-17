package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody

	public TbItem getItemById(@PathVariable long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/item/save")
	@ResponseBody
	public E3Result saveItem(TbItem item, String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}

	@RequestMapping("/item/desc/{itemId}")
	@ResponseBody
	public E3Result showItemDesc(@PathVariable long itemId) {
		E3Result result = itemService.showItemDesc(itemId);
		return result;
	}

	@RequestMapping("/item/update")
	@ResponseBody
	public E3Result updateItem(TbItem item, String desc) {
		E3Result result = itemService.updateItem(item, desc);
		return result;
	}

	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public E3Result instockItem(Long[] ids) {
		E3Result result = itemService.instocjItem(ids);
		return result;
	}

	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public E3Result reshelfItem(Long[] ids) {
		E3Result result = itemService.reshelfItem(ids);
		return result;
	}

	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public E3Result deleteItem(Long[] ids) {
		E3Result result = itemService.deleteItem(ids);
		return result;
	}

}
