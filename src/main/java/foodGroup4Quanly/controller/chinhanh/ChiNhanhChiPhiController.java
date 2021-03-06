package foodGroup4Quanly.controller.chinhanh;

import foodGroup4Quanly.common.ChiPhiNgayValidator;
import foodGroup4Quanly.common.DanhSachLuongValidator;
import foodGroup4Quanly.common.TienThueNhaValidator;
import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.dao.TienThueNhaDao;
import foodGroup4Quanly.dto.*;
import foodGroup4Quanly.entity.Chiphingay;
import foodGroup4Quanly.entity.Luongchonhanvien;
import foodGroup4Quanly.entity.Tienthuenha;
import foodGroup4Quanly.entity.TienthuenhaPK;
import foodGroup4Quanly.service.ChiPhiNgayService;
import foodGroup4Quanly.service.LuongNhanVienService;
import foodGroup4Quanly.service.TienThueNhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/chinhanh/chiphi")
public class ChiNhanhChiPhiController {

    @Autowired
    ChiPhiNgayValidator chiPhiNgayValidator;

    @Autowired
    ChiPhiNgayService chiPhiNgayService;

    @Autowired
    TienThueNhaService tienThueNhaService;

    @Autowired
    LuongNhanVienService luongNhanVienService;

    @Autowired
    DanhSachLuongValidator danhSachLuongValidator;

    @Autowired
    TienThueNhaValidator tienThueNhaValidator;

    @RequestMapping(value = "/ngay", method = RequestMethod.GET)
    public String getChiPhiNgay(Model model, @RequestParam(value = "date", required = false) String strDate) {
        Calendar calDate = convertStringToDate(strDate, "dd-MM-yyyy");
        List<Chiphingay> listChiPhiNgay = chiPhiNgayService.getChiPhiNgayInDate(calDate.getTime());
        model.addAttribute("listChiPhiNgay", listChiPhiNgay);
        return "chinhanh-chi-phi-ngay";
    }

    @RequestMapping(value = "/ngay/create", method = RequestMethod.GET)
    public String getThemChiPhiNgay(Model model) {
        model.addAttribute("chiPhiNgay", new ChiPhiNgayDto());
        return "chinhanh-them-chi-phi-ngay";
    }

    @RequestMapping(value = "/ngay/create", method = RequestMethod.POST)
    public String postThemChiPhiNgay(Model model,
                                     @ModelAttribute("chiPhiNgay") ChiPhiNgayDto chiPhiNgayDto,
                                     BindingResult bindingResult) {
        chiPhiNgayValidator.validate(chiPhiNgayDto, bindingResult);
        if(bindingResult.hasErrors()) {
            return "chinhanh-them-chi-phi-ngay";
        }
        Chiphingay chiphingay = chiPhiNgayDto.getChiPhiNgay();
        chiPhiNgayService.create(chiphingay);
        return "redirect:/chinhanh/chiphi/ngay/create";
    }

    @RequestMapping(value = "/ngay/update/{id}", method = RequestMethod.GET)
    public String getUpdateChiPhiNgay(Model model,
                                      @PathVariable("id")int id) {
        ChiPhiNgayDto chiPhiNgayDto = new ChiPhiNgayDto(chiPhiNgayService.getById(id));
        model.addAttribute("chiPhiNgay", chiPhiNgayDto);
        model.addAttribute("id", id);
        model.addAttribute("type", "update");
        return "chinhanh-them-chi-phi-ngay";
    }

    @RequestMapping(value = "/ngay/update", method = RequestMethod.POST)
    public String postUpdateChiPhiNgay(Model model,
                                       @RequestParam("id") int id,
                                       @ModelAttribute("chiPhiNgay") ChiPhiNgayDto chiPhiNgayDto,
                                       BindingResult bindingResult) {
        chiPhiNgayValidator.validate(chiPhiNgayDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("id", id);
            model.addAttribute("type", "update");
            return "chinhanh-them-chi-phi-ngay";
        }
        Chiphingay chiphingay = chiPhiNgayService.getById(id);
        chiphingay = chiPhiNgayDto.tranferDataToChiPhiNgay(chiphingay);
        chiPhiNgayService.update(chiphingay);

        return "redirect:/chinhanh/chiphi/ngay/update/" + id;
    }

