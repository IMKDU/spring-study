package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // 상품 등록 뷰 전환
    @GetMapping("/items/new")
    public String createForm(Model model){
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    // 상품 생성
    @PostMapping("/items/new")
    public String createItem(BookForm form, Model model) {

        // 상품 객체생성
        Book book = new Book();
        book.setName(form.getName());
        book.setAuthor(form.getAuthor());
        book.setPrice(form.getPrice());
        book.setIsbn(form.getIsbn());
        book.setStockQuantity(form.getStockQuantity());

        // 상품 DB등록
        itemService.saveItem(book);

        // 상품 목록재조회
        List<Item> items = itemService.findItems();
        model.addAttribute("items",items);
        return "items/itemList";
    }

    // 상품 목록조회
    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    // 상품 수정 뷰 전환
    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable Long itemId, Model model) {

        Book item = (Book) itemService.findOne(itemId);
        BookForm form = new BookForm();

        form.setId(item.getId());
        form.setName(item.getName());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        
        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@ModelAttribute BookForm form) {
        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());

        itemService.saveItem(book);
        return "redirect:/items";
    }



}
