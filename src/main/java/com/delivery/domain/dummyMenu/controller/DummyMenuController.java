package com.delivery.domain.dummyMenu.controller;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.dto.DummyMenuListDto;
import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyMenu.repository.DummyMenuRepository;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
public class DummyMenuController {

    private final DummyStoreRepository dummyStoreRepository;
    private final DummyMenuRepository dummyMenuRepository;

    @GetMapping("/menu/new")
    public String menuSaveForm(Model model){
        model.addAttribute("menuForm", new DummyMenuListDto());
        return "html/owner/menu_registration";
    }

    @PostMapping("/menu/new")
    public String menuSave(@ModelAttribute ArrayList<DummyMenuDto> dummyMenuDtoList, Model model){
        for(DummyMenuDto dummyMenuDto : dummyMenuDtoList){
            System.out.println(dummyMenuDto.toString());
        }
        return "html/owner/menu_registration";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(id);
        List<DummyMenu> dummyMenuList = dummyMenuRepository.findAllByDummyStoreEntity_Id(id);
        if(targetStore.isPresent()){
            model.addAttribute("store", targetStore.get());
            model.addAttribute("menuList", dummyMenuList);
            return "html/store/detail";
        }

        return null;
    }
}
