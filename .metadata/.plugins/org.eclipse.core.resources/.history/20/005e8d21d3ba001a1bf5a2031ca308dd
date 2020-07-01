package edu.vinaenter.controllers.admins;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.CommonConstants;
import edu.vinaenter.constants.UrlConstants;
import edu.vinaenter.dto.LandDto;
import edu.vinaenter.models.Category;
import edu.vinaenter.services.CategoryService;
import edu.vinaenter.services.LandService;
import edu.vinaenter.utils.FileUtil;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminLandController {
	@Autowired
	private LandService landService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ServletContext servletContext;

	@GetMapping({ UrlConstants.URL_ADMIN_LAND_INDEX, UrlConstants.URL_ADMIN_LAND_INDEX_PAGINATION })

	public String index(Model model, @PathVariable(required = false) Integer page) {
		if (page == null) {
			page = 1;
		}
		int countPagination = landService.countPagination();

		int offset = (page - 1) * CommonConstants.DEFAULT_PAGING_SIZE;
		int totalPage = (int) Math.ceil((float) countPagination / CommonConstants.DEFAULT_PAGING_SIZE);

		List<LandDto> listLand = landService.findAllPagination(offset);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("listLand", listLand);
		model.addAttribute("page", page);
		return "cland.admin.land.index";

	}

	@GetMapping(UrlConstants.URL_ADMIN_LAND_ADD)
	public String add(Model model) {
		List<Category> listCat = categoryService.findAll();
		model.addAttribute("listCat", listCat);
		return "cland.admin.land.add";
	}

	@PostMapping(UrlConstants.URL_ADMIN_LAND_ADD)
	public String add(@ModelAttribute("land") LandDto land, BindingResult rs,
			@RequestParam("file") CommonsMultipartFile mtf, RedirectAttributes ra) {

		if (rs.hasErrors()) {
			return "cland.admin.land.add";
		}

		// upload file
		String file = mtf.getOriginalFilename(); // get file Name
		// thu muc chua file
		String dirPath = servletContext.getRealPath("") + CommonConstants.DIR_UPLOAD;
		File saveDir = new File(dirPath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		// duong dan file
		String newFileName = FileUtil.rename(file);
		String filePath = dirPath + File.separator + newFileName;
		// doi tuong file
		// => upload to server

		try {
			mtf.transferTo(new File(filePath));
			System.out.println(filePath);
			ra.addFlashAttribute("msg", messageSource.getMessage("file.success", null, null));

		} catch (IllegalStateException | IOException e) {
			ra.addFlashAttribute("msg", messageSource.getMessage("file.fail", null, null));
		}
		land.setPicture(newFileName);

		int addLand = landService.add(land);
		if (addLand > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("admin.land.add.success", null, null));
			return "redirect:/admin/land/index";
		}
		ra.addFlashAttribute("msg", messageSource.getMessage("admin.land.add.fail", null, null));
		return "redirect:/admin/land/add";

	}

	@GetMapping(UrlConstants.URL_ADMIN_LAND_DEL)
	public String del(@PathVariable(value = "id", required = false) Integer id, RedirectAttributes ra) {
		LandDto land = landService.findLandById(id);

		String fileName = land.getPicture();

		if (!"".equals(fileName)) {
			String dirPath = servletContext.getRealPath("") + CommonConstants.DIR_UPLOAD;

			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName;
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
		}
		if (landService.del(id) > 0) {

			ra.addFlashAttribute("msg", messageSource.getMessage("admin.land.del.success", null, null));
			return "redirect:/admin/land/index";
		}

		ra.addFlashAttribute("msg", messageSource.getMessage("admin.land.del.fail", null, null));
		return "redirect:/admin/land/index";
	}

	@GetMapping(UrlConstants.URL_ADMIN_LAND_EDIT)
	public String edit(Model model, @PathVariable(value = "id", required = false) Integer id) {
		LandDto land = landService.findLandById(id);
		model.addAttribute("land", land);

		List<Category> listCat = categoryService.findAll();
		model.addAttribute("listCat", listCat);
		return "cland.admin.land.edit";
	}

	@PostMapping(UrlConstants.URL_ADMIN_LAND_EDIT)
	public String edit(@ModelAttribute("land") LandDto land, @PathVariable Integer id,
			@RequestParam("file") MultipartFile mtf, RedirectAttributes ra) {

		LandDto oldLand = landService.findLandById(id);
		// upload anh
		String fileName = mtf.getOriginalFilename();// lấy tên gốc file.
		String newFileName = "";

		if ("".equals(fileName)) {
			newFileName = oldLand.getPicture();
		} else {
			newFileName = FileUtil.rename(fileName);
		}
		
		if (!"".equals(fileName)) {
			String dirPath = servletContext.getRealPath("") + CommonConstants.DIR_UPLOAD;
			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			
			//delete old file
			String oldFilePath = dirPath + File.separator + oldLand.getPicture();
			File oldFile = new File(oldFilePath);
			if (oldFile.exists()) {
				oldFile.delete();
			}
			
			//upload new file
			String filePath = dirPath + File.separator + newFileName; // tao duong dan file.
			try {
				mtf.transferTo(new File(filePath));
				ra.addFlashAttribute("msg", messageSource.getMessage("file.success", null, null));

			} catch (Exception e) {
				ra.addFlashAttribute("msg", messageSource.getMessage("file.fail", null, null));

			}
		}
		
		land.setPicture(newFileName);

		if (landService.edit(land) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("admin.land.edit.success", null, null));
			return "redirect:/admin/land/index";
		}
		ra.addFlashAttribute("msg", messageSource.getMessage("admin.land.edit.fail", null, null));
		return "redirect:/admin/land/index";
	}
}
