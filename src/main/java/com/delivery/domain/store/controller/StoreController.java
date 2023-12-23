package com.delivery.domain.store.controller;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.store.dto.StoreDto;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/store")
@Slf4j
@RequiredArgsConstructor
public class StoreController {

    private final MenuDto menuDto;
    private final MenuEntity menuEntity;
    private final StoreRepository storeRepository;

    @GetMapping("/new")
    public String newStoreForm(){return "html/store/StoreAdd";}

    @PostMapping("/create")

    public String create(@ModelAttribute StoreDto form){

        StoreEntity store = form.toCreate();

        StoreEntity saved = storeRepository.save(store);



        return "redirect:/store/"+saved.getId();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){

        Optional<StoreEntity> storeEntity = storeRepository.findById(id);

        if(storeEntity.isPresent()){
            model.addAttribute("store", storeEntity.get());
        }
        return "html/store/StoreShow";
    }

    //목록보기
    @GetMapping("")
    public String list(Model model){

        List<StoreEntity> storeEntityList = storeRepository.findAll();
        model.addAttribute("store", storeEntityList);
        return "html/store/StoreShow";
    }

    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){

        Optional<StoreEntity> target = storeRepository.findById(id);

        if(target.isPresent()){
            storeRepository.delete(target.get());
            rttr.addFlashAttribute("msg", "게시물삭제");
        }
        return "redirect:/store/new";
    }

}
