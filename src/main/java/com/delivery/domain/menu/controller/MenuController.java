package com.delivery.domain.menu.controller;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.service.MenuService;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final StoreRepository storeRepository;
    private final MenuService menuService;

    @GetMapping("/{id}/menu/new")
    public String menuSaveForm(Model model, @PathVariable Long id) {
        Optional<StoreEntity> targetStore = storeRepository.findById(id);

        if (targetStore.isPresent()){
            model.addAttribute("targetStore", targetStore.get());
        }

        return "html/owner/menu_registration";

    }

    @PostMapping("/{id}/menu/new")
    public String menuSave(@ModelAttribute("dummyMenuDtoList") List<MenuDto> menuDtoList,
                           @PathVariable Long id) {
        // DummyMenuService를 사용하여 메뉴 저장
        menuService.save(menuDtoList, id);

        // 저장 후 다시 메뉴 등록 페이지로 이동
        return "redirect:/store/{id}/menu/new";
    }




    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<StoreEntity> targetStore = storeRepository.findById(id);
        // List<StoreMenuEntity> dummyMenuListEntity = storeMenuRepository.findAllByDummyStoreEntity_Id(id);

        if (targetStore.isPresent()) {
            model.addAttribute("store", targetStore.get());
            // model.addAttribute("menuList", dummyMenuListEntity);
//            model.addAttribute("base64Image", storePicturePath);
            return "html/store/detail";
        }
        // 예시로 null을 반환하였습니다. 실제 상황에 맞게 수정하세요.
        return null;
    }

    private String encodeImageToBase64(String picturePath) throws IOException {
        Path imagePath = Paths.get("path/to/your/image/directory", picturePath);
        byte[] imageBytes = Files.readAllBytes(imagePath);
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