    @RequestMapping(value = "/ngay/delete", method = RequestMethod.POST)
    public String postDeleteChiPhiNgay(HttpServletRequest request, @RequestParam("id") int id) {
        chiPhiNgayService.deleteById(id);

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/thang", method = RequestMethod.GET)
    public String getChiPhiThang(Model model, @RequestParam(value = "year", required = false) String strYear) {
        if(strYear == null) {
            strYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        }

        List<Tienthuenha> listTienThueNha = tienThueNhaService.getTienThueNhaOfYear(strYear);

        model.addAttribute("listTienThueNha", listTienThueNha);

        return "chinhanh-chi-phi-thang";
    }

    @RequestMapping(value = "/thang/create", method = RequestMethod.GET)
    public String getCreateChiPhiThang(Model model) {
        model.addAttribute("tienThueNha", new TienThueNhaDto());
        return "chinhanh-them-chi-phi-thang";
    }

    @RequestMapping(value = "/thang/create", method = RequestMethod.POST)
    public String postCreateChiPhiThang(Model model,
                                        @ModelAttribute("tienThueNha")TienThueNhaDto tienThueNhaDto,
                                        BindingResult bindingResult) {
        tienThueNhaValidator.validate(tienThueNhaDto, bindingResult);
        if(bindingResult.hasErrors()) {
            return "chinhanh-them-chi-phi-thang";
        }
        Tienthuenha tienthuenha = tienThueNhaDto.getTienThueNha();
        tienThueNhaService.create(tienthuenha);

        model.addAttribute("tienThueNha", new TienThueNhaDto());
        return "chinhanh-them-chi-phi-thang";
    }

    @RequestMapping(value = "/thang/update", method = RequestMethod.GET)
    public String getUpdateChiPhiThang(Model model,
                                       @RequestParam("month") String month,
                                       @RequestParam("year") String year) {
        Tienthuenha tienthuenha = tienThueNhaService.getById(new TienthuenhaPK(month, year));
        TienThueNhaDto tienThueNhaDto = new TienThueNhaDto(tienthuenha);
        tienThueNhaDto.setUpdate(true);

        model.addAttribute("tienThueNha", tienThueNhaDto);
        model.addAttribute("thang", tienthuenha.getThang());
        model.addAttribute("nam", tienthuenha.getNam());
        model.addAttribute("type", "update");

        return "chinhanh-them-chi-phi-thang";
    }

    @RequestMapping(value = "/thang/update", method = RequestMethod.POST)
    public String postUpdateChiPhiThang(Model model,
                                        @ModelAttribute("tienThueNha")TienThueNhaDto tienThueNhaDto,
                                        @RequestParam("thang") String thang,
                                        @RequestParam("nam") String nam,
                                        BindingResult bindingResult) {
        tienThueNhaDto.setUpdate(true);
        tienThueNhaValidator.validate(tienThueNhaDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("type", "update");
            return "chinhanh-them-chi-phi-thang";
        }

        Tienthuenha tienthuenha = tienThueNhaService.getById(new TienthuenhaPK(thang, nam));
        tienthuenha = tienThueNhaDto.updateTienThueNha(tienthuenha);
        tienThueNhaService.update(tienthuenha);

        model.addAttribute("tienThueNha", tienThueNhaDto);
        return "redirect:/chinhanh/chiphi/thang/update" + "?month=" + thang + "&year=" + nam;
    }

    @RequestMapping(value = "/luongnhanvien", method = RequestMethod.GET)
    public String getChiLuongNhanVien(Model model,
                                      @RequestParam(value = "year", required = false) String strYear) {
        if(strYear == null) {
            strYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        }

        List<TongLuongNhanVienTheoThangDto> listTongLuongTheoThang =
                luongNhanVienService.getTongLuongTheoThang(strYear, Utils.getChinhanhHienTai().getChiNhanhId());
        model.addAttribute("listTongLuongTheoThang", listTongLuongTheoThang);
        return "chinhanh-luong-nhan-vien";
    }

    @RequestMapping(value = "/luongnhanvien/create", method = RequestMethod.GET)
    public String getThemLuongNhanVien(Model model) {
        DanhSachLuongNhanVienDto danhSachLuongNhanVien
                = new DanhSachLuongNhanVienDto(Utils.getChinhanhHienTai().getNhanviens());
        model.addAttribute("danhSachLuongNv", danhSachLuongNhanVien);

        return "chinhanh-them-luong-nhan-vien";
    }

    @RequestMapping(value = "/luongnhanvien/create", method = RequestMethod.POST)
    public String postThemLuongNhanVien(Model model,
                                        @ModelAttribute(value = "danhSachLuongNv")
                                                DanhSachLuongNhanVienDto danhSachLuongNhanVien,
                                        BindingResult bindingResult) {
        danhSachLuongValidator.validate(danhSachLuongNhanVien, bindingResult);
        System.out.println(danhSachLuongNhanVien.getThoiGian());
        if(bindingResult.hasErrors()) {
            return "chinhanh-them-luong-nhan-vien";
        }

        luongNhanVienService.saveDsLuongNhanVien(danhSachLuongNhanVien);

        DanhSachLuongNhanVienDto danhSachLuongNhanVienNew
                = new DanhSachLuongNhanVienDto(Utils.getChinhanhHienTai().getNhanviens());
        model.addAttribute("danhSachLuongNv", danhSachLuongNhanVienNew);
        return "chinhanh-them-luong-nhan-vien";
    }

    @RequestMapping(value = "/luongnhanvien/update", method = RequestMethod.GET)
    public String getUpdateLuongNhanVien(Model model,
                                       @RequestParam("month") String month,
                                       @RequestParam("year") String year) {
        List<Luongchonhanvien> listLuongNv =
                luongNhanVienService.getListLuong(month, year, Utils.getChinhanhHienTai().getChiNhanhId());

        DanhSachLuongNhanVienDto danhSachLuongNhanVien
                = new DanhSachLuongNhanVienDto(listLuongNv);
        model.addAttribute("danhSachLuongNv", danhSachLuongNhanVien);
        model.addAttribute("type", "update");

        return "chinhanh-them-luong-nhan-vien";
    }

    @RequestMapping(value = "/luongnhanvien/update", method = RequestMethod.POST)
    public String postUpdateLuongNhanVien(Model model,
                                          @ModelAttribute(value = "danhSachLuongNv")
                                                  DanhSachLuongNhanVienDto danhSachLuongNhanVien,
                                          @RequestParam("thang") String thang,
                                          @RequestParam("nam") String nam,
                                          BindingResult bindingResult) {
        danhSachLuongNhanVien.setUpdate(true);
        danhSachLuongValidator.validate(danhSachLuongNhanVien, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("type", "update");
            return "chinhanh-them-luong-nhan-vien";
        }

        luongNhanVienService.updateDsLuongNhanVien(danhSachLuongNhanVien);

        return "redirect:/chinhanh/chiphi/luongnhanvien/update?month="+thang+"&year="+nam;
    }

    private Calendar convertStringToDate(String strDate, String formatDate) {
        Calendar cal = Calendar.getInstance();
        if(strDate != null) {
            Date date = Utils.parseDate(strDate, formatDate);
            if(date != null) {
                cal.setTime(date);
            }
        }

        return cal;
    }
}
